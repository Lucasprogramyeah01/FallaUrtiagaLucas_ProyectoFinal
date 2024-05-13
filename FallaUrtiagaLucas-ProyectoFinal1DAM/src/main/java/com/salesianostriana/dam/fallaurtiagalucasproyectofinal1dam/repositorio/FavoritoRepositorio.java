package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Favorito;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.FavoritoPK;

public interface FavoritoRepositorio extends JpaRepository<Favorito, FavoritoPK>{

}
