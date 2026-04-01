package com.example.vetcare.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//import javax.management.AttributeChangeNotificationFilter;

import org.springframework.stereotype.Repository;

import com.example.vetcare.model.Atencion;

@Repository
public class AtencionRepository {
    private List<Atencion> listaatencion = new ArrayList<>();

    public AtencionRepository() {
        listaatencion.add(new Atencion(1, "Rambo", "Eduardo", "Fiebre", "01/03/2026"));
        listaatencion.add(new Atencion(2, "Pelusa", "Samuel", "Diarrea", "31/03/2026"));

    }

    public List<Atencion> obtenerAtenciones() {
        return listaatencion;
    };

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

}
