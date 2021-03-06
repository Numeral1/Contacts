package com.innowise.example.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innowise.example.entity.ContactEntity;
import com.innowise.example.entity.Gender;
import com.innowise.example.entity.MaritalStatus;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ContactRequest {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private Date birthdate;
    private Gender gender;
    private String citizenship;
    @JsonProperty("maritalStatus")
    private MaritalStatus maritalStatus;
    private String website;
    private String email;
    private String currentPlaceOfWork;
    private String country;
    private String city;
    private String street;
    private String house;
    private String apartment;
    private String postcode;
    private String photo;
    private Instant CreateTime;
    private Instant UpdateTime;
    private List<AttachmentDtoRequest> attachmentDtoRequestList;
    private List<PhoneItem> phoneList;

    public static ContactEntity toEntity(ContactRequest contactRequest) {
        ContactEntity entity = new ContactEntity();
        entity.setId(contactRequest.getId());
        entity.setName(contactRequest.getName());
        entity.setSurname(contactRequest.getSurname());
        entity.setPatronymic(contactRequest.getPatronymic());
        entity.setBirthday(contactRequest.getBirthdate());
        entity.setGender(contactRequest.getGender());
        entity.setCitizenship(contactRequest.getCitizenship());
        entity.setMartialStatus(contactRequest.getMaritalStatus());
        entity.setWebsite(contactRequest.getWebsite());
        entity.setEmail(contactRequest.getEmail());
        entity.setCurrentPlaceOfWork(contactRequest.getCurrentPlaceOfWork());
        entity.setCountry(contactRequest.getCountry());
        entity.setCity(contactRequest.getCity());
        entity.setStreet(contactRequest.getStreet());
        entity.setHouse(contactRequest.getHouse());
        entity.setApartment(contactRequest.getApartment());
        entity.setPostcode(contactRequest.getPostcode());
        entity.setPhoto(contactRequest.getPhoto());

        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentPlaceOfWork() {
        return currentPlaceOfWork;
    }

    public void setCurrentPlaceOfWork(String currentPlaceOfWork) {
        this.currentPlaceOfWork = currentPlaceOfWork;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Instant getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Instant createTime) {
        CreateTime = createTime;
    }

    public Instant getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Instant updateTime) {
        UpdateTime = updateTime;
    }

    public List<AttachmentDtoRequest> getAttachmentDtoRequestList() {
        return attachmentDtoRequestList;
    }

    public void setAttachmentDtoRequestList(List<AttachmentDtoRequest> attachmentDtoRequestList) {
        this.attachmentDtoRequestList = attachmentDtoRequestList;
    }

    public List<PhoneItem> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<PhoneItem> phoneList) {
        this.phoneList = phoneList;
    }
}