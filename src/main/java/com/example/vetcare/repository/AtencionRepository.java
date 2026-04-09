package com.example.vetcare.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.vetcare.model.Atencion;

@Repository
public class AtencionRepository {
    private List<Atencion> listaatencion = new ArrayList<>();

    public AtencionRepository() {
        Date fecha = new Date();

        listaatencion.add(new Atencion(1, "Princesa", "Ambar", "Intoxicacion", fecha));
        listaatencion.add(new Atencion(2, "King", "K1", "Diarrea", fecha));
    }

    public List<Atencion> obtenerAtenciones() {
        return listaatencion;
    }

    public Atencion buscarPorId(int id) {
        for (Atencion atencion : listaatencion)
            if (atencion.getId() == id)
                return atencion;
        return null;
    }

    public Atencion guardar(Atencion ate) {
        Atencion atencion = buscarPorId(ate.getId());
        if (atencion != null) {
            return null;
        }
        listaatencion.add(ate);
        return ate;
    }

    public Atencion actualizar(int id, Atencion ate) {
        int idPosicion = 0;
        for (int i = 0; i < listaatencion.size(); i++) {
            if (listaatencion.get(i).getId() == id) {
                idPosicion = i;
            }
        }

        Atencion atencion1 = new Atencion();
        atencion1.setId(id);
        atencion1.setNombre(ate.getNombre());
        atencion1.setNombre_dueno(ate.getNombre_dueno());
        atencion1.setMotivo(ate.getMotivo());
        atencion1.setFecha(ate.getFecha());
        listaatencion.set(idPosicion, atencion1);
        return atencion1;
    }

    public void eliminar(int id) {
        Atencion atencion = buscarPorId(id);
        if (atencion != null) {
            listaatencion.remove(atencion);
        }
    }

    public List<Atencion> ordenarAtenciones() {
        List<Atencion> lista = new ArrayList<>(listaatencion);
        lista.sort(Comparator.comparing(Atencion::getNombre)/* .reversed() */);
        return lista;
    };

    public List<Atencion> buscarNombre(String nombre) {
        List<Atencion> lista = new ArrayList<>();
        for (Atencion a : listaatencion) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                lista.add(a);
            }
        }
        return lista;
    }
}