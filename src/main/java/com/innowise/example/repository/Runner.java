package com.innowise.example.repository;

public class Runner {
    public static void main(String[] args) {
        DbConnection connection = DbConnection.getInstance();
        ContactsRepository contactsRepository = new ContactsRepository(connection);

        contactsRepository.showAllContacts();
    }
}
