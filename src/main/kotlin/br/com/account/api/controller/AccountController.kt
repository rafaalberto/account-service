package br.com.account.api.controller

import br.com.account.api.request.AccountRequest
import br.com.account.api.request.asDomainModel
import br.com.account.api.response.AccountResponse
import br.com.account.domain.usecase.AccountUseCase
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class AccountController(private val accountUseCase: AccountUseCase) {

    @PostMapping
    fun create(@RequestBody request: AccountRequest): ResponseEntity<AccountResponse> {
        accountUseCase.createAccount(request.asDomainModel())
        return ResponseEntity(
            AccountResponse(message = "Account created successfully"), CREATED
        )
    }

}