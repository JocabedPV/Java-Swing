/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jocab
 */
import javax.swing.*;
import java.awt.*;

public class Raizcuadrada extends JPanel {

    private JTextField campoNumero;
    private JTextField campoExponente;
    private JLabel etiquetaResultado;

    public Raizcuadrada() {
        setLayout(new GridLayout(4, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        campoNumero = new JTextField();
        campoExponente = new JTextField();
        etiquetaResultado = new JLabel("Resultado: ", SwingConstants.CENTER);

        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 5, 5));
        panelCampos.add(new JLabel("Número:"));
        panelCampos.add(campoNumero);
        panelCampos.add(new JLabel("Exponente (solo para potencia):"));
        panelCampos.add(campoExponente);

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 5, 5));
        JButton botonRaiz = new JButton("Raíz cuadrada");
        JButton botonExponente = new JButton("Exponente");
        panelBotones.add(botonRaiz);
        panelBotones.add(botonExponente);

        botonRaiz.addActionListener(e -> calcularRaiz());
        botonExponente.addActionListener(e -> calcularExponente());

        add(new JLabel("Raíz cuadrada y Exponente", SwingConstants.CENTER));
        add(panelCampos);
        add(panelBotones);
        add(etiquetaResultado);
    }

    
    private void calcularRaiz() {
        try {
            double numero = Double.parseDouble(campoNumero.getText());

 
            if (numero < 0) {
                etiquetaResultado.setText("Error: no existe raíz cuadrada de un negativo");
                return;
            }

            etiquetaResultado.setText("√" + numero + " = " + Math.sqrt(numero));
        } catch (NumberFormatException ex) {
            etiquetaResultado.setText("Error: ingrese un número válido");
        }
    }

    private void calcularExponente() {
        try {
            double base = Double.parseDouble(campoNumero.getText());
            double exponente = Double.parseDouble(campoExponente.getText());
            etiquetaResultado.setText(base + " ^ " + exponente + " = " + Math.pow(base, exponente));
        } catch (NumberFormatException ex) {
            etiquetaResultado.setText("Error: ingrese números válidos");
        }
    }
}