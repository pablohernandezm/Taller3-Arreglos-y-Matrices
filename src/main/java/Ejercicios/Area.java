package Ejercicios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Ejercicio de cálculo del área entre líneas
 * @author Pablo José Hernández Meléndez [0221910052]
 * @author Juan Camilo Narváez Torres [0221920007]
 */
public class Area {
    private Triangle[] triangles;

    public Area(Path path){
        try{
            byte[] data = Files.readAllBytes(path);
            String content = new String(data);
            String[] lines = content.split("\n");

            triangles=new Triangle[lines.length-1];
            for (int i=0; i<lines.length-1; i++){
                triangles[i]=new Triangle(lines[i], i);
            }
        } catch (Exception e){
            throw new RuntimeException("Error al leer el archivo");
        }
    }

    private Triangle[] sortedTriangles(){
        Triangle[] sortedTriangles = triangles.clone();

        for (int i=0; i<sortedTriangles.length; i++){
            for (int j=i+1; j<sortedTriangles.length; j++){
                if (sortedTriangles[i].getArea()<sortedTriangles[j].getArea()){
                    Triangle temp = sortedTriangles[i];
                    sortedTriangles[i] = sortedTriangles[j];
                    sortedTriangles[j] = temp;
                }
            }
        }
        return sortedTriangles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Número de triángulos definidos: ").append(triangles.length).append("\n");
        sb.append("***\n").append("Área triángulos:\n");
        for (int i=0; i<triangles.length; i++){
            sb.append(i+1).append(".").append(String.format("%.2f", triangles[i].getArea())).append("\n");
        }
        sb.append("***\n");
        sb.append("Triángulos ordenados por el tamaño del área (mayor a menor):\n");

        Triangle[] sortedTriangles = sortedTriangles();
        for (int i=0; i<sortedTriangles.length; i++){
            sb.append(i+1).append(".-Triángulo #").append(sortedTriangles[i].index+1).append(": ");
            sb.append(String.format("%.2f", sortedTriangles[i].getArea())).append("\n");
        }
        return sb.toString();
    }

    private static class Triangle{
        private final float[] m;
        private final float[] b;

        private double area;
        private final int index;

        public Triangle(String data, int index){
            this.index = index;
            m = new float[3];
            b = new float[3];

            byte slopeIndex = 0;
            byte interceptIndex = 0;

            var rects = data.split(";");
            for (var rect: rects){
                var parts = rect.split(",");
                m[slopeIndex++] = Float.parseFloat(parts[0]);
                b[interceptIndex++] = Float.parseFloat(parts[1]);
            }
        }

        public int index(){
            return index;
        }

        private void calculateArea(){
            float[] x = new float[3];
            float[] y = new float[3];

            for (int i=0; i<3; i++){
                x[i] = (b[i]- b[(i+1)%3])/(m[(i+1)%3]- m[i]);
                y[i] = m[i]*x[i]+ b[i];
            }

            this.area= Math.abs((x[0] * (y[1] - y[2]) + x[1] * (y[2] - y[0]) + x[2] * (y[0] - y[1])) / 2);
        }

        public double getArea(){
            if (this.area==0){
                calculateArea();
            }
            BigDecimal area = new BigDecimal(this.area);
            area = area.setScale(2, RoundingMode.FLOOR);
            return area.doubleValue();
        }
    }
}
