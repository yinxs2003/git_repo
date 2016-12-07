package com.mvc.entity;

import java.util.Date;

public class Person {
    private Integer id;
    private String cardId;
    private String name;
    private String pinyin;
    private String usedName;
    private String sex;
    private Date birth;
    private String politicalStatus;
    private String phone;
    private String job;
    private String hometown;//籍贯
    private String homeAddress;//家庭住址
    private String officeAddress;//工作地址
    private String relationWithHost;//与户主关系

    public Person(String cardId, String name, String pinyin, String usedName, String sex, Date birth, String politicalStatus, String phone, String job, String hometown, String homeAddress, String officeAddress, String relationWithHost) {
        this.cardId = cardId;
        this.name = name;
        this.pinyin = pinyin;
        this.usedName = usedName;
        this.sex = sex;
        this.birth = birth;
        this.politicalStatus = politicalStatus;
        this.phone = phone;
        this.job = job;
        this.hometown = hometown;
        this.homeAddress = homeAddress;
        this.officeAddress = officeAddress;
        this.relationWithHost = relationWithHost;
    }

    public String getUsedName() {
        return usedName;
    }

    public void setUsedName(String usedName) {
        this.usedName = usedName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getRelationWithHost() {
        return relationWithHost;
    }

    public void setRelationWithHost(String relationWithHost) {
        this.relationWithHost = relationWithHost;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
