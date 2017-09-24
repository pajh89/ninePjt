package com.ninefilta.ingnine;

/**
 *
 */

public class FeedItem {

    private String ftitle;
    private String ftime;

/*    private int nteImg;
    private int fImg;
    private int profilePic;
    private String profileId;
    private int fLike;
*/

    public FeedItem(String ftitle, String ftime) {
        this.ftitle = ftitle;
        this.ftime = ftime;
    }

    public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle;
    }

    public String getFtime() {
        return ftime;
    }

    public void setFtime(String ftime) {
        this.ftime = ftime;
    }

    /*
    public int getNteImg() {
        return nteImg;
    }

    public void setNteImg(int nteImg) {
        this.nteImg = nteImg;
    }

    public int getfImg() {
        return fImg;
    }

    public void setfImg(int fImg) {
        this.fImg = fImg;
    }

    public int getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(int profilePic) {
        this.profilePic = profilePic;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public int getfLike() {
        return fLike;
    }

    public void setfLike(int fLike) {
        this.fLike = fLike;
    }

    */
}



