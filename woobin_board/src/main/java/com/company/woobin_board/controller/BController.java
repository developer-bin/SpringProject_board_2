package com.company.woobin_board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.woobin_board.command.BCommand;
import com.company.woobin_board.command.BContentCommand;
import com.company.woobin_board.command.BDeleteCommand;
import com.company.woobin_board.command.BListCommand;
import com.company.woobin_board.command.BModifyCommand;
import com.company.woobin_board.command.BReplyCommand;
import com.company.woobin_board.command.BReplyViewCommand;
import com.company.woobin_board.command.BWriteCommand;
import com.company.woobin_board.util.Constant;

@Controller
public class BController {
	
	BCommand command;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template=this.template;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list");
		command = new BListCommand();
		command.excute(model);
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request,Model model) {
		System.out.println("write");
		model.addAttribute("request",request);
		command = new BWriteCommand();
		command.excute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,Model model) {
		System.out.println("content_view");
		
		model.addAttribute("request",request);
		command=new BContentCommand();
		command.excute(model);
		
		return "content_view";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/modify")
	public String modify(HttpServletRequest request,Model model) {
		System.out.println("modify");
		
		model.addAttribute("request",request);
		command=new BModifyCommand();
		command.excute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view");
		
		model.addAttribute("request",request);
		command=new BReplyViewCommand();
		command.excute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request,Model model) {
		System.out.println("reply");
		
		model.addAttribute("request",request);
		command=new BReplyCommand();
		command.excute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete");
		
		model.addAttribute("request",request);
		command=new BDeleteCommand();
		command.excute(model);
		
		return "redirect:list";
	}
}
