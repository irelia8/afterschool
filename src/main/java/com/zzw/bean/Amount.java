package com.zzw.bean;

/**
 * Created by 张志伟 on 2017/11/23.
 */
public class Amount {

    private int userAmount;
    private int teacherAmount;
    private int adminAmount;
    private int chineseAmount;
    private int mathAmount;
    private int englishAmount;
    private int physicsAmount;
    private int chemistryAmount;
    private int biologyAmount;

    public Amount(int userAmount, int teacherAmount, int adminAmount,
                  int chineseAmount, int mathAmount, int englishAmount,
                  int physicsAmount, int chemistryAmount, int biologyAmount) {
        this.userAmount = userAmount;
        this.teacherAmount = teacherAmount;
        this.adminAmount = adminAmount;
        this.chineseAmount = chineseAmount;
        this.mathAmount = mathAmount;
        this.englishAmount = englishAmount;
        this.physicsAmount = physicsAmount;
        this.chemistryAmount = chemistryAmount;
        this.biologyAmount = biologyAmount;
    }

    public int getUserAmount() {
        return userAmount;
    }

    public void setUserAmount(int userAmount) {
        this.userAmount = userAmount;
    }

    public int getTeacherAmount() {
        return teacherAmount;
    }

    public void setTeacherAmount(int teacherAmount) {
        this.teacherAmount = teacherAmount;
    }

    public int getAdminAmount() {
        return adminAmount;
    }

    public void setAdminAmount(int adminAmount) {
        this.adminAmount = adminAmount;
    }

    public int getChineseAmount() {
        return chineseAmount;
    }

    public void setChineseAmount(int chineseAmount) {
        this.chineseAmount = chineseAmount;
    }

    public int getMathAmount() {
        return mathAmount;
    }

    public void setMathAmount(int mathAmount) {
        this.mathAmount = mathAmount;
    }

    public int getEnglishAmount() {
        return englishAmount;
    }

    public void setEnglishAmount(int englishAmount) {
        this.englishAmount = englishAmount;
    }

    public int getPhysicsAmount() {
        return physicsAmount;
    }

    public void setPhysicsAmount(int physicsAmount) {
        this.physicsAmount = physicsAmount;
    }

    public int getChemistryAmount() {
        return chemistryAmount;
    }

    public void setChemistryAmount(int chemistryAmount) {
        this.chemistryAmount = chemistryAmount;
    }

    public int getBiologyAmount() {
        return biologyAmount;
    }

    public void setBiologyAmount(int biologyAmount) {
        this.biologyAmount = biologyAmount;
    }
}
