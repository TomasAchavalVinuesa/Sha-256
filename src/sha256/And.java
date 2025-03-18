/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sha256;

/**
 *
 * @author tavto
 */
public class And {
    public static int[] and(int[] x, int[] y) {
        if (x == null || y == null || x.length != 32 || y.length != 32) {
            throw new IllegalArgumentException("Ambos arreglos deben ser de 32 bits.");
        }

        int[] z = new int[32];
        for (int i = 0; i < 32; i++) {
            z[i] = (x[i] == 1 && y[i] == 1) ? 1 : 0; // Asigna 1 solo si ambos valores son 1
        }
        return z;
    }
}
