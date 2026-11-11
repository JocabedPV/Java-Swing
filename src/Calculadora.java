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


public class Calculadora extends JPanel {

    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JLabel etiquetaResultado;

   
    public Calculadora() {
        setLayout(new GridLayout(4, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        campoNumero1 = new JTextField();
        campoNumero2 = new JTextField();
        etiquetaResultado = new JLabel("Resultado: ", SwingConstants.CENTER);

        
        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 5, 5));
        panelCampos.add(new JLabel("Número 1:"));
        panelCampos.add(campoNumero1);
        panelCampos.add(new JLabel("Número 2:"));
        panelCampos.add(campoNumero2);

   
        JPanel panelBotones = new JPanel(new GridLayout(1, 4, 5, 5));
        JButton botonSumar = new JButton("+");
        JButton botonRestar = new JButton("-");
        JButton botonMultiplicar = new JButton("×");
        JButton botonDividir = new JButton("÷");
        panelBotones.add(botonSumar);
        panelBotones.add(botonRestar);
        panelBotones.add(botonMultiplicar);
        panelBotones.add(botonDividir);

 
        botonSumar.addActionListener(e -> calcular('+'));
        botonRestar.addActionListener(e -> calcular('-'));
        botonMultiplicar.addActionListener(e -> calcular('*'));
        botonDividir.addActionListener(e -> calcular('/'));

        add(new JLabel("Modo Calculadora", SwingConstants.CENTER));
        add(panelCampos);
        add(panelBotones);
        add(etiquetaResultado);
    }


    private void calcular(char operacion) {
        try {
            double numero1 = Double.parseDouble(campoNumero1.getText());
            double numero2 = Double.parseDouble(campoNumero2.getText());
            double resultado = 0;

            if (operacion == '+') {
                resultado = numero1 + numero2;
            } else if (operacion == '-') {
                resultado = numero1 - numero2;
            } else if (operacion == '*') {
                resultado = numero1 * numero2;
            } else if (operacion == '/') {
        
                if (numero2 == 0) {
                    etiquetaResultado.setText("Error: no se puede dividir entre cero");
                    return;
                }
                resultado = numero1 / numero2;
            }

            etiquetaResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException ex) {
            etiquetaResultado.setText("Error: ingrese números válidos");
        }
    }
}