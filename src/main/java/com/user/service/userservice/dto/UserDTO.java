package com.user.service.userservice.dto;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDTO {

    private String userId;
    private String name;
    private int age;
    private String gender;
    private List<String> invoiceNumbers;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
