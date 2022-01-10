package com.innowise.example.entity;

import java.time.Instant;

public class PhoneEntity {
   private Long id;
   private String countryCode;
   private String operatorCode;
   private String number;
   private TypeOfPhone type;
   private String comment;
   private Instant createTime;
   private Instant updateTime;
   private Long contactId;

    public PhoneEntity() {
    }

    public PhoneEntity(Long id, String countryCode, String operatorCode, String number, TypeOfPhone type, String comment, Instant createTime, Instant updateTime, Long contactId) {
        this.id = id;
        this.countryCode = countryCode;
        this.operatorCode = operatorCode;
        this.number = number;
        this.type = type;
        this.comment = comment;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.contactId = contactId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public TypeOfPhone getType() {
        return type;
    }

    public void setType(TypeOfPhone type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }
}
