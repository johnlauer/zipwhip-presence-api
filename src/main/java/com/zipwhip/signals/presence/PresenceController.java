package com.zipwhip.signals.presence;

import com.zipwhip.signals.address.ChannelAddress;
import com.zipwhip.signals.address.ClientAddress;

import java.net.InetSocketAddress;

/**
 * Created by IntelliJ IDEA.
 * User: Michael
 * Date: 6/28/11
 * Time: 3:11 PM
 *
 * Controls who is connected to the SignalServer
 *
 * Recommendation for implementation is a JMS enqueue of a command.
 *
 */
public interface PresenceController {

    /**
     * Kick this person out of the channel.
     *
     * @param address
     * @param channelAddress
     */
    void unsubscribe(ClientAddress address, ChannelAddress channelAddress);

    /**
     * Full unsubscribe
     *
     * @param clientAddress
     */
    void unsubscribe(ClientAddress clientAddress);

    /**
     * Kick off the server.
     *
     * @param clientAddress
     * @param reconnect
     * @param delay
     */
    void disconnect(ClientAddress clientAddress, InetSocketAddress reconnect, Integer delay);

    /**
     * A normal disconnect, they will reconnect normally.
     *
     * @param clientAddress
     */
    void disconnect(ClientAddress clientAddress);

    /**
     * Disconnect them and tell them never to come back again.
     *
     * @param clientAddress
     */
    void ban(ClientAddress clientAddress);

}
