package Dia2.Parte2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class prueba2 {
    
    public static void main(String[] args) {
        
        File archivo = new File("Dia2/Parte2/input.txt");

        try {
            BufferedReader buffr = new BufferedReader(new FileReader(archivo));
            String linea;

            int suma = 0;

            while((linea = buffr.readLine()) != null){

                int maxRed = 0;
                int maxBlue = 0;
                int maxGreen = 0;

                int potencia = 0;

                // Se separa la parte de la id de los cubos
                String partes[] = linea.split(":");

                //Separar cada tramo con los cubos
                String tramos[] = partes[1].split(";");
                
                for(String tramo : tramos){
                    //Extraer cada elemento
                    String elementos[] = tramo.split(",");

                    for(String elemento : elementos){
                        elemento = elemento.trim();
                        //Separar la cantidad del color
                        String valorColor[] = elemento.split(" ");
                        int cantidad = Integer.parseInt(valorColor[0]);
                        String color = valorColor[1];

                        //Obtener el mayor de cada color
                        if(color.equals("red")){
                            if(cantidad > maxRed){
                                maxRed = cantidad;
                            }
                        }else if(color.equals("blue")){
                            if(cantidad > maxBlue){
                                maxBlue = cantidad;
                            }
                        }else if(color.equals("green")){
                            if(cantidad > maxGreen){
                                maxGreen = cantidad;
                            }
                        }
                    }

                }

                potencia = maxRed * maxBlue * maxGreen;

                suma += potencia;
                
            }

            buffr.close();

            System.out.println("La solución es: " + suma);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
