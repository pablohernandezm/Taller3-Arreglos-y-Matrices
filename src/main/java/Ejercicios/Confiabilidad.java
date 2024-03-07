package Ejercicios;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Ejercicio de complejidad del sistema.
 * @author Pablo José Hernández Meléndez [0221910052]
 * @author Juan Camilo Narváez Torres [0221920007]
 */
public class Confiabilidad {
    Sistema[] sistemas;

    public Confiabilidad(Path path){
        try{
            byte[] data = Files.readAllBytes(path);

            String fileData = new String(data);

            var systems = fileData.split(".:.");

            this.sistemas = new Sistema[systems.length-1];

            for (int i = 0; i < systems.length-1; i++) {
                Sistema sistema = new Sistema(systems[i]);
                this.sistemas[i] = sistema;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Sistema{
        private final byte[][] unidades;
        private final double[] confiabilidad;

        public Sistema(String systemData){
            var data = systemData.trim().split("\n");
            var confiabilidadData = data[0].split(";");

            this.confiabilidad= new double[confiabilidadData.length];
            this.unidades = new byte[data.length-1][confiabilidadData.length];

            for(int i=0; i<confiabilidadData.length; i++){
                String stringValue = confiabilidadData[i].trim();
                this.confiabilidad[i] = Double.parseDouble(stringValue);
            }

            for (int i=1; i<data.length; i++){
                var stringValues = data[i].split(",");

                for (int j=0; j<stringValues.length; j++){
                    String stringValue = stringValues[j].trim();
                    this.unidades[i-1][j] = Byte.parseByte(stringValue);
                }
            }
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("Confiabilidad: \n")
                    .append(Arrays.toString(this.confiabilidad))
                    .append("\n");

            sb.append("\nUnidades: \n");
            for (byte[] unidad : this.unidades) {
                sb.append(Arrays.toString(unidad))
                        .append("\n");
            }

            return sb.toString();
        }

        public double calcularConfiabilidad(){
            double confiabilidad = 0.0;

            for (byte[] unidad : this.unidades) {
                double producto = 1.0;

                for (int j = 0; j < this.confiabilidad.length; j++) {
                    var p = this.confiabilidad[j];
                    var b = unidad[j];

                    producto *= Math.pow(p, b) * Math.pow(1 - p, 1 - b);
                }

                confiabilidad += producto;
            }

            return confiabilidad;
        }
    }

    public String getConfiabilidad(){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<this.sistemas.length; i++){
            var r = this.sistemas[i].calcularConfiabilidad();
            BigDecimal bd = new BigDecimal(r);
            bd = bd.setScale(4, RoundingMode.FLOOR);

            sb.append(String.format("r%d=%s\n", i+1,bd));
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<this.sistemas.length; i++){
            sb.append(String.format("\nSistema #%d:\n", i+1))
                    .append(this.sistemas[i]);
            sb.append("Confiabilidad r=")
                    .append(this.sistemas[i].calcularConfiabilidad())
                    .append("\n");
        }


        return sb.toString();
    }
}
