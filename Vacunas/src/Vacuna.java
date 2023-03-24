import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vacuna {
    public String FILE_NAME = "vacunas.txt";


    private Map<String, String> vacunas;

    public Vacuna(){
        this.vacunas =leerArchivo();
    }

    public String buscarVacunas(String cui) {
        String vacunasPorCUI = vacunas.get(cui);

        if (vacunasPorCUI == null) {
            return "No se encontro vacunas para el CUI ingresado.";
        }

        return vacunasPorCUI;
    }


    public void guardarArchivo(String cui, String datos) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME, true);
            RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "rw");
            raf.seek(raf.length());
            String datosIngresar = cui+": "+datos+"\n";
            fw.write(datosIngresar);
            fw.close();

        } catch (IOException e) {
            System.out.println("Error al escribir en la ultima linea");
        }
    }

    @Override
    public String toString() {
        StringBuilder ls = new StringBuilder();

        for (Map.Entry<String, String> entry : vacunas.entrySet()) {
            ls.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        return ls.toString();
    }



    private Map<String, String> leerArchivo() {
        File archivo = new File(FILE_NAME);
        try{
            if(!archivo.exists()){
                archivo.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String, String> vacunas = new HashMap<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                String cui = parts[0];
                String vacuna = parts[1];

                vacunas.put(cui, vacuna);
            }
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo de texto.");
        }

        return vacunas;
    }
}
