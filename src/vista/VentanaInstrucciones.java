/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import tipografiam.Fuentes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import tipografiam.Fuentes;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextArea;

/**
 *
 * @author sazuk
 */
public class VentanaInstrucciones extends JFrame{
    
    Fuentes tipoFuente;
    private FondoVentana jpFondo;
    private JPanel jpContenidoInstrucciones;
    private JLabel lblTitulo;
    private JTextArea lblInstrucciones;
    private JButton btnMenuPrincipal;
    
    public VentanaInstrucciones()
    {
        inicializarComponentes();
    }

    private void inicializarComponentes() 
    {
        
        setTitle("Instrucciones Ahorcado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(570,771);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        
        tipoFuente= new Fuentes();
        
        jpFondo= new FondoVentana("/Fondo/FondoAhorcado.jpg");
        jpFondo.setSize(570,771);
        jpFondo.setLayout(null);
        
        jpContenidoInstrucciones = new JPanel();
        jpContenidoInstrucciones.setSize(570,771);        
        jpContenidoInstrucciones.setBounds(0,0, 570, 771);
        jpContenidoInstrucciones.setLayout(null);
        jpContenidoInstrucciones.setOpaque(false);
        
        lblTitulo = new JLabel("COMO JUGAR", SwingConstants.CENTER);
        lblTitulo.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,75));  
        lblTitulo.setBounds(15, 30, 570, 100);
        lblTitulo.setForeground(Color.RED.darker());
        jpContenidoInstrucciones.add(lblTitulo);
        
        lblInstrucciones = new JTextArea("    Escribe tu nombre,\n   el numero de palabras\n   y la tematica para jugar \n\n    Pulsa con el ratón las\n letras del abecedario para\n adivinar la palabra escondida.\n\n ");
        lblInstrucciones.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,40));  
        lblInstrucciones.setBounds(100, 200, 570, 400);
        lblInstrucciones.setHighlighter(null);
        lblInstrucciones.setEditable(false);
        lblInstrucciones.setForeground(Color.black);
        lblInstrucciones.setOpaque(false);

        jpContenidoInstrucciones.add(lblInstrucciones);  
        
        VentanaInstrucciones.ManejadorDeEventos manejadorDeEventos = new VentanaInstrucciones.ManejadorDeEventos();
        
        btnMenuPrincipal = new JButton("MENU PRINCIPAL");
        btnMenuPrincipal.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,50));
        btnMenuPrincipal.setBounds(50, 580, 500, 60);
        transparencia(btnMenuPrincipal);
        btnMenuPrincipal.setForeground(Color.cyan.darker());
        btnMenuPrincipal.addActionListener(manejadorDeEventos);
        btnMenuPrincipal.addMouseListener(manejadorDeEventos);
        jpContenidoInstrucciones.add(btnMenuPrincipal);
        
        this.getContentPane().add(jpContenidoInstrucciones);
        this.getContentPane().add(jpFondo);
        
        setVisible(true); 

    }

    private void transparencia(JButton boton) 
    {
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
    }
    
    private void volverMenuPrincipal() 
    {
        VentanaMenu ventanaMenu = new VentanaMenu();  
        dispose();
    }
        
    class ManejadorDeEventos implements ActionListener , MouseListener
    {
        @Override
        public void actionPerformed(ActionEvent evento)
        {
            if(evento.getSource() == btnMenuPrincipal)
            {                
                volverMenuPrincipal();
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
        
        @Override
        public void mouseEntered(MouseEvent arg0) {

             if(arg0.getSource() == btnMenuPrincipal)
            {
                btnMenuPrincipal.setForeground(Color.red.darker());
            }
        }

        @Override
        public void mouseExited(MouseEvent e) 
        {  
            if(e.getSource() == btnMenuPrincipal)
            {
                btnMenuPrincipal.setForeground(Color.cyan.darker());
            }

        }
    }
}