package gustavo.levandowski.exampleretrofit;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public static ArrayList<Coin> fullCoinSpinner;
    public static CoinFullAdapter adapter;
    private RecyclerView recyclerViewCoin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        execute();
        //ArrayList
        adapter = new CoinFullAdapter(this, new ArrayList<Coin>());
        recyclerViewCoin = findViewById(R.id.first_recyclerViewCoin);
        adapter.notifyDataSetChanged();
        //fecha referencia

        //ReciclerView
        recyclerViewCoin.setAdapter(adapter);
        recyclerViewCoin.setHasFixedSize(true);
        recyclerViewCoin.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewCoin.setLayoutManager(linearLayoutManager);
        adapter.setCoin(fullCoinSpinner);
        adapter.notifyDataSetChanged();
        //fecha ReciclerView

    }//fecha oncreate

    public static void execute(){
        DownloadAPIService o = new DownloadAPIService();
        o.getFullCoin();
        //instanciando o array com seus valores para o oncreate
        fullCoinSpinner = new ArrayList<Coin>();
    }
}
