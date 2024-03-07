package testBinance;

import Api.Binance.Cryptocurrency;
import Api.Binance.BinanceApi;
import java.io.IOException;
import java.util.List;

public class PruebaGenerica {
  public static void main(String[] args) {
    try {
      BinanceApi binanceApi = BinanceApi.instancia();
      List<Cryptocurrency> monedasConPrecio = binanceApi.listadoPrecios();

        for (Cryptocurrency cryptocurrency : monedasConPrecio) {
            System.out.println("Symbol: " + cryptocurrency.getSymbol() +", Price: " + cryptocurrency.getPrice());
             // Para salir del bucle interno una vez que se ha encontrado la moneda con precio
          }


    } catch (IOException e) {
      System.out.println("Error al obtener los datos de la API de Binance: " + e.getMessage());
    }
  }
}

