/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import modelo.Jugador;
import logica.JuegoAhorcado;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import tipografiam.Fuentes;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextArea;
import javax.swing.UIManager;

/**
 *
 * @author nicol
 */
public class VentanaJuego extends JFrame
{
    Fuentes tipoFuente;
    private FondoVentana jpFondo;
    private JPanel jpContenidoTitulo;
    private JLabel lblTitulo;
    private JPanel jpContenidoPalabra;
    private JLabel jpCasillasDeTexto[];
    private JLabel jpContenidoAhorcado;
    private JTextArea lblIntentos;
    private JTextArea lblRonda;
    private Ahorcado jpImagenAhorcado;
    private JPanel jpContenidoTeclado;
    private char [] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    private JButton[] botones = new JButton[27];
    private JPanel jpContenidoBoton;
    private JButton btnTerminarRonda;
    private JuegoAhorcado juegoAhorcado;
      
    public VentanaJuego(Jugador jugador)
    {
        juegoAhorcado = new JuegoAhorcado(jugador);
        juegoAhorcado.iniciarRonda();
        inicializarComponentes();
    }
    
    private void inicializarComponentes()
    {
        setTitle("Ahorcado");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(570,771);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null); 
        
        tipoFuente = new Fuentes();
        UIManager.put("ComboBox.font", tipoFuente.fuente(tipoFuente.Lapiz,1,20));
        UIManager.put("OptionPane.messageFont", tipoFuente.fuente(tipoFuente.Lapiz,1,20));
        UIManager.put("OptionPane.buttonFont", tipoFuente.fuente(tipoFuente.Lapiz,1,20));

        jpFondo = new FondoVentana("/Fondo/FondoAhorcado.jpg");
        jpFondo.setSize(570,771);
        jpFondo.setLayout(null);
        
        jpContenidoTitulo = new JPanel();
        jpContenidoTitulo.setSize(570,115);
        jpContenidoTitulo.setBounds(0,0,570, 115);
        jpContenidoTitulo.setLayout(null);
        jpContenidoTitulo.setOpaque(false);
        
        lblTitulo = new JLabel("AHORKDO", SwingConstants.CENTER);
        lblTitulo.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,100));  
        lblTitulo.setBounds(15, 30, 570, 100);
        lblTitulo.setForeground(Color.CYAN.darker().darker());
        jpContenidoTitulo.add(lblTitulo);
        
        jpContenidoPalabra = new JPanel();
        jpContenidoPalabra.setSize(570,100);        
        jpContenidoPalabra.setBounds(0,115, 570, 100);
        jpContenidoPalabra.setLayout(null);
        jpContenidoPalabra.setOpaque(false);

        jpCasillasDeTexto = new JLabel[(juegoAhorcado.getPalabra()).length()];
        
        int tamanoCasilla = 30;
        for(int i = 0; i < (juegoAhorcado.getPalabra()).length(); i++)
        {
            int posicionInicial = (((juegoAhorcado.getPalabra().length()*tamanoCasilla))/2);
            int espacioOcupado = i * tamanoCasilla;
            jpCasillasDeTexto[i] = new JLabel("_");
            jpCasillasDeTexto[i].setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,tamanoCasilla));
            jpCasillasDeTexto[i].setBounds(((570/2)-posicionInicial)+espacioOcupado, tamanoCasilla,570, 50);
            jpContenidoPalabra.add(jpCasillasDeTexto[i]);

        }
        
        jpContenidoAhorcado = new JLabel();
        jpContenidoAhorcado.setSize(570,350);
        jpContenidoAhorcado.setLayout(null);
        jpContenidoAhorcado.setBounds(0,160,570,350);
        jpContenidoAhorcado.setOpaque(false);
        
        lblIntentos = new JTextArea("   INTENTOS \n  RESTANTES: " + "\n           "+juegoAhorcado.getIntentosRestantes());
        lblIntentos.setEditable(false);
        lblIntentos.setHighlighter(null);
        lblIntentos.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,22));  
        lblIntentos.setForeground(Color.cyan.darker().darker());
        lblIntentos.setBounds(400, 183, 300, 70);
        lblIntentos.setOpaque(false);
        jpContenidoAhorcado.add(lblIntentos);
        
        lblRonda = new JTextArea("RONDA: " + "\n     " + juegoAhorcado.getNumeroDeRonda());
        lblRonda.setEditable(false);
        lblRonda.setHighlighter(null);
        lblRonda.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,22));  
        lblRonda.setForeground(Color.cyan.darker().darker());
        lblRonda.setBounds(430, 113, 150, 50);
        lblRonda.setOpaque(false);
        jpContenidoAhorcado.add(lblRonda);

        jpImagenAhorcado = new Ahorcado("/ImagenesAhorcado/0.png");
        jpImagenAhorcado.setSize(500,350);
        jpImagenAhorcado.setLayout(null);
        jpImagenAhorcado.setBounds(0,0,500,350);
        jpImagenAhorcado.setOpaque(false);
        jpContenidoAhorcado.add(jpImagenAhorcado);
        
        jpContenidoTeclado = new JPanel();
        jpContenidoTeclado.setSize(570,150);        
        jpContenidoTeclado.setBounds(0,500, 570, 150);
        jpContenidoTeclado.setLayout(null);
        jpContenidoTeclado.setOpaque(false);
        
        ManejadorDeEventos manejadorDeEventos = new ManejadorDeEventos();
     
        int tamanoBoton = 50;
        for(int i = 0; i < 27; i++)
        {
            int espacioOcupado = i * tamanoBoton;
            botones[i] = new JButton(Character.toString(alfabeto[i]));
            botones[i].setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,18));  
            botones[i].setForeground(Color.blue.darker());
            transparenciaBoton(botones[i]);
            
            if(i < 9)
            {
                botones[i].setBounds(55+espacioOcupado, 5,tamanoBoton, tamanoBoton);
            }
            else if(i>=9 && i<18)
            {

                botones[i].setBounds(55+(espacioOcupado-450), 55,tamanoBoton, tamanoBoton);
            }
            else
            {

                botones[i].setBounds(55+(espacioOcupado-900), 105,tamanoBoton, tamanoBoton);
            }
            
            botones[i].addMouseListener(manejadorDeEventos);
            botones[i].addActionListener(manejadorDeEventos);
            jpContenidoTeclado.add(botones[i]);
            
        }
        
        jpContenidoBoton = new JPanel();
        jpContenidoBoton.setSize(570,70);        
        jpContenidoBoton.setBounds(0,660, 570, 70);
        jpContenidoBoton.setLayout(null);
        jpContenidoBoton.setOpaque(false);
        
        btnTerminarRonda = new JButton("TERMINAR RONDA");
        btnTerminarRonda.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,50));  
        transparenciaBoton(btnTerminarRonda);
        btnTerminarRonda.setBounds(85, 10,400, 50);
        btnTerminarRonda.addActionListener(manejadorDeEventos);
        btnTerminarRonda.addMouseListener(manejadorDeEventos);
        jpContenidoBoton.add(btnTerminarRonda);
        
        this.getContentPane().add(jpContenidoTitulo);
        this.getContentPane().add(jpContenidoPalabra);
        this.getContentPane().add(jpContenidoAhorcado);
        //this.getContentPane().add(jpImagenAhorcado);
        this.getContentPane().add(jpContenidoTeclado);
        this.getContentPane().add(jpContenidoBoton);
        this.getContentPane().add(jpFondo); 
        setVisible(true);           
    }
    
    private void adivinoLetra(String letra)
    {
        if(juegoAhorcado.esLaLetra(letra))
        {
            int index = 0;
            while(index >= 0)
            {
                index = juegoAhorcado.getPalabra().indexOf(letra, index);
                if(!(index == -1))
                {
                    jpCasillasDeTexto[index].setText(letra);
                    index = index + 1;
                }
            }
        }
        else
        {
            lblIntentos.setText("   INTENTOS \n  RESTANTES: " + "\n           "+juegoAhorcado.getIntentosRestantes());
            jpImagenAhorcado.setImage("/ImagenesAhorcado/"+(10-juegoAhorcado.getIntentosRestantes())+".png");
            jpImagenAhorcado.repaint();
        }
    }
    
    private void adivinoPalabra()
    {
        if(!juegoAhorcado.terminoIntentos())
        {
            String palabraAdivinada = "";
            for(int i = 0; i < jpCasillasDeTexto.length; i++)
            {
                    palabraAdivinada = palabraAdivinada + jpCasillasDeTexto[i].getText(); 
            }

            if(juegoAhorcado.esLaPalabra(palabraAdivinada))
            {
                JOptionPane.showMessageDialog(null, "¡Has adivinado la palabra!","Ganaste", JOptionPane.INFORMATION_MESSAGE);
                if(!juegoAhorcado.terminoRonda())
                {
                    jugarOtraPalabra();
                }
                else
                {
                    mostrarResultadosRonda();
                    jugarOtraRonda();
                }      
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"¡No adivinaste la palabra!","Perdiste",JOptionPane.INFORMATION_MESSAGE);
            if(!juegoAhorcado.terminoRonda())
            {
                jugarOtraPalabra();
            }
            else
            {
                mostrarResultadosRonda();
                jugarOtraRonda();
            }   
        }        
    }  
    
    private void jugarOtraPalabra()
    {
        int respuesta;
        respuesta = JOptionPane.showConfirmDialog(null,"¿Desea continuar jugando?", "Advertencia",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION)
        {
            lblIntentos.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,22));
            lblIntentos.setText("   INTENTOS \n  RESTANTES: " + "\n           "+juegoAhorcado.getIntentosRestantes());
            jpImagenAhorcado.setImage("/ImagenesAhorcado/0.png");
            jpImagenAhorcado.repaint();
            for(int i = 0; i < jpCasillasDeTexto.length; i++)
            {
                jpCasillasDeTexto[i].setText("");  
            }
  
            jpCasillasDeTexto = null;
            jpCasillasDeTexto = new JLabel[(juegoAhorcado.getPalabra()).length()];
            
            int tamanoCasilla = 30;
            for(int i = 0; i < (juegoAhorcado.getPalabra()).length(); i++)
            {
                int posicionInicial = (((juegoAhorcado.getPalabra().length()*tamanoCasilla))/2);
                int espacioOcupado = i * tamanoCasilla;
                jpCasillasDeTexto[i] = new JLabel("_");
                jpCasillasDeTexto[i].setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,tamanoCasilla));
                jpCasillasDeTexto[i].setBounds(((570/2)-posicionInicial)+espacioOcupado, tamanoCasilla,570, 50);
                jpContenidoPalabra.add(jpCasillasDeTexto[i]);
            }
            
            for(int i = 0; i < 27; i++)
            {
                botones[i].setEnabled(true);
            } 
        }
        else
        {
            juegoAhorcado.compararPalabras();
            mostrarResultadosRonda();
            mostrarResultadosJuego();
            dispose();
        }      
    }
    
    private void jugarOtraRonda()
    {
        int respuesta;
        respuesta = JOptionPane.showConfirmDialog(null,"¿Desea jugar otra ronda?", "Información",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION)
        {
            
            preguntarTematica();
                
            juegoAhorcado.iniciarRonda();
            lblRonda.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,22));
            lblRonda.setText("RONDA: " + "\n     " + juegoAhorcado.getNumeroDeRonda());
            lblIntentos.setText("   INTENTOS \n  RESTANTES: " + "\n           "+juegoAhorcado.getIntentosRestantes());
            jpImagenAhorcado.setImage("/ImagenesAhorcado/0.png");
            jpContenidoAhorcado.repaint();
            for(int i = 0; i < jpCasillasDeTexto.length; i++)
            {
                jpCasillasDeTexto[i].setText("");  
            }

            jpCasillasDeTexto = null;
            jpCasillasDeTexto = new JLabel[(juegoAhorcado.getPalabra()).length()];
            int tamanoCasilla = 30;
                
            for(int i = 0; i < (juegoAhorcado.getPalabra()).length(); i++)
            {
                int posicionInicial = (((juegoAhorcado.getPalabra().length()*tamanoCasilla))/2);
                int espacioOcupado = i * tamanoCasilla;
                jpCasillasDeTexto[i] = new JLabel("_");
                jpCasillasDeTexto[i].setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,tamanoCasilla));
                jpCasillasDeTexto[i].setBounds(((570/2)-posicionInicial)+espacioOcupado, tamanoCasilla,570, 50);
                jpContenidoPalabra.add(jpCasillasDeTexto[i]);

            }
            for(int i = 0; i < 27; i++)
            {
                    botones[i].setEnabled(true);
            } 
        }
        else
        {
            mostrarResultadosJuego();
            dispose();
        }
    }
    
    private void terminarRonda()
    {
        int respuesta;
            respuesta = JOptionPane.showConfirmDialog(null,"¿Seguro desea terminar la ronda?", "Advertencia",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(respuesta == JOptionPane.YES_OPTION)
            {
                juegoAhorcado.compararRondas();
                juegoAhorcado.compararPalabras();
                mostrarResultadosRonda();
                mostrarResultadosJuego();
                dispose();
            }
    }
    
    private void preguntarTematica()
    {
        String[] options = {"ANIMALES", "COLORES", "FRUTAS"};

        String tematica = (String)JOptionPane.showInputDialog(null, "Escoja la tematica", "Jugar otra vez", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
 
        if(tematica == null)
        {
            mostrarResultadosRonda();
            mostrarResultadosJuego();
            dispose(); 
        }
        else
        {
            juegoAhorcado.setTematica(tematica);
        }
    }
        
    private void mostrarResultadosRonda()
    {
        String txtmostrarResultadosRonda = "Palabras Adivinadas: " + juegoAhorcado.getPalabrasAdivinadas() + "\ncon un porcentaje de: " + juegoAhorcado.getPorcPalabrasAdivinadas() + "\nPalabras no adivinadas: " + juegoAhorcado.getPalabrasNoAdivinadas() + "\ncon un porcentaje de: " + juegoAhorcado.getPorcPalabrasNoAdivinadas();
        JOptionPane.showMessageDialog(null,txtmostrarResultadosRonda, "Resultados ronda",JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarResultadosJuego()
    {
        String txtMostrarResultadosJuego = "Mejor ronda: " + juegoAhorcado.getMejorRonda().getNumeroDeRonda() + "\ncon un porcentaje de: " + juegoAhorcado.getMejorRonda().getPorcPalabrasAdivinadas() + "\nPeor ronda: " + juegoAhorcado.getPeorRonda().getNumeroDeRonda() + "\ncon un porcentaje de: " + juegoAhorcado.getPeorRonda().getPorcPalabrasNoAdivinadas() + "\nPalabra mas adivinada: " + juegoAhorcado.getPalabraMasAdivinda();
        JOptionPane.showMessageDialog(null,txtMostrarResultadosJuego, "Resultados juego",JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void transparenciaBoton(JButton boton)
    {
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
    }
    
    class ManejadorDeEventos implements ActionListener, MouseListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            //String palabra = juegoAhorcado.getPalabra();
            if(ae.getSource() == btnTerminarRonda)
            {
                terminarRonda();
            }
            else if (ae.getSource() instanceof JButton) 
            {
                String text = ((JButton) ae.getSource()).getText();
                adivinoLetra(text);
                ((JButton) ae.getSource()).setEnabled(false); 
                adivinoPalabra();
                
            }
        }
        
        @Override       
        public void mouseEntered(MouseEvent arg0) 
        {
            ((JButton) arg0.getSource()).setForeground(Color.gray);
        }

        @Override
        public void mouseExited(MouseEvent e) 
        {  
            if(e.getSource() == btnTerminarRonda)
            {
                btnTerminarRonda.setForeground(Color.black);
            }
            else if (e.getSource() instanceof JButton) 
            {
              ((JButton) e.getSource()).setForeground(Color.blue.darker());      
            }

        } 

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

    }
    
    
    
}




