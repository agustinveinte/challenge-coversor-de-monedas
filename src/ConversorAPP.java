import com.agustin.modelos.Moneda;
import com.agustin.modelos.RatioDeConversionNoEncontrado;
import com.agustin.servicios.ConsultorDeMonedas;
import com.agustin.servicios.ExchangerateApi;
import com.agustin.servicios.ServicioDeConversionException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorAPP {
    /*
    Esta app utiliza la api de https://www.exchangerate-api.com/
     * */
    //tu api key
    private final String API_KEY = "";

    //url ejemplo: https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD
    private final String URL_API = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) {
        ConversorAPP conversorAPP = new ConversorAPP();
        var opcion = 0;
        Moneda moneda;
        ConsultorDeMonedas api = new ExchangerateApi(conversorAPP.URL_API);
        while (true) {
            //muestra menu
            mostrarMenu();
            try {
                //ingresa la opcion
                opcion = ingresarOpcion();
                switch (opcion) {
                    case 1:
                        moneda = api.consultarMoneda("USD");
                        convertirMonto(moneda, "ARS", ingresarMonto());
                        break;
                    case 2:
                        moneda = api.consultarMoneda("ARS");
                        convertirMonto(moneda, "USD", ingresarMonto());
                        break;
                    case 3:
                        moneda = api.consultarMoneda("USD");
                        convertirMonto(moneda, "BRL", ingresarMonto());
                        break;
                    case 4:
                        moneda = api.consultarMoneda("BRL");
                        convertirMonto(moneda, "USD", ingresarMonto());
                        break;
                    case 5:
                        moneda = api.consultarMoneda("USD");
                        convertirMonto(moneda, "COP", ingresarMonto());
                        break;
                    case 6:
                        moneda = api.consultarMoneda("COP");
                        convertirMonto(moneda, "USD", ingresarMonto());
                        break;
                    case 7:
                        System.out.println("Finalizando...");
                        break;
                    default:
                        System.out.println("Debe seleccionar una opcion valida");
                }
                //si la opcion es 7 sale del bucle
                if (opcion == 7) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
        System.out.println("Programa Finalizado");
    }

    private static void mostrarMenu() {
        System.out.println("""
                ********************************************************
                Sea bienvenido/a al Conversor de Moneda =]
                
                1) Dolar =>> Peso argentino
                2) Peso argentino =>> Dolar
                3) Dolar =>> Real brasileno
                4) Real brasileno =>> Dolar
                5) Dolar =>> Peso colombiano
                6) Peso colombiano =>> Dolar
                7) Salir
                ********************************************************
                """);
    }

    //Metodo para ingresar la opcion del menu
    private static int ingresarOpcion() {
        System.out.println("Elija una opcion valida:");
        Scanner lectura = new Scanner(System.in);
        try {
            return lectura.nextInt();
        } catch (InputMismatchException e) {
            lectura.next();
            throw new RuntimeException("La opcion no se pudo ingresar correctamente");
        }
    }

    //Metodo para ingresar el monto
    private static double ingresarMonto() {
        System.out.println("Ingrese el valor que desea convertir");
        Scanner lectura = new Scanner(System.in);
        try {
            double monto;
            monto = lectura.nextDouble();
            if (monto < 0) {
                throw new RuntimeException("El monto debe ser igual o mayor a 0");
            }
            return monto;
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un monto");
            lectura.next();
            throw new RuntimeException("La conversion no se pudo realizar");
        }
    }

    //metodo para convertir un monto determinado
    private static double convertirMonto(Moneda codigoMonedaOrigen, String codigoMonedaDestino, double monto) {
        try {
            var montoResultante = codigoMonedaOrigen.convertir(monto, codigoMonedaDestino);
            System.out.println("El valor " + monto + " [" + codigoMonedaOrigen.base_code() + "] " +
                    "corresponde al valor final de =>>> "
                    + String.format("%,.2f", montoResultante) +
                    " [" + codigoMonedaDestino + "]");
            System.out.println("Pulse ENTER para continuar...");
            Scanner lectura = new Scanner(System.in);
            lectura.nextLine();
            return montoResultante;
        } catch (RatioDeConversionNoEncontrado | ServicioDeConversionException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}