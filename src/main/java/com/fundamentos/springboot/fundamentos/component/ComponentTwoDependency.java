package com.fundamentos.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoDependency implements ComponetDependency{
    @Override
    public void saludar() {
        System.out.println("Hello world");
    }
}
