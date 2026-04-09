package com.example.vetcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vetcare.model.Atencion;

@RestController
@RequestMapping("/api/v1/atenciones")
public class AtencionController {
  @Autowired
  private com.example.vetcare.service.AtencionService atencionService;

  @GetMapping
  public List<Atencion> listarAtenciones() {
    return atencionService.getAtenciones();
  }

  @GetMapping("{id}")
  public Atencion buscarLibro(@PathVariable int id) {
    return atencionService.getAtencionId(id);
  }

  @PostMapping
  public Object agregarAtencion(@RequestBody Atencion atencion) {
    return atencionService.saveAtencion(atencion);
  }

  @PutMapping("{id}")
  public Atencion actualizarAtencion(@PathVariable int id, @RequestBody Atencion atencion) {
    return atencionService.updateAtencion(id, atencion);
  }

  @DeleteMapping("{id}")
  public String eliminarAtencion(@PathVariable int id) {
    return atencionService.deleteAtencion(id);
  }

  @GetMapping("/ordenar")
  public List<Atencion> listarAtencionesOrdenadas() {
    return atencionService.getAtencionesOrdenadas();
  }

  @GetMapping("/nombre/{nombre}")
  public List<Atencion> buscarAtencionNombre(@PathVariable String nombre) {
    return atencionService.getAtencionNombre(nombre);
  }

}
