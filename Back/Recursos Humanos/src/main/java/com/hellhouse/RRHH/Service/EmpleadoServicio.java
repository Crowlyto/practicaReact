/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hellhouse.RRHH.Service;

import com.hellhouse.RRHH.model.Empleado;
import com.hellhouse.RRHH.repository.EmpleadoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crowl
 */
@Service
public class EmpleadoServicio implements IEmpleadoServicio{
    
    @Autowired
    private EmpleadoRepositorio empleadoRepository;

    @Override
    public List<Empleado> listarEmpleados() {
     return empleadoRepository.findAll();
    }

    @Override
    public Empleado buscarEmpleadoId(Long idEmpleado) {
        Empleado empleado= empleadoRepository.findById(idEmpleado).orElse(null);
        return empleado;
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
      
        return empleadoRepository.save(empleado);
    }
    
    public Empleado editarEmpleado(Empleado empleado, Long id){
        Empleado empleadoBBDD=buscarEmpleadoId(id);
        if(empleadoBBDD!=null){
            empleadoBBDD.setNombre(empleado.getNombre());
            empleadoBBDD.setApellido(empleado.getApellido());
            empleadoBBDD.setDepartamento(empleado.getDepartamento());
            empleadoBBDD.setMail(empleado.getMail());
            empleadoBBDD.setTelefono(empleado.getTelefono());
            empleadoBBDD.setSueldo(empleado.getSueldo());
            return empleadoRepository.save(empleadoBBDD);
        }
        return null;
    }

    @Override
    public void eliminarEmpleado(Long id) {
        Empleado empleadoBBDD=buscarEmpleadoId(id);
        if(empleadoBBDD!=null){
            empleadoRepository.deleteById(id);
        }
    }
    
}
