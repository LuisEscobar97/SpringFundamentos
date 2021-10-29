package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBeaWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponetDependency;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.sun.jdi.PrimitiveValue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	private ComponetDependency componetDependency;
	private MyBean myBean;
	private MyBeaWithDependency myBeaWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	private final Log LOGGER= LogFactory.getLog(FundamentosApplication.class);

	public FundamentosApplication(@Qualifier("componentTwoDependency") ComponetDependency componetDependency, MyBean myBean, MyBeaWithDependency myBeaWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo){
		this.componetDependency=componetDependency;
		this.myBean=myBean;
		this.myBeaWithDependency=myBeaWithDependency;
		this.myBeanWithProperties=myBeanWithProperties;
		this.userPojo=userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args)  {

		clasesAnteriores();

	}

	public void clasesAnteriores(){
		componetDependency.saludar();
		myBean.print();
		myBeaWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + userPojo.getPassword());
		try {

		}catch (Exception e){
			LOGGER.error("Esto es un error del aplicativo" + e.getMessage());
		}

	}
}
