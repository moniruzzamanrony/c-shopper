package com.itvillage.ecommaz.web.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nev_item")
public class NevItem {
    @Id
    private String nevId;

    private String nevItem;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "item_sub_items",
            joinColumns = @JoinColumn(name = "nev_id"),
            inverseJoinColumns = @JoinColumn(name = "sub_nev_id"))
    private List<NevSubItem> nevSubItems;

}
