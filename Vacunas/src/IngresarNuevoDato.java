import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngresarNuevoDato extends JFrame{
    private JPanel panel;
    private JTextField fechaNueva;
    private JTextField vacunaNueva;
    private JTextField cuiNuevo;
    private JButton ingresarDatoNuevo;
    private JTextField dosis2;
    private JLabel Dosis2;
    private JTextField fecha2;

    public IngresarNuevoDato() {
        ingresarDatoNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vacuna vacuna = new Vacuna();
                IngresarNuevoDato dato = new IngresarNuevoDato();
                String cui = cuiNuevo.getText();
                String datos = vacunaNueva.getText()+", "+fechaNueva.getText()+" ; "+dosis2.getText()+", "+fecha2.getText();
                vacuna.guardarArchivo(cui, datos);
                cuiNuevo.setText("");
                vacunaNueva.setText("");
                fechaNueva.setText("");
                dosis2.setText("");
                fecha2.setText("");
                JOptionPane.showMessageDialog(panel, "Se han guardado los datos");
                //Falta como cerrar la venta despues de dar click

            }
        });
    }
    public void levantar(){
        IngresarNuevoDato f = new IngresarNuevoDato();
        f.setContentPane(new IngresarNuevoDato().panel);
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.pack();
    }
}
