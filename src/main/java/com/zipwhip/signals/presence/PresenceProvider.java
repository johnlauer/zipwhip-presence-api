package com.zipwhip.signals.presence;

import com.zipwhip.signals.app.Address;
import com.zipwhip.signals.mail.ClientInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Michael
 * Date: 6/28/11
 * Time: 2:41 PM
 *
 * This interface gives the website near-real-time presence information. It will empower the user to know who
 * can currently get their signals. (Is a hacker listening for my msgs? Did i forget to turn off my tablet?)
 *
 * Gives you a way to interact with the connectivity of the SignalServer. You can list connections, and ban/kick
 * people from the server. These commands will probably be injected via JMS or sockets through some privilaged means.
 *
 * Recommendation for implementation is a direct memcached/couch hit, rather than a round trip to a SignalServer.
 * We want to reduce middlemen to reduce points of failure.
 *
 */
public interface PresenceProvider {

    /**
     * For a given channel, tell me everyone who is currently listening.
     *
     * @param address The address that people can listen to
     * @return list of presence objects
     */
    List<Presence> listByAddress(Address address);

    /**
     * For a given "person listening" tell me everything they are able to also listen for, and what
     * they've already heard. aka the clientInfo object
     *
     * @param presence presence object
     * @return clientInfo object for a given presence object.
     */
    ClientInfo get(Presence presence);

}
