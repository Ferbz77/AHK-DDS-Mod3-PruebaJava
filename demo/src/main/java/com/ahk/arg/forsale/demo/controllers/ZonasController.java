package com.ahk.arg.forsale.demo.controllers;

import com.ahk.arg.forsale.demo.models.entities.Zona;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/zonas")
public class ZonasController {

    private List<Zona> zonas;

    public ZonasController(){
        this.zonas = new ArrayList<>();

        Zona unaZona = new Zona();
        unaZona.setId(1);
        unaZona.setNombre("Palermo");
        unaZona.setPrecio(150F);

        this.zonas.add(unaZona);

        Zona otraZona = new Zona();
        otraZona.setId(6);
        otraZona.setNombre("Almagro");
        otraZona.setPrecio(130F);

        this.zonas.add(otraZona);
    }

    @GetMapping

    public ModelAndView listadoDeZonas(Map<String, Object> model){
        model.put("title", "For Sale");
        model.put("zonas", this.zonas);
        return new ModelAndView("zonas", model);

    }

    @GetMapping("/crear")
    public ModelAndView cargarUnaZona(Map<String, Object> model){
        model.put("title", "For Sale");
        return new ModelAndView("formZona", model);
    }
}

//Necesita que investigue como poder hacer un post desde un form html hacia una ruta en particular de nuestro controller.
//El form de alta de zona tiene q funcionar
//zonascontroller nueva q admita un control