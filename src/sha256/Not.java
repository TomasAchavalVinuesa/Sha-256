/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sha256;

/**
 *
 * @author tavto
 */
public class Not {
    public static int[] not(int[] x) {
        if (x == null || x.length != 32) {
            throw new IllegalArgumentException("El arreglo debe ser de 32 bits.");
        }

        int[] z = new int[32];
        for (int i = 0; i < 32; i++) {
            z[i] = (x[i] == 1) ? 0 : 1; // Cambia 1 por 0 y 0 por 1
        }
        return z;
    }
}

