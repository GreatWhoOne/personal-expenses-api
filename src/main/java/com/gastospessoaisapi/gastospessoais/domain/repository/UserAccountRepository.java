package com.gastospessoaisapi.gastospessoais.domain.repository;

import com.gastospessoaisapi.gastospessoais.domain.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
   List<UserAccount>findByEmail(String email);
}