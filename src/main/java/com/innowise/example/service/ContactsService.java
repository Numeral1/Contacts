package com.innowise.example.service;

import com.innowise.example.dto.request.ContactRequest;
import com.innowise.example.dto.request.PhoneItem;
import com.innowise.example.dto.response.ContactShortResponse;
import com.innowise.example.dto.response.ContactResponse;
import com.innowise.example.entity.ContactEntity;
import com.innowise.example.entity.PhoneEntity;
import com.innowise.example.repository.ContactsRepository;
import com.innowise.example.repository.PhoneRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ContactsService {

    private ContactsRepository contactsRepository = new ContactsRepository();
    private PhoneRepository phoneRepository = new PhoneRepository();



    public List<ContactShortResponse> showAll() {
        List<ContactShortResponse> contactShortResponseList = new LinkedList<>();
        for (ContactEntity element : contactsRepository.showAllContacts()) {
            contactShortResponseList.add(ContactShortResponse.fromEntity(element));
        }
        return contactShortResponseList;
    }

    public long addContact(ContactRequest request) {
        ContactEntity contact = ContactRequest.toEntity(request);
        Long savedId = contactsRepository.saveContact(contact);
        List<PhoneItem> phoneList = request.getPhoneList();
        phoneList.stream()
                .map(phoneItem -> PhoneItem.toPhoneEntity(phoneItem, savedId))
                .forEach(phoneEntity -> phoneRepository.savePhone(phoneEntity));

        return savedId;
    }

    public ContactResponse findContactById(long id) {
        ContactEntity contact = contactsRepository.findById(id);
        ContactResponse contactDto = ContactResponse.fromEntity(contact);
        List<PhoneItem> phoneItems = new LinkedList<>();
        PhoneItem item= PhoneItem.fromPhoneEntity(phoneRepository.getPhoneByContactId(id));
        phoneItems.add(item);
        contactDto.setPhoneItemList(phoneItems);

        return contactDto;
    }

    public void UpdateEntity(ContactRequest updateContact){
        ContactEntity entity = ContactRequest.toEntity(updateContact);
        contactsRepository.UpdateContact(entity);
    }
    public void deleteById(Long id){
        contactsRepository.deleteContact(id);
    }
}
