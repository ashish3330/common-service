package com.neighbourly.commonservice.service;

import com.neighbourly.commonservice.errorhandling.Either;
import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID, DTO> {
    Either<String, DTO> create(DTO dto);
    Either<String, Optional<DTO>> getById(ID id);
    Either<String, List<DTO>> getAll();
    Either<String, DTO> update(ID id, DTO dto);
    Either<String, Void> delete(ID id);
}