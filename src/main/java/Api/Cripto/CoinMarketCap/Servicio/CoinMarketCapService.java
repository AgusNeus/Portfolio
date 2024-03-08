package Api.Cripto.CoinMarketCap.Servicio;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface CoinMarketCapService {

  @GET("cryptocurrency/listings/latest")
  Call<CoinMarketCapResponse> getLatestListings(
      @Header("X-CMC_PRO_API_KEY") String apiKey,
      @Query("start") int start,
      @Query("limit") int limit,
      @Query("convert") String convert
  );
}
