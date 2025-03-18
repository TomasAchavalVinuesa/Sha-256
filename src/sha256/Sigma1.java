/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sha256;

/**
 *
 * @author tavto
 */
public class Sigma1 {
    public static int[] sigma1(int[] x) {
        if (x == null || x.length != 32) {
            throw new IllegalArgumentException("El arreglo debe ser de 32 bits.");
        }

        // Rotaciones y desplazamiento
        int[] rot17 = RotR.rotateRight(x, 17);
        int[] rot19 = RotR.rotateRight(x, 19);
        int[] shr10 = ShR.shiftRight(x, 10);

        // Aplicar XOR sucesivamente
        int[] xor1 = Xor.xor(rot17, rot19);
        int[] z = Xor.xor(xor1, shr10);

        return z;
    }
}
