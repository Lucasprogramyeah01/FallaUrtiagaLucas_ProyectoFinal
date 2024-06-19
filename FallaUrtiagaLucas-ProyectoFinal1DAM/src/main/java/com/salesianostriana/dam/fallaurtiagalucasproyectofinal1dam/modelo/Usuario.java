package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Usuario implements UserDetails {
	
	@Id @GeneratedValue
	private Long idUsuario;
	
	private String nombre;
	
	private String apellidos;
	
	private String correo;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	private String imagen;
	
	private String textoAltImagen;

	private int numPuntosHon;
	
	private boolean admin;
	
	
	//ASOCIACIÓN CON VENTA [1U - MV]
	
		@ToString.Exclude
		@EqualsAndHashCode.Exclude
		@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@Builder.Default
		private List<Venta> venta = new ArrayList<>();
		
		
	//ASOCIACIÓN CON LIBROS [MU - ML UNIDIRECCIONAL] (Un Usuario tiene una lista de LIBROS FAVORITOS).
		
		@ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(name = "favoritos",
			joinColumns = @JoinColumn(name="usuario_id"),
			inverseJoinColumns = @JoinColumn(name="libro_id"))
	 	
	 	@Builder.Default
		private List<Libro> listadoFavoritos = new ArrayList<>(); 
		
		//Lo sé, también lo podría hacer con un Set.
		
		
	//SEGURIDAD
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			String role = "ROLE_";
			role += (admin) ? "ADMIN" : "USER";
			return List.of(new SimpleGrantedAuthority(role));
		}	

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}
	
}
