package net.custom.medical.pages;

import net.custom.medical.utils.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class Index {

	private static Logger logger = LoggerFactory
	.getLogger(Index.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String validate() {
		 logger.info("Returning index Page Path: ", Utils.buildPath(this.getClass()));
		 return Utils.buildPath(this.getClass());
	}
}
