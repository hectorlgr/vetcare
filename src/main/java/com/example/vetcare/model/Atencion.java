package com.example.vetcare.model;

//import org.springframework.http.HttpStatus;
//import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atencion {
    private int id;
    private String nombre;
    private String nombre_dueno;
    private String Motivo;
    private String fecha;

    public boolean validarNombre() {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}