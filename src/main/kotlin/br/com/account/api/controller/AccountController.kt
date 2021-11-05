package br.com.account.api.controller

import br.com.account.api.request.AccountRequest
import br.com.account.api.response.AccountResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class AccountController {

    @PostMapping
    fun validate(@RequestBody request: AccountRequest) =
        ResponseEntity.ok(AccountResponse(status = "ok")
    )

}