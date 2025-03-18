/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sha256;

/**
 *
 * @author tavto
 */
public class BinaryToHexadecimal {
    public static String binaryArrayToHex(int[] binaryArray) {
        if (binaryArray.length != 32) {
            throw new IllegalArgumentException("El arreglo debe tener exactamente 32 valores.");
        }

        StringBuilder binaryString = new StringBuilder();
        for (int bit : binaryArray) {
            if (bit != 0 && bit != 1) {
                throw new IllegalArgumentException("El arreglo solo debe contener números 0 y 1.");
            }
            binaryString.append(bit);
        }

        // Convertir el binario a hexadecimal
        int decimalValue = Integer.parseUnsignedInt(binaryString.toString(), 2);
        return Integer.toHexString(decimalValue).toUpperCase();
    }
}
