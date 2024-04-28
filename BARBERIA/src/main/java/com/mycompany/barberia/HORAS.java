/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barberia;

/**
 *
 * @author onicg
 */
public class HORAS {
    // Constructor
    public HORAS () {}

    // Atributos
    public BARBERO barbero;
    public CLIENTE cliente;
    public CITAS cita;

    // Métodos
    public void ingresarBarberoDia(BARBERO objBarbero) {
        this.barbero = objBarbero;
    }

    public void ingresarClienteDia(CLIENTE objCliente) {
        this.cliente = objCliente;
    }
    
    public void ingresarHoraCita(CITAS objCita) {
        this.cita = objCita;
    }
}