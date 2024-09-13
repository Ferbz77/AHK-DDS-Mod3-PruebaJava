package com.ahk.arg.forsale.demo.controllers.api;

import com.ahk.arg.forsale.demo.models.entities.Zona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/zonas")
public class ZonasAPIController {
    private List<Zona> zonas;

    public ZonasAPIController(){
        this.zonas = new ArrayList<>();
        Zona zona1 = new Zona();
        zona1.setNombre("Recoleta");
        zona1.setId(1);

        this.zonas.add(zona1);
    }
    @GetMapping
    public ResponseEntity<List<Zona>> buscarTodos(){

        return new ResponseEntity<>(this.zonas, HttpStatus.OK);
} //lo convierte en jason
    @PostMapping
    public ResponseEntity<Zona> crearZona(@RequestBody Zona zona){
        this.zonas.add(zona);
        return new ResponseEntity<>(zona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Zona> modificarZona(@PathVariable Integer id, @RequestBody Zona zona){
        Optional<Zona> posibleZona = this.zonas.stream().filter(z -> z.getId().equals(id))
                .findFirst();

        if(posibleZona.isEmpty()){ //si no encuentra la zona
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


        Zona zonaAModificar = posibleZona.get();
        zonaAModificar.setNombre(zona.getNombre());
        zonaAModificar.setPrecio(zona.getPrecio());

        return new ResponseEntity<>(zonaAModificar, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarZona(@PathVariable Integer id){ //chequea si existe el id
        Optional<Zona> posibleZona = this.zonas.stream().filter(z -> z.getId().equals(id))
                .findFirst();

        if(posibleZona.isEmpty()){ //si no encuentra la zona
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        Zona zonaABorrar = posibleZona.get();

        this.zonas.remove(zonaABorrar);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
