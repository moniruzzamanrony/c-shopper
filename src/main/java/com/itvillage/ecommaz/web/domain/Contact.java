package com.itvillage.ecommaz.web.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contacts")
public class Contact {

    @Id
    private Long id;

    private String shopName;

    private String shopDescription;

    private String shopAddress;

    private String email;

    private String phone;

    private String facebookLink;

    private String twitterLink;

    private String youtubeLink;

    private String mapLocationLink;
}
