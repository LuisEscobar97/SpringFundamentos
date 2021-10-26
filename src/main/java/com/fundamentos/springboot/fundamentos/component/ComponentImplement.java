package com.fundamentos.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponetDependency{
    @Override
    public void saludar() {
        System.out.println("hola mundo desde mi componente");
    }
}
