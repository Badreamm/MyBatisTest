package com.hzh.mbtest.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hzh.mbtest.pojo.Author;
import com.hzh.mbtest.pojo.User;

public class TestUser {
	public static void main(String[] args) {
		String res = "com/hzh/mbtest/mapper/mybatisConfig.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(res);

		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		try {
			User user = new User();
			user.setName("tww");
			user.setPassword("123");
			session.insert("insertUser", user);
			System.out.println("新插入的用户id是："+user.getId());
			Author author = new Author();
			author.setRealName("田文文");
			author.setIdCard("123dddd");
			author.setUser(user);
			session.insert("insertAuthor", author);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		
	}
}
