package com.ninefilta.ingnine.myfragment;

/**
 * Created by pajh8 on 2017-09-29.
 */

public class MyWorkItem {

    private String mfCTG;
    private String mfTitle;

    public MyWorkItem(String mfCTG, String mfTitle) {
        this.mfCTG = mfCTG;
        this.mfTitle = mfTitle;
    }

    public String getMfCTG() {
        return mfCTG;
    }

    public void setMfCTG(String mfCTG) {
        this.mfCTG = mfCTG;
    }

    public String getMfTitle() {
        return mfTitle;
    }

    public void setMfTitle(String mfTitle) {
        this.mfTitle = mfTitle;
    }
}
