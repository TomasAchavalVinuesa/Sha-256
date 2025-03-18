/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sha256;

import java.util.Arrays;
import java.util.List;

public class Sha256 {

    public static void main(String[] args) {
    
        //ETAPA DE RELLENO
        //paso 1 definir el mensaje
        String mensaje = "Si";
        //Fin Paso 1
        //
        //Paso 2 Obtener el mensaje extendido
        String mensajeExtendido = MensajeExtendido.convertirMensaje(mensaje);
        System.out.println("Mensaje extendido en bits:");
        System.out.println(mensajeExtendido);
        //Fin Paso 2
        
        //Paso 3 Dividirlo en piezas de 512 bits 
        System.out.println("Cantidad de bits del mensaje extendido: " + mensajeExtendido.length());
        int cantPiezas = mensajeExtendido.length()/512;
        List<int[]> piezas = DividirMensaje.dividirEnPiezas(mensajeExtendido, cantPiezas);
        for (int i = 0; i < piezas.size(); i++) {
            System.out.println("Pieza " + (i + 1) + ":");
            for (int j = 0; j < piezas.get(i).length; j++) {
                System.out.print(piezas.get(i)[j]);
            }
            System.out.println(); 
        }
        //Fin paso 3
        
        //ETAPA DEL LAZO PRINCIPAL
        
        //paso 4 Definir e inicializar las variables y constantes hashes
        int[] h0 = {0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1};
        int[] h1 = {1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1};
        int[] h2 = {0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0};
        int[] h3 = {1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0};
        int[] h4 = {0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1};
        int[] h5 = {1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0};
        int[] h6 = {0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[] h7 = {0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1};
        
        int[][] k = new int[64][32];
        k[0] = new int[] {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0};
        k[1] = new int[] {0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1};
        k[2] = new int[] {1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1};
        k[3] = new int[] {1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1};
        k[4] = new int[] {0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1};
        k[5] = new int[] {0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1};
        k[6] = new int[] {1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0};
        k[7] = new int[] {1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1};
        
        k[8] = new int[] {1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0};
        k[9] = new int[] {0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1};
        k[10] = new int[] {0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0};
        k[11] = new int[] {0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1};
        k[12] = new int[] {0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0};
        k[13] = new int[] {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0};
        k[14] = new int[] {1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1};
        k[15] = new int[] {1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0};
        
        k[16] = new int[] {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1};
        k[17] = new int[] {1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0};
        k[18] = new int[] {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0};
        k[19] = new int[] {0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0};
        k[20] = new int[] {0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1};
        k[21] = new int[] {0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0};
        k[22] = new int[] {0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0};
        k[23] = new int[] {0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0};
        
        k[24] = new int[] {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0};       
        k[25] = new int[] {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1};
        k[26] = new int[] {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0};
        k[27] = new int[] {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1};
        k[28] = new int[] {1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1};
        k[29] = new int[] {1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1};
        k[30] = new int[] {0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1};
        k[31] = new int[] {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1};
        
        k[32] = new int[] {0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1};
        k[33] = new int[] {0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0};
        k[34] = new int[] {0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0};
        k[35] = new int[] {0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1};
        k[36] = new int[] {0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0};
        k[37] = new int[] {0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1};
        k[38] = new int[] {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0};
        k[39] = new int[] {1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1};
        
        k[40] = new int[] {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1};
        k[41] = new int[] {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1};
        k[42] = new int[] {1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0};
        k[43] = new int[] {1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1};
        k[44] = new int[] {1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1};
        k[45] = new int[] {1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0};
        k[46] = new int[] {1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1};
        k[47] = new int[] {0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0};
        
        k[48] = new int[] {0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0};
        k[49] = new int[] {0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        k[50] = new int[] {0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0};
        k[51] = new int[] {0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1};
        k[52] = new int[] {0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1};
        k[53] = new int[] {0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0};
        k[54] = new int[] {0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1};
        k[55] = new int[] {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1};
        
        k[56] = new int[] {0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0};
        k[57] = new int[] {0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1};
        k[58] = new int[] {1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0};
        k[59] = new int[] {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        k[60] = new int[] {1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0};
        k[61] = new int[] {1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1};
        k[62] = new int[] {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1};
        k[63] = new int[] {1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0};
        //Fin paso 4
            
        //Paso 5 Inicializar Los registros y registros temporales
        int[] registroA = h0;
        int[] registroB = h1;
        int[] registroC = h2;
        int[] registroD = h3;
        int[] registroE = h4;
        int[] registroF = h5;
        int[] registroG = h6;
        int[] registroH = h7;
        int[] registroT1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] registroT2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        //Fin paso 5
        
        //Paso 6 Crear e inicializar arreglo de w palabras 
        //SubPaso 6.1 definir arreglo (matriz)
        int[][] arregloW = new int[64][32];
        //Fin Subpaso 6.1
        
        //SubPaso 6.2 Dividir cada pieza en 16 partes de 32 bits y asignarlas a las primeras 16 palabras
        for (int i = 0; i < cantPiezas; i++) { 
            
            int fila = 0;
            if (!piezas.isEmpty()) { 
                int[] pieza = piezas.get(i); 
                for (int j = 0; j < 16; j++) { 
                    System.arraycopy(pieza, j * 32, arregloW[fila], 0, 32); 
                    fila++;
                }
            }
        //Fin SubPaso 6.2
        
        //Paso 6.3 Para las palabras 17 a 64 asignarlas siguiendo la función 
            for (int f = 16; f < 64; f++) {
                long sigma1 = BinaryToDecimal.binaryToDecimal(Sigma1.sigma1(arregloW[f - 2]));
                long w7 = BinaryToDecimal.binaryToDecimal(arregloW[f - 7]);
                long sigma0 = BinaryToDecimal.binaryToDecimal(Sigma0.sigma0(arregloW[f - 15]));
                long w16 = BinaryToDecimal.binaryToDecimal(arregloW[f - 16]);

               
                long result = ModuloSum.moduloSum(
                    ModuloSum.moduloSum(
                        ModuloSum.moduloSum(sigma1, w7),
                        sigma0
                    ),
                    w16
                ); //anidamiento de ModuloSum

                
                arregloW[f] = DecimalToBinary.decimalToBinary(Math.abs(result));
            }
        //Fin SubPaso 6.3
        //Fin paso 6
        
        
        
        for (int n = 0; n < 64; n++) { // Recorre las filas del arreglo
        long h = BinaryToDecimal.binaryToDecimal(registroH);
        long sum1 = BinaryToDecimal.binaryToDecimal(Sumatorio1.sumatorio1(registroE));
        long cho = BinaryToDecimal.binaryToDecimal(Choose.choose(registroE, registroF, registroG));
        long ksubn = BinaryToDecimal.binaryToDecimal(k[n]);
        long wsubn = BinaryToDecimal.binaryToDecimal(arregloW[n]);
        
        long result = ModuloSum.moduloSum(ModuloSum.moduloSum( ModuloSum.moduloSum(ModuloSum.moduloSum(h,sum1), cho), ksubn),wsubn);
        
        registroT1 = DecimalToBinary.decimalToBinary(Math.abs(result));
        
        long sum0 = BinaryToDecimal.binaryToDecimal(Sumatorio0.sumatorio0(registroA));
        long majo = BinaryToDecimal.binaryToDecimal(Majority.majority(registroA, registroB, registroC));
        
        long result2 = ModuloSum.moduloSum(sum0, majo);
        registroT2 = DecimalToBinary.decimalToBinary(Math.abs(result2));
        
        registroH = registroG;
        registroG = registroF;
        registroF = registroE;
        long  regD = BinaryToDecimal.binaryToDecimal(registroD);
        long result3 = ModuloSum.moduloSum(regD, result);
        registroE = DecimalToBinary.decimalToBinary(Math.abs(result3));
        registroD = registroC;
        registroC = registroB;
        registroB = registroA;
        long result4 = ModuloSum.moduloSum(result, result2);
        registroA = DecimalToBinary.decimalToBinary(Math.abs(result4));
        }
        
        long  regAvf = BinaryToDecimal.binaryToDecimal(registroA);
        long  regBvf = BinaryToDecimal.binaryToDecimal(registroB);
        long  regCvf = BinaryToDecimal.binaryToDecimal(registroC);
        long  regDvf = BinaryToDecimal.binaryToDecimal(registroD);
        long  regEvf = BinaryToDecimal.binaryToDecimal(registroE);
        long  regFvf = BinaryToDecimal.binaryToDecimal(registroF);
        long  regGvf = BinaryToDecimal.binaryToDecimal(registroG);
        long  regHvf = BinaryToDecimal.binaryToDecimal(registroH);
        long  h0vf = BinaryToDecimal.binaryToDecimal(h0);
        long  h1vf = BinaryToDecimal.binaryToDecimal(h1);
        long  h2vf = BinaryToDecimal.binaryToDecimal(h2);
        long  h3vf = BinaryToDecimal.binaryToDecimal(h3);
        long  h4vf = BinaryToDecimal.binaryToDecimal(h4);
        long  h5vf = BinaryToDecimal.binaryToDecimal(h5);
        long  h6vf = BinaryToDecimal.binaryToDecimal(h6);
        long  h7vf = BinaryToDecimal.binaryToDecimal(h7);
        
        long resulth0 = ModuloSum.moduloSum(regAvf, h0vf);
        long resulth1 = ModuloSum.moduloSum(regBvf, h1vf);
        long resulth2 = ModuloSum.moduloSum(regCvf, h2vf);
        long resulth3 = ModuloSum.moduloSum(regDvf, h3vf);
        long resulth4 = ModuloSum.moduloSum(regEvf, h4vf);
        long resulth5 = ModuloSum.moduloSum(regFvf, h5vf);
        long resulth6 = ModuloSum.moduloSum(regGvf, h6vf);
        long resulth7 = ModuloSum.moduloSum(regHvf, h7vf);
        
        h0 = DecimalToBinary.decimalToBinary(Math.abs(resulth0));
        h1 = DecimalToBinary.decimalToBinary(Math.abs(resulth1));
        h2 = DecimalToBinary.decimalToBinary(Math.abs(resulth2));
        h3 = DecimalToBinary.decimalToBinary(Math.abs(resulth3));
        h4 = DecimalToBinary.decimalToBinary(Math.abs(resulth4));
        h5 = DecimalToBinary.decimalToBinary(Math.abs(resulth5));
        h6 = DecimalToBinary.decimalToBinary(Math.abs(resulth6));
        h7 = DecimalToBinary.decimalToBinary(Math.abs(resulth7));
        
        registroA= h0;
        registroB= h1;
        registroC= h2;
        registroD= h3;
        registroE= h4;
        registroF= h5;
        registroG= h6;
        registroH= h7;
        System.out.println("");
        System.out.println("en la vuelta: "+ i + " El valor del h0 es de: ");
        System.out.print("{");
        for(int r = 0; r<31; r++){
            System.out.print(h0[r]+ ", ");
        }
        System.out.print(h0[31]+ "}");
        System.out.println("");
        System.out.println("en la vuelta: "+ i + " El valor del h1 es de: ");
        System.out.print("{");
        for(int r = 0; r<31; r++){
            System.out.print(h1[r]+ ", ");
        }
        System.out.print(h1[31]+ "}");
        System.out.println("");
        System.out.println("en la vuelta: "+ i + " El valor del h2 es de: ");
        System.out.print("{");
        for(int r = 0; r<31; r++){
            System.out.print(h2[r]+ ", ");
        }
        System.out.print(h2[31]+ "}");
        System.out.println("");
        System.out.println("en la vuelta: "+ i + " El valor del h3 es de: ");
        System.out.print("{");
        for(int r = 0; r<31; r++){
            System.out.print(h3[r]+ ", ");
        }
        System.out.print(h3[31]+ "}");
        System.out.println("");
        System.out.println("en la vuelta: "+ i + " El valor del h4 es de: ");
        System.out.print("{");
        for(int r = 0; r<31; r++){
            System.out.print(h4[r]+ ", ");
        }
        System.out.print(h4[31]+ "}");
        System.out.println("");
        System.out.println("en la vuelta: "+ i + " El valor del h5 es de: ");
        System.out.print("{");
        for(int r = 0; r<31; r++){
            System.out.print(h5[r]+ ", ");
        }
        System.out.print(h5[31]+ "}");
        System.out.println("");
        System.out.println("en la vuelta: "+ i + " El valor del h6 es de: ");
        System.out.print("{");
        for(int r = 0; r<31; r++){
            System.out.print(h6[r]+ ", ");
        }
        System.out.print(h6[31]+ "}");
        System.out.println("");
        System.out.println("en la vuelta: "+ i + " El valor del h7 es de: ");
        System.out.print("{");
        for(int r = 0; r<31; r++){
            System.out.print(h7[r]+ ", ");
        }
        System.out.print(h7[31]+ "}");
        System.out.println("");
 
        }

       StringBuilder hashBinario = new StringBuilder();
        
        hashBinario.append(arrayToString(h0));
        hashBinario.append(arrayToString(h1));
        hashBinario.append(arrayToString(h2));
        hashBinario.append(arrayToString(h3));
        hashBinario.append(arrayToString(h4));
        hashBinario.append(arrayToString(h5));
        hashBinario.append(arrayToString(h6));
        hashBinario.append(arrayToString(h7)); 
        System.out.println("HashBinario: " + hashBinario.toString());
        String h0h = BinaryToHexadecimal.binaryArrayToHex(h0);
        String h1h = BinaryToHexadecimal.binaryArrayToHex(h1);
        String h2h = BinaryToHexadecimal.binaryArrayToHex(h2);
        String h3h = BinaryToHexadecimal.binaryArrayToHex(h3);
        String h4h = BinaryToHexadecimal.binaryArrayToHex(h4);
        String h5h = BinaryToHexadecimal.binaryArrayToHex(h5);
        String h6h = BinaryToHexadecimal.binaryArrayToHex(h6);
        String h7h = BinaryToHexadecimal.binaryArrayToHex(h7);
        System.out.println("Hexadecimal: " + h0h + h1h + h2h + h3h + h4h + h5h + h6h + h7h);
        
    

    }
    public static String arrayToString(int[] array) {
        // Convertir el arreglo a una cadena sin comas ni corchetes
        String str = Arrays.toString(array);
        return str.substring(1, str.length() - 1).replace(",", "").replace(" ", "");
    }
}