package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class HireDto {

    private Copy copy;
    private User user;
    private Date hireDate;
    private Date returnDate;
}
