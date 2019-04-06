package cn.imust.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.imust.pojo.Member;

public interface MemberService {
	List<Member> list();
	void add(Member member);
	Boolean isExist(String id);
	Member login(String id,String password);
	int update(Member member);
	Member getMemberByid(@Param("id") String id);
}
