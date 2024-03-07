package Binance;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface BinanceService {
  @GET("ticker/price")
  Call<List<Cryptocurrency>> requestCryptocurrenciesPrices();

}
//