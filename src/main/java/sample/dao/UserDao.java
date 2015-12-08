package sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import sample.entity.User;

@Component
public class UserDao {

	@Autowired
	JdbcTemplate jdbctemplate;

	public List<User> selectAll() {
		String sql = "select * from users";

		return jdbctemplate.query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User entity = new User();
				entity.setId(rs.getInt("id"));
				entity.setName(rs.getString("name"));
				entity.setEmail(rs.getString("email"));
				entity.setPassword(rs.getString("password"));
				entity.setRememberToken(rs.getString("remember_token"));
				entity.setCreatedAt(rs.getDate("created_at"));
				entity.setUpdatedAt(rs.getDate("updated_at"));
				return entity;
			}
		});
	}

	public User selectById(int id) {
		String sql = "select * from users where id = ?";

		try {

			return jdbctemplate.queryForObject(sql, new RowMapper<User>() {
				@Override
				public User mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					User entity = new User();
					entity.setId(rs.getInt("id"));
					entity.setName(rs.getString("name"));
					entity.setEmail(rs.getString("email"));
					entity.setPassword(rs.getString("password"));
					entity.setRememberToken(rs.getString("remember_token"));
					entity.setCreatedAt(rs.getDate("created_at"));
					entity.setUpdatedAt(rs.getDate("updated_at"));
					return entity;
				}
			}, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}
}
