package com.gastospessoaisapi.gastospessoais.domain.service;

import com.gastospessoaisapi.gastospessoais.domain.dto.userAccount.UserAccountRequestDto;
import com.gastospessoaisapi.gastospessoais.domain.dto.userAccount.UserAccountResponseDto;
import com.gastospessoaisapi.gastospessoais.domain.exceptions.ResourceBadRequestException;
import com.gastospessoaisapi.gastospessoais.domain.exceptions.ResourceNotFoundException;
import com.gastospessoaisapi.gastospessoais.domain.model.UserAccount;
import com.gastospessoaisapi.gastospessoais.domain.repository.UserAccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserAccountService implements ICRUDService<UserAccountRequestDto, UserAccountResponseDto> {

    private UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<UserAccountResponseDto> getAll() {
        List<UserAccount> userAccounts = userAccountRepository.findAll();

        return userAccounts.stream()
        .map(user -> mapper.map(user, UserAccountResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserAccountResponseDto getById(Long id) {
        Optional<UserAccount> optionalUserAccount = userAccountRepository.findById(id);

        if(optionalUserAccount.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possível encontrar o usuário com o id: " + id);
        }

        return mapper.map(optionalUserAccount.get(), UserAccountResponseDto.class);

    }

    @Override
    public UserAccountResponseDto register(UserAccountRequestDto dto) {
        validateUser(dto);
       UserAccount userAccount = mapper.map(dto, UserAccount.class);
       userAccount.setId(null);
       userAccountRepository.save(userAccount);
       return mapper.map(userAccount, UserAccountResponseDto.class);
    }

    @Override
    public UserAccountResponseDto update(Long id, UserAccountRequestDto dto) {
        getById(id);
        validateUser(dto);
        UserAccount userAccount = mapper.map(dto, UserAccount.class);
        userAccount.setId(id);
        userAccountRepository.save(userAccount);
        return mapper.map(userAccount, UserAccountResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        userAccountRepository.deleteById(id);
    }

    private void validateUser(UserAccountRequestDto dto) {
        if(dto.getEmail() == null || dto.getPassword() == null) {
            throw new ResourceBadRequestException("E-mail e senha são obrigatórios");
        }
    }
}
