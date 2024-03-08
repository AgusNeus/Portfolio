package Domain;

import Api.Cripto.Binance.Entidades.Cryptocurrency;
import Api.Stocks.Stock;
import java.util.ArrayList;
import java.util.List;

public class Portafolio {
  private List<Cryptocurrency> criptoPortfolio = new ArrayList<>();
  private List<Stock> stocksPortfolio= new ArrayList<>();

  public void agregarCriptos(Cryptocurrency cripto) {
    criptoPortfolio.add(cripto);
  }

  public void sacarCripto(Cryptocurrency cripto) {
    criptoPortfolio.remove(cripto);
  }

  public void agregarStock(Stock accion) {
    stocksPortfolio.add(accion);
  }

  public void sacarStock(Stock accion) {
    stocksPortfolio.remove(accion);
  }

}

