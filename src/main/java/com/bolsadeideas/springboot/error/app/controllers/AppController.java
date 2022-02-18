package com.bolsadeideas.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bolsadeideas.springboot.error.app.errors.UsuarioNoEncontradoException;
import com.bolsadeideas.springboot.error.app.models.domain.Usuario;
import com.bolsadeideas.springboot.error.app.services.IUsuarioService;

@Controller
public class AppController {
	
	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/index")
	public String index() {
		//Forzando a que muestre un ArithmeticException para mostrar el aritmetica.html
		int res = 100/0;
		
		// Como no existe la vista index, lanzará el error 500 y en automático mostrará
		// la vista 500.html ubicado dentro del directorio error. 
		//Cualquier error 500 mostrará el archivo /error/500.html
		return "index";
	}
	
	@GetMapping("/cadena")
	public String cadena() {
		//Forzando a que muestre el error NumberFormatException
		Integer valor = Integer.parseInt("hola");
		
		return  "cadena";
	}
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable("id") Integer id, Model model) {
		//Usuario usuario = this.usuarioService.obtenerPorId(id);
		//if(usuario == null) {
		//	throw new UsuarioNoEncontradoException(id.toString());
		//}
		
		//El código comentado de arriba es lo mismo que este de abajo, solo que aquí usamos las características de Java 8
		Usuario usuario = this.usuarioService.obtenerPorIdOptional(id).orElseThrow(()-> new UsuarioNoEncontradoException(id.toString()));
		//
		model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));
		model.addAttribute("usuario", usuario);
		return "ver";
	}
	

}
