package com.innowise.example.service;

import com.innowise.example.dto.request.ContactDtoRequest;
import com.innowise.example.dto.response.ContactDtoResponse;
import com.innowise.example.entity.ContactsEntity;
import com.innowise.example.repository.ContactsRepository;

import java.util.ArrayList;
import java.util.List;

public class ContactsService {
    ContactsRepository contactsRepository = new ContactsRepository();
    List<ContactDtoResponse> contactDtoResponseList = new ArrayList<>();

    public List<ContactDtoResponse> showAll() {
        for (ContactsEntity element : contactsRepository.showAllContacts()) {
            contactDtoResponseList.add(ContactDtoResponse.toModel(element));
        }
        return contactDtoResponseList;
    }

    public void addContact(ContactDtoRequest request) {
        ContactsEntity contact = ContactDtoRequest.toEntity(request);
        contactsRepository.saveContact(contact);
    }

    public ContactDtoResponse findContactById(long id) {
        ContactDtoResponse contactDto = new ContactDtoResponse();
        contactDto.setId(contactsRepository.findById(id).getId());
        contactDto.setName(contactsRepository.findById(id).getName());
        contactDto.setSurname(contactsRepository.findById(id).getSurname());
        contactDto.setPatronymic(contactsRepository.findById(id).getPatronymic());
        return contactDto;
    }
}
