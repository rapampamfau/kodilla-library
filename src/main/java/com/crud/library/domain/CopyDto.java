package com.crud.library.domain;

import com.crud.library.controller.StatusOfCopy;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CopyDto {

    private Long id;
    private Title titleId;
    private StatusOfCopy status;
}
