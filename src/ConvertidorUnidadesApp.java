import javax.swing.*;

public class ConvertidorUnidadesApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConvertidorUnidadesFrame convertidor = new ConvertidorUnidadesFrame();
            convertidor.setVisible(true);
        });
    }
}
