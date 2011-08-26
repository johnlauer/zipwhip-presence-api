package com.zipwhip.signals.address;

/**
 * Created by IntelliJ IDEA.
 * User: Michael
 * Date: 12/15/10
 * Time: 1:29 AM
 */
public class AddressBase implements Address, Comparable {

    /**
     * a negative integer, zero, or a positive integer as this object
     *		is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Object o) {
        int hc1 = this.hashCode();
        int hc2 = o.hashCode();
        return hc1 < hc2 ? -1 : ( hc1 == hc2 ? 0 : 1 );
    }
}
