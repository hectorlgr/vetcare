package com.example.vetcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vetcare.model.Atencion;
import com.example.vetcare.repository.AtencionRepository;

@Service
public class AtencionService {
  @Autowired
  private AtencionRepository atencionRepository;

  public List<Atencion> getAtenciones() {
    return atencionRepository.obtenerAtenciones();
  }

  public Atencion getAtencionId(int id) {
    return atencionRepository.buscarPorId(id);
  }

  public Object saveAtencion(Atencion atencion) {
    String validacion = atencion.validarDatos();

    if (!validacion.equals("OK")) {
      return validacion;
    }

    Atencion resultado = atencionRepository.guardar(atencion);

    if (resultado == null) {
      return "Error: Ya existe una atención con el ID " + atencion.getId();
    }

    return resultado;
  }

  public Object updateAtencion(int id, Atencion atencion) {
    String validacion = atencion.validarDatos();

    if (!validacion.equals("OK")) {
      return validacion;
    }

    Atencion resultado = atencionRepository.actualizar(id, atencion);

    if (resultado == null) {
      return "Error: No se puede actualizar. La atención con ID " + id + " no existe.";
    }

    return resultado;
  }

  public String deleteAtencion(int id) {
    Atencion existe = atencionRepository.buscarPorId(id);
    if (existe != null) {
      atencionRepository.eliminar(id);
      return "Atención " + id + " eliminada exitosamente.";
    } else {
      return "Error: La atención " + id + " no existe.";
    }
  }

  public List<Atencion> getAtencionesOrdenadas() {
    return atencionRepository.ordenarAtenciones();
  }

  public List<Atencion> getAtencionNombre(String nombre) {
    return atencionRepository.buscarNombre(nombre);
  }

  public List<Atencion> getAtencionesPorFecha() {
    return atencionRepository.ordenarPorFechaDescendente(); // o el ascendente
  }

}
