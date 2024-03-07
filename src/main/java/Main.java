import Ejercicios.Confiabilidad;
import Ejercicios.Area;
import javax.swing.UIManager;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Ejercicio propuesto para estructuras de datos en la Universidad de Cartagena.
 * @author Pablo José Hernández Meléndez [0221910052]
 * @author Jorge David Junior Sierra Morales [0221910025]
 * @author Sergio Alejandro Severiche Guerrero [0222010041]
 */
public class Main {
    public static void main(String ...args){
        boolean exit=false;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("""
            Menú de ejercicios
            1. Confiabilidad del sistema
            2. Área entre líneas
            3. Frecuencia de números
            0. Salir
                    """);
            System.out.print("Opción: ");
            String option = sc.nextLine();
            System.out.println();

            switch(option){
                case "1"-> {
                    Confiabilidad confiabilidad = new Confiabilidad(getPath());
                    System.out.println(confiabilidad.getConfiabilidad());
                }
                case "2"->{
                    Area area = new Area(getPath());
                    System.out.println(area);
                }
                case "3"->Ejercicios.Frecuencia.run();
                case "0"->exit=true;
                default-> {
                    System.out.println("Opción no válida");
                    sc.nextLine();
                }
            }

            System.out.print("\nPresione enter para continuar...");
            sc.nextLine();
            System.out.println("\n");
        } while(!exit);
    }

    private static Path getPath(){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ignored) {
        }

        StringBuilder sb = new StringBuilder();

        JFrame frame = new JFrame();
        JFileChooser fileChooser = getjFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos del programa (.in)", "in"));

        fileChooser.addActionListener(e -> {
            frame.dispose();
            if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
                sb.append(fileChooser.getSelectedFile().getPath());
            }
        });

        
        frame.add(fileChooser);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);

        fileChooser.showOpenDialog(frame);
;
        return Path.of(sb.toString());
    }

    private static JFileChooser getjFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setDialogTitle("Selecciona el archivo de entrada");
        fileChooser.setApproveButtonText("Seleccionar");
        fileChooser.setApproveButtonMnemonic('s');
        fileChooser.setApproveButtonToolTipText("Seleccionar archivo");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de texto", "txt"));
        fileChooser.setAcceptAllFileFilterUsed(false);
        return fileChooser;
    }
}
