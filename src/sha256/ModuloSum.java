/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sha256;

/**
 *
 * @author tavto
 */

public class ModuloSum {
    private static final long MODULO = 4294967296L;

    public static long moduloSum(long a, long b) {
        long sum = a + b; // Suma los dos números
        return sum % MODULO; // Devuelve el módulo de la suma
    }
}
