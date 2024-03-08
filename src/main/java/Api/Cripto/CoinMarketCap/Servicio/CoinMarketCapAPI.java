package Api.Cripto.CoinMarketCap.Servicio;

import Api.Cripto.CoinMarketCap.Entidades.Coin;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class CoinMarketCapAPI {

  private static final String BASE_URL = "https://pro-api.coinmarketcap.com/v1/";
  private static final String API_KEY = "430f80e1-f5a5-46ec-8587-7b11ef0f673a";

  public static void main(String[] args) {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    CoinMarketCapService service = retrofit.create(CoinMarketCapService.class);

    Call<CoinMarketCapResponse> call = service.getLatestListings(API_KEY, 1, 30, "USD");

    try {
      CoinMarketCapResponse response = call.execute().body();
      List<Coin> cryptocurrencies = response.getCryptocurrencies();

      for (Coin crypto : cryptocurrencies) {
        System.out.println("Name: " + crypto.getName());
        System.out.println("Symbol: " + crypto.getSymbol());
        System.out.println("Price: $" + crypto.getQuote().getUsd().getPrice());
        System.out.println("Market Cap: $" + crypto.getQuote().getUsd().getMarketCap());
        System.out.println("Volume 24h: $" + crypto.getQuote().getUsd().getVolume24h());
        System.out.println("Percent Change 1h: " + crypto.getQuote().getUsd().getPercentChange1h() + "%");
        System.out.println("Percent Change 24h: " + crypto.getQuote().getUsd().getPercentChange24h() + "%");
        System.out.println("Percent Change 7d: " + crypto.getQuote().getUsd().getPercentChange7d() + "%");
        System.out.println("----------------------------------------");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
