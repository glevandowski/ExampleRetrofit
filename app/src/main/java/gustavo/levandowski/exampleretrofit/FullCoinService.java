package gustavo.levandowski.exampleretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FullCoinService {
    public static final String BASE_URL="https://api.coinmarketcap.com/v1/ticker/";

    @GET("?convert=BRL")
    Call<List<Coin>> callCoin(@Query("limit") int limit);//get é responsavel por inserir o convert na URL e query por alocar os valores dentro da variavel limit
}
