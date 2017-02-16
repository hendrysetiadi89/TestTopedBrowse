
package com.example.hendry.testtopedbrowse.network.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("search_url")
    @Expose
    private String searchUrl;
    @SerializedName("share_url")
    @Expose
    private String shareUrl;
    @SerializedName("paging")
    @Expose
    private Paging paging;
    @SerializedName("st")
    @Expose
    private String st;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    @SerializedName("has_catalog")
    @Expose
    private Integer hasCatalog;
    @SerializedName("hashtag")
    @Expose
    private Object hashtag;
    @SerializedName("breadcrumb")
    @Expose
    private List<Breadcrumb> breadcrumb = null;
    @SerializedName("department_id")
    @Expose
    private Integer departmentId;
    @SerializedName("locations")
    @Expose
    private Object locations;

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getHasCatalog() {
        return hasCatalog;
    }

    public void setHasCatalog(Integer hasCatalog) {
        this.hasCatalog = hasCatalog;
    }

    public Object getHashtag() {
        return hashtag;
    }

    public void setHashtag(Object hashtag) {
        this.hashtag = hashtag;
    }

    public List<Breadcrumb> getBreadcrumb() {
        return breadcrumb;
    }

    public void setBreadcrumb(List<Breadcrumb> breadcrumb) {
        this.breadcrumb = breadcrumb;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Object getLocations() {
        return locations;
    }

    public void setLocations(Object locations) {
        this.locations = locations;
    }

}
