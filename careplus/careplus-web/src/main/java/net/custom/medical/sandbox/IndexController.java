package net.custom.medical.sandbox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

	private static Logger logger = LoggerFactory
	.getLogger(IndexController.class);
	
	 @RequestMapping(method = RequestMethod.GET)
	public String validate() {
		 logger.info("Returning index Page");
//		 RequestContextUtils
		return "index.jsp";
	}
}
