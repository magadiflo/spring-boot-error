package com.bolsadeideas.springboot.error.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/index")
	public String index() {
		//Forzando a que muestre un ArithmeticException para mostrar el aritmetica.html
		int res = 100/0;
		
		// Como no existe la vista index, lanzará el error 500 y en automático mostrará
		// la vista 500.html ubicado dentro del directorio error. 
		//Cualquier error 500 mostrará el archivo /error/500.html
		return "index";
	}

}
