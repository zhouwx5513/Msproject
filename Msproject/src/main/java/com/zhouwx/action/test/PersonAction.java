package com.zhouwx.action.test;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.zhouwx.enity.test.Person;
import com.zhouwx.service.test.PersonService;

@Controller
public class PersonAction {
	
	@Autowired
	PersonService personService;
	
	@Test
	public void testPerson(){
		ApplicationContext applcition = new ClassPathXmlApplicationContext("application-context.xml");
		PersonAction personAction = (PersonAction) applcition.getBean("personAction");
//		Person person = personAction.personService.querypersonbyid(3);
		 Person person = new Person();
		 person.setName("С�װ�");
		 person.setAddress("�Ϻ�");
		 person.setAge(15);
		 person.setBirthday("05-04");
		 personAction.personService.inserperson(person);
		System.out.println(person);
	}
	
	

}
