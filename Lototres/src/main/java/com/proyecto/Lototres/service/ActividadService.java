package com.proyecto.Lototres.service;

import com.proyecto.Lototres.entity.Actividad;
import com.proyecto.Lototres.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ComponentScan(basePackages = {"com.proyecto.Lototres.ActividadService"})
@Service
@Transactional
public class ActividadService {

    @Autowired
    ActividadRepository actividadRepository;

    public List<Actividad> list(){
    return actividadRepository.findAll();
    }

    public Optional <Actividad> getOne(int id_act){
        return actividadRepository.findById(id_act);
    }
    public Optional<Actividad> getByNom_act (String nom_act){
        return actividadRepository.findByNombre_act(nom_act);
    }

    public void save(Actividad actividad){
        actividadRepository.save(actividad);
    }
    public void delete (int id_act){
        actividadRepository.deleteById(id_act);
    }

    public boolean existsById(int id_act){
    return actividadRepository.existsById(id_act);
    }
    public boolean existsByNom_act(String nom_act){
        return actividadRepository.existsByNombre_act(nom_act);
    }




}
