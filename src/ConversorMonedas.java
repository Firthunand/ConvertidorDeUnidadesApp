public class ConversorMonedas {

    //monedas = {"USD", "EUR", "JPY", "CLP", "MXN", "KRW"};
    //          [  0  ,   1  ,   2  ,   3  ,   4  ,   5  ]
    private static double[][] tasasDeCambio = {
            {1.0, 0.91, 144.90, 853.21, 17.01, 1330.60}, //USD | USD EUR JPY CLP MXN KRW
            {1.09, 1.0, 158.80, 943.39, 18.65, 1457.82}, //EUR | USD EUR JPY CLP MXN KRW
            {0.0069, 0.0062, 1.0, 5.94, 0.11, 9.18},//JPY | USD EUR JPY CLP MXN KRW
            {0.0011, 0.00106, 0.168, 1.0, 0.019, 1.54}, //CLP | USD EUR JPY CLP MXN KRW
            {0.0587, 0.0536, 8.512, 50.566, 1.0, 78.21 }, // MXN | USD EUR JPY CLP MXN KRW
            {0.00075,0.00069,0.11,0.64, 0.013, 1.0} // KRW | USD EUR JPY CLP MXN KRW
    };

    public static double convertirMoneda(double valor, int monedaOrigen, int monedaDestino) {
        return valor * tasasDeCambio[monedaOrigen][monedaDestino];
    }
}
