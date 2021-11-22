package com.proyecto.Lototres.controller;

import antlr.StringUtils;
import com.proyecto.Lototres.dto.ActividadDto;
import com.proyecto.Lototres.dto.Mensaje;
import com.proyecto.Lototres.entity.Actividad;
import com.proyecto.Lototres.service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping ("/actividad")
@CrossOrigin(origins = "http://localhost:4200")
public class ActividadController {

    @Autowired
    ActividadService actividadService;

    @GetMapping("/lista")
    public ResponseEntity<List<Actividad>> List(){
        List<Actividad> list = actividadService.list();
        return new ResponseEntity<List<Actividad>>(list, HttpStatus.OK);
    }
    @GetMapping ("/detail/{id_act}")
    public ResponseEntity <Actividad> getById_act(@PathVariable("id_act") int id_act){
        if(!actividadService.existsById(id_act))
            return new ResponseEntity(new Mensaje("No existe la actividad"), HttpStatus.NOT_FOUND);
        Actividad actividad = actividadService.getOne(id_act).get();
        return new ResponseEntity(actividad, HttpStatus.OK );
    }
    @GetMapping ("/detailname/{nom_act}")
    public ResponseEntity <Actividad> getByNom_act(@PathVariable("nom_act") String nom_act){
        if(!actividadService.existsByNom_act(nom_act))
            return new ResponseEntity(new Mensaje("No existe la actividad"), HttpStatus.NOT_FOUND);
        Actividad actividad = actividadService.getByNom_act(nom_act).get();
        return new ResponseEntity(actividad, HttpStatus.OK );
    }
    @PostMapping ("/create")
    public ResponseEntity<?> create (@PathVariable("id_act") int id_act,@RequestBody ActividadDto actividadDto){
        if(!actividadService.existsByNom_act(actividadDto.getNom_act()))
            return new ResponseEntity(new Mensaje("No se a podido registrar"),HttpStatus.BAD_REQUEST);
       Actividad actividad = new Actividad(actividadDto.getNom_act());
       actividadService.save(actividad);
       return new ResponseEntity(new Mensaje("Actividad Registrada"), HttpStatus.OK);
    }
    @PutMapping("/update/{id_act}")
    public ResponseEntity<?> update (@PathVariable("id_act") int id_act, @RequestBody ActividadDto actividadDto){
        if(!actividadService.existsById(id_act))
            return new ResponseEntity(new Mensaje("No existe la actividad"), HttpStatus.NOT_FOUND);
        if(!actividadService.existsByNom_act(actividadDto.getNom_act()) && actividadService.getByNom_act(actividadDto.getNom_act()).get().getId_act() != id_act)
            return new ResponseEntity(new Mensaje("Esa actividad ya existe"),HttpStatus.BAD_REQUEST);
        if(!actividadService.existsByNom_act(actividadDto.getNom_act()))
            return new ResponseEntity(new Mensaje("No se a podido registrar"),HttpStatus.BAD_REQUEST);

        Actividad actividad = actividadService.getOne(id_act).get();
        actividad.setNombre_act(actividadDto.getNom_act());
        actividadService.save(actividad);
        return new ResponseEntity(new Mensaje("Actividad Actualizada"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id_act}")
    public ResponseEntity<?> delete (@PathVariable("id_act") int id_act){
        if(!actividadService.existsById(id_act))
            return new ResponseEntity(new Mensaje("No existe la actividad"), HttpStatus.NOT_FOUND);
        actividadService.delete(id_act);
        return new ResponseEntity(new Mensaje("Actividad Eliminada0"), HttpStatus.OK);

    }



}
