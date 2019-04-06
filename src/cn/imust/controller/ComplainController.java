package cn.imust.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.imust.pojo.Complain;
import cn.imust.pojo.Member;
import cn.imust.service.ComplainService;

@Controller
public class ComplainController {
	@Autowired
	ComplainService complainService;
	
	@RequestMapping("addComplainPage")
	public String addComplainPage(HttpServletRequest request) {
		Member member = (Member) request.getSession().getAttribute("member");
		request.setAttribute("m_id",member.getId());
		return "back/addComplainPage";
	}
	
	@RequestMapping(value="addComplain",method=RequestMethod.POST)
	public String addComplain(HttpServletRequest request) {
		String m_id = request.getParameter("m_id");
		Timestamp commitDate = new Timestamp(System.currentTimeMillis());
		String content  = request.getParameter("content");
		Complain complain = new Complain();
		complain.setCommitDate(commitDate);
		complain.setM_id(m_id);
		complain.setContent(content);
		complainService.addComplain(complain);
		request.setAttribute("message", "Í¶Ëß³É¹¦£¡£¡");
		return "fore/message";
	}
	
}
