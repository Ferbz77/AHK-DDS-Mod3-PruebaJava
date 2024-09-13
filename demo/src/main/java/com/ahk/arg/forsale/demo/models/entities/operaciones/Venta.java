package com.ahk.arg.forsale.demo.models.entities.operaciones;

import com.ahk.arg.forsale.demo.models.entities.personas.Empleado;

public class Venta extends Operacion {
    private static Float porcentajeComision = 1.5F;

    @Override
    public Float calcularComisionPara(Empleado empleado) {
        return super.inmueble.precioFinal() * porcentajeComision;
    }
}
