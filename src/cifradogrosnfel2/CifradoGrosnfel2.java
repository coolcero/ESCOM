/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradogrosnfel2;

import javax.swing.JOptionPane;


public class CifradoGrosnfel2 {
public static void main(String[] args) {
        String[] buttons = {"Cifrar", "Descifrar"};
        String keyword;
        String message;
        int option = JOptionPane.showOptionDialog(null, "Elija un opcion", "Cifrado Gronsfeld", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
        
        //Cifrar mensaje
        if (option == 0){
            keyword = JOptionPane.showInputDialog("Ingrese la clave (numerica): ");
            message = JOptionPane.showInputDialog("Ingrese el mensaje: ");
            Gronsfel gronsfeld = new Gronsfel(message, keyword);
            String cipherText = gronsfeld.encrypt();
            System.out.println("La palabra cifrada es: " + cipherText);
            JOptionPane.showMessageDialog(null, "El mensaje cifrado es: " + cipherText,
                    "Mensaje Cifrado", 1);
        }
        else if (option == 1){//Descifrar mensaje
            keyword = JOptionPane.showInputDialog("Ingrese la clave (numerica): ");
            message = JOptionPane.showInputDialog("Ingrese el mensaje cifrado: ");
            Gronsfel gronsfeld = new Gronsfel(message, keyword);
            String originalText = gronsfeld.decrypt();
            System.out.println("El mensaje original es: " + originalText);
            JOptionPane.showMessageDialog(null, "El mensaje original es: " + originalText,
                    "Mensaje Descifrado", 1);
        }
    }
}