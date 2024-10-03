import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class prueba2 {
    
    public static void main(String[] args) {

        File archivo = new File("C:\\Users\\gabin\\OneDrive\\Escritorio\\Visual Studio_workspace\\adventOfCode\\2023\\Dia1\\Parte2\\adventoCode.txt");

        try {
            BufferedReader buffr = new BufferedReader(new FileReader(archivo));
            String linea;

            int suma=0;

            Map<String, Integer> palabrasNumero = new HashMap<>();
            palabrasNumero.put("zero", 0);
            palabrasNumero.put("one", 1);
            palabrasNumero.put("two", 2);
            palabrasNumero.put("three", 3);
            palabrasNumero.put("four", 4);
            palabrasNumero.put("five", 5);
            palabrasNumero.put("six", 6);
            palabrasNumero.put("seven", 7);
            palabrasNumero.put("eight", 8);
            palabrasNumero.put("nine", 9);

            while((linea=buffr.readLine()) != null){

                int numeroFinal;

                StringBuilder numero1 = new StringBuilder();
                boolean primerNumero=false;

                StringBuilder numero2 = new StringBuilder();
                boolean segundoNumero=false;

                //Obtener el primer numero
                for(int i=0;i<linea.length();i++){
                    char c = linea.charAt(i);

                    if(Character.isDigit(c)){
                        if(!primerNumero){
                            numero1.append(c);
                            primerNumero=true;
                        } 
                    }else{
                        for(String palabra : palabrasNumero.keySet()){
                            if(linea.startsWith(palabra, i)){
                                if(!primerNumero){
                                    numero1.append(palabrasNumero.get(palabra));
                                    primerNumero=true;
                                }
                                i += palabra.length() -1;
                                break;
                            }
                        }
                    }
                    if(primerNumero){
                        break;
                    }
                }

                //Obtener el segundo numero
                for(int i=linea.length() -1;i>=0;i--){
                    char c = linea.charAt(i);

                    if(Character.isDigit(c)){
                        if(!segundoNumero){
                            numero2.append(c);
                            segundoNumero=true;
                        }
                    }else{
                        for(String palabra : palabrasNumero.keySet()){
                            if(linea.startsWith(palabra, i)){
                                if(!segundoNumero){
                                    numero2.append(palabrasNumero.get(palabra));
                                    segundoNumero=true;
                                }
                                i -= palabra.length() -1;
                                break;
                            }   
                        }
                    }
                    if(segundoNumero){
                        break;
                    }
                }

                String numeroCombinado = numero1.toString() + numero2.toString();
                
                numeroFinal = Integer.parseInt(numeroCombinado.toString());
                suma +=numeroFinal;
            }

            System.out.println("La solucion es: " + suma);

            buffr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
