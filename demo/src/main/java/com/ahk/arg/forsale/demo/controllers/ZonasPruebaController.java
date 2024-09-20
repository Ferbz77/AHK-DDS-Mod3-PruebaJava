package com.ahk.arg.forsale.demo.controllers;

import com.ahk.arg.forsale.demo.models.entities.Zona;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/zonas")
public class ZonasPruebaController {

    private List<Zona> zonas;

    public ZonasPruebaController(){
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

    @PostMapping("/alta-zona")
    public ModelAndView agregarZona(@RequestParam("id") int id,
                                    @RequestParam("nombre") String nombre,
                                    @RequestParam("precio") float precio) {
        Zona nuevaZona = new Zona();
        nuevaZona.setId(id);
        nuevaZona.setNombre(nombre);
        nuevaZona.setPrecio(precio);

        this.zonas.add(nuevaZona);

        return new ModelAndView("redirect:/zonas"); // Redirige al listado de zonas
    }
}
