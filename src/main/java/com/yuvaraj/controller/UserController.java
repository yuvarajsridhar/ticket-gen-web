package com.yuvaraj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.Department;
import com.yuvaraj.model.EmployeeDetail;
import com.yuvaraj.model.Role;
import com.yuvaraj.model.UserDetail;
import com.yuvaraj.service.EmployeeDetailService;
import com.yuvaraj.service.UserDetailService;

@Controller
@RequestMapping("/login")
public class UserController {
	
	@GetMapping("/userLogin")
	public String userLogin(@RequestParam("emailid") String emailid, @RequestParam("password") String password,
			ModelMap modelMap,HttpSession session) {
		System.out.println("hi");
		UserDetail userDetail = new UserDetail();
		userDetail.setEmailId(emailid);
		userDetail.setPassword(password);
		System.out.println(userDetail.getEmailId());
		UserDetailService userDetailService = new UserDetailService();
		try {
			UserDetail row=userDetailService.login(userDetail.getEmailId(), userDetail.getPassword());
			System.out.println(userDetail);
			session.setAttribute("userid", row);
		} catch (ValidationException e) {
			e.printStackTrace();
			modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
			return "../userlogin.jsp";
		}
		return "../susscessfull.jsp";

	}
	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "../index.jsp";
	}

	
	  @GetMapping("/employeelogin") 
	  public String employeelogin(@RequestParam("emailid") String emailid, @RequestParam("password") String password,ModelMap modelMap,HttpSession session){ 
		 EmployeeDetail employeeDetail=new EmployeeDetail();
		  employeeDetail.setEmailId(emailid);
	   employeeDetail.setPassword(password);
	  EmployeeDetailService employeeDetailService=new EmployeeDetailService();
	  try{
		  System.out.println("hi");
	     EmployeeDetail row=  employeeDetailService.login(employeeDetail.getEmailId(),employeeDetail.getPassword()); 
	    session.setAttribute("employeeid", row);
	  
	  }catch(ValidationException e){
		  e.printStackTrace();
		  modelMap.addAttribute("ERROR_MESSAGE",e.getMessage());
		  return"../employeelogin.jsp";
	  }
	  return"../successfull.jsp";
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
			return "../userregistration.jsp";

		}
		modelMap.addAttribute("ERROR_MESSAGE","successfully registered");
		return "../index.jsp";

	}
	@GetMapping("/employeeregistration")
	public String employeeregistration(@RequestParam("employeeid") Integer employeeid,@RequestParam("employeename") String employeename
			,@RequestParam("emailid") String emailid,@RequestParam("password") String password,@RequestParam("department") Integer department,
			@RequestParam("role") Integer role,ModelMap modelMap){
		EmployeeDetail employeeDetail=new EmployeeDetail();
		employeeDetail.setId(employeeid);
		employeeDetail.setName(employeename);
		employeeDetail.setEmailId(emailid);
		employeeDetail.setPassword(password);
		Department depart=new Department();
		depart.setId(department);
		employeeDetail.setDepartment(depart); 
		Role rol=new Role();
		rol.setId(role);
		employeeDetail.setRole(rol);
		EmployeeDetailService employeeDetailService=new EmployeeDetailService();
		try{
			employeeDetailService.save(employeeDetail);
		}catch(ValidationException e){
			e.printStackTrace();
			modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
			return "../employeeregistration.jsp";
		}
		modelMap.addAttribute("ERROR_MESSAGE","successfully registered");
		return "../index.jsp";
	}
}