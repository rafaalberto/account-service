package br.com.account.api.exception

import br.com.account.domain.exception.AccountException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler {

    @ExceptionHandler(AccountException::class)
    fun handleAppException(exception: AccountException) =
        ResponseEntity.badRequest().body(ErrorResponse(exception.description))
}

class ErrorResponse(val message: String)