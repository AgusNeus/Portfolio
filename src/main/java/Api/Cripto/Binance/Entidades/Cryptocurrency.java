package Api.Cripto.Binance.Entidades;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cryptocurrency {
  @SerializedName("symbol")
  private String symbol;
  @SerializedName("price")
  private String price;
}
