package com.innowise.example.entity;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class ContactEntity {

   private Long id;
   private String name;
   private String surname;
   private String patronymic;
   private Date birthday;
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
   private Instant CreateTime;
   private Instant UpdateTime;

    public ContactEntity(Long id, String name, String surname, String patronymic, Date birthday, Gender gender, String citizenship, MaritalStatus martialStatus, String website,
                         String email, String currentPlaceOfWork, String country, String city, String street, String house, String apartment, String postcode, String photo,
                         Instant createTime, Instant updateTime) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.gender = gender;
        this.citizenship = citizenship;
        this.martialStatus = martialStatus;
        this.website = website;
        this.email = email;
        this.currentPlaceOfWork = currentPlaceOfWork;
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.postcode = postcode;
        this.photo = photo;
        CreateTime = createTime;
        UpdateTime = updateTime;
    }

    public ContactEntity() {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    @Override
    public String toString() {
        return "ContactEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", citizenship='" + citizenship + '\'' +
                ", martialStatus=" + martialStatus +
                ", website='" + website + '\'' +
                ", email='" + email + '\'' +
                ", currentPlaceOfWork='" + currentPlaceOfWork + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", apartment='" + apartment + '\'' +
                ", postcode='" + postcode + '\'' +
                ", photo='" + photo + '\'' +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactEntity)) return false;
        ContactEntity that = (ContactEntity) o;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && getSurname().equals(that.getSurname()) && getPatronymic().equals(that.getPatronymic()) && getBirthday().equals(that.getBirthday()) && getGender() == that.getGender() && getCitizenship().equals(that.getCitizenship()) && getMartialStatus() == that.getMartialStatus() && getWebsite().equals(that.getWebsite()) && getEmail().equals(that.getEmail()) && getCurrentPlaceOfWork().equals(that.getCurrentPlaceOfWork()) && getCountry().equals(that.getCountry()) && getCity().equals(that.getCity()) && getStreet().equals(that.getStreet()) && getHouse().equals(that.getHouse()) && getApartment().equals(that.getApartment()) && getPostcode().equals(that.getPostcode()) && getPhoto().equals(that.getPhoto()) && getCreateTime().equals(that.getCreateTime()) && getUpdateTime().equals(that.getUpdateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getPatronymic(), getBirthday(), getGender(), getCitizenship(), getMartialStatus(), getWebsite(), getEmail(), getCurrentPlaceOfWork(), getCountry(), getCity(), getStreet(), getHouse(), getApartment(), getPostcode(), getPhoto(), getCreateTime(), getUpdateTime());
    }

    public String getFullName() {
        return String.join(" ", name, patronymic, surname);
    }

    public String getFullAddress() {
        return String.join(" ", country, city, street, house, apartment, postcode);
    }
}
