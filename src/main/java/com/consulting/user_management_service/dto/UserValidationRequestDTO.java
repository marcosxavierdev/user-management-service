package com.consulting.user_management_service.dto;

import lombok.Value;

@Value
public class UserValidationRequestDTO {
    String username;
    String password;
}
