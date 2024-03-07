package Stocks;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Etf {
  public static void main(String[] args) {
    String baseUrl = "https://finance.yahoo.com/etfs/?count=100&offset=";
    for (int offset = 0; offset <= 500; offset += 100) {
      String url = baseUrl + offset;
      try {
        Document doc = Jsoup.connect(url).get();
        Elements rows = doc.select("tr.simpTblRow");

        for (Element row : rows) {
          String symbol = row.select("td:nth-child(1) a").text();
          String name = row.select("td:nth-child(2)").text();
          String price = row.select("td:nth-child(3)").text();
          String change = row.select("td:nth-child(4)").text();
          String changePercent = row.select("td:nth-child(5)").text();
          String volume = row.select("td:nth-child(6)").text();
          String avg50 = row.select("td:nth-child(7)").text();
          String avg200 = row.select("td:nth-child(8)").text();
          String range52Week = row.select("td:nth-child(9)").text();

          System.out.println("Symbol: " + symbol);
          System.out.println("Name: " + name);
          System.out.println("Price: " + price);
          System.out.println("Change: " + change);
          System.out.println("Change Percent: " + changePercent);
          System.out.println("Volume: " + volume);
          System.out.println("50 Day Average: " + avg50);
          System.out.println("200 Day Average: " + avg200);
          System.out.println("52 Week Range: " + range52Week);
          System.out.println("-----------------------------");
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
