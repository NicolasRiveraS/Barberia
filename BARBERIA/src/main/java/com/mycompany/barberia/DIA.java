/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barberia;

import javax.swing.JOptionPane;

/**
 *
 * @author onicg
 */
public class DIA {
    // Constructor
    public DIA () {}
    
    // Atributos
    public HORAS jornada [] = new HORAS [8];    // De 9am a 5pm (900 a 1700)
    public double precio_total_cita;
    
    // Métodos
    public void llenarHorasJornada (HORAS hora_obj) {
        for (int i = 0; i < 8; i++) {
            if (hora_obj.cita.HoraInicioCita == ((i+9)*100)) {
                for (int j = 0; j < hora_obj.cita.HorasSesion; j++) {
                    this.jornada[i+j] = hora_obj;
                }
            }
        }
    }
    public void llenarPrecioTotalCita () {
        for (int i = 0; i < 8; i++) {
            if (this.jornada[i] != null && this.jornada [i].cita.PrecioTotalCita > 0) {
                this.precio_total_cita = this.jornada [i].cita.PrecioTotalCita;
                break;
            }
        }
    }
}
