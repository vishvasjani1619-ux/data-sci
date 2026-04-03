package com.crud.project.request;

import com.crud.project.enums.UserStatus;
import lombok.Data;

@Data
public class UserDTO {

    private String name;
    private String email;
    private UserStatus status;
}
