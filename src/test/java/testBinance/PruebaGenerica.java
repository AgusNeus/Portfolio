package testBinance;

import Api.Cripto.Binance.Entidades.Cryptocurrency;
import Api.Cripto.Binance.Servicio.BinanceApi;
import java.io.IOException;
import java.util.List;

public class PruebaGenerica {
  public static void main(String[] args) {
    try {
      BinanceApi binanceApi = BinanceApi.instancia();
      List<Cryptocurrency> monedasConPrecio = binanceApi.listadoPrecios();

        for (Cryptocurrency cryptocurrency : monedasConPrecio) {
            System.out.println("Symbol: " + cryptocurrency.getSymbol() +", Price: " + cryptocurrency.getPrice());
          }

    } catch (IOException e) {
      System.out.println("Error al obtener los datos de la API de Binance: " + e.getMessage());
    }
  }
}

