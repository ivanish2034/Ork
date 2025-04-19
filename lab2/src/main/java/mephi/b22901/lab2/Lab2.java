/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mephi.b22901.lab2;

import javax.swing.SwingUtilities;

/**
 *
 * @author ivis2
 */
public class Lab2 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow();
            window.setVisible(true); 
        });
    }
}
