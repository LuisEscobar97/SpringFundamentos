package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeaWithDependency{

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }


    @Override
    public void printWithDependency() {
        System.out.println(myOperation.sum(1));
        System.out.println("Hola con la impelmenetacion ncon dependecia");
    }
}
