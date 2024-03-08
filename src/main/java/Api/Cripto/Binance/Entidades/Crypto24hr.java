package Api.Cripto.Binance.Entidades;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Crypto24hr {
  @SerializedName("symbol")
  private String symbol;
  @SerializedName("priceChange")
  private String priceChange;
  @SerializedName("priceChangePercent")
  private String priceChangePercent;
  @SerializedName("weightedAvgPrice")
  private String weightedAvgPrice;
  @SerializedName("prevClosePrice")
  private String prevClosePrice;
  @SerializedName("lastPrice")
  private String lastPrice; // precio Actual
  @SerializedName("lastQty")
  private String lastQty;
  @SerializedName("bidPrice")
  private String bidPrice;
  @SerializedName("bidQty")
  private String bidQty;
  @SerializedName("askPrice")
  private String askPrice;
  @SerializedName("askQty")
  private String askQty;
  @SerializedName("openPrice")
  private String openPrice;
  @SerializedName("highPrice")
  private String highPrice;
  @SerializedName("lowPrice")
  private String lowPrice;
  @SerializedName("volume")
  private String volume;
  @SerializedName("quoteVolume")
  private String quoteVolume;
  @SerializedName("openTime")
  private String openTime;
  @SerializedName("closeTime")
  private String closeTime;
  @SerializedName("firstId")
  private String firstId;
  @SerializedName("lastId")
  private String lastId;
  @SerializedName("count")
  private String count;
}
