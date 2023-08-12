import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertidorUnidadesFrame extends JFrame {

    private JComboBox<String> tipoConversionCombo;
    private JComboBox<String> unidadOrigenCombo;
    private JComboBox<String> unidadDestinoCombo;
    private JTextField valorField;
    private JLabel resultadoLabel;

    private String[] tiposConversion = {"Monedas", "Temperatura"};

    public ConvertidorUnidadesFrame() {
        setTitle("Convertidor de Unidades");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        tipoConversionCombo = new JComboBox<>(tiposConversion);
        unidadOrigenCombo = new JComboBox<>();
        unidadDestinoCombo = new JComboBox<>();
        valorField = new JTextField(10);
        resultadoLabel = new JLabel("");

        tipoConversionCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarUnidades();
            }
        });

        JButton convertirButton = new JButton("Convertir");
        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!valorField.getText().isEmpty()) {
                    convertirUnidad();
                } else {
                    JOptionPane.showMessageDialog(ConvertidorUnidadesFrame.this, "Ingresa un valor antes de convertir.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(new JLabel("Tipo de Conversión:"));
        panel.add(tipoConversionCombo);
        panel.add(new JLabel("Unidad de Origen:"));
        panel.add(unidadOrigenCombo);
        panel.add(new JLabel("Unidad de Destino:"));
        panel.add(unidadDestinoCombo);
        panel.add(new JLabel("Valor:"));
        panel.add(valorField);
        panel.add(convertirButton);
        panel.add(resultadoLabel);

        add(panel);
    }

    private void actualizarUnidades() {
        int tipoSeleccionado = tipoConversionCombo.getSelectedIndex();
        UnidadesManager.actualizarUnidades(unidadOrigenCombo, unidadDestinoCombo, tipoSeleccionado);
    }

    private void convertirUnidad() {
        int tipoSeleccionado = tipoConversionCombo.getSelectedIndex();
        int unidadOrigenSeleccionada = unidadOrigenCombo.getSelectedIndex();
        int unidadDestinoSeleccionada = unidadDestinoCombo.getSelectedIndex();
        double valor = Double.parseDouble(valorField.getText());

        double resultado;

        if (tipoSeleccionado == 0) { // Conversión de monedas
            resultado = ConversorMonedas.convertirMoneda(valor, unidadOrigenSeleccionada, unidadDestinoSeleccionada);
        } else { // Conversión de temperaturas
            resultado = ConversorTemperatura.convertirTemperatura(valor, unidadOrigenSeleccionada, unidadDestinoSeleccionada);
        }

        resultadoLabel.setText("Resultado: " + resultado);
    }
}
