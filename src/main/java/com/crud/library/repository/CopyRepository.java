package com.crud.library.repository;

import com.crud.library.domain.Copy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {

    @Override
    List<Copy> findAll();

    @Query
    int getAvailableCopiesOfBook(@Param(value = "bookId") Long id);

    @Override
    Optional<Copy> findById(Long copyId);
}
