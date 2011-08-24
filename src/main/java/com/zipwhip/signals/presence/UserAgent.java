package com.zipwhip.signals.presence;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Michael
 * Date: 6/28/11
 * Time: 3:39 PM
 *
 * Formalizes what information the client can send when they connect.
 * We need this information for sending updates, and knowledge of
 * where our shit is installed.
 */
public class UserAgent implements Serializable {

    /**
     * The make/model of the device, in the case of a browser it will be NULL
     *
     * (hardware)
     */
    String makeModel;
    /**
     * The OS build version
     * A json string with these key/val pairs
     * (for example on the phone)
     * android.os.Build.DEVICE
     * android.os.Build.HARDWARE
     * android.os.Build.DISPLAY
     *
     * (software)
     */
    String build;
    /**
     * Software on the phone/browser
     * eg.
     * ZIPGROUPS, DEVICE_CARBON, TABLET_TEXTER, PEEPS
     * and version number
     */
    Product product;

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
