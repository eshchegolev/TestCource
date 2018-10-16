package org.acs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author GenCloud
 * @date 10/2018
 */
@Controller
@RequestMapping("/")
public class DefaultController {
	@RequestMapping
	public String index(ModelMap map) {
		map.addAttribute("title", "Index page");

		final String userName = System.getProperty("user.name");
		map.addAttribute("user", userName);

		return "index";
	}
}
