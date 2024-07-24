package com.fin.testtask.service;

import com.fin.testtask.dto.AccountUserDTO;
import com.fin.testtask.entity.Account;

import java.math.BigDecimal;
import java.util.List;

/**
 * Интерфейс для управления операциями с банковскими счетами.
 */
public interface AccountService {

    /**
     * Получает список всех аккаунтов.
     *
     * @return Список всех аккаунтов.
     */
    List<Account> getAllAccounts();

    /**
     * Получает аккаунт по идентификатору пользователя.
     *
     * @param userId Идентификатор пользователя.
     * @return Аккаунт, принадлежащий указанному пользователю.
     */
    Account getAccountByUserId(Long userId);

    /**
     * Пополняет баланс аккаунта.
     *
     * @param accountId Идентификатор аккаунта.
     * @param amount    Сумма пополнения.
     */
    void deposit(Long accountId, BigDecimal amount);

    /**
     * Снимает средства с баланса аккаунта.
     *
     * @param accountId Идентификатор аккаунта.
     * @param amount    Сумма для снятия.
     */
    void withdraw(Long accountId, BigDecimal amount);

    /**
     * Блокирует аккаунт.
     *
     * @param accountId Идентификатор аккаунта.
     */
    void blockAccount(Long accountId);

    /**
     * Разблокирует аккаунт.
     *
     * @param accountId Идентификатор аккаунта.
     */
    void unblockAccount(Long accountId);

    /**
     * Получает аккаунт с данными пользователя.
     *
     * @param userId Идентификатор пользователя.
     * @return DTO с данными аккаунта и пользователя.
     */
    AccountUserDTO getAccountWithUser(Long userId);

    /**
     * Получает список всех аккаунтов с данными пользователей.
     *
     * @return Список DTO с данными аккаунтов и пользователей.
     */
    List<AccountUserDTO> getAllAccountsWithUsers();
}
