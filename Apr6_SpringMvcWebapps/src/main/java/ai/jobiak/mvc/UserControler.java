package ai.jobiak.mvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserControler {
	@RequestMapping(value="data",method=RequestMethod.POST)
	public String userDetails(ModelMap map) {
	map.put("username", "Hemima");
	map.put("password", "hemima123");
	map.put("otp", "12345");
	return "user";
}
}