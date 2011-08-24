package com.zipwhip.signals.presence;

import com.zipwhip.cache.CacheProvider;
import com.zipwhip.cache.MemcachedCacheProvider;
import com.zipwhip.signals.address.ChannelAddress;
import com.zipwhip.signals.app.Address;
import com.zipwhip.signals.mail.ClientInfo;
import com.zipwhip.util.CollectionUtil;
import com.zipwhip.util.StringUtil;
import com.zipwhip.website.data.dto.Device;
import com.zipwhip.website.data.dto.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: David Davis
 * Date: 7/11/11
 * Time: 4:47 PM
 */
public class MemcachedPresenceProvider extends PresenceProviderBase {

    MemcachedCacheProvider cacheProvider;
    private static final String PRESENCE_PREFIX = "presence:";
    private static final String MEMBER_LIST_PREFIX = "members:";

    /**
     * For a given channel, tell me everyone who is currently listening.
     */
    @Override
    public List<Presence> listByAddress(Address address) {
        List<Presence> plist = new ArrayList<Presence>();
        List<String> keyList = (List<String>)cacheProvider.get(PRESENCE_PREFIX + MEMBER_LIST_PREFIX + address);
        if(!CollectionUtil.isNullOrEmpty(keyList)) {
            for (String key : keyList) {
                PresenceGroup presenceGroup = (PresenceGroup)cacheProvider.get(PRESENCE_PREFIX + key);
                if (CollectionUtil.isNullOrEmpty(presenceGroup)) {
                    continue;
                }
                plist.addAll(presenceGroup);
            }
        }
        return plist;
    }

    /**
     * For a given "person listening" tell me everything they are able to also listen for, and what
     * they've already heard.
     */
    @Override
    public ClientInfo get(Presence presence) {
        return (ClientInfo) cacheProvider.get(PRESENCE_PREFIX + presence.getAddress(), null);
    }

    public MemcachedCacheProvider getCacheProvider() {
        return cacheProvider;
    }

    public void setCacheProvider(MemcachedCacheProvider cacheProvider) {
        this.cacheProvider = cacheProvider;
    }
}
