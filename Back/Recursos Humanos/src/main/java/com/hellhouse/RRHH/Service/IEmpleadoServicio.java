/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hellhouse.RRHH.Service;

import com.hellhouse.RRHH.model.Empleado;
import java.util.*;

/**
 *
 * @author crowl
 */
public interface IEmpleadoServicio {
    
    public List<Empleado> listarEmpleados();
    
    public Empleado buscarEmpleadoId(Long idEmpleado);
    
    public Empleado guardarEmpleado(Empleado empleado);
    
    public void eliminarEmpleado(Long  id);
    
}
