package testBinance;

import Binance.Cryptocurrency;
import Binance.BinanceApi;
import java.io.IOException;
import java.util.List;

public class PruebaBTC {
  public static void main(String[] args) {
    try {
      BinanceApi binanceApi = BinanceApi.instancia();
      List<Cryptocurrency> monedasConPrecio = binanceApi.listadoPrecios();


      // Buscar Bitcoin en la lista de criptomonedas
      Cryptocurrency bitcoin = new Cryptocurrency();
      for (Cryptocurrency cryptocurrencyWithPrice : monedasConPrecio) {
        if (cryptocurrencyWithPrice.getSymbol().equals("BTCUSDT")) {
          System.out.println("Symbol: " + cryptocurrencyWithPrice.getSymbol());
          System.out.println("Price: " + cryptocurrencyWithPrice.getPrice());
          break;
        }
      }
      // Si se encontró Bitcoin, mostrar su información

    } catch (IOException e) {
      System.out.println("Error al obtener los datos de la API de Binance: " + e.getMessage());
    }
  }
}