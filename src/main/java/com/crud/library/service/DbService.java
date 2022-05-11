package com.crud.library.service;

import com.crud.library.controller.StatusOfCopy;
import com.crud.library.domain.Copy;
import com.crud.library.domain.Hire;
import com.crud.library.domain.Title;
import com.crud.library.domain.User;
import com.crud.library.exceptions.CopyNotFoundException;
import com.crud.library.repository.CopyRepository;
import com.crud.library.repository.HireRepository;
import com.crud.library.repository.TitleRepository;
import com.crud.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DbService {

    private final CopyRepository copyRepository;
    private final HireRepository hireRepository;
    private final TitleRepository titleRepository;
    private final UserRepository userRepository;

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public Title saveTitle(final Title title) {
        return titleRepository.save(title);
    }

    public Copy saveCopy(final Copy copy) {
        return copyRepository.save(copy);
    }

    public Hire saveHire(final Hire hire) {
        return hireRepository.save(hire);
    }

    public int checkAmountOfCopies(final Long titleId) {
        return copyRepository.getAvailableCopiesOfTitle(titleId);
    }

    public void deleteHire(final Long hireId) {
        hireRepository.deleteById(hireId);
    }

    public Copy changeStatus(final Long copyId) throws CopyNotFoundException {
        Copy copy = getCopy(copyId);
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
