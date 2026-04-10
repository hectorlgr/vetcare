package com.example.vetcare.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atencion {
    private int id;
    private String nombre;
    private String nombreDueno;
    private String motivo;
    private Date fecha;

    public String validarDatos() {
        // Validar ID (como es int, por defecto es 0, validamos que sea mayor a 0)
        if (id <= 0) {
            return "Error: El ID debe ser mayor a 0.";
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            return "Error: El nombre de la mascota no puede estar vacío.";
        }
        if (nombreDueno == null || nombreDueno.trim().isEmpty()) {
            return "Error: El nombre del dueño no puede estar vacío.";
        }
        if (motivo == null || motivo.trim().isEmpty()) {
            return "Error: El motivo de la consulta no puede estar vacío.";
        }
        if (fecha == null) {
            return "Error: La fecha de atención es obligatoria.";
        }

        return "OK";
    }
}