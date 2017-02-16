
package com.example.hendry.testtopedbrowse.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Config {

    @SerializedName("backoff_multi")
    @Expose
    private Integer backoffMulti;
    @SerializedName("max_retries")
    @Expose
    private Integer maxRetries;
    @SerializedName("timeout")
    @Expose
    private Integer timeout;

    public Integer getBackoffMulti() {
        return backoffMulti;
    }

    public void setBackoffMulti(Integer backoffMulti) {
        this.backoffMulti = backoffMulti;
    }

    public Integer getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(Integer maxRetries) {
        this.maxRetries = maxRetries;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

}
