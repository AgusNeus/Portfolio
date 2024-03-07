package Stocks;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Indices {
  public static void main(String[] args) {
    String url = "https://finance.yahoo.com/world-indices/"; // Reemplaza con la URL de la página web que contiene la tabla de acciones

    try {
      Document doc = Jsoup.connect(url).get();
      Elements rows = doc.select("tr.simpTblRow");

      for (Element row : rows) {
        Element symbolElement = row.selectFirst("td[aria-label=Symbol] a");
        String symbol = symbolElement.text();

        Element nameElement = row.selectFirst("td[aria-label=Name]");
        String name = nameElement.text();

        Element priceElement = row.selectFirst("td[aria-label='Last Price'] fin-streamer");
        String price = priceElement.text();

        Element changeElement = row.selectFirst("td[aria-label=Change] fin-streamer span");
        String change = changeElement.text();

        Element changePercentElement = row.selectFirst("td[aria-label='% Change'] fin-streamer span");
        String changePercent = changePercentElement.text();

        Element volumeElement = row.selectFirst("td[aria-label=Volume] fin-streamer");
        String volume = volumeElement.text();

        System.out.println("Symbol: " + symbol);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Change: " + change);
        System.out.println("% Change: " + changePercent);
        System.out.println("Volume: " + volume);
        System.out.println("-----------------------------");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
