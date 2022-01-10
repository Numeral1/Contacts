package com.innowise.example.dto.response;

import com.innowise.example.entity.ContactEntity;

public class ContactShortResponse {

    private String fullName;
    private String dayOfBirth;
    private String fullAddress;
    private String currentCompany;

    public static ContactShortResponse fromEntity(ContactEntity entity){
        ContactShortResponse model = new ContactShortResponse();
        model.setFullName(entity.getFullName());
        model.setDayOfBirth(entity.getBirthday().toString());
        model.setFullAddress(entity.getFullAddress());
        model.setCurrentCompany(entity.getCurrentPlaceOfWork());

        return model;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(String currentCompany) {
        this.currentCompany = currentCompany;
    }


}
