package com.hasanli.spinner;


public class SpinnerModel {
    private String mName;
    private Integer mPrice;
    private String mImage;
    private Boolean mVip;

    public SpinnerModel() {
        // Needed for Firebase
    }

    public SpinnerModel(String name, Integer price, String image, Boolean vip) {
        mName = name;
        mPrice = price;
        mImage = image;
        mVip = vip;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Integer getPrice() {
        return mPrice;
    }

    public void setPrice(Integer price) {
        mPrice = price;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public Boolean getVip (Boolean vip) {
        mVip = vip;
        return vip;
    }

    public void setVip (Boolean vip) {
        mVip = vip;
    }
}
