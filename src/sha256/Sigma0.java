/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sha256;

/**
 *
 * @author tavto
 */
public class Sigma0 {
    public static int[] sigma0(int[] x) {
        if (x == null || x.length != 32) {
            throw new IllegalArgumentException("El arreglo debe ser de 32 bits.");
        }

        // Rotaciones y desplazamiento
        int[] rot7 = RotR.rotateRight(x, 7);
        int[] rot18 = RotR.rotateRight(x, 18);
        int[] shr3 = ShR.shiftRight(x, 3);

        // Aplicar XOR sucesivamente
        int[] xor1 = Xor.xor(rot7, rot18);
        int[] z = Xor.xor(xor1, shr3);

        return z;
    }
}

