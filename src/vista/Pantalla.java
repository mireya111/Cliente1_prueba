package vista;

import clase.Cliente;

import javax.swing.*;
import java.awt.*;

public class Pantalla extends JFrame {
    public Pantalla() {
        super("Cliente");
        JPanel panel;
        JTextField numeroBusqueda;
        JLabel textoBusqueda, resultado1, resultado2, resultado3, resultado4, resultado5, resultado6, resultado7, resultado8;
        JButton boton, resetear;
        setSize(800,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173, 216, 230));

        //Se crea un objeto
        numeroBusqueda = new JTextField();
        textoBusqueda = new JLabel();
        resultado1 = new JLabel();
        resultado2 = new JLabel();
        resultado3 = new JLabel();
        resultado4 = new JLabel();
        resultado5 = new JLabel();
        resultado6 = new JLabel();
        resultado7 = new JLabel();
        resultado8 = new JLabel();
        boton = new JButton();
        resetear = new JButton();

        //Se dimensiona
        textoBusqueda.setBounds(2, 20, 300, 30);
        numeroBusqueda.setBounds(10, 30, 100, 30);
        resultado1.setBounds(10, 60, 500, 200);
        resultado2.setBounds(10, 90, 500, 200);
        resultado3.setBounds(10, 110, 500, 200);
        resultado4.setBounds(10, 130, 500, 200);
        resultado5.setBounds(10, 150, 500, 200);
        resultado6.setBounds(10, 170, 500, 200);
        resultado7.setBounds(10, 190, 500, 200);
        resultado8.setBounds(10, 200, 500, 200);
        resetear.setText("Resetear");
        resetear.setBounds(10, 540, 100, 30);


        boton.setText("Buscar");
        boton.setBounds(10, 500, 100, 30);
        boton.addActionListener(e -> {
            try {
                int numerodePersona = Integer.parseInt(numeroBusqueda.getText());
                String mensaje = String.valueOf(numerodePersona);
                Cliente.enviarParanetros("172.31.116.71", 8080, mensaje, resultado1, resultado2, resultado3, resultado4, resultado5, resultado6);
            } catch (NumberFormatException ex) {
                resultado1.setText("Error: Entrada no válida");
            }
        });

        resetear.addActionListener(e -> {
            numeroBusqueda.setText("");
            resultado1.setText("");
            resultado2.setText("");
            resultado3.setText("");
            resultado4.setText("");
            resultado5.setText("");
            resultado6.setText("");
        });

        panel.add(numeroBusqueda);
        panel.add(textoBusqueda);
        panel.add(resultado1);
        panel.add(boton);
        panel.add(resetear);
        panel.add(resultado2);
        panel.add(resultado3);
        panel.add(resultado4);
        panel.add(resultado5);
        panel.add(resultado6);
        panel.add(resultado7);
        panel.add(resultado8);

        //Añadir al panel los elementos
        add(panel);
    }
}
