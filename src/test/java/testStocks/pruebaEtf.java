package testStocks;

import Api.Stocks.Etf;
import Api.Stocks.Stock;
import java.io.IOException;
import java.util.List;

public class pruebaEtf {
  public static void main(String[] args) {
    Etf etf = new Etf();
    try {
      List<Stock> acciones = etf.listadoPrecios();
      for (Stock accion : acciones) {
        System.out.println("Symbol: " + accion.getSymbol());
        System.out.println("Name: " + accion.getNombre());
        System.out.println("Price: " + accion.getPrice());
        System.out.println("-----------------------------");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
