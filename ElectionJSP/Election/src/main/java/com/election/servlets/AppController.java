package com.election.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/ctl")
public class AppController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String page = req.getParameter("page");
		String uri = "/WEB-INF/Views/index.jsp";
		
		if(page.equals("index"))
			uri = "/WEB-INF/Views/index.jsp";
		else if(page.equals("login"))
			uri = "/WEB-INF/Views/login.jsp";
		else if(page.equals("newuser"))
			uri = "/WEB-INF/Views/newuser.jsp";
		else if(page.equals("register"))
			uri = "/WEB-INF/Views/register.jsp";
		else if(page.equals("candidateList"))
			uri = "/WEB-INF/Views/candidateList.jsp";
		else if(page.equals("result"))
			uri = "/WEB-INF/Views/result.jsp";
		else if(page.equals("vote"))
			uri = "/WEB-INF/Views/vote.jsp";
		else if(page.equals("editCandidate"))
			uri = "/WEB-INF/Views/editCandidate.jsp";
		else if(page.equals("deleteCandidate"))
			uri = "/WEB-INF/Views/deleteCandidate.jsp";
		else if(page.equals("updateCandidate"))
			uri = "/WEB-INF/Views/updateCandidate.jsp";
		else if(page.equals("announcement"))
			uri = "/WEB-INF/Views/announcement.jsp";
		else if(page.equals("logout"))
			uri = "/WEB-INF/Views/logout.jsp";
		else 
			System.out.println("Invalid Page");
		
		ServletContext context = this.getServletContext();
		 RequestDispatcher rd = context.getRequestDispatcher(uri);
		 rd.forward(req, res);
	}
	
}
