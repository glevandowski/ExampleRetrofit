package gustavo.levandowski.exampleretrofit;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DownloadAPIService extends MainActivity {
    //metodos responsáveis pela progress bar

    public  void getFullCoin(){
        final Gson objectGson = new GsonBuilder().registerTypeAdapter(Coin.class, new CoinDeserializer()).create();//criando objeto para implementação de json para gson

        final Retrofit retrofit = new Retrofit.Builder() //instancia o serviço do retrofit
                .baseUrl(FullCoinService.BASE_URL) //utiliza a url da apr declarada no service
                .addConverterFactory(GsonConverterFactory.create(objectGson)) //converte os dados para o GSON e variavel g esta declarada logo acima
                .build();//metodo build serve para armazenar todos os dados no objeto criado para o retrofit

        final FullCoinService ServiceCoin = retrofit.create(FullCoinService.class); //implementa os dados de forma unica, para podermos realizar um requestt
        final Call<List<Coin>> requestCoin = ServiceCoin.callCoin(0); //realiza a requisição para baixar os dados

        //enqueue é responsavel por buscar os dados de forma assincrona, criando o callback e seus metodos de sucesso e onfailure
        final String finalTAG = "Comando:";
        requestCoin.enqueue(new Callback<List<Coin>>() {
            @Override
            public void onResponse(Call<List<Coin>> call,Response<List<Coin>> response) {
                //metodo que serve para identificar se a chamada foi respondida, mas nao identifica itengridade dos dados
                //response = variavel local, vinda do onResponse
                if(response.isSuccessful()){//responsavel por identificar se a chamada respondeu os dados corretamente

                   List <Coin> parametros = response.body();//se a chamada retornou sucesso incorpora os dados a minha classe(corpo)
                    for (Coin c:parametros) {fullCoinSpinner.add(c);//adiciona a lista de parametros com seus respectivos dados ao arraylist
                    }
                    listCoin();
                }else{
                    Log.i(finalTAG,"ERRO:"+response.code());
                }
            }
            @Override
            public void onFailure(Call<List<Coin>> call, Throwable t) {
                //metodo caso a chamada nao seja respondida
                Log.e(finalTAG,"ERRO:"+t.getMessage());
            }
        });
    }

    public void listCoin(){
        adapter.setCoin(fullCoinSpinner);
        adapter.notifyDataSetChanged();
        for(int i = 0; i < fullCoinSpinner.size() ; i++){
            fullCoinSpinner.get(i);
        }
    }
}
