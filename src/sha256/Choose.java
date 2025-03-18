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
public class Choose {
    public static int[] choose(int[] x, int[] y, int[] z) {
        if (x.length != 32 || y.length != 32 || z.length != 32) {
            throw new IllegalArgumentException("Todos los arreglos deben tener exactamente 32 elementos.");
        }
        
        int[] andxy = And.and(x, y);
        int[] notx = Not.not(x);
        int[] andnotxz = And.and(notx, z);
        
        long decimalAndxy = BinaryToDecimal.binaryToDecimal(andxy);
        long decimalandnotxz = BinaryToDecimal.binaryToDecimal(andnotxz);
        
        long sumMod232 = ModuloSum.moduloSum(decimalAndxy, decimalandnotxz);
        
        return DecimalToBinary.decimalToBinary(sumMod232);
    }
}

