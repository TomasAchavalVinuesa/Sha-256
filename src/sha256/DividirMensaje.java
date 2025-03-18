/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sha256;

/**
 *
 * @author tavto
 */
import java.util.ArrayList;
import java.util.List;

public class DividirMensaje {

    // Método para convertir un String a un arreglo de bits
    public static int[] convertirStringABits(String mensaje) {
        StringBuilder sb = new StringBuilder();
        // Convertir cada caracter a su valor en binario
        for (int i = 0; i < mensaje.length(); i++) {
            char c = mensaje.charAt(i);
            String binario = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
            sb.append(binario); // Agregar el valor binario del carácter
        }
        // Convertir el mensaje binario a un arreglo de bits
        int[] bits = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            bits[i] = sb.charAt(i) == '1' ? 1 : 0;
        }
        return bits;
    }

    // Método para dividir el mensaje binario en piezas de 512 bits
    public static List<int[]> dividirEnPiezas(String mensaje, int cantPiezas) {
        int tamanioPieza = 512;
        List<int[]> piezas = new ArrayList<>();

        
        // Dividir el mensajeExtendido en piezas de 512 bits
        for (int i = 0; i < cantPiezas; i++) {
            int[] pieza = new int[tamanioPieza];
            int j = 0;
            for(int k = 0; k<512; k++){
             j = (i*512)+ k; 
            pieza[k] = Character.getNumericValue( mensaje.charAt(j));
            }
            piezas.add(pieza);
        }

        return piezas;
    }
}

