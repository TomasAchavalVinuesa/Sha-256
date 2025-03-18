/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sha256;


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
        
        int[]  XorAndxyAndxz = Xor.xor(andxy, andxz);
        return Xor.xor(XorAndxyAndxz, andyz);
    }
}
