package com.ahk.arg.forsale.demo.models.entities.operaciones;

import com.ahk.arg.forsale.demo.models.entities.personas.Empleado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Alquiler extends Operacion {
    private Integer cantMeses;

    @Override
    public Float calcularComisionPara(Empleado empleado) {
        Float comision = (this.cantMeses * super.inmueble.precioFinal())/ 50000;
        empleado.agregarComision(comision);
        return comision;
    }
}