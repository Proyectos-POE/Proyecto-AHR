/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import tipografiam.Fuentes;
import modelo.Jugador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import tipografiam.Fuentes;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.UIManager;

/**
 *
 * @author nicol
 */
public class VentanaMenu extends JFrame 
{
    Fuentes tipoFuente;
    private FondoVentana jpFondo;
    private JPanel jpContenido;
    private JLabel lblTitulo;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblCantidadPalabras;
    private JTextField txtCantidadPalabras;
    private JLabel lblTematica;
    private JComboBox menuTematica;
    private JButton btnJugar;
    private JButton btnInstrucciones; 

    public VentanaMenu()
    {
        inicializarComponentes();
    }
    
    private void inicializarComponentes()
    {
        setTitle("Ahorcado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(570,771);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        
        tipoFuente= new Fuentes();
        UIManager.put("OptionPane.messageFont", tipoFuente.fuente(tipoFuente.Lapiz,1,16));
        UIManager.put("OptionPane.buttonFont", tipoFuente.fuente(tipoFuente.Lapiz,1,16));
        
        jpFondo= new FondoVentana("/Fondo/FondoAhorcado.jpg");
        jpFondo.setSize(570,771);
        jpFondo.setLayout(null);
        
        jpContenido = new JPanel();
        jpContenido.setSize(570,771);        
        jpContenido.setBounds(0,0, 570, 771);
        jpContenido.setLayout(null);
        jpContenido.setOpaque(false); 
        
        lblTitulo = new JLabel("AHORKDO", SwingConstants.CENTER);
        lblTitulo.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,100));  
        lblTitulo.setBounds(15, 30, 570, 100);
        lblTitulo.setForeground(Color.CYAN.darker().darker());
        jpContenido.add(lblTitulo);
        
        lblNombre = new JLabel("NOMBRE", SwingConstants.CENTER);
        lblNombre.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,20)); 
        lblNombre.setBounds(228, 210, 350, 40);
        jpContenido.add(lblNombre);
        
        txtNombre = new JTextField(SwingConstants.CENTER);
        txtNombre.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,20)); 
        txtNombre.setBounds(330, 245, 140, 30);
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        jpContenido.add(txtNombre);
        
        lblCantidadPalabras = new JLabel("CANTIDAD DE PALABRAS", SwingConstants.CENTER);
        lblCantidadPalabras.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,20)); 
        lblCantidadPalabras.setBounds(300, 290, 200, 40);
        jpContenido.add(lblCantidadPalabras);
        
        txtCantidadPalabras = new JTextField(SwingConstants.CENTER);
        txtCantidadPalabras.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,20)); 
        txtCantidadPalabras.setBounds(330, 330, 140, 30);
        txtCantidadPalabras.setHorizontalAlignment(JTextField.CENTER);
        jpContenido.add(txtCantidadPalabras);
        
        lblTematica = new JLabel("TEMATICA", SwingConstants.CENTER);
        lblTematica.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,20));
        lblTematica.setBounds(215, 380, 370, 20);
        jpContenido.add(lblTematica);
     
        menuTematica = new JComboBox();
        menuTematica.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,20));
        ((JLabel)menuTematica.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        menuTematica.addItem("ANIMALES");
        menuTematica.addItem("COLORES");
        menuTematica.addItem("FRUTAS");
        menuTematica.setBounds(340, 410, 120, 40);
        jpContenido.add(menuTematica);
  
        ManejadorDeEventos manejadorDeEventos = new ManejadorDeEventos();
        
        btnJugar = new JButton("JUGAR");
        btnJugar.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,60)); 
        btnJugar.setBounds(50, 300, 250, 70);
        transparencia(btnJugar);
        btnJugar.addActionListener(manejadorDeEventos);
        btnJugar.addMouseListener(manejadorDeEventos);
        jpContenido.add(btnJugar);
        
        btnInstrucciones = new JButton("INSTRUCCIONES");
        btnInstrucciones.setFont(tipoFuente.fuente(tipoFuente.Lapiz,1,60));
        btnInstrucciones.setBounds(50, 580, 500, 60);
        transparencia(btnInstrucciones);
        btnInstrucciones.addActionListener(manejadorDeEventos);
        btnInstrucciones.addMouseListener(manejadorDeEventos);
        jpContenido.add(btnInstrucciones);
        
        this.getContentPane().add(jpContenido);
        this.getContentPane().add(jpFondo);
        
        setVisible(true); 
    }  
    
    private void transparencia(JButton boton)
    {
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
    }
    
    private void iniciarJuego()
    {
        boolean datosCompletos = false;
        String nombre =txtNombre.getText();
        String tematica = (String)menuTematica.getSelectedItem();
        int cantidadPalabras = 0;
        if(!nombre.trim().isEmpty() || nombre.trim().length() > 0)
        { 
            try
            {
                cantidadPalabras = Integer.parseInt(txtCantidadPalabras.getText());
                if(!(cantidadPalabras == 0))
                {
                    datosCompletos = true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Por favor ingrese un numero distino a 0", "Advertencia", JOptionPane.ERROR_MESSAGE);
                    txtCantidadPalabras.requestFocusInWindow();
                }    
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Por favor ingrese un numero", "Advertencia", JOptionPane.ERROR_MESSAGE);
                txtCantidadPalabras.requestFocusInWindow();
            }

        } 
        else 
        {
            JOptionPane.showMessageDialog(null,"Por favor ingrese su nombre", 
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocusInWindow();
        }
        
        if(datosCompletos)
        {
            Jugador jugador = new Jugador();
            jugador.setNombre(nombre);
            jugador.setNumeroDePalabras(cantidadPalabras);
            jugador.setTematicaElegida(tematica);
            VentanaJuego ventanaJuego = new VentanaJuego(jugador);  
            dispose();
        }
        
   
    }
    
    private void mostrarInstrucciones()
    {

        VentanaInstrucciones ventanaInstrucciones = new VentanaInstrucciones();  
        dispose(); 
    }
    
    class ManejadorDeEventos implements ActionListener , MouseListener
    {
        @Override
        public void actionPerformed(ActionEvent evento)
        {
            if(evento.getSource() == btnJugar)
            {                
                iniciarJuego();
            }
            if(evento.getSource() == btnInstrucciones)
            {
                mostrarInstrucciones();
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
            ((JButton) e.getSource()).setForeground(Color.black);
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







