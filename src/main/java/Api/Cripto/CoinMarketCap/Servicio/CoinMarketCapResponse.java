package Api.Cripto.CoinMarketCap.Servicio;


import Api.Cripto.CoinMarketCap.Entidades.Coin;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoinMarketCapResponse {

  @SerializedName("data")
  private List<Coin> cryptocurrencies;

  public List<Coin> getCryptocurrencies() {
    return cryptocurrencies;
  }
}
