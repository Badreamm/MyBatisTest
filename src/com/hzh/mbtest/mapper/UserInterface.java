package com.hzh.mbtest.mapper;

import org.apache.ibatis.annotations.Delete;

public interface UserInterface {
	@Delete("delete from user where id=#{id}")
	public void deleteUser(int id);
}
