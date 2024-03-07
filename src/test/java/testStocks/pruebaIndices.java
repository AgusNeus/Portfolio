package testStocks;

import Api.Stocks.Indices;
import Api.Stocks.Stock;
import java.io.IOException;
import java.util.List;

public class pruebaIndices {
  public static void main(String[] args) {
    Indices indices = new Indices();
    try {
      List<Stock> listadoAcciones = indices.listadoPrecios();
      for (Stock accion : listadoAcciones) {
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
