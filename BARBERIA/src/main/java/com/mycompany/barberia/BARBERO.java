/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barberia;


/**
 *
 * @author sebas
 */
public class BARBERO {
   // Constructor
   public BARBERO () {}
   
   // Atributos
   public String NombreBarbero;
   public int AlmuerzoBarbero;
   
   // Métodos
   public void ingresarNombreBarbero (String nombre_barbero) {
        this.NombreBarbero = nombre_barbero;
   }
   
   public void ingresarAlmuerzoBarbero (int hora_almuerzo_barbero) {
       this.AlmuerzoBarbero = hora_almuerzo_barbero;
   }
}
