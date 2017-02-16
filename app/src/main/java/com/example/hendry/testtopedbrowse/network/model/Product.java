
package com.example.hendry.testtopedbrowse.network.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("product_url")
    @Expose
    private String productUrl;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("product_image_full")
    @Expose
    private String productImageFull;
    @SerializedName("product_image")
    @Expose
    private String productImage;
    @SerializedName("product_price")
    @Expose
    private String productPrice;
    @SerializedName("product_wholesale")
    @Expose
    private Integer productWholesale;
    @SerializedName("shop_location")
    @Expose
    private String shopLocation;
    @SerializedName("shop_url")
    @Expose
    private String shopUrl;
    @SerializedName("shop_gold_status")
    @Expose
    private Integer shopGoldStatus;
    @SerializedName("shop_name")
    @Expose
    private String shopName;
    @SerializedName("shop_id")
    @Expose
    private Integer shopId;
    @SerializedName("rate")
    @Expose
    private Integer rate;
    @SerializedName("product_sold_count")
    @Expose
    private Integer productSoldCount;
    @SerializedName("product_review_count")
    @Expose
    private Integer productReviewCount;
    @SerializedName("product_talk_count")
    @Expose
    private Integer productTalkCount;
    @SerializedName("is_owner")
    @Expose
    private Integer isOwner;
    @SerializedName("shop_lucky")
    @Expose
    private String shopLucky;
    @SerializedName("condition")
    @Expose
    private Integer condition;
    @SerializedName("preorder")
    @Expose
    private Integer preorder;
    @SerializedName("product_preorder")
    @Expose
    private Integer productPreorder;
    @SerializedName("labels")
    @Expose
    private List<Label> labels = null;
    @SerializedName("badges")
    @Expose
    private List<Badge> badges = null;

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductImageFull() {
        return productImageFull;
    }

    public void setProductImageFull(String productImageFull) {
        this.productImageFull = productImageFull;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductWholesale() {
        return productWholesale;
    }

    public void setProductWholesale(Integer productWholesale) {
        this.productWholesale = productWholesale;
    }

    public String getShopLocation() {
        return shopLocation;
    }

    public void setShopLocation(String shopLocation) {
        this.shopLocation = shopLocation;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public Integer getShopGoldStatus() {
        return shopGoldStatus;
    }

    public void setShopGoldStatus(Integer shopGoldStatus) {
        this.shopGoldStatus = shopGoldStatus;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getProductSoldCount() {
        return productSoldCount;
    }

    public void setProductSoldCount(Integer productSoldCount) {
        this.productSoldCount = productSoldCount;
    }

    public Integer getProductReviewCount() {
        return productReviewCount;
    }

    public void setProductReviewCount(Integer productReviewCount) {
        this.productReviewCount = productReviewCount;
    }

    public Integer getProductTalkCount() {
        return productTalkCount;
    }

    public void setProductTalkCount(Integer productTalkCount) {
        this.productTalkCount = productTalkCount;
    }

    public Integer getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Integer isOwner) {
        this.isOwner = isOwner;
    }

    public String getShopLucky() {
        return shopLucky;
    }

    public void setShopLucky(String shopLucky) {
        this.shopLucky = shopLucky;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public Integer getPreorder() {
        return preorder;
    }

    public void setPreorder(Integer preorder) {
        this.preorder = preorder;
    }

    public Integer getProductPreorder() {
        return productPreorder;
    }

    public void setProductPreorder(Integer productPreorder) {
        this.productPreorder = productPreorder;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

}
