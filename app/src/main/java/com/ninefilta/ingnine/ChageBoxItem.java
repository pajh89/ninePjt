package com.ninefilta.ingnine;

/**
 * Created by pajh8 on 2017-09-26.
 */

public class ChageBoxItem {

    private String changeID;
    private String changeDate;

    public ChageBoxItem(String changeID, String changeDate) {
        this.changeID = changeID;
        this.changeDate = changeDate;
    }

    public String getChangeID() {
        return changeID;
    }

    public void setChangeID(String changeID) {
        this.changeID = changeID;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }
}
