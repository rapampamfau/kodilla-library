package com.crud.library.repository;

import com.crud.library.controller.StatusOfCopy;
import com.crud.library.domain.Copy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {

    @Override
    Optional<Copy> findById(Long copyId);

    Optional<Copy> findByIdAndStatus(Long copyId, StatusOfCopy status);

    @Query
    Long getAvailableCopiesOfBook(@Param(value = "book") Long id);
}
