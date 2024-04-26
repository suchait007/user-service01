package com.user.service.userservice.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "user_record", schema = "user_db")
public class User {


    @Column(name = "user_id")
    @Id
    @GeneratedValue(generator = "UUID")
    private String id;
    private String name;
    private int age;
    private String gender;

    @OneToMany(mappedBy = "user")
    @Column(name = "invoice_numbers")
    List<Invoice> invoicesNumbers;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

}
