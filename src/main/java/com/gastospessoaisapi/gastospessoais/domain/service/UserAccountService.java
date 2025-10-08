package com.gastospessoaisapi.gastospessoais.domain.service;


import com.gastospessoaisapi.gastospessoais.domain.dto.userAccount.UserAccountRequestDto;
import com.gastospessoaisapi.gastospessoais.domain.dto.userAccount.UserAccountResponseDto;

import java.util.List;

public class UserAccountService implements ICRUDService<UserAccountRequestDto, UserAccountResponseDto> {



    @Override
    public List<UserAccountResponseDto> getAll() {
        return List.of();
    }

    @Override
    public UserAccountResponseDto getById(Long id) {
        return null;
    }

    @Override
    public UserAccountResponseDto register(UserAccountRequestDto dto) {
        return null;
    }

    @Override
    public UserAccountResponseDto update(Long id, UserAccountRequestDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
