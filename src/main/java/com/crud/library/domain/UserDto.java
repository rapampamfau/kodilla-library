package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private Date created;
}
