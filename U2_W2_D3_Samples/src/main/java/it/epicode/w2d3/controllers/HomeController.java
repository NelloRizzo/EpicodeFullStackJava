package it.epicode.w2d3.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

	public String home() {
		return "index";
	}
}
