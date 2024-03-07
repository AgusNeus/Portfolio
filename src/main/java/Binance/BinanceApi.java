package Binance;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BinanceApi {
  private static final String url_api = "https://api.binance.com/api/v3/";
  private Retrofit retrofit;
  private static BinanceApi instancia = null;

  public static BinanceApi instancia() {
    if (instancia == null) {
      instancia = new BinanceApi();
    }
    return instancia;
  }

  private BinanceApi() {
    this.retrofit = new Retrofit.Builder()
        .baseUrl(url_api)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public List<Cryptocurrency> listadoPrecios() throws IOException {
    BinanceService service = this.retrofit.create(BinanceService.class);
    Call<List<Cryptocurrency>> request = service.requestCryptocurrenciesPrices();

    Response<List<Cryptocurrency>> response = request.execute();

    List<Cryptocurrency> criptomonedas = new ArrayList<>();

    if (response.isSuccessful()) {
      List<Cryptocurrency> cryptocurrencies = response.body();
      for (Cryptocurrency cryptocurrency : cryptocurrencies) {
        criptomonedas.add(cryptocurrency);
      }
    }
    return criptomonedas;
  }

}

