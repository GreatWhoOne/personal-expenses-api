package com.gastospessoaisapi.gastospessoais.domain.service;

import java.util.List;

public interface ICRUDService<Req, Res> {
    List<Res> getAll();
    Res getById(Long id);
    Res register(Req dto);
    Res update(Long id, Req dto);
    void delete(Long id);

}
