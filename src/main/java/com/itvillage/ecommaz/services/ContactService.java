package com.itvillage.ecommaz.services;


import com.itvillage.ecommaz.dto.response.ContactInfoResponse;
import com.itvillage.ecommaz.web.domain.Contact;
import com.itvillage.ecommaz.web.repository.ContactRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Setter
@Getter
@AllArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactInfoResponse getContactDetails() {
        Optional<Contact> contactOptional = contactRepository.findById(1l);
        if (!contactOptional.isPresent()) {
            throw new RuntimeException("Contact Details Not found");
        }
        Contact contact = contactOptional.get();
        ContactInfoResponse contactInfoResponse = new ContactInfoResponse();
        contactInfoResponse.setEmail(contact.getEmail());
        contactInfoResponse.setPhone(contact.getPhone());
        contactInfoResponse.setFacebookLink(contact.getFacebookLink());
        contactInfoResponse.setShopAddress(contact.getShopAddress());
        contactInfoResponse.setShopName(contact.getShopName());
        contactInfoResponse.setTwitterLink(contact.getTwitterLink());
        contactInfoResponse.setYoutubeLink(contact.getYoutubeLink());
        return contactInfoResponse;
    }
}
