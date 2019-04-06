package cn.imust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.imust.mapper.MemberMapper;
import cn.imust.pojo.Member;
import cn.imust.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberMapper memberMapper;
	
	public List<Member> list(){
		return memberMapper.list();
	}

	public void add(Member member) {
		// TODO Auto-generated method stub
		memberMapper.add(member);
		
	}

	public Boolean isExist(String id) {
		// TODO Auto-generated method stub
		int isExist = memberMapper.isExist(id);
		if(isExist!=0)
			return true;
		return false;
	}

	public Member login(String id, String password) {
		// TODO Auto-generated method stub
		return memberMapper.login(id, password);
	}
	
	public int update(Member member) {
		return memberMapper.update(member);
	}

	@Override
	public Member getMemberByid(String id) {
		// TODO Auto-generated method stub
		return memberMapper.getMemberByid(id);
	}
	
	
}
