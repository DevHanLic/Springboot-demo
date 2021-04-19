package com.example.spring.demo.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.spring.demo.entity.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {
	
    int deleteByPrimaryKey(String id);

    void insert(Login login);

    int insertSelective(Login record);

    Login selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login login);
    
    public Login login(Map<String, String> map);

    List<Login> list(String input);
	
	public int selectCount();
	
	public int selectusername(String username);
	 
	public List<Login> findByPage(HashMap<String, Object> map);
	
	public int selectCounts(String name);
	
	public List<Login> findByPages(@Param("name") String name, @Param("start") int start, @Param("size") int size);
	 
}