import javax.swing.*;

public class UnidadesManager {

    private static String[] monedas = {"USD", "EUR", "JPY", "CLP", "MXN", "KRW"};
    private static String[] temperaturas = {"Celsius", "Fahrenheit"};

    public static void actualizarUnidades(JComboBox<String> unidadOrigenCombo, JComboBox<String> unidadDestinoCombo, int tipoSeleccionado) {
        String[] unidades = (tipoSeleccionado == 0) ? monedas : temperaturas;

        unidadOrigenCombo.setModel(new DefaultComboBoxModel<>(unidades));
        unidadDestinoCombo.setModel(new DefaultComboBoxModel<>(unidades));
    }
}
