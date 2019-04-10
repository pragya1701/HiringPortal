package com.hiring.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHomePage(ModelMap model) {
		return "home";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String showRegistrationPage(ModelMap model) {
		return "registration";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "login";
	
	}
	
	@RequestMapping(value = "/levels", method = RequestMethod.GET)
	public String showLevelsPage(ModelMap model) {
		return "levels";
	}
	
	@RequestMapping(value = "/cordinit", method = RequestMethod.GET)
	public String showCordInitPage(ModelMap model) {
		return "cordinit";
	}
	
	@RequestMapping(value = "/cordhistory", method = RequestMethod.GET)
	public String showCordHistoryPage(ModelMap model) {
		return "cordhistory";
	}
	@RequestMapping(value = "/corddashboard", method = RequestMethod.GET)
	public String showCordDashPage(ModelMap model) {
		return "corddashboard";
	}
	
	@RequestMapping(value = "/addmcqquestion", method = RequestMethod.GET)
	public String showAddMCQQuestionPage(ModelMap model) {
		return "addmcqquestion";
	}
	
	@RequestMapping(value = "/addcodequestion", method = RequestMethod.GET)
	public String showAddCodeQuestionPage(ModelMap model) {
		return "addcodequestion";
	}
	
	@RequestMapping(value = "/addcategory", method = RequestMethod.GET)
	public String showAddCategoryPage(ModelMap model) {
		return "addcategory";
	}
	
	@RequestMapping(value = "/level?level= {level}", method = RequestMethod.GET)
	public String level(ModelMap model) {
		return "level?level={level}";
	}
	
	@RequestMapping(value = "/sendemail", method = RequestMethod.GET)
	public String sendEmail(ModelMap model) {
		return "sendemail";
	}
	
	@RequestMapping(value = "/sendnotification", method = RequestMethod.GET)
	public String sendNotification(ModelMap model) {
		return "sendnotification";
	}

	@RequestMapping(value = "/contactus", method = RequestMethod.GET)
	public String contactUs(ModelMap model) {
		return "contactus";
	}

	@RequestMapping(value = "/showtest", method = RequestMethod.GET)
	public String showTest(ModelMap model) {
		return "showtest";
	}

	@RequestMapping(value = "/cordtestdisplay", method = RequestMethod.GET)
	public String showCordTestDisplay(ModelMap model) {
		return "cordtestdisplay";
	}
	
	@RequestMapping(value = "/tempreg", method = RequestMethod.GET)
	public String showTestPage(ModelMap model) {
		return "tempreg";
	}
	
	@RequestMapping(value = "/temp", method = RequestMethod.GET)
	public String showTesPage(ModelMap model) {
		return "temp";
	}
	
	@RequestMapping(value = "/userhome", method = RequestMethod.GET)
	public String showTsPage(ModelMap model) {
		return "userhome";
	}
	
}
