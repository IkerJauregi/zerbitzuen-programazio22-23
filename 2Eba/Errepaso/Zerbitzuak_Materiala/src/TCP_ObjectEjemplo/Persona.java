/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_ObjectEjemplo;

import java.io.Serializable;

/**
 *
 * @author Hodei
 */
class Persona implements Serializable{

    public String izena;
    public int urteak;
    
    Persona(String izena, int urteak) {
        this.izena = izena;
        this.urteak = urteak;     
    }

    public String getIzena() {
        return izena;
    }

    public int getUrteak() {
        return urteak;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void setUrteak(int urteak) {
        this.urteak = urteak;
    }
    
}
