package com.ssoo.delidrones.negocio;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dron {
    private int id;
    private int bateria;
    private String ubicacion;
    private boolean ocupado;
    private boolean cargando;
}
