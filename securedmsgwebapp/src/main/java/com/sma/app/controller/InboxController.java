package com.sma.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sma.app.entity.Inbox;
import com.sma.app.service.MessageService;
import com.sma.app.service.UserService;

@Controller("/inbox")
public class InboxController {

	@Autowired
	UserService us;
	@Autowired
	MessageService ms;
	
	
	
	
}
