/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sha256;


/**
 *
 * @author tavto
 */
public class DecimalToBinary {
    public static int[] decimalToBinary(long decimal) {
        if (decimal < 0) {
            throw new IllegalArgumentException("El número decimal debe ser no negativo.");
        }

        int[] binaryArray = new int[32];
        int index = 31;

        while (decimal > 0) {
            binaryArray[index--] = (int) (decimal % 2); // Obtiene el bit menos significativo
            decimal /= 2; // Divide el número por 2
        }

        // Los bits sobrantes ya estarán en 0 por defecto
        return binaryArray;
    }
    
}