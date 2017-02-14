package com.yuvaraj.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yuvaraj.dao.TicketDetailDao;
import com.yuvaraj.exception.ValidationException;
import com.yuvaraj.model.Department;
import com.yuvaraj.model.EmployeeDetail;
import com.yuvaraj.model.Issue;
import com.yuvaraj.model.TicketDetail;
import com.yuvaraj.model.UserDetail;
import com.yuvaraj.service.IssueService;
import com.yuvaraj.service.TicketDetailService;
@CrossOrigin
@RestController
@RequestMapping("/ticket")
public class TicketController {

	@PutMapping("/viewticket")
	public List<TicketDetail> viewTicket(@RequestParam("userId") int userId) {
		TicketDetailDao ticketDetailDao = new TicketDetailDao();
		return  ticketDetailDao.ticketview(userId);
		
	
	}
	@PostMapping("/delete")
	public String delete(@RequestParam("ticketid") Integer ticketid,@RequestParam("employeeid") Integer employeeid,ModelMap modelMap){
		TicketDetail ticketDetail=new TicketDetail();
		ticketDetail.setId(ticketid);
		EmployeeDetail employeeDetail=new EmployeeDetail();
		employeeDetail.setId(employeeid);
		ticketDetail.setAssignedTo(employeeDetail);
		TicketDetailService ticketDetailService=new TicketDetailService();
	   try{
		   ticketDetailService.delete(ticketDetail);
	   }catch(ValidationException e){
		   e.printStackTrace();
		   modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
		   return "../deleteticket.jsp";
	   }
	   return "../successfull.jsp";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("ticketid") Integer ticketid,@RequestParam("employeeid") Integer employeeid,ModelMap modelMap){
		TicketDetail ticketDetail=new TicketDetail();
		ticketDetail.setId(ticketid);
		EmployeeDetail employeeDetail=new EmployeeDetail();
		employeeDetail.setId(employeeid);
		ticketDetail.setAssignedTo(employeeDetail);
		TicketDetailService ticketDetailService=new TicketDetailService();
	   try{
		   ticketDetailService.delete(ticketDetail);
	   }catch(ValidationException e){
		   e.printStackTrace();
		   modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
		   return "../deleteticket.jsp";
	   }
	   return "../successfull.jsp";
	}
	@GetMapping("/closeticket")
	public String closeticket(@RequestParam("ticketid") int ticketid,ModelMap modelMap){
		TicketDetail ticketDetail=new TicketDetail();
		ticketDetail.setId(ticketid);
		System.out.println("hi");
	TicketDetailService ticketDetailService=new TicketDetailService();
	try{
	ticketDetailService.close(ticketDetail);
	TicketDetailDao ticketDetailDao=new TicketDetailDao();
	ticketDetailDao.closeTicket(ticketDetail.getId());
	}catch(ValidationException e){
		e.printStackTrace();
		modelMap.addAttribute("ERROR_MESSAGE", e);
		return "../closeticket.jsp";
	}
	return "../viewticket.jsp";
	}

	@PostMapping("/createticket")
	public String createticket(@RequestParam("ticketid") Integer ticketid, @RequestParam("userid") Integer userid,
			@RequestParam("department") Integer department, @RequestParam("subject") String subject,
			@RequestParam("description") String description, @RequestParam("priority") String priority,
			ModelMap modelMap) {
		System.out.println(userid + "" + department);
		TicketDetail ticketDetail = new TicketDetail();
		ticketDetail.setId(ticketid);
		UserDetail userDetail = new UserDetail();
		userDetail.setId(userid);
		ticketDetail.setUserId(userDetail);
		Department department2 = new Department();
		department2.setId(department);
		ticketDetail.setDepartmentId(department2);
		ticketDetail.setSubject(subject);
		ticketDetail.setDescription(description);
		ticketDetail.setPriority(priority);
		ticketDetail.setCreatedTime(LocalDateTime.now());
		System.out.println("hi");
		modelMap.addAttribute("variable", userid);
		try {
			TicketDetailService ticketDetailService = new TicketDetailService();
			ticketDetailService.createTicket(ticketDetail);
		} catch (ValidationException | EmailException e) {
			e.printStackTrace();
			modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
			return "../createticket.jsp";
		}
		return "../viewticket.jsp";

	}
	@PostMapping("/updateticket")
	
	public String updateticket(@RequestParam("ticketid") Integer ticketid,@RequestParam("subject") String subject,ModelMap modelMap){
		TicketDetail ticketDetail=new TicketDetail();
		ticketDetail.setId(ticketid);
		ticketDetail.setSubject(subject);
		TicketDetailService ticketDetailService=new TicketDetailService();
		try{
			ticketDetailService.update(ticketDetail);
			TicketDetailDao ticketDetailDao=new TicketDetailDao();
			ticketDetailDao.update(ticketDetail.getId(), ticketDetail.getSubject());
			modelMap.addAttribute("variable", ticketDetail.getUserId());
		}
		catch(ValidationException e){
			e.printStackTrace();
			modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
			return "../updateticket.jsp";
		}
		return "../viewticket.jsp";
	}
	@PostMapping("/assignticket")
	public String assignticket(@RequestParam("ticketid") Integer ticketid,@RequestParam("employeeid") Integer employeeid,ModelMap modelMap){
		TicketDetail ticketDetail=new TicketDetail();
		ticketDetail.setId(ticketid);
		EmployeeDetail employeeDetail =new EmployeeDetail();
		employeeDetail.setId(employeeid);
		ticketDetail.setAssignedTo(employeeDetail);
		ticketDetail.setModifiedTime(LocalDateTime.now());
		TicketDetailService ticketDetailService=new TicketDetailService();
		try{
			ticketDetailService.assignTicket(ticketDetail);
			modelMap.addAttribute("message"," Ticket Assigned");
		}
		catch(ValidationException e){
			e.printStackTrace();
			modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
			return "../assignticket.jsp";
			
		}
        return "../successfull.jsp";
	}
	@PostMapping("/replyticket")
	public String replyticket(@RequestParam("id")Integer id, @RequestParam("ticketid") Integer ticketid,@RequestParam("solution") String solution,ModelMap modelMap){
		IssueService issueService=new IssueService();
		Issue issue=new Issue();
		issue.setId(id);
		TicketDetail ticketDetail=new TicketDetail();
		ticketDetail.setId(ticketid);
		issue.setTicket(ticketDetail);
		issue.setSolution(solution);
		try{
		issueService.replyToTicket(issue);}
		catch(ValidationException e){
			e.printStackTrace();
			modelMap.addAttribute("ERROR_MESSAGE", e);
			return "../replyticket.jsp";
		}
		return "../successfull.jsp";
	}
}
