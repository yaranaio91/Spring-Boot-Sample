package sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NameController {

	@RequestMapping(path = "name.html", method = RequestMethod.GET)
	public String init(Model model, InputParam param) {

		model.addAttribute(param);

		return "name";
	}

	@RequestMapping(path = "name.html", method = RequestMethod.POST)
	public String name(Model model, InputParam param) {

		model.addAttribute(param);
		System.out.println(model);
		System.out.println(param);

		return "name";
	}

	public static class InputParam {

		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Param [name=" + name + "]";
		}

	}
}