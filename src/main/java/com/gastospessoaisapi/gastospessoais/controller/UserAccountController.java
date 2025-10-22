package com.gastospessoaisapi.gastospessoais.controller;

import com.gastospessoaisapi.gastospessoais.domain.dto.userAccount.UserAccountRequestDto;
import com.gastospessoaisapi.gastospessoais.domain.dto.userAccount.UserAccountResponseDto;
import com.gastospessoaisapi.gastospessoais.domain.service.UserAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/usuarios")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping
    public ResponseEntity<List<UserAccountResponseDto>> getAll(){
        return ResponseEntity.ok(userAccountService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccountResponseDto> getById(@PathVariable Long id){
            return ResponseEntity.ok(userAccountService.getById(id));
    }

    @PostMapping
    public ResponseEntity<UserAccountResponseDto> register(@RequestBody UserAccountRequestDto dto) {
        UserAccountResponseDto user = userAccountService.register(dto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAccountResponseDto> update(@PathVariable Long id, @RequestBody UserAccountRequestDto dto) {
        UserAccountResponseDto user = userAccountService.update(id,dto);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        userAccountService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
