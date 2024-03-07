package testStocks;

import Api.Stocks.Acciones;
import Api.Stocks.Stock;
import java.io.IOException;
import java.util.List;

public class pruebaAccion {
  public static void main(String[] args) {
  Acciones acciones = new Acciones();
  try {
    List<Stock> listadoAcciones = acciones.listadoPrecios();
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
