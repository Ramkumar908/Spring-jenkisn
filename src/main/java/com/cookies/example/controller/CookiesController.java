package com.cookies.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookiesController {
	
	
	
	// set cookie wit
	
	@RequestMapping(value="/username",method=RequestMethod.GET)
	public String setCookiesWithUsername(HttpServletResponse response)
	{
		  System.out.println(" function calling befire set th ecookies in the method");
		  Cookie cookies=new Cookie("username","Rambabu");
		  cookies.setMaxAge(500);
		  cookies.setHttpOnly(true);// add for access only server not with javascripts dom element
		  //cookies.setSecure(true);// add for security and accesss with only https 
		 // If the scope is not specified, a cookie is only sent to the server for a path that was used to set it in the browser. We can change this behavior using setPath() method of the Cookie class. This sets the Path directive for the cookie.
		 cookies.setPath("/");
		  response.addCookie(cookies);
		  //response.addCookie(new Cookie("technology1","Java"));
		  //response.addCookie(new Cookie("technology2","Spring"));
		  //response.addCookie(new Cookie("technology3","Jsp"));
		  //response.addCookie(new Cookie("technology4","JavaScript"));

		  return "add cookies successfully";
	}
	
	
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String readCookies(HttpServletRequest request,@CookieValue("username")String username)
	{
		
		Cookie[] cookies=request.getCookies();
		
		if(cookies!=null)
		{
		    return Arrays.stream(cookies).map(c->c.getName()+" "+c.getValue()).collect(Collectors.joining(","));
		}
		return "adding cookies is"+username;
	}

}
