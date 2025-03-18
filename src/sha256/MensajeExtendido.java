/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sha256;

/**
 *
 * @author tavto
 */

public class MensajeExtendido {

    public static String convertirMensaje(String mensaje) {
        if (mensaje == null || mensaje.isEmpty()) {
            throw new IllegalArgumentException("El mensaje no puede estar vacío.");
        }

        //SubPaso 2.1 Convertir cada carácter a su representación en binario (8 bits)
        StringBuilder binario = new StringBuilder();
        for (char c : mensaje.toCharArray()) {
            String bin = Integer.toBinaryString(c);
            while (bin.length() < 8) {
                bin = "0" + bin; // Autocompletar con ceros
            }
            System.out.println("Caracter: " + c + " y su binario extendido es: "+ bin);
            binario.append(bin);
        }
        //Fin subpaso 2.1

        //SubPaso 2.2 Obtener longitud original en bits (L)
        int L = binario.length();
        System.out.println("tamanio de L: " + L );
        System.out.println("Mensaje antes de aniadir el 1: "+ binario.toString());
        //Fin SubPaso 2.2
        
        //SubPaso 2.3 Añadir un '1' al final
        binario.append("1");
        System.out.println("Mensaje post aniadir el 1: "+ binario.toString());
        //Fin SubPaso 2.3
        
        //SubPaso 2.4 Calcular la cantidad de ceros a añadir
        int cerosFaltantes = (448 - (L + 1) % 512 + 512) % 512;
        System.out.println("Cantidad de ceros faltantes: " + cerosFaltantes);
        //Fin subPaso 2.4
        
        //SubPaso 2.5 añadir los 0 necesarios
        for (int i = 0; i < cerosFaltantes; i++) {
            binario.append("0");
        }
        System.out.println("Mensaje post aniadir los 0: "+ binario.toString());
        //Fin subPaso 2.5
        
        
        //SubPaso 2.6 Convertir L (longitud original) a su representación binaria (64 bits)
        String LBin = Integer.toBinaryString(L);
        System.out.println("L en binario queda: "+ LBin);
        while (LBin.length() < 64) {
            LBin = "0" + LBin; // Autocompletar con ceros
        }
        System.out.println("L en binario extendido queda: "+ LBin);
        //Fin subPaso 2.6

        // SubPaso 2.7 Añadir la representación de L al final
        binario.append(LBin);
        System.out.println("Mensaje post aniadir los LBin: "+ binario.toString());
        return binario.toString();
        //Fin subPaso2.7
    }
}

