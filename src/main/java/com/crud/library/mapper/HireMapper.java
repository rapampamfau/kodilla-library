package com.crud.library.mapper;

import com.crud.library.domain.Hire;
import com.crud.library.domain.HireDto;
import org.springframework.stereotype.Service;

@Service
public class HireMapper {

    public Hire mapToHire(final HireDto hireDto) {
        return new Hire(
                hireDto.getId(),
                hireDto.getCopy(),
                hireDto.getUser(),
                hireDto.getHireDate(),
                hireDto.getReturnDate()
        );
    }
}
