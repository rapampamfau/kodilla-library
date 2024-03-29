package com.crud.library.service;

import com.crud.library.controller.StatusOfCopy;
import com.crud.library.domain.Copy;
import com.crud.library.domain.Hire;
import com.crud.library.domain.Book;
import com.crud.library.domain.User;
import com.crud.library.exceptions.CopyNotFoundException;
import com.crud.library.exceptions.UserNotFoundException;
import com.crud.library.repository.CopyRepository;
import com.crud.library.repository.HireRepository;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void addCopyToBookCopies(final Copy copy, final Book book) {
        book.getCopies().add(copy);
        copy.setBook(book);
    }

    public Copy changeStatus(final Long copyId) throws CopyNotFoundException {
        Copy copy = copyRepository.findById(copyId).orElseThrow(CopyNotFoundException::new);
        if (copy.getStatus() == StatusOfCopy.AVAILABLE) {
            copy.setStatus(StatusOfCopy.HIRED);
        } else if (copy.getStatus() == StatusOfCopy.HIRED) {
            copy.setStatus(StatusOfCopy.AVAILABLE);
        }
        return copy;
    }

    public Long checkAmountOfCopies(final Long bookId) {
        return copyRepository.getAvailableCopiesOfBook(bookId);
    }

    public Copy addCopyToHire(final Copy copy) throws CopyNotFoundException {
        Copy thisCopy = copyRepository.findByIdAndStatus(copy.getId(), copy.getStatus()).orElseThrow(CopyNotFoundException::new);
        thisCopy.setStatus(StatusOfCopy.HIRED);
        return thisCopy;
    }

    public User addUserToHire(final User user) throws UserNotFoundException {
        return userRepository.findById(user.getId()).orElseThrow(UserNotFoundException::new);
    }

    public void deleteHire(final Long hireId) {
        hireRepository.deleteById(hireId);
    }
}
