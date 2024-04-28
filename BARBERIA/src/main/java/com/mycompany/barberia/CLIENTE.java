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
public class CLIENTE {
    // Constructor
    public CLIENTE () {}
    
    // Atributos
    private String NombreCliente;
    private String TelefonoCliente;
    
    // Encapsuladores
    public void setNombreCliente (String nombre_cliente) {
        this.NombreCliente = nombre_cliente;
    }
    public String getNombreCliente (){
        return this.NombreCliente;
    }
    
    public void setTelefonoCliente (String telefono_cliente) {
        this.TelefonoCliente = telefono_cliente;
    }
    public String getTelefonoCliente () {
        return this.TelefonoCliente;
    }
}
