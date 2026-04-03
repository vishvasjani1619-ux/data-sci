package com.crud.project.response;

import com.crud.project.enums.UserStatus;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private UserStatus status;

}
