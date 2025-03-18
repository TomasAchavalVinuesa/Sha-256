/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sha256;

import java.math.BigInteger;

/**
 *
 * @author tavto
 */
public class Majority {
    public static int[] majority(int[] x, int[] y, int[] z) {
        if (x.length != 32 || y.length != 32 || z.length != 32) {
            throw new IllegalArgumentException("Todos los arreglos deben tener exactamente 32 elementos.");
        }
        
        int[] andxy = And.and(x, y);
        int[] andxz = And.and(x, z);
        int[] andyz = And.and(y, z);
        
        long decimalAndxy = BinaryToDecimal.binaryToDecimal(andxy);
        long decimalAndxz = BinaryToDecimal.binaryToDecimal(andxz);
        long decimalAndyz = BinaryToDecimal.binaryToDecimal(andyz);
        
        long sumMod2321 = ModuloSum.moduloSum(decimalAndxy, decimalAndxz);
        long sumMod2322 = ModuloSum.moduloSum(sumMod2321, decimalAndyz);
        
        return DecimalToBinary.decimalToBinary(sumMod2322);
    }
}
