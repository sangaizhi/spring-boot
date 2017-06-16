package org.sangaizhi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sangaizhi.dao.UserDao;
import org.sangaizhi.mdoel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	public void test() {
		for (int i = 65; i < 65 + 26; i++) {
			userDao.save(new User("zhang" + (char) i, i, "address" + (char) i));
		}
		List<User> bUserList = userDao.findByName("zhang1");
		List<User> cUserList = userDao.getByName("zhangC");
		List<User> dUserList = userDao.readByName("zhangD");
		List<User> likeUserList = userDao.findByNameLike("ang");
		List<User> naUserList = userDao.findByNameAndAddress("zhangA", "addressA");
		List<User> firstUserList = userDao.findFirst10ByName("zhang");
		List<User> topUserList = userDao.findTop30ByAddressLike("address");
		List<User> nameQueryList = userDao.findByNameWithNamedQuery("zhangE");
		List<User> argsIndexList = userDao.findByAddressWithArgIndex("addressE");
		List<User> argsNameList = userDao.findByAddressWithArgsName("addressE");
		int result = userDao.updateName("zhangf", "zhangF");
		Page<User> userPage = userDao.findByName("zhangG", new PageRequest(0, 10));
		List<User> sortUser = userDao.findByName("zhangH", new Sort(Sort.Direction.ASC, "age"));

	}

}
