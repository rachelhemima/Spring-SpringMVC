package ai.jobiak.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class SignUpController {
	@Autowired
	UserDao signup;
	
	public SignUpController(UserDao signup) {
		super();
		this.signup = signup;
	}
	@RequestMapping(value ="signup", method = RequestMethod.POST)
	public String  doSignup(User user,ModelMap map)
	{
   signup.insertRow(user.getFname(),user.getMobile(),user.getEmail());
		map.put("fname", user.getFname());
		map.put("mobile",user.getMobile());
		map.put("email", user.getEmail());
		return "user";
	}
	@RequestMapping(value ="update", method = RequestMethod.POST)
	public String  doUpadte(User user,ModelMap map)
	{
		signup.updateRow(user.getMobile(), user.getEmail(),user.getFname());
		map.put("fname", user.getFname());
		map.put("mobile",user.getMobile());
		map.put("email", user.getEmail());
		return "user";
	}
	@RequestMapping(value ="delete", method = RequestMethod.POST)
	public String  doDelete(User user,ModelMap map)
	                             //model object/command  obj
	{
		signup.deleteRow(user.getFname());
		map.put("fname", user.getFname());
		map.put("msg", "User Details successfully deleted!!!");
		return "user2";
	}
}
