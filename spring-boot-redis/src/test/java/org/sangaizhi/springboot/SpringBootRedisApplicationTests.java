package org.sangaizhi.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sangaizhi.springboot.model.User;
import org.sangaizhi.springboot.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private RedisUtil redisUtil;

	@Test
	public void testPut() {
		User user = new User(1L, "sangaizhi", 24, "深圳市");
		redisUtil.put("user." + 1, user);
	}

	@Test
	public void testGet() {
		User user = redisUtil.getCache("user.1", User.class);
		System.out.println(user);
	}

}
