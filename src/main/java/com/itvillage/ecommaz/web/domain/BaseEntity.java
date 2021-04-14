package com.itvillage.ecommaz.web.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id of persisted entity.
     */
    @Id
    private String id;

    /**
     * Username (aka email) of creator.
     * Auto updated by Hibernate.
     */
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    /**
     * Date time when entity got persisted first time by Hibernate.
     * Auto updated by Hibernate
     */
    @CreatedDate
    @Column(nullable = true, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Username (aka email) of updater.
     * Auto updated by Hibernate.
     */
    @LastModifiedBy
    @Column(nullable = true)
    private String updatedBy;


    /**
     * Date time when entity got updated by Hibernate.
     */
    @LastModifiedDate
    @Column(nullable = true)
    private LocalDateTime updatedAt;
}
