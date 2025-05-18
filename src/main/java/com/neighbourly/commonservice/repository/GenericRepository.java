package com.neighbourly.commonservice.repository;

import com.neighbourly.commonservice.errorhandling.Either;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface GenericRepository<T, ID> {
    Either<String, T> save(T entity);
    Either<String, Optional<T>> findById(ID id);
    Either<String, List<T>> findAll();
    Either<String, Page<T>> findAll(Pageable pageable);
    Either<String, List<T>> findByCriteria(Criteria criteria);
    Either<String, Void> deleteById(ID id);
    Either<String, T> update(T entity);
}