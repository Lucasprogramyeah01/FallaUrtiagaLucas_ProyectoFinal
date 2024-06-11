package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Usuario;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.base.ServicioBaseImpl;

@Service
public class UsuarioServicio extends ServicioBaseImpl<Usuario, Long, UsuarioRepositorio>{

	@Autowired
    private PasswordEncoder encoder;
	
	public Usuario saveUsuarioConContrasenhaCodificada(Usuario u) {
        u.setPassword(encoder.encode(u.getPassword()));
        return save(u);
    }

	
}
