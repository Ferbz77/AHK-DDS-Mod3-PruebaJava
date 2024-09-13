package com.ahk.arg.forsale.demo.controllers;

import com.ahk.arg.forsale.demo.models.entities.Casa;
import com.ahk.arg.forsale.demo.models.entities.Inmueble;
import com.ahk.arg.forsale.demo.models.entities.PH;
import com.ahk.arg.forsale.demo.models.entities.Zona;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}