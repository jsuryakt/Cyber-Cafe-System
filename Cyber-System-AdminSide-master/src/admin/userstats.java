/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

/**
 *
 * @author Jayasurya
 */
public class userstats {
    
    String userid1,username1,usagetime1,billamount1,extraamount1,totalamount1,firstvisit1,likelihoodtoreturn1,feedback1;

    public String getFirstvisit1() {
        return firstvisit1;
    }

    public void setFirstvisit1(String firstvisit1) {
        this.firstvisit1 = firstvisit1;
    }

    public String getLikelihoodtoreturn1() {
        return likelihoodtoreturn1;
    }

    public void setLikelihoodtoreturn1(String likelihoodtoreturn1) {
        this.likelihoodtoreturn1 = likelihoodtoreturn1;
    }

    public String getFeedback1() {
        return feedback1;
    }

    public void setFeedback1(String feedback1) {
        this.feedback1 = feedback1;
    }

    public String getUserid1() {
        return userid1;
    }

    public String getTotalamount1() {
        return totalamount1;
    }

    public void setTotalamount1(String totalamount1) {
        this.totalamount1 = totalamount1;
    }

    public void setUserid1(String userid1) {
        this.userid1 = userid1;
    }

    public String getUsername1() {
        return username1;
    }

    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    public String getUsagetime1() {
        return usagetime1;
    }

    public void setUsagetime1(String usagetime1) {
        this.usagetime1 = usagetime1;
    }

    public String getBillamount1() {
        return billamount1;
    }

    public void setBillamount1(String billamount1) {
        this.billamount1 = billamount1;
    }

    public String getExtraamount1() {
        return extraamount1;
    }

    public void setExtraamount1(String extraamount1) {
        this.extraamount1 = extraamount1;
    }

    public userstats(String userid1, String username1, String usagetime1, String billamount1, String extraamount1, String totalamount1, String firstvisit1, String likelihoodtoreturn1, String feedback1) {
        this.userid1 = userid1;
        this.username1 = username1;
        this.usagetime1 = usagetime1;
        this.billamount1 = billamount1;
        this.extraamount1 = extraamount1;
        this.totalamount1 = totalamount1;
        this.firstvisit1 = firstvisit1;
        this.likelihoodtoreturn1 = likelihoodtoreturn1;
        this.feedback1 = feedback1;
    }
    
    
    
}
