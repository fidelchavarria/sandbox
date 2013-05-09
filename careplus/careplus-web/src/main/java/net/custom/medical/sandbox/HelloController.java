package net.custom.medical.sandbox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello.html")
public class HelloController {

	private static Logger logger = LoggerFactory
			.getLogger(HelloController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String helloWorld(Model model) {
		logger.info("Returning Hello world String ! ");
		model.addAttribute("message", "Hello World!");
		return "hello.jsp";
	}
}
