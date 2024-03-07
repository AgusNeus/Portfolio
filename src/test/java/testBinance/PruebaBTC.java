package testBinance;

import Api.Binance.Cryptocurrency;
import Api.Binance.BinanceApi;
import java.io.IOException;
import java.util.List;

public class PruebaBTC {
  public static void main(String[] args) {
    try {
      BinanceApi binanceApi = BinanceApi.instancia();
      List<Cryptocurrency> monedasConPrecio = binanceApi.listadoPrecios();

      for (Cryptocurrency cryptocurrencyWithPrice : monedasConPrecio) {
        if (cryptocurrencyWithPrice.getSymbol().equals("BTCUSDT")) {
          System.out.println("Symbol: " + cryptocurrencyWithPrice.getSymbol());
          System.out.println("Price: " + cryptocurrencyWithPrice.getPrice());
          break;
        }
      }

    } catch (IOException e) {
      System.out.println("Error al obtener los datos de la API de Binance: " + e.getMessage());
    }
  }
}