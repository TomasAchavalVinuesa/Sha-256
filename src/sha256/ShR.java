/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sha256;

import java.util.Arrays;

/**
 *
 * @author tavto
 */
public class ShR {
    public static int[] shiftRight(int[] x, int n) {
        if (x == null || x.length != 32) {
            throw new IllegalArgumentException("El arreglo debe ser de 32 bits.");
        }
        int[] copia = Arrays.copyOf(x, x.length);
        for (int j = 0; j< n; j++){
            for (int i = 31; i > 0; i--) {
                copia[(i)] = copia[i-1];
            }
            copia[0]= 0;
        }
        return copia;
    }
}

