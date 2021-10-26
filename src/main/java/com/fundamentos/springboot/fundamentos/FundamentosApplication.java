package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBeaWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.component.ComponetDependency;
import com.sun.jdi.PrimitiveValue;
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

	public FundamentosApplication(@Qualifier("componentTwoDependency") ComponetDependency componetDependency, MyBean myBean, MyBeaWithDependency myBeaWithDependency){
		this.componetDependency=componetDependency;
		this.myBean=myBean;
		this.myBeaWithDependency=myBeaWithDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args)  {
		componetDependency.saludar();
		myBean.print();
		myBeaWithDependency.printWithDependency();
	}
}
