package net.custom.medical.pages;

import net.custom.medical.utils.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login.html")
public class Login {

	private static Logger logger = LoggerFactory
	.getLogger(Login.class);
	
	@Autowired
	private AuthenticationManager manager;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loginPage() {
		 logger.info("Returning index Page Path: {} ", Utils.buildPath(this.getClass()));
		 return Utils.buildPath(this.getClass());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView validate(@RequestParam String username, @RequestParam String password) {
		try {
	        Authentication request = new UsernamePasswordAuthenticationToken(username, password);
	        Authentication result = manager.authenticate(request);
	        SecurityContextHolder.getContext().setAuthentication(result);
	      } catch(AuthenticationException e) {
	        logger.error("Authentication failed:  {}" ,e.getMessage());
	        return new ModelAndView(Utils.buildPath(Login.class), "showError", true);
	      }
		logger.info("Successfully authenticated. Security context contains:  {}",
	              SecurityContextHolder.getContext().getAuthentication());
		 return new ModelAndView(Utils.buildPath(Index.class));
	}
}
