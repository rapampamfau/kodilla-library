package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookDto;
import org.springframework.stereotype.Service;

@Service
public class TitleMapper {

    public Book mapToTitle(final BookDto titleDto) {
        return new Book(
                titleDto.getId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getYear(),
                titleDto.getCopies()
        );
    }

    public BookDto mapToTitleDto(final Book title) {
        return new BookDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getYear(),
                title.getCopies()
        );
    }
}
