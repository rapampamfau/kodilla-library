package com.crud.library.repository;

import com.crud.library.domain.Hire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HireRepository extends CrudRepository<Hire, Long> {

    @Override
    List<Hire> findAll();

    Optional<Hire> findById(Long copyId);
}
