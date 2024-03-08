package Api.Cripto.Binance.Servicio;

import Api.Cripto.Binance.Entidades.Crypto24hr;
import Api.Cripto.Binance.Entidades.Cryptocurrency;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface BinanceService {
  @GET("ticker/price")
  Call<List<Cryptocurrency>> requestCryptocurrenciesPrices();

  @GET("/api/v3/ticker/24hr")
  Call<List<Crypto24hr>> getTicker24hr();

}

//430f80e1-f5a5-46ec-8587-7b11ef0f673a