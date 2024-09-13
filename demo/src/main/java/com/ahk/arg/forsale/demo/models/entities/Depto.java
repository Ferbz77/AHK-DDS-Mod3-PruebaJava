package com.ahk.arg.forsale.demo.models.entities;

public class Depto extends Inmueble {

    @Override
    public Float precio() {
        return Float.valueOf(350000 * super.cantAmbientes);
    }
}
