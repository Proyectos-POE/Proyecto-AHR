/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.awt.List;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nicol
 */
public class RondaAhorcado 
{
    
    private String palabra;
    private String listaDePalabras[];
    private int cantidadDePalabras;
    private int intentosMaximos = 10;
    private static int rondasTotales;
    private int numeroDeRonda;
    private int totalPalabrasJugadas;
    private int palabrasAdivinadas;
    private int palabrasNoAdivinadas;
    
    RondaAhorcado()
    {
        rondasTotales++;
        setNumeroRonda(rondasTotales);
        palabrasAdivinadas = 0;
        palabrasNoAdivinadas = 0;
        totalPalabrasJugadas = 0;
    }
    
    public void elegirPalabra()
    {
        Random r = new Random();
        int numeroPalabra = r.nextInt(listaDePalabras.length-1);
        this.palabra = listaDePalabras[numeroPalabra].toUpperCase();
    }
    
    public boolean esLaPalabra(String palabraAdivinada)
    {
        if(palabra.equals(palabraAdivinada))
        {
            totalPalabrasJugadas++;
            palabrasAdivinadas++;
            consumirPalabra();
            setIntentos(10);
            elegirPalabra();
            
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean esLaLetra(String letraAdivinada)
    {
       if(palabra.contains(letraAdivinada))
       {
           return true;
       }
       else
       {
           consumirIntento();
           return false;
       }
        
    }
    
    public boolean terminoIntentos()
    {
        if(intentosMaximos == 0)
        {
            totalPalabrasJugadas++;
            palabrasNoAdivinadas++; 
            consumirPalabra();
            setIntentos(10);
            elegirPalabra();
            return true;
        }
        else
        {
            return false;
        }
    }
   
    public boolean terminoRonda()
    { 
        if(cantidadDePalabras == 0)
        {
            return true;
        }
        else
        {
            return  false;
        }
        
    }
    
    public void setCantidadDePalabras(int cantidadDePalabras)
    {
        this.cantidadDePalabras = cantidadDePalabras;  
    }
    
    public void setListaDePalabras(String listaDePalabras[])
    {
        this.listaDePalabras = listaDePalabras;
    }
    
    public String getPalabra()
    {
        return palabra;
    }
    
    public int getIntentosRestantes()
    {
        return intentosMaximos;
    }
    
    public int getPalabrasAdivinadas()
    {
        return palabrasAdivinadas;  
    }
    
    public int getPalabrasNoAdivinadas()
    {
        return palabrasNoAdivinadas;  
    }
    
    public float getPorcPalabrasAdivinadas()
    {
        if(totalPalabrasJugadas == 0)
        {
            return 0;
        }
        else
        {
            float resultado = Math.round((float)palabrasAdivinadas/totalPalabrasJugadas*100);
            return resultado;  
        }    
    }
    
    public float getPorcPalabrasNoAdivinadas()
    {
        if(totalPalabrasJugadas == 0)
        {
            return 0;
        }
        else
        {
            float resultado = Math.round((float)palabrasNoAdivinadas/totalPalabrasJugadas*100);
            return resultado; 
        }   
    }
    
    public int getNumeroDeRonda()
    {
        return numeroDeRonda;  
    }
    
    private void setNumeroRonda(int numeroDeRonda)
    {
        this.numeroDeRonda = numeroDeRonda;
    }
    
    private void consumirIntento()
    {
        intentosMaximos = intentosMaximos - 1;
    }
    
    private void consumirPalabra()
    {
        cantidadDePalabras = cantidadDePalabras - 1;
    } 
    
    private void setIntentos(int intentos)
    {
        this.intentosMaximos = intentos;
    }
    
}
