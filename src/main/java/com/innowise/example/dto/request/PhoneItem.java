package com.innowise.example.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innowise.example.entity.PhoneEntity;
import com.innowise.example.entity.TypeOfPhone;

import java.time.Instant;
import java.util.List;
import java.util.stream.Stream;

public class PhoneItem {
    private Long id;
    private String countryCode;
    private String operatorCode;
    private String number;
    private TypeOfPhone type;
    private String comment;

    public static PhoneEntity toPhoneEntity(PhoneItem phoneItem, Long savedId){
        PhoneEntity phoneEntity = new PhoneEntity();
        phoneEntity.setCountryCode(phoneItem.getCountryCode());
        phoneEntity.setOperatorCode(phoneItem.getOperatorCode());
        phoneEntity.setNumber(phoneItem.getNumber());
        phoneEntity.setType(phoneItem.getType());
        phoneEntity.setComment(phoneItem.getComment());
        phoneEntity.setContactId(savedId);
        return phoneEntity;
    }
    public static PhoneItem fromPhoneEntity(PhoneEntity phoneEntity){
        PhoneItem phoneItem = new PhoneItem();
        phoneItem.setId(phoneEntity.getId());
        phoneItem.setCountryCode(phoneEntity.getCountryCode());
        phoneItem.setOperatorCode(phoneEntity.getOperatorCode());
        phoneItem.setNumber(phoneEntity.getNumber());
        phoneItem.setType(phoneEntity.getType());
        phoneItem.setComment(phoneEntity.getComment());
        return phoneItem;
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


}
