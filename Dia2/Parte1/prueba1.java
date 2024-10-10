package Dia2.Parte1;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class prueba1 {
    
    public static void main(String[] args) {
        
        File archivo = new File("2023/Dia2/Parte1/input.txt");

        try {
            BufferedReader buffr = new BufferedReader(new FileReader(archivo));
            String linea;

            int suma=0;

            while((linea=buffr.readLine()) != null){

                int idGame = 0;
                boolean isPossible = true;

                //Extraer la id de la cadena
                String partes[] = linea.split(":");
                String parteGameId = partes[0].trim();

                String parteId[] = parteGameId.split(" ");
                idGame = Integer.parseInt(parteId[1]);
                
                //Separar cada tramo con informacion
                String tramos[] = partes[1].split(";");

                for(String tramo : tramos){
                    //Extraer cada elemento
                    String elementos[] = tramo.split(","); 

                    int totalRed = 0;
                    int totalBlue = 0;
                    int totalGreen = 0;

                    for(String elemento : elementos){
                        elemento = elemento.trim();
                        //Separar la cantidad del color
                        String valorColor[] = elemento.split(" ");
                        int cantidad = Integer.parseInt(valorColor[0]);
                        String color = valorColor[1];

                        //Incrementar la variable del color
                        if(color.equals("red")){
                            totalRed += cantidad;
                        }else if(color.equals("blue")){
                            totalBlue += cantidad;
                        }else if(color.equals("green")){
                            totalGreen += cantidad;
                        }

                    }

                    if(totalRed > 12 || totalGreen > 13 || totalBlue > 14){
                        isPossible = false;
                        break;
                    } 

                }  

                if(isPossible) {
                    suma += idGame;
                }    
                       
            }

            buffr.close();

            System.out.println("La solucion es: " + suma);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
