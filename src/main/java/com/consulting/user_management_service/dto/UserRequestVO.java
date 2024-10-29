package com.consulting.user_management_service.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class UserRequestVO {
    String username;
    String password;
    String email;
}
