/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hellhouse.RRHH.Controlador;

import com.hellhouse.RRHH.Service.EmpleadoServicio;
import com.hellhouse.RRHH.model.Empleado;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author crowl
 */
@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins ="*")
public class EmpleadoControlador {
    
    private static final Logger logger=LoggerFactory.getLogger(EmpleadoControlador.class);
    
    
    @Autowired
    private EmpleadoServicio empleadoServicio;
    
    @GetMapping("/todos")
    public ResponseEntity<?>listarEmpleados(){
        List<Empleado>empleados=empleadoServicio.listarEmpleados();
        empleados.forEach((empleado->logger.info(empleado.toString())));
        return ResponseEntity.ok(empleados);
    }
    
    @GetMapping("/porId/{id}")
    public ResponseEntity<?>buscarPorId(@PathVariable Long id){
        Empleado empleadoBBDD=empleadoServicio.buscarEmpleadoId(id);
        return ResponseEntity.ok(empleadoBBDD);
        
    }
    
    @PostMapping("/guardar")
    public ResponseEntity<?>agregarEmpleados(@RequestBody Empleado empleado){
        logger.info("Empleado a agregar: "+ empleado);
        return ResponseEntity.ok(empleadoServicio.guardarEmpleado(empleado));
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?>editarEmpleado(@RequestBody Empleado empleado, @PathVariable Long id){
        Empleado empleadoBBDD=empleadoServicio.editarEmpleado(empleado, id);
        return ResponseEntity.ok(empleadoBBDD);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?>eliminarEmpleado(@PathVariable Long id){
        empleadoServicio.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }
    
}
