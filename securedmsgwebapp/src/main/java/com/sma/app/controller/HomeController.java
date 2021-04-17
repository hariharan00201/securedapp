package com.sma.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sma.app.entity.Inbox;
import com.sma.app.entity.RandomWords;
import com.sma.app.entity.message;
import com.sma.app.entity.miners;
import com.sma.app.service.MessageService;
import com.sma.app.service.UserService;
import com.sma.app.service.VisitedService;

@Controller
public class HomeController {

	@Autowired
	UserService us;
	@Autowired
	RandomWords rw;
	@Autowired
	MessageService ms;
	@Autowired
	VisitedService vs;
	
	
	
	@RequestMapping("/")
	public String homePage()
	{
		return "login.jsp";
	}

	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public ModelAndView verifyLogin(String uname,String pass)
	{
		System.out.println("1");
		if(us.checkLogin(uname, pass))
		{
			return new ModelAndView("securitylayer.jsp","uname",uname);
		}
		else if(us.alreadyUser(uname))
			return new ModelAndView("login.jsp","msg",1);
		return new ModelAndView("signin.jsp","msg",2);
	}

	@RequestMapping(value = "/{uname}" , method = RequestMethod.POST)
	public ModelAndView codeEvaluation(@PathVariable("uname") String uname,String word1,String word2,String word3,String word4,String word5,String word6,String word7,String word8,String word9,String word10,HttpSession sc)
	{
		System.out.println(5);
		List<String> l=Arrays.asList(word1,word2,word3,word4,word5,word6,word7,word8,word9,word10);
		if(us.checkCode(l,uname))
		{
			sc.setAttribute("uname", uname);
			return new ModelAndView("welcome.jsp");
		}
		return new ModelAndView("login.jsp");
	}

	@RequestMapping("/callsignin")
	public String signin()
	{
		return "signin.jsp";
	}

	@RequestMapping(value="/signin" , method = RequestMethod.POST)
	public ModelAndView addMiner(String uname ,String pass,HttpSession sc)
	{
		if(us.alreadyUser(uname))
		{
			ModelAndView mv=new ModelAndView("signin.jsp");
			mv.addObject("msg", 1);
			return mv;
		}


		sc.setAttribute("uname", uname);
		ArrayList<String> rl=rw.returnRandomWords();
		miners m=new miners(uname,pass,rl.get(0),rl.get(1),rl.get(2),rl.get(3),rl.get(4),rl.get(5),rl.get(6),rl.get(7),rl.get(8),rl.get(9));
		us.addMiner(m);
		ModelAndView mv=new ModelAndView("randcred.jsp");
		mv.addObject("wordlist",rl);
		return mv;
	}

	@RequestMapping(value="/logout" , method = RequestMethod.POST)
	public void logout(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		HttpSession sc=req.getSession();
		sc.removeAttribute("uname");
		sc.invalidate();
		res.sendRedirect("login.jsp");
	}
	
	@RequestMapping(value="/inbox" , method=RequestMethod.POST) 
	public void inbox(HttpSession sc,HttpServletRequest req,HttpServletResponse res,int in) throws ServletException, IOException 
	{
		int id=us.getId((String)sc.getAttribute("uname"));
		ArrayList<Inbox> msgs=ms.getMessage(id,1);
		req.setAttribute("msgs", msgs);
		req.setAttribute("in", in);
		RequestDispatcher rd=req.getRequestDispatcher("inbox.jsp");
		rd.forward(req, res);
	}
	
	@RequestMapping(value="/openmsg" , method=RequestMethod.POST)
	public void openMessage(int mid,HttpSession sc,HttpServletRequest req,HttpServletResponse res,int in) throws IOException, ServletException
	{
		System.out.println(mid);
		if(in == 1)
		vs.removeFromVisited(mid,(String) sc.getAttribute("uname"));
		
		Inbox inbox=ms.getInboxMsgForThatMid(mid);
		req.setAttribute("inbox_msg", inbox);
		RequestDispatcher rd=req.getRequestDispatcher("readmsg.jsp");
		rd.forward(req, res);
	}
	
	@RequestMapping(value="/outbox", method=RequestMethod.POST)
	public void outbox(HttpServletRequest req , HttpServletResponse res ,HttpSession sc,int in) throws ServletException, IOException
	{
		int id=us.getId((String)sc.getAttribute("uname"));
		ArrayList<Inbox> msgs=ms.getMessage(id,2);	
		req.setAttribute("msgs", msgs);
		req.setAttribute("in", in);
		req.setAttribute("msgs", msgs);
		RequestDispatcher rd=req.getRequestDispatcher("inbox.jsp");
		rd.forward(req, res);
		
	}
	
	@RequestMapping(value="/compose" , method=RequestMethod.POST)
	public void compose(String to,String msgg,HttpSession sc,HttpServletRequest req , HttpServletResponse res ) throws ServletException, IOException
	{
		int id=us.getId(to);
		int from_id=us.getId((String)sc.getAttribute("uname"));
		message msg=new message(id,msgg,from_id);
		ms.addMessage(msg);
		req.setAttribute("success", 1);
		RequestDispatcher rd=req.getRequestDispatcher("welcome.jsp");
		rd.forward(req, res);
		
	}
	
}
