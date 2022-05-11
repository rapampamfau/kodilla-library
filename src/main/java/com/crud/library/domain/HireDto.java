package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class HireDto {

    private Long id;
    private Copy copy;
    private User user;
    private LocalDate hireDate;
    private LocalDate returnDate;
}
