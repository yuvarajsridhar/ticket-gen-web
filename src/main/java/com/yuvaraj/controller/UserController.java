package com.yuvaraj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.EmployeeDetail;
import com.yuvaraj.model.UserDetail;
import com.yuvaraj.service.EmployeeDetailService;
import com.yuvaraj.service.UserDetailService;

@Controller
@RequestMapping("/login")
public class UserController {
	@GetMapping("/userLogin")
	public String userLogin(@RequestParam("emailid") String emailid, @RequestParam("password") String password,
			ModelMap modelMap) {
		System.out.println("hi");
		UserDetail userDetail = new UserDetail();
		userDetail.setEmailId(emailid);
		userDetail.setPassword(password);
		System.out.println(userDetail.getEmailId());
		UserDetailService userDetailService = new UserDetailService();
		try {
			userDetailService.login(userDetail.getEmailId(), userDetail.getPassword());
			System.out.println(userDetail);
		} catch (ValidationException e) {
			e.printStackTrace();
			modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
			return "../userlogin.jsp";
		}
		return "../susscessfull.jsp";

	}

	
	  @GetMapping("/employeeLogin") 
	  public String employeelogin(@RequestParam("emailid") String emailid, @RequestParam("password") String password,ModelMap modelMap){ 
		 EmployeeDetail employeeDetail=new EmployeeDetail();
		  employeeDetail.setEmailId(emailid);
	   employeeDetail.setPassword(password);
	  EmployeeDetailService employeeDetailService=new EmployeeDetailService();
	  try{
	  employeeDetailService.login(employeeDetail.getEmailId(),employeeDetail.getPassword()); 
	  System.out.println("hi");
	  
	  }catch(ValidationException e){
		  e.printStackTrace();
		  modelMap.addAttribute("ERROR_MESSAGE",e.getMessage());
		  return"../userlogin.jsp";
	  }
	  return"../susscessfull.jsp";
	  }
	@GetMapping("/userregistration")
	public String userRegistration(@RequestParam("userid") Integer userid, @RequestParam("username") String username,
			@RequestParam("emailid") String emailid, @RequestParam("password") String password, ModelMap modelMap) {
		UserDetail userDetail = new UserDetail();
		userDetail.setEmailId(emailid);
		userDetail.setPassword(password);
		userDetail.setId(userid);
		userDetail.setName(username);
		System.out.println(userDetail);
		UserDetailService userDetailService = new UserDetailService();
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