
package com.example.hendry.testtopedbrowse.network.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Breadcrumb {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("total_data")
    @Expose
    private String totalData;
    @SerializedName("parent_id")
    @Expose
    private Integer parentId;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("child")
    @Expose
    private List<Child> child = null;
    @SerializedName("tree")
    @Expose
    private Integer tree;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("name_without_total")
    @Expose
    private String nameWithoutTotal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalData() {
        return totalData;
    }

    public void setTotalData(String totalData) {
        this.totalData = totalData;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<Child> getChild() {
        return child;
    }

    public void setChild(List<Child> child) {
        this.child = child;
    }

    public Integer getTree() {
        return tree;
    }

    public void setTree(Integer tree) {
        this.tree = tree;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getNameWithoutTotal() {
        return nameWithoutTotal;
    }

    public void setNameWithoutTotal(String nameWithoutTotal) {
        this.nameWithoutTotal = nameWithoutTotal;
    }

}
