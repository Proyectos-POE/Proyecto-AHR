/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import modelo.Jugador;
/**
 *
 * @author nicol
 */
public class JuegoAhorcado {
    
    private Jugador jugador;
    private String listaDeAnimales[]={"leon", "caballo", "gallina", "cocodrilo", "oso", "conejo", "vaca", "ballena", "cabra", "gato", "abeja", "pelicano", "murcielago", "cucaracha", "pantera", "leopardo", "avestruz", "jaguar", "tigre", "pinguino", "aguila", "elefante", "hipopotamo", "hormiga", "rinoceronte", "ardilla", "iguana", "caracol"};
    private String listaDeColores[]={"rojo", "verde", "amarillo", "azul", "blanco", "negro", "violeta", "morado", "magenta", "rosado", "lima", "gris", "plateado", "dorado", "naranja", "marron", "vinotinto", "purpura", "inidigo", "lila", "cyan"};
    private String listaDeFrutas[]={"manzana", "pera", "sandia", "melocoton", "mandarina", "berenjena", "banano", "piña", "uva", "mora", "durazno", "maracuya", "granadilla", "frambuesa", "fresa", "cereza", "ciruela", "melon", "papaya", "limon", "guanabana"};
    private RondaAhorcado ronda;
    private RondaAhorcado mejorRonda;
    private RondaAhorcado peorRonda;
    private ArrayList<String> palabrasAdivinadas;
    private String palabraMasAdivinada;
    
    public JuegoAhorcado(Jugador jugador)
    {
        this.jugador = jugador;
        palabrasAdivinadas = new ArrayList<String>();
    }
    
    public void iniciarRonda()
    {  
        ronda = new RondaAhorcado();
        if (ronda.getNumeroDeRonda() == 1){
            mejorRonda = ronda;
            peorRonda = ronda;
        }
        ronda.setCantidadDePalabras(jugador.getNumeroDePalabras());
        if(jugador.getTematicaElegida().equals("ANIMALES"))
        {
            ronda.setListaDePalabras(listaDeAnimales);
        }
        else if(jugador.getTematicaElegida().equals("COLORES"))
        {
            ronda.setListaDePalabras(listaDeColores);
        }
        else if(jugador.getTematicaElegida().equals("FRUTAS"))
        {
            ronda.setListaDePalabras(listaDeFrutas);
        }
        ronda.elegirPalabra();
    }
    
    public boolean esLaLetra(String letraAdivinada)
    {
       return ronda.esLaLetra(letraAdivinada);
    }
    
    public boolean esLaPalabra(String palabraAdivinada)
    {
        if(ronda.esLaPalabra(palabraAdivinada))
        {
            palabrasAdivinadas.add(palabraAdivinada);
            return true;
            
        }
        else
        {
            return false;
        }
    }
    
    public boolean terminoIntentos()
    {
        return ronda.terminoIntentos();
    }
    
    public boolean terminoRonda()
    {
        if(ronda.terminoRonda())
        {
            compararRondas();
            compararPalabras();
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public RondaAhorcado getMejorRonda()
    {
        return mejorRonda;
    }
    
    public RondaAhorcado getPeorRonda()
    {
        return peorRonda;
    }
    
    public void compararRondas()
    {
        if(ronda.getPorcPalabrasAdivinadas() > mejorRonda.getPorcPalabrasAdivinadas())
        {
            mejorRonda = ronda;
        }
        if(ronda.getPorcPalabrasNoAdivinadas() > peorRonda.getPorcPalabrasNoAdivinadas())
        {
            peorRonda = ronda;
        }
    }
    
    public void compararPalabras()
    {
        String auxPalabraMasAdivinda = "";
        int maxRepPalabra = 0;
        for(int i=0; i< palabrasAdivinadas.size(); i++)
        {
            int repeticiones = 0;
            for(int j=0; j<palabrasAdivinadas.size(); j++)
            {
                if(palabrasAdivinadas.get(i).equals(palabrasAdivinadas.get(j)))
                {
                    repeticiones++;
                }   
                if(repeticiones > maxRepPalabra)
                {
                    auxPalabraMasAdivinda = palabrasAdivinadas.get(i);
                    maxRepPalabra = repeticiones;
                }
            }
        } 
        this.palabraMasAdivinada = auxPalabraMasAdivinda;
    }
    
    public String getPalabra()
    {
      return ronda.getPalabra().toUpperCase();
    }
    
    public String getPalabraMasAdivinda()
    {
        return palabraMasAdivinada;
    }
    
    public int getPalabrasAdivinadas()
    {
        return ronda.getPalabrasAdivinadas();
    }
    
    public float getPorcPalabrasAdivinadas()
    {
        return ronda.getPorcPalabrasAdivinadas();
    }
    
    public int getPalabrasNoAdivinadas()
    {
        return ronda.getPalabrasNoAdivinadas();
    }
    
    public float getPorcPalabrasNoAdivinadas()
    {
        return ronda.getPorcPalabrasNoAdivinadas();
    }
    
    public int getIntentosRestantes() 
    {
        return ronda.getIntentosRestantes();
    }

    public int getNumeroDeRonda()
    {
        return ronda.getNumeroDeRonda();
    }
    
    public void setTematica(String tematica)
    {
        jugador.setTematicaElegida(tematica);
    }
    
    
    
    
    
    
   
}
