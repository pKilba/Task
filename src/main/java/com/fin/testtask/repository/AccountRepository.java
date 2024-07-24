package com.fin.testtask.repository;

import com.fin.testtask.entity.Account;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @EntityGraph(attributePaths = "user")
    List<Account> findAll();

    Account findByUserId(Long userId);
}
