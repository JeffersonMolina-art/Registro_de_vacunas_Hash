import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame{
    private JPanel panel;
    private JTextField datobuscar;
    private JButton buscarDato;
    private JButton ingresarDato;
    private JList list1;
    private JButton listarElementosButton;
    DefaultListModel<String> model = new DefaultListModel<>();
    public VentanaPrincipal() {
        buscarDato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list1.setModel(model);
                model.removeAllElements();
                Vacuna sd = new Vacuna();
                String cuiBuscar = datobuscar.getText();
                String resultado = sd.buscarVacunas(cuiBuscar);
                model.addElement("Datos para el cui buscado: "+cuiBuscar);
                model.addElement(" "+resultado);
                datobuscar.setText("");
            }
        });
        ingresarDato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IngresarNuevoDato d = new IngresarNuevoDato();
                d.levantar();
            }
        });
    }


    public static void main(String[] args) {
        VentanaPrincipal f = new VentanaPrincipal();
        f.setContentPane(new VentanaPrincipal().panel);
        f.setSize(500, 400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.pack();
    }
}
