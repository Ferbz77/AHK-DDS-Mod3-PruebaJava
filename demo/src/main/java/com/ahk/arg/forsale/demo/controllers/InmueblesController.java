package com.ahk.arg.forsale.demo.controllers;

import com.ahk.arg.forsale.demo.models.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/inmuebles")

public class InmueblesController {

    private List<Inmueble> inmuebles;

    public InmueblesController(){
        this.inmuebles = new ArrayList<>();

        Zona unaZona = new Zona();
        unaZona.setId(1);
        unaZona.setNombre("Palermo");
        unaZona.setPrecio(150F);

        Zona otraZona = new Zona();
        otraZona.setId(6);
        otraZona.setNombre("Almagro");
        otraZona.setPrecio(130F);

        Casa unaCasa = new Casa();
        unaCasa.setCantAmbientes(2);
        unaCasa.setTamanioEnM2(40F);
        unaCasa.setZona(unaZona);

        PH unPH = new PH();
        unPH.setCantAmbientes(3);
        unPH.setTamanioEnM2(50F);
        unPH.setZona(otraZona);

        this.inmuebles.add(unaCasa);
        this.inmuebles.add(unPH);
    }

    @GetMapping
    public ModelAndView listadoDeInmuebles(Map<String, Object> model){
        model.put("title", "For Sale");
        model.put("inmuebles", this.inmuebles);
        return new ModelAndView("inmuebles", model);
    }

    @GetMapping("/2")
    public ModelAndView listadoDeInmuebles2(Map<String, Object> model){
        model.put("title", "For Sale");
        model.put("inmuebles", this.inmuebles);
        return new ModelAndView("inmuebles_2", model);
    }

    @GetMapping("/crear")
    public ModelAndView formInmuebles(Map<String, Object> model){
        model.put("title", "For Sale");
        model.put("inmuebles", this.inmuebles);
        return new ModelAndView("formInmueble", model);
    }

    @PostMapping("/crear/casa")
    public RedirectView guardarCasa(@ModelAttribute Casa casa){  //le pasa los parametros a la vista
        this.inmuebles.add(casa);

        return new RedirectView("/inmuebles");
    }

    @PostMapping("/crear/ph")
    public RedirectView guardarPh(@ModelAttribute PH ph){  //le pasa los parametros a la vista
        this.inmuebles.add(ph);

        return new RedirectView("/inmuebles");
    }

    @PostMapping("/crear/dpto")
    public RedirectView guardarDpto(@ModelAttribute Depto depto){  //le pasa los parametros a la vista
        this.inmuebles.add(depto);

        return new RedirectView("/inmuebles");
    }

}