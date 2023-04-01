package examen_3;
//C:\\Users\\nicob\\eclipse-workspace\\examen_3\\emails.csv
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Lectura {
	String archivoCSV = "C:\\\\Users\\\\nicob\\\\eclipse-workspace\\\\examen_3\\\\emails.csv";
	        String linea = "";
	        String separador = ",";
	        int f_totales = 50;
	        int cont_0=1;
	        int num_id;
	        
public void ejecutar (int ID){
	        
	num_id=ID%1000;num_id=num_id-1;
	Map<String, Integer> columnas = new HashMap<>();
		try (BufferedReader buff_reader = new BufferedReader(new FileReader(archivoCSV))) {
	            linea = buff_reader.readLine();
	            String[] palabras = linea.split(separador);

	            for (int x = 1; x < palabras.length; x++) {
	                columnas.put(palabras[x].trim(), 0);
	            }
	            
	            int cont = 0;
	            while ((linea = buff_reader.readLine()) != null && cont < f_totales) {
	                String[] valores = linea.split(separador);
	                

	                if (cont_0 == num_id) { 
	                    String[] datos = linea.split(separador);

	                    for (int x = 1; x < datos.length; x++) {
	                        String columna = palabras[x];
	                        int valor = Integer.parseInt(datos[x]);
	                        int suma = columnas.get(columna);
	                        columnas.put(columna, suma + valor);
	                    }
	                    cont++;
	                }
	                else {
	                	cont_0++;
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        try {
	            FileWriter writer = new FileWriter("175513.txt");
	            for (Map.Entry<String, Integer> entry : columnas.entrySet()) {
	                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
	                
	            }
	            System.out.println("El dcumento ha sido creado");
	            writer.close();
	        } catch (IOException e_1) {
	            e_1.printStackTrace();
	     }
	}
}
