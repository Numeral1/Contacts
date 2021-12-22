package com.innowise.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.innowise.example.dto.request.ContactDtoRequest;
import com.innowise.example.dto.request.PhoneDtoRequest;
import com.innowise.example.entity.Gender;
import com.innowise.example.entity.MaritalStatus;
import com.innowise.example.entity.PhoneEntity;
import com.innowise.example.repository.ContactsRepository;
import com.innowise.example.service.ContactsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.stream.Collectors;


public class ContactServlet extends HttpServlet {
       ContactsService contactsService = new ContactsService();
       ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String contacts = mapper.writeValueAsString(contactsService.showAll());
       PrintWriter writer = resp.getWriter();
       writer.println(contacts);
       writer.close();



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String contactValue = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        ContactDtoRequest contacts = mapper.readValue(contactValue, ContactDtoRequest.class);
        contactsService.addContact(contacts);
        resp.getStatus();

    }
}
