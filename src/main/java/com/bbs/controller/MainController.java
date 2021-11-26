package com.bbs.controller;


import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbs.service.UsersService;
import com.bbs.v.Users;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Inject
	UsersService usersService;
	
	
	//url패턴이 'path/'일 경우
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Model model) throws Exception{
		
//		model.addAttribute("msg","반갑습니다.");
		
		
		return "main/main";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) throws Exception{
		
		
		return "main/join";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) throws Exception{
		
		
		return "main/login";
	}
	
	@RequestMapping(value="/idCheck", method = RequestMethod.GET)
	@ResponseBody
	public String idCheck(String user_id) throws Exception{
		
		System.out.println(user_id);
		
		int result = usersService.idCheck(user_id);
		
		return result + "";
		
	}
	
	@RequestMapping(value="/sendAuthMail", method = RequestMethod.GET)
	@ResponseBody
	public String sendAuthMail(String user_mail) throws Exception{
		
		int result = usersService.setAuthnum(user_mail);
		
		return result+"";
	}
	
	//path/mailAuth
	@RequestMapping(value="/mailAuth", method =  RequestMethod.POST)
	@ResponseBody
	public String mailAuth(String user_mail, String auth_num) throws Exception{
		
		return "0";
	}
	
	//path/joinAction
	@RequestMapping(value="/joinAction", method = RequestMethod.POST)
	public String joinActino(Users users, String addr1, String addr2, String addr3) throws Exception{
		users.setUser_addr(addr1+" "+addr2+" "+addr3);
		usersService.joinAction(users);
		
		return "redirect:/login";		
	}
	
}
