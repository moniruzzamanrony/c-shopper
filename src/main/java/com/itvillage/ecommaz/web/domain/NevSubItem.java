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
@Table(name = "nev_sub_item")
public class NevSubItem {
    @Id
    private String nevSubId;

    private String nevSubItem;

}
