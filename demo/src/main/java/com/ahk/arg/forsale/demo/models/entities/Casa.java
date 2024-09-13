package com.ahk.arg.forsale.demo.models.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Casa extends Inmueble {
    private Float valor;

    @Override
    public Float precio() {
        return this.valor;
    }
}
