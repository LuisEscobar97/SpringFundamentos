package com.fundamentos.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeaWithDependency{

    private MyOperation myOperation;
    Log LOGGER= LogFactory.getLog(MyBeanWithDependencyImplement.class);


    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }


    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos ingreado al meotodo print with dependency");
        int num=1;
        LOGGER.debug("el numero enviado como parametro a la dependencia operation es: "+num);
        System.out.println(myOperation.sum(num));

        System.out.println("Hola con la impelmenetacion ncon dependecia");
    }
}
