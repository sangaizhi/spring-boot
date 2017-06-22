package org.sangaizhi.springboot.jdbc;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sangaizhi.jdbc.model.User;
import org.sangaizhi.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbcApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test(){
		userService.save(new User("zhangsan1",1));
		userService.save(new User("zhangsan2",2));
		userService.save(new User("zhangsan3",3));
		userService.save(new User("zhangsan4",4));
		userService.save(new User("zhangsan5",5));

		List<Map<String, Object>> list = userService.queryList();
		if(null != list){
			for(Map<String, Object> map : list){
				for(Map.Entry<String, Object> entry :  map.entrySet()){
					System.out.println(entry.getKey() + ":" + entry.getValue());
				}
			}
		}
		userService.deleteByName("zhangsan3");
	}

}
