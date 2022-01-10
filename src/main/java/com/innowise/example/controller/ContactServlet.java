package com.innowise.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.innowise.example.dto.request.ContactRequest;
import com.innowise.example.dto.request.PhoneItem;
import com.innowise.example.dto.response.ContactResponse;
import com.innowise.example.service.ContactsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;


public class ContactServlet extends HttpServlet {

    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContactsService contactsService = new ContactsService();
        Long contactId;

        String idPath = req.getPathInfo();
        PrintWriter writer = resp.getWriter();
        if (idPath == null) {

            String contacts = mapper.writeValueAsString(contactsService.showAll());
            writer.println(contacts);
        } else {
            String id = idPath.replaceAll("[^0-9]", "");
            contactId = Long.parseLong(id);
            ContactResponse contactById = contactsService.findContactById(contactId);
            String oneContact = mapper.writeValueAsString(contactById);
            writer.println(oneContact);
        }
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContactsService contactsService = new ContactsService();
        String contactValue = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        ContactRequest contacts = mapper.readValue(contactValue, ContactRequest.class);
        long id = contactsService.addContact(contacts);

        resp.setHeader(String.valueOf(HttpServletResponse.SC_CREATED), "http://localhost:8080/contacts/" + id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContactsService contactsService = new ContactsService();
        Long contactId;
        String idPath = req.getPathInfo();
        String id = idPath.replaceAll("[^0-9]", "");
        contactId = Long.parseLong(id);
        String updateContactValue = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        ContactRequest contact = mapper.readValue(updateContactValue, ContactRequest.class);
        contact.setId(contactId);
        contactsService.UpdateEntity(contact);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContactsService contactsService = new ContactsService();
        Long contactId;
        String idPath = req.getPathInfo();
        String id = idPath.replaceAll("[^0-9]", "");
        contactId = Long.parseLong(id);
        contactsService.deleteById(contactId);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
