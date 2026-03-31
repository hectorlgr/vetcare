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
    if (atencion.validarNombre())
      return atencionRepository.guardar(atencion);
    return "El nombre no puede estar vacío";
  }

  public Atencion updateAtencion(int id, Atencion atencion) {
    return atencionRepository.actualizar(id, atencion);
  }

  public String deleteAtencion(int id) {
    atencionRepository.eliminar(id);
    return "Atencion eliminada";
  }

  public List<Atencion> getAtencionesOrdenadas() {
    return atencionRepository.ordenarAtenciones();
  }

}
