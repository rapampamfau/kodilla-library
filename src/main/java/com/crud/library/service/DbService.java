package com.crud.library.service;

import com.crud.library.controller.StatusOfCopy;
import com.crud.library.domain.Copy;
import com.crud.library.domain.Hire;
import com.crud.library.domain.Book;
import com.crud.library.domain.User;
import com.crud.library.exceptions.CopyNotFoundException;
import com.crud.library.repository.CopyRepository;
import com.crud.library.repository.HireRepository;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    private final CopyRepository copyRepository;
    private final HireRepository hireRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public Copy saveCopy(final Copy copy) {
        return copyRepository.save(copy);
    }

    public Hire saveHire(final Hire hire) {
        return hireRepository.save(hire);
    }

    public int checkAmountOfCopies(final Long bookId) {
        return copyRepository.getAvailableCopiesOfBook(bookId);
    }

    public void deleteHire(final Long hireId) {
        hireRepository.deleteById(hireId);
    }

    public Copy changeStatus(final Copy copy) {
        if (copy.getStatus() == StatusOfCopy.AVAILABLE) {
            copy.setStatus(StatusOfCopy.HIRED);
        } else {
            copy.setStatus(StatusOfCopy.AVAILABLE);
        }
        return copyRepository.save(copy);
    }

    public Copy getCopy(final Long copyId) throws CopyNotFoundException {
        return copyRepository.findById(copyId).orElseThrow(CopyNotFoundException::new);
    }
}
