package com.yuvaraj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.UserDetail;
import com.yuvaraj.service.UserDetailService;



@Controller
@RequestMapping("/login")
public class UserController {
@GetMapping("/userLogin")
public String userlogin(@RequestParam("emailid") String emailid, @RequestParam("password") String password){
	UserDetail userDetail=new UserDetail();
	userDetail.setEmailId(emailid);
	userDetail.setPassword(password);
	UserDetailService userDetailService=new UserDetailService();
	 userDetailService.login(userDetail.getEmailId(), userDetail.getPassword());
	 return "susscessfull.jsp";
	
}
@GetMapping("/registration")
public String userRegistration(@RequestParam("userid")Integer userid, @RequestParam("username")String username,@RequestParam("emailid")String emailid,@RequestParam("password")String password, ModelMap modelMap) {
	UserDetail  userDetail=new UserDetail();
	userDetail.setEmailId(emailid);
	userDetail.setPassword(password);
	userDetail.setId(userid);
	userDetail.setName(username);
	System.out.println(userDetail);
	UserDetailService userDetailService=new  UserDetailService();
	try {
		userDetailService.regestration(userDetail);
	} catch (ValidationException e) {
		e.printStackTrace();
		modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
		return "../error.jsp";
		
	}
	return "../susscessfull.jsp";
	
}
}