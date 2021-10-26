package com.fundamentos.springboot.fundamentos.configuracion;

import com.fundamentos.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    @Bean
    public MyBean beanOperation(){
        return  new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationNumber(){
        return  new MyOperationNumber();
    }
    @Bean
    public MyBeaWithDependency beanOperationNumberwithDependency(MyOperation myOperation){
        return  new MyBeanWithDependencyImplement(myOperation);
    }
}
