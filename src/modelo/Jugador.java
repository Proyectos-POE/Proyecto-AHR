/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author nicol
 */
public class Jugador {
    
    private String nombre;
    private int numeroDePalabras;
    private String tematicaElegida;
    
    public void setNombre(String _nombre)
    {
        this.nombre = _nombre;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setNumeroDePalabras(int _numeroDePalabras)
    {
        this.numeroDePalabras = _numeroDePalabras;
    }
    
    public int getNumeroDePalabras()
    {
        return numeroDePalabras;
    }
    
    public void setTematicaElegida(String _tematicaElegida)
    {
        this.tematicaElegida = _tematicaElegida;
    }
    
    public String getTematicaElegida()
    {
        return tematicaElegida;
    }
    
}
