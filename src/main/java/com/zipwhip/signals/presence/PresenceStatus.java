package com.zipwhip.signals.presence;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: David Davis
 * Date: 7/1/11
 * Time: 5:28 PM
 *
 * This is for GUI use, not an ON/OFF flag
 */
public enum PresenceStatus implements Serializable {
    ONLINE, AWAY, BUSY, INVISIBLE, OFFLINE
}
