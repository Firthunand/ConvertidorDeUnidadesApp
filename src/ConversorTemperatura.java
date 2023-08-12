public class ConversorTemperatura {

    //temperaturas = {"Celsius", "Fahrenheit", "Kelvin"};
    //                     0   ,       1     ,     2
    public static double convertirTemperatura(double valor, int temperaturaOrigen, int temperaturaDestino) {
        if (temperaturaOrigen == 0 && temperaturaDestino == 1) {
            return (valor * 9/5) + 32;
        } else if (temperaturaOrigen == 1 && temperaturaDestino == 0) {
            return (valor - 32) * 5/9;
        } else {
            return valor; // Misma unidad de origen y destino
        }
    }
}
