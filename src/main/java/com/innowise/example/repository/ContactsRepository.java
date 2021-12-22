package com.innowise.example.repository;

import com.innowise.example.entity.ContactsEntity;
import com.innowise.example.entity.Gender;
import com.innowise.example.entity.MaritalStatus;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ContactsRepository {


   ContactsEntity contactsEntity = new ContactsEntity();
   List<ContactsEntity> contactsList = new ArrayList<>();

    private final String SELECT_ALL_QUERY = "select * from contact;";
    private final String ADD_TO_CONTACT_TABLE = "insert into contact(name, surname, patronymic, gender, citizenship, marital_status, website, email,\n" +
            "                     current_place_of_work, country, city, street, house, apartment, postcode, photo, create_time,\n" +
            "                     update_time, birthdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT_BY_ID = "select * from contact where id =";
    private final String ADD_TO_PHONE_TABLE = "insert into phone(country_code, operator_code, number, type, comment, create_time, update_time, contact_id)\n" +
                                             " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String ADD_TO_ATTACHMENT_TABLE = "insert into attachment(file_name, comment, create_time, update_time, contact_id) VALUES (?, ?, ?, ?, ?)";

    private DbConnection dbConnection = DbConnection.getInstance();


    public ContactsRepository(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public DbConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public ContactsRepository() {
    }

    public ContactsEntity getContactsEntity() {
        return contactsEntity;
    }

    public void setContactsEntity(ContactsEntity contactsEntity) {
        this.contactsEntity = contactsEntity;
    }

    public List<ContactsEntity> showAllContacts() {
        PreparedStatement prstatement;
        try {
            prstatement = dbConnection.getConnection().prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = prstatement.executeQuery();
            while (resultSet.next()) {
                ContactsEntity contactsEntity = new ContactsEntity();
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String patronymic = resultSet.getString("patronymic");
                Date birthdate = resultSet.getDate("birthdate");
                String gender = resultSet.getString("gender");
                String citizenship = resultSet.getString("citizenship");
                String maritalStatus = resultSet.getString("marital_status");
                String website = resultSet.getString("website");
                String email = resultSet.getString("email");
                String currentPlaceOfWork = resultSet.getString("current_place_of_work");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                String street = resultSet.getString("street");
                String house = resultSet.getString("house");
                String apartment = resultSet.getString("apartment");
                String postcode = resultSet.getString("postcode");
                String photo = resultSet.getString("photo");
                Timestamp createTime = resultSet.getTimestamp("create_time");
                Timestamp updateTime = resultSet.getTimestamp("update_time");

                 contactsEntity.setId(id);
                 contactsEntity.setName(name);
                 contactsEntity.setSurname(surname);
                 contactsEntity.setPatronymic(patronymic);
                 contactsEntity.setBirthday(birthdate);
                 contactsEntity.setGender(Gender.valueOf(gender));
                 contactsEntity.setCitizenship(citizenship);
                 contactsEntity.setMartialStatus(MaritalStatus.valueOf(maritalStatus));
                 contactsEntity.setWebsite(website);
                 contactsEntity.setEmail(email);
                 contactsEntity.setCurrentPlaceOfWork(currentPlaceOfWork);
                 contactsEntity.setCountry(country);
                 contactsEntity.setCity(city);
                 contactsEntity.setStreet(street);
                 contactsEntity.setHouse(house);
                 contactsEntity.setApartment(apartment);
                 contactsEntity.setPostcode(postcode);
                 contactsEntity.setPhoto(photo);
                 contactsEntity.setCreateTime(createTime.toInstant());
                 contactsEntity.setUpdateTime(updateTime.toInstant());
                contactsList.add(contactsEntity);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contactsList;
    }

    public void saveContact (ContactsEntity contact) {

        try (Connection connection = dbConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(ADD_TO_CONTACT_TABLE)) {

            java.util.Date utilDate = contact.getBirthday();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            System.out.println(sqlDate + contact.getName() + " " + Timestamp.from(contact.getCreateTime()));

            ps.setString(1, contact.getName());
            ps.setString(2, contact.getSurname());
            ps.setString(3, contact.getPatronymic());
            ps.setString(4, contact.getGender().toString());
            ps.setString(5, contact.getCitizenship());
            ps.setString(6, contact.getMartialStatus().toString());
            ps.setString(7, contact.getWebsite());
            ps.setString(8, contact.getEmail());
            ps.setString(9, contact.getCurrentPlaceOfWork());
            ps.setString(10, contact.getCountry());
            ps.setString(11, contact.getCity());
            ps.setString(12, contact.getStreet());
            ps.setString(13, contact.getHouse());
            ps.setString(14, contact.getApartment());
            ps.setString(15, contact.getPostcode());
            ps.setString(16, contact.getPhoto());
            ps.setTimestamp(17, Timestamp.from(contact.getCreateTime()));
            ps.setTimestamp(18, Timestamp.from(contact.getUpdateTime()));
            ps.setDate(19, sqlDate);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ContactsEntity findById (Long id){
        try (PreparedStatement ps = dbConnection.getConnection().prepareStatement(SELECT_BY_ID + id + ";")){
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                ContactsEntity contactsEntity = new ContactsEntity();
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String patronymic = resultSet.getString("patronymic");
                Date birthdate = resultSet.getDate("birthdate");
                String gender = resultSet.getString("gender");
                String citizenship = resultSet.getString("citizenship");
                String maritalStatus = resultSet.getString("marital_status");
                String website = resultSet.getString("website");
                String email = resultSet.getString("email");
                String currentPlaceOfWork = resultSet.getString("current_place_of_work");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                String street = resultSet.getString("street");
                String house = resultSet.getString("house");
                String apartment = resultSet.getString("apartment");
                String postcode = resultSet.getString("postcode");
                String photo = resultSet.getString("photo");
                Timestamp createTime = resultSet.getTimestamp("create_time");
                Timestamp updateTime = resultSet.getTimestamp("update_time");

                contactsEntity.setId(id);
                contactsEntity.setName(name);
                contactsEntity.setSurname(surname);
                contactsEntity.setPatronymic(patronymic);
                contactsEntity.setBirthday(birthdate);
                contactsEntity.setGender(Gender.valueOf(gender));
                contactsEntity.setCitizenship(citizenship);
                contactsEntity.setMartialStatus(MaritalStatus.valueOf(maritalStatus));
                contactsEntity.setWebsite(website);
                contactsEntity.setEmail(email);
                contactsEntity.setCurrentPlaceOfWork(currentPlaceOfWork);
                contactsEntity.setCountry(country);
                contactsEntity.setCity(city);
                contactsEntity.setStreet(street);
                contactsEntity.setHouse(house);
                contactsEntity.setApartment(apartment);
                contactsEntity.setPostcode(postcode);
                contactsEntity.setPhoto(photo);
                contactsEntity.setCreateTime(createTime.toInstant());
                contactsEntity.setUpdateTime(updateTime.toInstant());

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contactsEntity;
    }


}
