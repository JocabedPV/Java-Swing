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


public class ConversorTemperatura extends JPanel {

    private JTextField campoTemperatura;
    private JLabel etiquetaResultado;

    
    public ConversorTemperatura() {
        setLayout(new GridLayout(4, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        campoTemperatura = new JTextField();
        etiquetaResultado = new JLabel("Resultado: ", SwingConstants.CENTER);

        JPanel panelCampo = new JPanel(new GridLayout(1, 2, 5, 5));
        panelCampo.add(new JLabel("Temperatura:"));
        panelCampo.add(campoTemperatura);

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 5, 5));
        JButton botonFaC = new JButton("Fahrenheit → Celsius");
        JButton botonCaF = new JButton("Celsius → Fahrenheit");
        panelBotones.add(botonFaC);
        panelBotones.add(botonCaF);

        botonFaC.addActionListener(e -> convertir(true));
        botonCaF.addActionListener(e -> convertir(false));

        add(new JLabel("Modo Conversor", SwingConstants.CENTER));
        add(panelCampo);
        add(panelBotones);
        add(etiquetaResultado);
    }

   
    private void convertir(boolean deFahrenheitACelsius) {
        try {
            double temperatura = Double.parseDouble(campoTemperatura.getText());

            if (deFahrenheitACelsius) {

                double celsius = (temperatura - 32) * 5 / 9;
                etiquetaResultado.setText(String.format("%.2f °F = %.2f °C", temperatura, celsius));
            } else {

                double fahrenheit = (temperatura * 9 / 5) + 32;
                etiquetaResultado.setText(String.format("%.2f °C = %.2f °F", temperatura, fahrenheit));
            }
        } catch (NumberFormatException ex) {
            etiquetaResultado.setText("Error: ingrese un número válido");
        }
    }
}