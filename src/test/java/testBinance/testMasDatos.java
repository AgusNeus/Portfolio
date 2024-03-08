package testBinance;

import Api.Cripto.Binance.Entidades.Crypto24hr;
import Api.Cripto.Binance.Servicio.BinanceApi;
import java.io.IOException;
import java.util.List;

public class testMasDatos {
  public static void main(String[] args) {
    try {
      BinanceApi binanceApi = BinanceApi.instancia();
      List<Crypto24hr> monedasConPrecio = binanceApi.getTickersWithUSDT();

      for (Crypto24hr cryptocurrency : monedasConPrecio) {
        System.out.println("Symbol: " + cryptocurrency.getSymbol());
        System.out.println("Price Change: " + cryptocurrency.getPriceChange());
        System.out.println("Price Change Percent: " + cryptocurrency.getPriceChangePercent());
        System.out.println("Weighted Avg Price: " + cryptocurrency.getWeightedAvgPrice());
        System.out.println("Previous Close Price: " + cryptocurrency.getPrevClosePrice());
        System.out.println("Last Price: " + cryptocurrency.getLastPrice());
        System.out.println("Last Qty: " + cryptocurrency.getLastQty());
        System.out.println("Bid Price: " + cryptocurrency.getBidPrice());
        System.out.println("Bid Qty: " + cryptocurrency.getBidQty());
        System.out.println("Ask Price: " + cryptocurrency.getAskPrice());
        System.out.println("Ask Qty: " + cryptocurrency.getAskQty());
        System.out.println("Open Price: " + cryptocurrency.getOpenPrice());
        System.out.println("High Price: " + cryptocurrency.getHighPrice());
        System.out.println("Low Price: " + cryptocurrency.getLowPrice());
        System.out.println("Volume: " + cryptocurrency.getVolume());
        System.out.println("Quote Volume: " + cryptocurrency.getQuoteVolume());
        System.out.println("Open Time: " + cryptocurrency.getOpenTime());
        System.out.println("Close Time: " + cryptocurrency.getCloseTime());
        System.out.println("First Id: " + cryptocurrency.getFirstId());
        System.out.println("Last Id: " + cryptocurrency.getLastId());
        System.out.println("Count: " + cryptocurrency.getCount());
        System.out.println("----------------------------------------");
      }

    } catch (IOException e) {
      System.out.println("Error al obtener los datos de la API de Binance: " + e.getMessage());
    }
  }
}

