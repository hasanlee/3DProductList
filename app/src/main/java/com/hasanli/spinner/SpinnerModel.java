package com.hasanli.spinner;

/**
 * Created by hasan on 21.03.2017.
 */

public class SpinnerModel {
    private String mName;
    private String mPrice;
    private String mImage;
    private Boolean mVip;

    public SpinnerModel() {
        // Needed for Firebase
    }

    public SpinnerModel(String name, String price, String image, Boolean vip) {
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

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public void getVip (Boolean vip) {
        mVip = vip;
    }

    public void setVip(Boolean vip) {
        mVip = vip;
    }

}
