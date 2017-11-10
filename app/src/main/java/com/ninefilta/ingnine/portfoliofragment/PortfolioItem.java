package com.ninefilta.ingnine.portfoliofragment;

/**
 *
 */

public class PortfolioItem {

    private String boxNum_Port;
    private String title_Port;

    public PortfolioItem(String boxNum_Port, String title_Port) {
        this.boxNum_Port = boxNum_Port;
        this.title_Port = title_Port;
    }

    public String getBoxNum_Port() {
        return boxNum_Port;
    }

    public void setBoxNum_Port(String boxNum_Port) {
        this.boxNum_Port = boxNum_Port;
    }


    public String getTitle_Port() {
        return title_Port;
    }

    public void setTitle_Port(String title_Port) {
        this.title_Port = title_Port;
    }
}



