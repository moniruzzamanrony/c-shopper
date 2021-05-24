package com.itvillage.cshopper.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")

public class Product extends BaseEntity {


    @Column(nullable = true, length = 64)
    private String photos;
    @Column(nullable = true, length = 64)
    private String name;
    @Column(nullable = true, length = 64)
    private String price;
    @Column(nullable = true, length = 64)
    private String category;
    @Column(nullable = true, length = 64)
    private String description;
    private String quantity;



    @Transient
    public String getUserImagePath(){
        if (photos == null || id == null) return null;
        return "/user-photos/" + id + "/" +photos;
    }


}
