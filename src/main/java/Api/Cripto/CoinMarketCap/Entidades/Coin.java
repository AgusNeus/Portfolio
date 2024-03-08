package Api.Cripto.CoinMarketCap.Entidades;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coin {

  @SerializedName("id")
  private int id;

  @SerializedName("name")
  private String name;

  @SerializedName("symbol")
  private String symbol;

  @SerializedName("slug")
  private String slug;

  @SerializedName("num_market_pairs")
  private int numMarketPairs;

  @SerializedName("date_added")
  private String dateAdded;

  @SerializedName("tags")
  private String[] tags;

  @SerializedName("max_supply")
  private long maxSupply;

  @SerializedName("circulating_supply")
  private double circulatingSupply;

  @SerializedName("total_supply")
  private double totalSupply;

  @SerializedName("infinite_supply")
  private boolean infiniteSupply;

  @SerializedName("platform")
  private Object platform;

  @SerializedName("cmc_rank")
  private int cmcRank;

  @SerializedName("self_reported_circulating_supply")
  private Object selfReportedCirculatingSupply;

  @SerializedName("self_reported_market_cap")
  private Object selfReportedMarketCap;

  @SerializedName("tvl_ratio")
  private Object tvlRatio;

  @SerializedName("last_updated")
  private String lastUpdated;

  @SerializedName("quote")
  private Quote quote;

  @Getter
  @Setter
  public static class Quote {

    @SerializedName("USD")
    private USD usd;

    @Getter
    @Setter
    public static class USD {

      @SerializedName("price")
      private double price;

      @SerializedName("volume_24h")
      private double volume24h;

      @SerializedName("volume_change_24h")
      private double volumeChange24h;

      @SerializedName("percent_change_1h")
      private double percentChange1h;

      @SerializedName("percent_change_24h")
      private double percentChange24h;

      @SerializedName("percent_change_7d")
      private double percentChange7d;

      @SerializedName("percent_change_30d")
      private double percentChange30d;

      @SerializedName("percent_change_60d")
      private double percentChange60d;

      @SerializedName("percent_change_90d")
      private double percentChange90d;

      @SerializedName("market_cap")
      private double marketCap;

      @SerializedName("market_cap_dominance")
      private double marketCapDominance;

      @SerializedName("fully_diluted_market_cap")
      private double fullyDilutedMarketCap;

      @SerializedName("tvl")
      private Object tvl;

      @SerializedName("last_updated")
      private String lastUpdated;

    }
  }
}
