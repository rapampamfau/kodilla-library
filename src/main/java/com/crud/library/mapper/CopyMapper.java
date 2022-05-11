package com.crud.library.mapper;

import com.crud.library.domain.Copy;
import com.crud.library.domain.CopyDto;
import org.springframework.stereotype.Service;

@Service
public class CopyMapper {

    public Copy mapToCopy(final CopyDto copyDto) {
        return new Copy(
                copyDto.getId(),
                copyDto.getTitleId(),
                copyDto.getStatus()
        );
    }

    public CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getTitleId(),
                copy.getStatus()
        );
    }
}
