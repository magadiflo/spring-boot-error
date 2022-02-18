package com.bolsadeideas.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	private List<Usuario> lista;
	
	public UsuarioServiceImpl() {
		this.lista = new ArrayList<>();
		this.lista.add(new Usuario(1, "Martín", "Díaz"));
		this.lista.add(new Usuario(2, "Gaspar", "Flores"));
		this.lista.add(new Usuario(3, "Alicia", "Zúñiga"));
		this.lista.add(new Usuario(4, "Violeta", "Nemecia"));
		this.lista.add(new Usuario(5, "Tinkler", "Cerpa"));
		this.lista.add(new Usuario(6, "Adán", "López"));
		this.lista.add(new Usuario(7, "Gabrielito", "Gonzales"));
	}

	@Override
	public List<Usuario> listar() {		
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario usuario = null;		
		for(Usuario u : this.lista) {
			if(u.getId().equals(id)) {
				usuario = u;
				break;
			}
		}		
		return usuario;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario = this.obtenerPorId(id);		
		return Optional.ofNullable(usuario);
	}

}
