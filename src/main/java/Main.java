import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            1. Ejercicio 1
            2. Ejercicio 2
            3. Ejercicio 3
            0. Salir
                    """);
            System.out.print("Opción: ");
            String option = sc.nextLine();

            switch(option){
                case "1"->Ejercicios.Confiabilidad.run(getPath());
                case "2"->Ejercicios.Area.run(getPath());
                case "3"->Ejercicios.Frecuencia.run();
                case "0"->exit=true;
                default-> {
                    System.out.println("Opción no válida");
                    sc.nextLine();
                }
            }
        } while(!exit);

    }

    private static String getPath(){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ignored) {
        }

        StringBuilder sb = new StringBuilder();

        JFrame frame = new JFrame();
        JFileChooser fileChooser = getjFileChooser();

        fileChooser.addActionListener(e -> {
            frame.dispose();
            if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
                sb.append(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });

        
        frame.add(fileChooser);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);

        return sb.toString();
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
