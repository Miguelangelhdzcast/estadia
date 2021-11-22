package com.proyecto.Lototres.repository;

import com.proyecto.Lototres.entity.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ActividadRepository extends JpaRepository <Actividad, Integer>{
    Optional<Actividad> findByNombre_act(String nombre_act);
    boolean existsByNombre_act(String nombre_act);



}
