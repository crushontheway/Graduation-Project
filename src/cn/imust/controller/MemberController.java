package cn.imust.controller;

import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.imust.pojo.Member;
import cn.imust.pojo.MemberRegisterFormBean;
import cn.imust.service.MemberService;

@Controller
@RequestMapping("")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("listMember")
	public String list(Model model) {
		List<Member> list = memberService.list();
		model.addAttribute("ms", list);
		return "fore/listMember";
	}
	
	@RequestMapping("memberForeRegister")
	public String addShop(MemberRegisterFormBean memberRegisterFormBean, HttpServletRequest request) {
		if (memberRegisterFormBean.validate(request) == false) {
			request.setAttribute("MemberRegisterFormBean", memberRegisterFormBean);
			return "fore/memberRegister";
		}
		if(memberService.isExist(memberRegisterFormBean.getId()))
		{
			memberRegisterFormBean.getErrors().put("id", "�û����Ѿ�����");
			request.setAttribute("MemberRegisterFormBean", memberRegisterFormBean);
			return "fore/memberRegister";
		}else {	
			Member member = new Member(memberRegisterFormBean.getId(),memberRegisterFormBean.getPassword(),memberRegisterFormBean.getUsername(),memberRegisterFormBean.getTel(),memberRegisterFormBean.getAddress());
			request.setAttribute("MemberRegisterFormBean", memberRegisterFormBean);
			memberService.add(member);
			return "fore/registerSuccess";
		}
	}
	
	@RequestMapping(value="memberforelogin",method=RequestMethod.POST)
	public String memberLogin(HttpServletRequest request) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Member member = memberService.login(id, password);
		if(member!=null) {
			request.getSession().setAttribute("member", member);
			request.setAttribute("message", "��ϲ��&nbsp;"+member.getUsername()+"��¼�ɹ�������ҳ����3���������ҳ����");
			return "fore/message";
		}else{
			request.setAttribute("message", "��¼ʧ�ܣ����˺Ż�������󣬱�ҳ����3���������ҳ����");
			return "fore/message";
		}
		
	}
	
	@RequestMapping("memberLogout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("member");
		request.setAttribute("message", "���߳ɹ�����ҳ����3���������ҳ����");
		return "fore/message";
	}
	
	@RequestMapping("memberInformation")
    public String memberInformation() {
    	return "back/memberInformation";
    }
	
	@RequestMapping("showMemberInformation")
	public String showMemberInformation(Map<String,Object> map,HttpServletRequest request) {
		Member member = (Member) request.getSession().getAttribute("member");
		map.put("member", member);
		return "back/showMemberInformation";
	}
	
	@RequestMapping("updateMemberInformation")
	public String updateMemberInformation(Member member,HttpServletRequest request) {
		int isUpdate = memberService.update(member);
		if(isUpdate !=0) {
			request.setAttribute("message", "�޸ĳɹ�����ҳ����3���������ҳ��");
		}
		return "fore/message"; 
	}
}
