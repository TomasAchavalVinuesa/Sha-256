/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sha256;
/**
 *
 * @author tavto
 */
public class BinaryToDecimal {
    public static long binaryToDecimal(int[] binaryArray) {
        if (binaryArray == null || binaryArray.length != 32) {
            throw new IllegalArgumentException("El arreglo debe ser de 32 bits.");
        }

        long decimal = 0;
        for (int i = 0; i < 32; i++) {
            if (binaryArray[i] != 0 && binaryArray[i] != 1) {
                throw new IllegalArgumentException("El arreglo debe contener solo 0 y 1.");
            }
            decimal += binaryArray[i] * Math.pow(2, 31 - i); // Convierte cada bit a su equivalente decimal
        }
        return decimal;
    }
    
}

