package com.innowise.example.repository;

import com.innowise.example.entity.ContactEntity;
import com.innowise.example.entity.Gender;
import com.innowise.example.entity.MaritalStatus;
import com.innowise.example.entity.PhoneEntity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

public class ContactsRepository {

    private final static String SELECT_ALL_QUERY = "select * from contact;";
    private final static String ADD_TO_CONTACT_TABLE = "insert into contact(name, surname, patronymic, gender, citizenship, marital_status, website, email,\n" +
            "                     current_place_of_work, country, city, street, house, apartment, postcode, photo, create_time,\n" +
            "                     update_time, birthdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String SELECT_BY_ID = "select * from contact where id =";
    private final static String UPDATE_CONTACT = "update contact set name = ?, surname = ?, patronymic = ?, birthdate = ?, gender = ?, citizenship = ?, marital_status = ?, website =?, email = ?,\n" +
            "current_place_of_work = ?, country = ?, city = ?, street = ?, apartment = ?, postcode = ?, photo = ?, update_time = ? where id = ? ;";
    private final static String DELETE_BY_ID = "delete from contact where id = ? ;";
    private final static String ADD_TO_PHONE_TABLE = "insert into phone(country_code, operator_code, number, type, comment, create_time, update_time, contact_id)\n" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String ADD_TO_ATTACHMENT_TABLE = "insert into attachment(file_name, comment, create_time, update_time, contact_id) VALUES (?, ?, ?, ?, ?)";



    private DbConnection dbConnection = DbConnection.getInstance();

    public ContactsRepository() {}


    public List<ContactEntity> showAllContacts() {
        PreparedStatement prstatement;
        List<ContactEntity> contactsList = new LinkedList<>();

        try {
            prstatement = dbConnection.getConnection().prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = prstatement.executeQuery();
            while (resultSet.next()) {
                ContactEntity contactEntity = new ContactEntity();
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

                contactEntity.setId(id);
                contactEntity.setName(name);
                contactEntity.setSurname(surname);
                contactEntity.setPatronymic(patronymic);
                contactEntity.setBirthday(birthdate);
                contactEntity.setGender(Gender.valueOf(gender));
                contactEntity.setCitizenship(citizenship);
                contactEntity.setMartialStatus(MaritalStatus.valueOf(maritalStatus));
                contactEntity.setWebsite(website);
                contactEntity.setEmail(email);
                contactEntity.setCurrentPlaceOfWork(currentPlaceOfWork);
                contactEntity.setCountry(country);
                contactEntity.setCity(city);
                contactEntity.setStreet(street);
                contactEntity.setHouse(house);
                contactEntity.setApartment(apartment);
                contactEntity.setPostcode(postcode);
                contactEntity.setPhoto(photo);
                contactEntity.setCreateTime(createTime.toInstant());
                contactEntity.setUpdateTime(updateTime.toInstant());
                contactsList.add(contactEntity);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return contactsList;
    }

    public Long saveContact(ContactEntity contact) {

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(ADD_TO_CONTACT_TABLE, Statement.RETURN_GENERATED_KEYS)) {

            java.util.Date utilDate = contact.getBirthday();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());


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
            ps.setTimestamp(17, Timestamp.from(Instant.now()));
            ps.setTimestamp(18, Timestamp.from(Instant.now()));
            ps.setDate(19, sqlDate);
            ps.execute();
            ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next())
                    contact.setId(generatedKeys.getLong(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contact.getId();
    }

    public ContactEntity findById(Long id) {
        ContactEntity contactEntity = new ContactEntity();
        try (PreparedStatement ps = dbConnection.getConnection().prepareStatement(SELECT_BY_ID + id)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {

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


                contactEntity.setId(id);
                contactEntity.setName(name);
                contactEntity.setSurname(surname);
                contactEntity.setPatronymic(patronymic);
                contactEntity.setBirthday(birthdate);
                contactEntity.setGender(Gender.valueOf(gender));
                contactEntity.setCitizenship(citizenship);
                contactEntity.setMartialStatus(MaritalStatus.valueOf(maritalStatus));
                contactEntity.setWebsite(website);
                contactEntity.setEmail(email);
                contactEntity.setCurrentPlaceOfWork(currentPlaceOfWork);
                contactEntity.setCountry(country);
                contactEntity.setCity(city);
                contactEntity.setStreet(street);
                contactEntity.setHouse(house);
                contactEntity.setApartment(apartment);
                contactEntity.setPostcode(postcode);
                contactEntity.setPhoto(photo);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contactEntity;
    }


    public void UpdateContact(ContactEntity updateEntity) {

        try (Connection connection = dbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(UPDATE_CONTACT)) {

            java.util.Date utilDate = updateEntity.getBirthday();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            ps.setString(1, updateEntity.getName());
            ps.setString(2, updateEntity.getSurname());
            ps.setString(3, updateEntity.getPatronymic());
            ps.setDate(4, sqlDate);
            ps.setString(5, updateEntity.getGender().toString());
            ps.setString(6, updateEntity.getCitizenship());
            ps.setString(7, updateEntity.getMartialStatus().toString());
            ps.setString(8, updateEntity.getWebsite());
            ps.setString(9, updateEntity.getEmail());
            ps.setString(10, updateEntity.getCurrentPlaceOfWork());
            ps.setString(11, updateEntity.getCountry());
            ps.setString(12, updateEntity.getCity());
            ps.setString(13, updateEntity.getStreet());
            ps.setString(14, updateEntity.getApartment());
            ps.setString(15, updateEntity.getPostcode());
            ps.setString(16, updateEntity.getPhoto());
            ps.setTimestamp(17, Timestamp.from(Instant.now()));
            ps.setLong(18, updateEntity.getId());
            ps.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteContact(long id){
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_BY_ID)){
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
