package com.ssoo.delidrones.negocio;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Local {

    private int id;
    private String nombre;
    private String ubicacion;
    private boolean esEstacion;

}
