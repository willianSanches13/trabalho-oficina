package com.ellp.boot.web.controller;

import com.ellp.boot.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping("/")
	public String home(ModelMap model) {
		model.addAttribute("alunos", alunoService.buscarTodos());
		return "home";
	}
}
