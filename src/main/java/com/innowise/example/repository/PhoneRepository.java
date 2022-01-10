package com.innowise.example.repository;

import com.innowise.example.entity.PhoneEntity;
import com.innowise.example.entity.TypeOfPhone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;

public class PhoneRepository {

    private final static String ADD_TO_PHONE_TABLE = "insert into phone(country_code, operator_code, number, type, comment, create_time, update_time, contact_id)\n" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String SELECT_BY_CONTACT_ID = "select * from phone where contact_id = ?";

    private DbConnection dbConnection = DbConnection.getInstance();

    public void savePhone(PhoneEntity pEntity){
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(ADD_TO_PHONE_TABLE)){
            ps.setString(1, pEntity.getCountryCode());
            ps.setString(2, pEntity.getOperatorCode());
            ps.setString(3, pEntity.getNumber());
            ps.setString(4, pEntity.getType().name());
            ps.setString(5, pEntity.getComment());
            ps.setTimestamp(6, Timestamp.from(Instant.now()));
            ps.setTimestamp(7, Timestamp.from(Instant.now()));
            ps.setLong(8,pEntity.getContactId());
            ps.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public PhoneEntity getPhoneByContactId(Long contactId){
        PhoneEntity phoneEntity = new PhoneEntity();
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_BY_CONTACT_ID)){
            ps.setLong(1,contactId);
            ps.execute();
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String countryCode = resultSet.getString("country_code");
                String operatorCode = resultSet.getString("operator_code");
                String number = resultSet.getString("number");
                String type = resultSet.getString("type");
                String comment = resultSet.getString("comment");

                phoneEntity.setId(id);
                phoneEntity.setCountryCode(countryCode);
                phoneEntity.setOperatorCode(operatorCode);
                phoneEntity.setNumber(number);
                phoneEntity.setType(TypeOfPhone.valueOf(type));
                phoneEntity.setComment(comment);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phoneEntity;
    }
}
