package TestCoinMarketCap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class testTop10Criptos {
    public static void main(String[] args) throws Exception {
      String url = "https://coinmarketcap.com/es/";
      Document doc = Jsoup.connect(url).get();

      Element table = doc.select("table").first();
      Elements rows = table.select("tr");

      for (int i = 1; i < rows.size(); i++) {
        Element row = rows.get(i);
        Elements cols = row.select("td");
        if (cols.size() >= 3) {
          Element coinInfoElement = cols.get(2);

          // Extraer el nombre y símbolo de la criptomoneda
          Element coinNameElement = coinInfoElement.select("p.kKpPOn").first();
          Element coinSymbolElement = coinInfoElement.select("p.iqdbQL").first();

          if (coinNameElement != null && coinSymbolElement != null) {
            String coinName = coinNameElement.text();
            String coinSymbol = coinSymbolElement.text();

            // Construir la URL de la criptomoneda
            Element coinLinkElement = coinInfoElement.selectFirst("a.cmc-link");
            String coinSlug = coinLinkElement.attr("href").replace("/es/currencies/", "");
            String coinUrl = "https://coinmarketcap.com/currencies/" + coinSlug;

            // Extraer el precio y market cap
            Element priceElement = cols.get(3);
            String price = priceElement.text();

            String oneHourChange = cols.get(4).text();
            String twentyFourHourChange = cols.get(5).text();
            String sevenDayChange =cols.get(6).text();

            Element marketCapElement = cols.get(7);
            String marketCapText = marketCapElement.text().replaceAll("[^\\d.]", "");

            // Convertir marketCapText a BigDecimal
            String volumen =cols.get(8).text();
            String[] volumenParts = volumen.split(" ");
            String VolumenUSDT = volumenParts[0];
            String VolumenEnCripto = volumenParts[1]+" " +coinSymbol ;

            String AccionesenCirculacion=cols.get(9).text();

            Element graphElement = cols.get(10).select("img").first();
            String urlGrafico = graphElement.attr("src");
            // Imprimir la información
            System.out.println("Coin Name: " + coinName);
            System.out.println("Coin Symbol: " + coinSymbol);
            System.out.println("Coin URL: " + coinUrl);
            System.out.println("Price: " + price);
            System.out.println("Variacion 1h: " + oneHourChange + "%");
            System.out.println("Variacion 24h: " + twentyFourHourChange + "%");
            System.out.println("Variacion 7d: " + sevenDayChange + "%");
            System.out.println("Market Cap: $" + formatMarketCap(marketCapText));
            System.out.println("Volumen (USDT): " + VolumenUSDT);
            System.out.println("Volumen " + "("+coinSymbol + "):" + VolumenEnCripto );
            System.out.println("Acciones en circulacion: " + AccionesenCirculacion);
            System.out.println("urlGrafico: " + urlGrafico);
            System.out.println("-----------------------");
          }
        }
      }
    }

    public static String formatMarketCap(String number) {
      StringBuilder formattedNumber = new StringBuilder();
      int count = 0;
      for (int i = number.length() - 1; i >= 0; i--) {
        char c = number.charAt(i);
        if (c != '.') { // Ignorar el punto
          formattedNumber.insert(0, c);
          count++;
          if (count % 3 == 0 && i > 0) {
            formattedNumber.insert(0, ",");
          }
        }
      }
      return formattedNumber.toString();
    }

  }
