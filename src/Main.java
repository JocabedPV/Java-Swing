/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jocab
 */
import javax.swing.*;


public class Main {

   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Calculadora Extendida");

            // Pestañas para alternar entre los modos
            JTabbedPane pestanas = new JTabbedPane();
            pestanas.addTab("Calculadora", new Calculadora());
            pestanas.addTab("Conversor", new ConversorTemperatura());
            pestanas.addTab("Raíz y Exponente", new Raizcuadrada());

            ventana.add(pestanas);
            ventana.setSize(500, 300);
            ventana.setLocationRelativeTo(null);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setVisible(true);
        });
    }
}
