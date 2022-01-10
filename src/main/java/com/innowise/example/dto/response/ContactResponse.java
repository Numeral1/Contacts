package com.innowise.example.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.innowise.example.dto.request.PhoneItem;
import com.innowise.example.entity.ContactEntity;
import com.innowise.example.entity.Gender;
import com.innowise.example.entity.MaritalStatus;

import java.util.Date;
import java.util.List;

public class ContactResponse {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date birthdate;
    private Gender gender;
    private String citizenship;
    private MaritalStatus martialStatus;
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
    private List<PhoneItem> phoneItemList;

    public static ContactResponse fromEntity(ContactEntity contact) {
        ContactResponse contactDto = new ContactResponse();
        contactDto.setId(contact.getId());
        contactDto.setName(contact.getName());
        contactDto.setSurname(contact.getSurname());
        contactDto.setPatronymic(contact.getPatronymic());
        contactDto.setBirthdate(contact.getBirthday());
        contactDto.setGender(contact.getGender());
        contactDto.setCitizenship(contact.getCitizenship());
        contactDto.setMartialStatus(contact.getMartialStatus());
        contactDto.setWebsite(contact.getWebsite());
        contactDto.setEmail(contact.getEmail());
        contactDto.setCurrentPlaceOfWork(contact.getCurrentPlaceOfWork());
        contactDto.setCountry(contact.getCountry());
        contactDto.setCity(contact.getCity());
        contactDto.setStreet(contact.getStreet());
        contactDto.setHouse(contact.getHouse());
        contactDto.setApartment(contact.getApartment());
        contactDto.setPostcode(contact.getPostcode());
        contactDto.setPhoto(contact.getPhoto());
        return contactDto;
    }

    public List<PhoneItem> getPhoneItemList() {
        return phoneItemList;
    }

    public void setPhoneItemList(List<PhoneItem> phoneItemList) {
        this.phoneItemList = phoneItemList;
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

    public MaritalStatus getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(MaritalStatus martialStatus) {
        this.martialStatus = martialStatus;
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

}
