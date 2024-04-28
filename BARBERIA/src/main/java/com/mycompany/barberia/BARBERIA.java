/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.barberia;

import javax.swing.JOptionPane;
import java.time.*;

/**
 *
 * @author Nicolás Rivera
 */
public class BARBERIA {   
    public static void main(String[] args) {
        // Declaración de variables
        int opcion;
        int opcion_barbero;
        int opcion_cita;
        int opcion_barbero_cita;
        int opcion_barbero_eliminar;
        int opcion_calendario_barberos;
        
        String nombre_barbero;
        int hora_almuerzo_barbero;

        String mostrar_barberos = "";
        String mostrar_citas = "";
        
        String nombre_cliente;
        String telefono_cliente;
        
        int cantidad_barberos = 0;
        int cantidad_clientes = 0;
        int cantidad_citas = 0;
        int cantidad_dias = 0;
        int cantidad_horas = 0;
        
        boolean hay_cita_o_no = false;
        
        LocalDate fecha_eliminar;
        LocalDate fecha_calendario;
        
        // Declaración de arreglos        
        BARBERO barberos_lista [] = new BARBERO [5];
        CALENDARIO calendario_lista [] = new CALENDARIO [5];
        CLIENTE clientes_lista [] = new CLIENTE [10];
        CITAS citas_lista [] = new CITAS [10];
        DIA dias_lista [] = new DIA [10];
        HORAS horas_lista [] = new HORAS [80];
                
        // Menú Principal
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("▬ Bienvenido a Fresh Barber ▬\n\n"
                    + "1. Administración de Barberos\n"
                    + "2. Administración de Citas\n"
                    + "3. Calendario de Barberos\n"
                    + "4. Salir\n\n"
                    + "Ingrese una opción:"));

            switch (opcion) {                   
                // Administración de los Barberos
                case 1:
                    // Sub-menú Información del Barbero
                    do {
                        opcion_barbero = Integer.parseInt(JOptionPane.showInputDialog("► Administración de Barberos ◄\n\n"
                                + "1. Ingresar información de los barberos\n"
                                + "2. Mostrar información ingresada\n"
                                + "3. Regresar al menú anterior\n\n"
                                + "Ingrese una opción:"));
                        
                        switch (opcion_barbero) {
                            
                            // Ingresar nombre y hora de almuerzo
                            case 1:
                                for (int i = 0; i < barberos_lista.length; i++) {
                                    BARBERO Barbero_Obj = new BARBERO();
                                    CALENDARIO Calendario_Obj = new CALENDARIO();
                                    
                                    nombre_barbero = JOptionPane.showInputDialog("Ingrese el nombre del Barbero " + (i + 1));
                                    Barbero_Obj.ingresarNombreBarbero(nombre_barbero);
                                    
                                    hora_almuerzo_barbero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la hora de almuerzo de " + nombre_barbero + " en formato militar (ej: 1500)"));
                                    Barbero_Obj.ingresarAlmuerzoBarbero(hora_almuerzo_barbero);
                                    
                                    barberos_lista [i] = Barbero_Obj;
                                    calendario_lista [i] = Calendario_Obj;
                                    
                                    cantidad_barberos ++;
                                }
                                
                                JOptionPane.showMessageDialog(null, "¡Información guardada con éxito!");
                                
                                break;
                                
                            // Mostrar información
                            case 2:
                                if (cantidad_barberos > 0) {                                    // Poner solo una vez
                                    for (int i = 0; i < barberos_lista.length; i++) {
                                        mostrar_barberos += "► Barbero " + (i + 1) 
                                                + "\nNombre: " + barberos_lista [i].NombreBarbero 
                                                + "\nHora de almuerzo: " + barberos_lista [i].AlmuerzoBarbero 
                                                + "\n\n";
                                    }
                                    
                                    JOptionPane.showMessageDialog(null, "Información registrada:\n" + mostrar_barberos);
                                    
                                } else {
                                    JOptionPane.showMessageDialog(null, "Opción no disponible. Introduzca la información de los barberos primeramente.");
                                }
                                break;
                            
                            // Regresar
                            case 3:
                                break;

                            // Opción no válida
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
                                break;
                        }
                    } while (opcion_barbero != 3);
                    break; 
                
                // Administración de Citas
                case 2:
                    do {
                        opcion_cita = Integer.parseInt(JOptionPane.showInputDialog("► Administración de Citas ◄\n\n"
                                + "1. Agendar una cita\n"
                                + "2. Mostrar citas registradas\n"
                                + "3. Eliminar una cita\n"
                                + "4. Regresar al menú anterior\n\n"
                                + "Ingrese una opción:"));

                        switch (opcion_cita) {

                            // Agendar cita
                            case 1:
                                if (cantidad_barberos > 0){
                                    CLIENTE Cliente_obj = new CLIENTE();

                                    nombre_cliente = JOptionPane.showInputDialog("Ingrese el nombre completo del cliente: ");
                                    Cliente_obj.setNombreCliente(nombre_cliente);

                                    telefono_cliente = JOptionPane.showInputDialog("Ingrese el número telefónico: ");
                                    Cliente_obj.setTelefonoCliente(telefono_cliente);

                                    JOptionPane.showMessageDialog(null, "¡Información del cliente guardada con éxito!");
                                    
                                    CITAS Cita_obj = new CITAS();

                                    opcion_barbero_cita = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opción del Barbero que desea para su cita\n"
                                            + "\n1. " + barberos_lista[0].NombreBarbero 
                                            + "\n2. " + barberos_lista[1].NombreBarbero
                                            + "\n3. " + barberos_lista[2].NombreBarbero
                                            + "\n4. " + barberos_lista[3].NombreBarbero
                                            + "\n5. " + barberos_lista[4].NombreBarbero 
                                            + "\n"));
                                                       
                                    citas_lista[cantidad_citas] = Cita_obj;

                                    citas_lista[cantidad_citas].ingresarFechaCita();
                                    citas_lista[cantidad_citas].ingresarHoraInicioCita();
                                    citas_lista[cantidad_citas].ingresarHorasSesion();
                                    citas_lista[cantidad_citas].calcularHoraFinalCita();
                                    citas_lista[cantidad_citas].calcularPrecioCita();
                                    citas_lista[cantidad_citas].calcularPrecioTotalCita();
                                    
                                    if (opcion_barbero_cita > 5) {
                                        JOptionPane.showMessageDialog(null, "Opción no disponible. Intente nuevamente.");
                                    }
                                    else if (Cita_obj.HoraFinalCita > barberos_lista[(opcion_barbero_cita - 1)].AlmuerzoBarbero && barberos_lista[(opcion_barbero_cita - 1)].AlmuerzoBarbero >= Cita_obj.HoraInicioCita) {
                                        JOptionPane.showMessageDialog(null, "La hora seleccionada no se encuentra disponible.\nPor favor intente nuevamente con otra hora.");
                                    }
                                    else if (Cita_obj.HoraInicioCita < 900 || Cita_obj.HoraFinalCita > 1700) {
                                        JOptionPane.showMessageDialog(null, "La hora seleccionada se encuentra fuera del horario de servicio disponible.\nPor favor intente nuevamente con otra hora.");
                                    }
                                    else {
                                        clientes_lista[cantidad_clientes] = Cliente_obj;
                                        
                                        DIA Dia_obj = new DIA();
                                        HORAS Hora_obj = new HORAS();

                                        dias_lista [cantidad_dias] = Dia_obj;
                                        horas_lista [cantidad_horas] = Hora_obj;

                                        horas_lista [cantidad_horas].ingresarBarberoDia(barberos_lista[(opcion_barbero_cita - 1)]);
                                        horas_lista [cantidad_horas].ingresarClienteDia(clientes_lista [cantidad_citas]);
                                        horas_lista [cantidad_horas].ingresarHoraCita(citas_lista [cantidad_citas]);

                                        dias_lista [cantidad_dias].llenarHorasJornada(horas_lista [cantidad_horas]);
                                        dias_lista[cantidad_dias].llenarPrecioTotalCita();

                                        calendario_lista [(opcion_barbero_cita - 1)].AsignarDiaCalendario(Cita_obj.MesCitaInt, Cita_obj.DiaCitaInt, dias_lista[cantidad_dias]);
                                        
                                        JOptionPane.showMessageDialog(null, "¡Información de la cita guardada con éxito!");
                                        
                                        cantidad_clientes++;
                                        cantidad_citas++;
                                        cantidad_dias++;
                                        cantidad_horas++;
                                    }                               
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "Opción no disponible. Introduzca la información de los barberos primeramente.");
                                }
                                break;

                            // Mostrar citas
                            case 2:
                                if (cantidad_citas > 0) {
                                    mostrar_citas = "Citas registradas:\n\n";
                                    for (int i = 0; i < cantidad_citas; i++) {
                                        if (horas_lista [i] != null){
                                            mostrar_citas += "► Nombre cliente: " + horas_lista [i].cliente.getNombreCliente()
                                                + "\nTeléfono: " + horas_lista [i].cliente.getTelefonoCliente()
                                                + "\nBarbero encargado: " + horas_lista [i].barbero.NombreBarbero
                                                + "\nFecha de la cita: " + horas_lista [i].cita.FechaCita
                                                + "\nHora de inicio de la cita: " + horas_lista [i].cita.HoraInicioCita
                                                + "\nHora de finalización de la cita: " + horas_lista [i].cita.HoraFinalCita
                                                + "\nDuración de la cita: " + horas_lista [i].cita.HorasSesion + " horas"
                                                + "\nAl ser la cita " + horas_lista [i].cita.FinDeSemanaONo + " el precio por hora es de " + horas_lista [i].cita.PrecioCita + " colones"
                                                + "\nTotal (IVA incluido): " + horas_lista [i].cita.PrecioTotalCita + " colones\n\n";
                                        }
                                    }
                                    JOptionPane.showMessageDialog(null, mostrar_citas);

                                } 
                                else {
                                    JOptionPane.showMessageDialog(null, "Opción no disponible. No existen citas registradas actualmente.");
                                }
                                break;
                            
                            // Eliminar cita
                            case 3:
                                if (cantidad_citas > 0) {
                                    opcion_barbero_eliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opción del Barbero que tiene asignada la cita\n"
                                            + "\n1. " + barberos_lista[0].NombreBarbero
                                            + "\n2. " + barberos_lista[1].NombreBarbero
                                            + "\n3. " + barberos_lista[2].NombreBarbero
                                            + "\n4. " + barberos_lista[3].NombreBarbero
                                            + "\n5. " + barberos_lista[4].NombreBarbero));

                                    if (opcion_barbero_eliminar > 5) {
                                        JOptionPane.showMessageDialog(null, "Opción no disponible. Intente nuevamente.");
                                    }
                                    else {
                                        fecha_eliminar = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de la cita que desea eliminar (AAAA-MM-DD):"));

                                        int DiaEliminarInt = fecha_eliminar.getDayOfMonth();
                                        int MesEliminarInt = fecha_eliminar.getMonthValue();

                                        for (int i = 0; i < 8; i++) {
                                            if (calendario_lista[(opcion_barbero_eliminar - 1)].MatrizCalendario[MesEliminarInt][DiaEliminarInt] == null) {
                                                break;
                                            }
                                            else if (calendario_lista[(opcion_barbero_eliminar - 1)].MatrizCalendario[MesEliminarInt][DiaEliminarInt].jornada[i] != null) {
                                                hay_cita_o_no = true;
                                                break;
                                            }
                                        }

                                        if (hay_cita_o_no == true) {
                                            int confirmacion_eliminar = Integer.parseInt(JOptionPane.showInputDialog("Se encontró una cita en la fecha ingresada\n"
                                                    + "¿Está seguro de que desea eliminarla?\n"
                                                    + "1. Si\n"
                                                    + "2. No\n"));

                                            switch (confirmacion_eliminar) {
                                                case 1:
                                                    for (int i = 0; i < 8; i++) {
                                                        if (calendario_lista[(opcion_barbero_eliminar - 1)].MatrizCalendario[MesEliminarInt][DiaEliminarInt].jornada[i] != null) {

                                                            for (int j = 0; j < 10; j++) {
                                                                if (citas_lista[j] == calendario_lista[(opcion_barbero_eliminar - 1)].MatrizCalendario[MesEliminarInt][DiaEliminarInt].jornada[i].cita) {
                                                                    citas_lista[j] = null;
                                                                    cantidad_citas--;
                                                                }
                                                                if (clientes_lista[j] == calendario_lista[(opcion_barbero_eliminar - 1)].MatrizCalendario[MesEliminarInt][DiaEliminarInt].jornada[i].cliente) {
                                                                    clientes_lista[j] = null;
                                                                    cantidad_clientes--;
                                                                }
                                                                if (dias_lista[j] == calendario_lista[(opcion_barbero_eliminar - 1)].MatrizCalendario[MesEliminarInt][DiaEliminarInt]) {
                                                                    dias_lista[j] = null;
                                                                    cantidad_dias--;
                                                                }
                                                            }
                                                            for (int k = 0; k < 80; k++) {
                                                                if (horas_lista[k] == calendario_lista[(opcion_barbero_eliminar - 1)].MatrizCalendario[MesEliminarInt][DiaEliminarInt].jornada[i]) {
                                                                    horas_lista[k] = null;
                                                                    cantidad_horas--;
                                                                }
                                                            }

                                                            calendario_lista[(opcion_barbero_eliminar - 1)].MatrizCalendario[MesEliminarInt][DiaEliminarInt].jornada[i] = null;

                                                        }
                                                    }   break;
                                                case 2:
                                                    JOptionPane.showMessageDialog(null, "Cancelando eliminación de la cita...");
                                                    break;

                                                default:
                                                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                                                    break;
                                            }
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(null, "De momento no existe una cita asignada en la fecha seleccionada.\nIntente nuevamente con otra fecha.");
                                        }
                                    }
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "Opción no disponible. No existen citas registradas actualmente.");
                                }
                                break;
                            
                            // Regresar
                            case 4:
                                break;

                            // Opción no válida
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
                                break;
                        }
                    } while (opcion_cita != 4);
                    break;
                
                // Calendario de Barberos
                case 3:
                    if (cantidad_barberos > 0 && cantidad_citas > 0) {
                        do {
                            opcion_calendario_barberos = Integer.parseInt(JOptionPane.showInputDialog("► Calendario de Barberos ◄\n"
                                    + "\n1. Calendario del barbero " + barberos_lista[0].NombreBarbero
                                    + "\n2. Calendario del barbero " + barberos_lista[1].NombreBarbero
                                    + "\n3. Calendario del barbero " + barberos_lista[2].NombreBarbero
                                    + "\n4. Calendario del barbero " + barberos_lista[3].NombreBarbero
                                    + "\n5. Calendario del barbero " + barberos_lista[4].NombreBarbero
                                    + "\n6. Regresar al menú anterior"
                                    + "\n\nIngrese una opción:"));

                            if (opcion_calendario_barberos > 6) {
                                JOptionPane.showMessageDialog(null, "Opción no disponible. Intente nuevamente.");
                            }
                            else if (opcion_calendario_barberos == 6) {
                                break;
                            }
                            else {
                                fecha_calendario = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha que desea consultar en el calendario de " + barberos_lista[(opcion_calendario_barberos - 1)].NombreBarbero + " (AAAA-MM-DD):"));
                                String dia_formateado = "Información de citas del día " + fecha_calendario + " del barbero " + barberos_lista[(opcion_calendario_barberos - 1)].NombreBarbero + "\n\n";

                                int DiaInt = fecha_calendario.getDayOfMonth();
                                int MesInt = fecha_calendario.getMonthValue();

                                for (int i = 0; i < 8; i++) {
                                    if (barberos_lista[(opcion_calendario_barberos - 1)].AlmuerzoBarbero == ((i + 9) * 100)) {
                                        dia_formateado += "► De " + ((i + 9) * 100) + " a "+ ((i + 10) * 100) + ":\n"
                                                + "-HORA DE ALMUERZO-\n\n";
                                    }

                                    else if (calendario_lista [(opcion_calendario_barberos - 1)].MatrizCalendario [MesInt][DiaInt] == null || calendario_lista [(opcion_calendario_barberos - 1)].MatrizCalendario [MesInt][DiaInt].jornada [i] == null) {
                                        dia_formateado += "► De " + ((i + 9) * 100) + " a "+ ((i + 10) * 100) + ":\n"
                                                        + "-VACÍO-\n\n";
                                    }

                                    else {
                                        dia_formateado += "► De " + ((i + 9) * 100) + " a "+ ((i + 10) * 100) + ":\n"
                                                + "→→ CITA ASIGNADA ←←\n"
                                                + "Nombre: " + calendario_lista [(opcion_calendario_barberos - 1)].MatrizCalendario [MesInt][DiaInt].jornada [i].cliente.getNombreCliente() + "\n"
                                                + "Teléfono: " + calendario_lista [(opcion_calendario_barberos - 1)].MatrizCalendario [MesInt][DiaInt].jornada[i].cliente.getTelefonoCliente() + "\n\n";
                                    }
                                }
                                JOptionPane.showMessageDialog(null, dia_formateado);
                                JOptionPane.showMessageDialog(null, "Total generado en el día: " + calendario_lista [(opcion_calendario_barberos - 1)].MatrizCalendario [MesInt][DiaInt].precio_total_cita + " colones");
                            }
                            
                        } while (opcion_calendario_barberos != 6);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Opción no disponible. Introduzca la información de los barberos y/o agende una cita primeramente.");
                    }
                    break;

                // Salir
                case 4:
                    JOptionPane.showMessageDialog(null, "→ Saliendo...\n\n"
                            + "¡Gracias!");
                    break;
                
                // Opción no válida
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            }        
        } while (opcion != 4);  
    }     
}

