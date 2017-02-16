
package com.example.hendry.testtopedbrowse.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BrowseProductModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("config")
    @Expose
    private Config config;
    @SerializedName("server_process_time")
    @Expose
    private Double serverProcessTime;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Double getServerProcessTime() {
        return serverProcessTime;
    }

    public void setServerProcessTime(Double serverProcessTime) {
        this.serverProcessTime = serverProcessTime;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
