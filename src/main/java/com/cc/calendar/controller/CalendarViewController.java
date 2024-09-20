package com.cc.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarViewController {
	
	@GetMapping("/calendar")
	public String home() {
		return "/calendar/schedule";
	}
}
