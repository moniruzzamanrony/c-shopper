//package com.itvillage.cshopper.domain.model;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.GeneratorType;
//import org.springframework.data.annotation.CreatedBy;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedBy;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import javax.persistence.*;
//import java.io.Serializable;
//@Entity
//@Setter
//@Getter
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
//public class BaseEntity implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @CreatedBy
//    private String createBy;
//
//    @CreatedDate
//    private String createDate;
//
//    @LastModifiedBy
//    private String lastUpdateBy;
//
//    @LastModifiedDate
//    private String lastUpdateDate;
//}
