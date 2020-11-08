package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.BoardMapper;




@Controller
public class HomeController {


	@Autowired
	BoardMapper dao;
	 
	@RequestMapping(value="/")
	public String hello(Model model) {
		model.addAttribute("data","안녕하세유 리즈님~");
		return "/hello";
	}
	
	
	  @RequestMapping(value="/board",method=RequestMethod.GET)
	 
	  public String board_list(HttpServletRequest	request,HttpServletResponse response) throws IOException {
		  request.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html;charset=UTF-8");
		  HttpSession session = request.getSession();
		  PrintWriter out = response.getWriter();
	  try { 
		  List<HashMap> board = dao.getBoardList(); 
		  request.setAttribute("board", board);
	  
	  } catch (Exception e) { // TODO Auto-generated catch block 
		  e.printStackTrace(); 
	  }
	  
	  return "/board";
	  
	  }
	 
}
