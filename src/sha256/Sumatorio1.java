/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sha256;

/**
 *
 * @author tavto
 */


public class Sumatorio1 {
    public static int[] sumatorio1(int[] x) {
        if (x == null || x.length != 32) {
            throw new IllegalArgumentException("El arreglo debe ser de 32 bits.");
        }

        // Realizar las operaciones RotR y Xor
        int[] rotR6 = RotR.rotateRight(x, 6);
        int[] rotR11 = RotR.rotateRight(x, 11);
        int[] rotR25 = RotR.rotateRight(x, 25);

        // Xor de los resultados
        int[] temp1 = Xor.xor(rotR6, rotR11);
        int[] result = Xor.xor(temp1, rotR25);

        return result;
    }
}

