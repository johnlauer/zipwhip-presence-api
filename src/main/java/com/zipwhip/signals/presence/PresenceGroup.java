package com.zipwhip.signals.presence;

import com.zipwhip.signals.address.ClientAddress;

import java.io.Serializable;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: David Davis
 * Date: 7/27/11
 * Time: 2:40 PM
 */
public class PresenceGroup extends ArrayList<Presence> implements Serializable {

    // we control the serialisation version
    static final long serialVersionUID = 30936826296139318L;

    public void setData(ClientAddress address, String ip, Date date, boolean connected) {
        for (Presence presence : this) {
            presence.setAddress(address);
            presence.setIp(ip);
            presence.setLastActive(date);
            presence.setConnected(connected);
        }
    }

    public void setIp(String ip) {
        for (Presence presence : this) {
            presence.setIp(ip);
        }
    }

    public void setLastActive(Date date) {
        for (Presence presence : this) {
            presence.setLastActive(date);
        }
    }

    public void setConnected(boolean connected) {
        for (Presence presence : this) {
            presence.setConnected(connected);
        }
    }

    public void setAddress(ClientAddress address) {
        for (Presence presence : this) {
            presence.setAddress(address);
        }
    }
}
