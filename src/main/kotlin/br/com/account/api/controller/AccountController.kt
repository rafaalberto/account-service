package br.com.account.api.controller

import br.com.account.api.request.AccountRequest
import br.com.account.api.response.AccountResponse
import br.com.account.domain.entity.Account
import br.com.account.domain.usecase.AccountUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class AccountController(private val accountUseCase: AccountUseCase) {

    @PostMapping
    fun validate(@RequestBody request: AccountRequest) : ResponseEntity<AccountResponse> {
        val account = Account(
            fullName = request.fullName,
            email = request.email,
            password = request.password,
            confirmPassword = request.confirmPassword,
            active = request.active
        )
        accountUseCase.validateAccount(account)
        return ResponseEntity.ok(AccountResponse(status = "ok"))
    }

}