package com.fundamentos.springboot.fundamentos.configuracion;

import com.fundamentos.springboot.fundamentos.caseuse.GetUser;
import com.fundamentos.springboot.fundamentos.caseuse.GetUserImplement;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CaseUseConfiguration implements GetUser {

    @Override
    public List<User> getAll() {
        return null;
    }

    @Bean
    GetUser getUser(UserService userService){

        return new GetUserImplement(userService);

    }

}
