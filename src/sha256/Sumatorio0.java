/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sha256;

public class Sumatorio0 {
    public static int[] sumatorio0(int[] x) {
        if (x == null || x.length != 32) {
            throw new IllegalArgumentException("El arreglo debe ser de 32 bits.");
        }

        // Realizar las operaciones RotR y Xor
        int[] rotR2 = RotR.rotateRight(x, 2);
        int[] rotR13 = RotR.rotateRight(x, 13);
        int[] rotR22 = RotR.rotateRight(x, 22);

        // Xor de los resultados
        int[] temp1 = Xor.xor(rotR2, rotR13);
        int[] result = Xor.xor(temp1, rotR22);

        return result;
    }
}

