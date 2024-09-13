package com.ahk.arg.forsale.demo.models.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public abstract class Inmueble {
    protected Integer cantAmbientes;
    protected Float tamanioEnM2;
    private Zona zona;

    public abstract Float precio();

    public Float precioFinal() {
        return this.precio() + this.zona.getPrecio();
    }
}
