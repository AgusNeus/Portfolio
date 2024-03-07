package Api.Stocks;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Acciones {
  public List<Stock> listadoPrecios() throws IOException {
    List<Stock> acciones = new ArrayList<>();
    String baseUrl = "https://finance.yahoo.com/most-active/?count=100&offset=";
    for (int offset = 0; offset <= 200; offset += 100) {
      String url = baseUrl + offset;
        Document doc = Jsoup.connect(url).get();
        Elements rows = doc.select("tr.simpTblRow");

        for (Element row : rows) {
          Stock accion = new Stock();
          String symbol = row.select("td:nth-child(1) a").text();
          String name = row.select("td:nth-child(2)").text();
          String price = row.select("td:nth-child(3)").text();
          accion.setSymbol(symbol);
          accion.setNombre(name);
          accion.setPrice(price);
          acciones.add(accion);
        }

      }
    return acciones;
    }
  }

