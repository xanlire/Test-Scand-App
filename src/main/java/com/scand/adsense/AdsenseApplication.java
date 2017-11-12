package com.scand.adsense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.scand.adsense"})
public class AdsenseApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AdsenseApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AdsenseApplication.class, args);
	}

	@RequestMapping("/greeting")
	public String greeting(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String data){
		model.addAttribute("name", data);
		return "greeting";
	}

	@RequestMapping("/welcome.html")
	public ModelAndView welcomePage(){
		return new ModelAndView("welcome");
	}

}

