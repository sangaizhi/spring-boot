package org.sangaizhi.jdbc.service;

import java.util.List;

import org.sangaizhi.jdbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author sangaizhi
 * @date 2017/6/16
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(User user) {
		jdbcTemplate.update("INSERT INTO t_user(name, age) VALUES (?, ?)", user.getName(), user.getAge());
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM t_user WHERE id=?", id);
	}

	@Override
	public void deleteByName(String name) {
		jdbcTemplate.update("DELETE FROM t_user WHERE name=?", name);
	}

	@Override
	public List queryList() {
		return jdbcTemplate.queryForList("SELECT id,name,age FROM t_user ");
	}

	@Override
	public void deleteAll() {
		jdbcTemplate.update("DELETE FROM t_user");
	}
}
