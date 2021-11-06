package br.com.account.config

import br.com.account.AccountServiceApplication
import br.com.account.domain.usecase.AccountUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = [AccountServiceApplication::class])
class BeanConfig {

    @Bean
    fun accountUseCaseImpl(): AccountUseCaseImpl = AccountUseCaseImpl()

}