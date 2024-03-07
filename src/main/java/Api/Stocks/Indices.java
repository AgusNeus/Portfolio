package Api.Stocks;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Indices {
  public List<Stock> listadoPrecios() throws IOException {
    List<Stock> acciones = new ArrayList<>();
    String url = "https://finance.yahoo.com/world-indices/"; // Reemplaza con la URL de la página web que contiene la tabla de acciones

      Document doc = Jsoup.connect(url).get();
      Elements rows = doc.select("tr.simpTblRow");

      for (Element row : rows) {
        Stock accion = new Stock();
        Element symbolElement = row.selectFirst("td[aria-label=Symbol] a");
        Element nameElement = row.selectFirst("td[aria-label=Name]");
        Element priceElement = row.selectFirst("td[aria-label='Last Price'] fin-streamer");

        accion.setSymbol(symbolElement.text());
        accion.setNombre(nameElement.text());
        accion.setPrice(priceElement.text());
        acciones.add(accion);

      }
      return acciones;
    }
  }

