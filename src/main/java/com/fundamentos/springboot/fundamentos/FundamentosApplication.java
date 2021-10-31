package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBeaWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponetDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import com.sun.jdi.PrimitiveValue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	private ComponetDependency componetDependency;
	private MyBean myBean;
	private MyBeaWithDependency myBeaWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	private final Log LOGGER= LogFactory.getLog(FundamentosApplication.class);

	public FundamentosApplication(@Qualifier("componentTwoDependency") ComponetDependency componetDependency, MyBean myBean, MyBeaWithDependency myBeaWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){
		this.componetDependency=componetDependency;
		this.myBean=myBean;
		this.myBeaWithDependency=myBeaWithDependency;
		this.myBeanWithProperties=myBeanWithProperties;
		this.userPojo=userPojo;
		this.userRepository=userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args)  {

		//clasesAnteriores();
		try {
			saveUsersinDataBase();
			getInformationJPQL();
		}catch (Exception e){
			LOGGER.error("Esto es un error del aplicativo" + e.getMessage());
		}


	}
	private void getInformationJPQL(){
		LOGGER.info("usuario con el metodo findbyUserEmail "+userRepository.findByUserEmail("john5@domain.com").orElseThrow(()-> new RuntimeException("No se encontro el usuario") ));
		userRepository.findAndSort("John", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("users con meotod sort"+user));

		userRepository.findByName("John").stream().forEach(user -> LOGGER.info(" Usuario con query metod "+user));

		LOGGER.info("usuario buscado por email y name por query metod" +
				userRepository.findByNameAndEmail("John","john@domain.com").orElseThrow(
						()-> new RuntimeException("No se encontro el usuario por query metod") ));

		userRepository.findBynameLike("%John%").stream()
				.forEach(user -> LOGGER.info("uso de like en query metods"+user));

		userRepository.findByNameOrEmail(null,"john@domain.com").stream()
				.forEach(user -> LOGGER.info("uso de like en query metods con or"+user));

		userRepository.findByBirthDateBetween(LocalDate.of(2021,3,1),LocalDate.of(201,10,1)).stream()
				.forEach(user -> LOGGER.info("uso de metod con uso de betweenr"+user));

		userRepository.findByNameLikeOrderByIdDesc("%John%").stream()
				.forEach(user -> LOGGER.info("uso de like en query metods con order by y like"+user));
	}
	private void saveUsersinDataBase(){
		User user1 =new User("John","john@domain.com", LocalDate.of(2021,3,12));
		User user2 =new User("Julia","julian@domain.com", LocalDate.of(2021,5,12));
		User user3 =new User("John2","john2@domain.com", LocalDate.of(2021,6,12));
		User user4 =new User("John3","john3@domain.com", LocalDate.of(2021,7,12));
		User user5 =new User("John4","john4@domain.com", LocalDate.of(2021,8,12));
		User user6 =new User("John5","john5@domain.com", LocalDate.of(2021,9,12));
		User user7 =new User("Joh6","john6@domain.com", LocalDate.of(2021,10,12));

		List<User> list= Arrays.asList(user1,user2,user3,user4,user5,user6,user7);
		list.stream().forEach(userRepository::save);
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
