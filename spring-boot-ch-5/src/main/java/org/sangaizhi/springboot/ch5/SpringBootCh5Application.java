package org.sangaizhi.springboot.ch5;

import org.sangaizhi.springboot.ch5.model.Person;
import org.joda.time.DateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@SpringBootApplication
public class SpringBootCh5Application {


	@RequestMapping("/index")
	private String index(Model model){
		Person person = new Person("zhangsan", 10,(short)0);
		model.addAttribute("person", person);
		List<Person> personList = new ArrayList<>();
		Person person1 = new Person("lisi", 11, (short)1);
		Person person2 = new Person("wangwu", 19, (short)0);
		Person person3 = new Person("maliu", 13, (short)2);
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		model.addAttribute("personList", personList);

		Date date = new Date();
		model.addAttribute("date", date);

		Date[] dateArray = new Date[2];
		dateArray[0] = DateTime.now().plusDays(1).toDate();
		dateArray[1] = DateTime.now().plusDays(2).toDate();
		model.addAttribute("dateArray", dateArray);

		List dateList = new ArrayList();
		for(int i = 3;i<6;i++){
			dateList.add(DateTime.now().plusDays(i).toDate());
		}
		model.addAttribute("dateList", dateList);

		Set<Date> dateSet = new HashSet<>();
		dateSet.add(DateTime.now().plusDays(6).toDate());
		dateSet.add(DateTime.now().plusDays(7).toDate());
		dateSet.add(DateTime.now().plusDays(8).toDate());
		model.addAttribute("dateSet", dateSet);

		String name = "String Is Empty Test";
		model.addAttribute("name", name);

		String[] nameArr = new String[2];
		nameArr[0] = "Array Is Empty Test 1";
		nameArr[1] = "Array Is Empty Test 2";
		model.addAttribute("nameArr", nameArr);

		List nameList = new ArrayList();
		nameList.add("List Is Empty Test 1");
		nameList.add("List Is Empty Test 2");
		model.addAttribute("nameList", nameList);

		Set nameSet = new HashSet();
		nameSet.add("Set Is Empty Test 1");
		nameSet.add("Set Is Empty Test 2");
		model.addAttribute("nameSet", nameSet);

		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCh5Application.class, args);
	}
}
