package sample.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sample.service.HelloService;

@Controller
@Transactional
public class HelloController {

	@Autowired
	HelloService helloService;

	@RequestMapping(path = { "/", "index.html" }, method = RequestMethod.GET)
	public String hello(Model model, InputParam param) {
		model.addAttribute(param);
		return "index";
	}

	@RequestMapping(path = { "", "/", "index.html" }, method = RequestMethod.POST)
	public String login(Model model, @Valid InputParam param, Errors errors) {

		model.addAttribute(param);

		if (errors.hasErrors()) {
			return "index";
		}

		return helloService.login(param.id, param.password) ? "redirect:name.html"
				: "index";
	}

	public static class InputParam {

		@NotNull
		Integer id;
		@NotBlank
		String password;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}
}