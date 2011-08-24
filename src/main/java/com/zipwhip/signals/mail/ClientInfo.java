package com.zipwhip.signals.mail;

import com.zipwhip.util.StringUtil;
import com.zipwhip.signals.app.Address;
import com.zipwhip.signals.util.LocalDirectory;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Michael
 * Date: 1/7/11
 * Time: 3:10 PM
 *
 * A per connection data object that helps us persist state.
 */
public class ClientInfo implements Serializable {

    public String clientId;

    /**
     * You can put whatever key/value stuff you want in this map. (as long as it's serializable)
     */
    public Map<String, Object> cache;

    /**
     * The channels that this connection is subscribed to.
     *
     * The KEY here is the subscriptionId, the ADDRESSes here are the actual subscriptions.
     */
    public LocalDirectory<String, Address> subscriptions;
    //public String subscriptionId;

    public String toString() {
        //return StringUtil.join(getClass().getSimpleName(), " ", clientId, " subscriptionId:", subscriptionId);
        return StringUtil.join(getClass().getSimpleName(), " ", clientId);
    }

}
