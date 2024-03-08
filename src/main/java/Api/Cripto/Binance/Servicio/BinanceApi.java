package Api.Cripto.Binance.Servicio;


import Api.Cripto.Binance.Entidades.Crypto24hr;
import Api.Cripto.Binance.Entidades.Cryptocurrency;
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
        criptomonedas.addAll(cryptocurrencies);
    }
    return criptomonedas;
  }

  public List<Crypto24hr> getTickersWithUSDT() throws IOException {
    BinanceService service = this.retrofit.create(BinanceService.class);

    Call<List<Crypto24hr>> call = service.getTicker24hr();

    List<Crypto24hr> tickersWithUSDT = new ArrayList<>();
    try {
      List<Crypto24hr> tickers = call.execute().body();

      for (Crypto24hr ticker : tickers) {
        //if (ticker.getSymbol().endsWith("USDT")) {
          tickersWithUSDT.add(ticker);
        //}
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return tickersWithUSDT;
  }
}

