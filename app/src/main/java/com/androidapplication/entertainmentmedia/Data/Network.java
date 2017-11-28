package com.androidapplication.entertainmentmedia.Data;

import java.io.Serializable;

/**
 * Created by Devin on 11/28/2017.
 */

public class Network extends User implements Serializable {
    private String username;
    private String network_name;

    public Network(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNetwork_name() {
        return network_name;
    }

    public void setNetwork_name(String network_name) {
        this.network_name = network_name;
    }
}
