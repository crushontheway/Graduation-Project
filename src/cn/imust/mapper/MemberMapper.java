package cn.imust.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.imust.pojo.Member;
import cn.imust.pojo.Shop;

public interface MemberMapper {
	List<Member> list();
	void add(Member member);
	int isExist(String id);
	Member login(@Param("id") String id,@Param("password")String password);
	int update(Member member);
	Member getMemberByid(@Param("id") String id);
}
