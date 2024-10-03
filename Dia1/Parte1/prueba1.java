
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class prueba1 {

	public static void main(String[] args) {

		File archivo = new File("C:\\Users\\gabin\\OneDrive\\Escritorio\\Visual Studio_workspace\\adventOfCode\\2023\\Dia1\\Parte1\\adventoCode.txt");
		
		try {
			BufferedReader buffr = new BufferedReader(new FileReader(archivo));
			String linea;
			
			int suma=0;
			
			while((linea=buffr.readLine()) != null) {
				
				int numero;
				
				String numero1 = "";
				String numero2 = "";
				
				char[] contenido = linea.toCharArray();
				
					int contador1=0;
					while(contador1<1) {
						for(int i=0;i<contenido.length;i++) {
							if(Character.isDigit(contenido[i])) {
								numero1 += contenido[i];
								break;
							}
						}
						contador1++;
					}
			
					int contador2=0;
					while(contador2<1) {
						for(int i=contenido.length-1;i>=0;i--) {
							if(Character.isDigit(contenido[i])) {
								 numero2 +=  contenido[i];
								 break;
							}	
						}
						contador2++;
					}
				
				String numero3 = numero1 + numero2;
			
				numero = Integer.parseInt(numero3);
				suma += numero; 
			}
			
			System.out.println("La solucion es: " + suma);
			
			buffr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
