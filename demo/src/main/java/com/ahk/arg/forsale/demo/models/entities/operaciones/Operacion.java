package com.ahk.arg.forsale.demo.models.entities.operaciones;

import com.ahk.arg.forsale.demo.models.entities.Inmueble;
import com.ahk.arg.forsale.demo.models.entities.personas.Empleado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class Operacion {
    protected Inmueble inmueble;

    public abstract Float calcularComisionPara(Empleado empleado);
}
