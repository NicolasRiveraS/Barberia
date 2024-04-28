/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barberia;

/**
 *
 * @author onicg
 */
public class CALENDARIO {
    // Constructor
    public CALENDARIO () {}
    
    // Atributos
    public DIA MatrizCalendario [][] = new DIA [12][30];
    
    // Métodos
    public void AsignarDiaCalendario (int MesCitaInt, int DiaCitaInt, DIA Dia_obj) {
        this.MatrizCalendario [MesCitaInt][DiaCitaInt] = Dia_obj;
    }
}
