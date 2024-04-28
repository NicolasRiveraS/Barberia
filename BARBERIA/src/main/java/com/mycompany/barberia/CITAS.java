/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barberia;

import java.time.DayOfWeek;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author onicg
 */
public class CITAS {
    // Atributos
    public int HorasSesion;
    public int HoraInicioCita;
    public int HoraFinalCita;
    public LocalDate FechaCita;
    public DayOfWeek DiaCitaString;
    public int DiaCitaInt;
    public int MesCitaInt;
    public double PrecioCita;
    public double PrecioTotalCita;
    public double iva = 0.13;
    public int conversion_hora_regular_a_militar;
    public String FinDeSemanaONo;
    
    // Constructor
    public CITAS () {}
       
    // Métodos
    public void ingresarHorasSesion () {
        this.HorasSesion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de horas necesarias para su sesión en la Barbería: "));
    }
    
    public void ingresarHoraInicioCita () {
        this.HoraInicioCita = Integer.parseInt(JOptionPane.showInputDialog("Ingrese a qué hora desearía agendar su cita (en formato militar, ej: 1600): "));
    }
    
    public void calcularHoraFinalCita (){
        this.conversion_hora_regular_a_militar = this.HorasSesion * 100;
        this.HoraFinalCita = (this.HoraInicioCita + conversion_hora_regular_a_militar);
    }
    
    public void ingresarFechaCita () {
        // Input de fecha
        this.FechaCita = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha para la cual quiere agendar su cita (AAAA-MM-DD):"));
        
        // Parseo para saber el nombre del día (Lunes, Martes...)
        this.DiaCitaString = FechaCita.getDayOfWeek();
        
        // Parseo para obtener el número del día (12, 28...)
        this.DiaCitaInt = FechaCita.getDayOfMonth();
        
        // Parseo para obtener el número de mes (1, 5, 11)
        this.MesCitaInt = FechaCita.getMonthValue();
    }
    public void calcularPrecioCita () {
        switch (DiaCitaString) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                this.PrecioCita = 2500;
                this.FinDeSemanaONo = "entre semana";
                break;
            
            case SATURDAY:
            case SUNDAY:
                this.PrecioCita = 3000;
                this.FinDeSemanaONo = "fin de semana";
                break;
        }
    }
    public void calcularPrecioTotalCita () {
        double total_sin_iva = (this.PrecioCita * this.HorasSesion);
        double monto_iva = (total_sin_iva * this.iva);
        this.PrecioTotalCita = (total_sin_iva + monto_iva);
    }
}
