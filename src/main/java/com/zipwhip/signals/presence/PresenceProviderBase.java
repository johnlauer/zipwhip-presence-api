package com.zipwhip.signals.presence;

import com.zipwhip.signals.app.Address;
import com.zipwhip.signals.mail.ClientInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: David Davis
 * Date: 7/13/11
 * Time: 3:37 PM
 */
public class PresenceProviderBase implements PresenceProvider {

    @Override
    public List<Presence> listByAddress(Address address) {
        throw new RuntimeException("listByAddress not implemented in subclass");
    }

    @Override
    public ClientInfo get(Presence presence) {
        throw new RuntimeException("get not implemented in subclass");
    }
}
