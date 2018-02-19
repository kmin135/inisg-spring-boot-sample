package inisg.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("/hello")
	@ResponseBody
	public String hello(@RequestParam(required=true) String name) {
		return String.format("Hello, %s", name);
	}
}
