package gustavo.levandowski.exampleretrofit;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class CoinFullAdapter extends RecyclerView.Adapter{
    private Context context;
    public ArrayList<Coin> coin;

    public CoinFullAdapter(Context context, ArrayList<Coin> coin) {
        this.context = context;
        this.coin = coin;}

    public void setCoin(ArrayList<Coin> coin) {
        this.coin = coin;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_coin_line_full, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder hold = (ViewHolder) holder;
        Coin c = coin.get(position);
        //**ESTE METODO SETA TODOS OS VALORES DOS CARDS E MANIPULA DADOS

        //comando responsável por formatar os numeros do json de maneira correta.
        //NumberFormat nf = NumberFormat.getCurrencyInstance();

        //COMANDOS RESPONSÁVEIS POR SETAR TEXTOS E CORES VINDOS DO JSON NOS CARDS
        //condicional de 24hrs
        if (c.percent_change_24h == null) {
            hold.priceTwentyView.setText("Sem Informação");
            hold.priceTwentyView.setTextColor(Color.BLACK);
            hold.percentsTwenty.setTextColor(Color.BLACK);
        } else {
            if (c.percent_change_24h>= 0.01) {
                hold.priceTwentyView.setTextColor(Color.GREEN);
                hold.percentsTwenty.setTextColor(Color.GREEN);
            } else if (c.percent_change_24h <= -0.01) {
                hold.priceTwentyView.setTextColor(Color.RED);
                hold.percentsTwenty.setTextColor(Color.RED);
            }
            hold.priceTwentyView.setText(String.valueOf(c.percent_change_24h));}
        //condicional de 1hrs
        if (c.percent_change_1h == null) {
            hold.priceOneView.setText("Sem Informação");
            hold.priceOneView.setTextColor(Color.BLACK);
            hold.percentsOne.setTextColor(Color.BLACK);
        } else {
            if (c.percent_change_1h >= 0.01) {
                hold.priceOneView.setTextColor(Color.GREEN);
                hold.percentsOne.setTextColor(Color.GREEN);
            } else if (c.percent_change_1h <= -0.01) {
                hold.priceOneView.setTextColor(Color.RED);
                hold.percentsOne.setTextColor(Color.RED);
            }
            hold.priceOneView.setText(String.valueOf(c.percent_change_1h));}
        //AQUI ENCERRA

        //CONDICIONAIS PARA ERROS DE INFO NULAS
        //condicional de erro para preços
        if (c.price_brl == null) {
            hold.priceView.setText("Sem Informação");
        } else {
            hold.priceView.setText((String.valueOf(c.price_brl)));
        }
        //condicional de erro para o nome das moedas
        if (c.name == null) {
            hold.nomeView.setText("Sem Informação");
        } else {
            hold.nomeView.setText(c.name);
        }
        //AQUI ENCERRA

        hold.id.setText(c.id);
        hold.symbol.setText(c.symbol);
        hold.rank.setText(c.rank);
        hold.price_usd.setText(c.price_usd);
        hold.price_btc.setText(c.price_btc);
        hold.twentyVolumUsd.setText(c.twentyHours);
        hold.market_cap_usd.setText(c.market_cap_usd);
        hold.available_supply.setText(c.available_supply);
        hold.total_supply.setText(c.total_supply);
        hold.max_supply.setText(c.max_supply);
        hold.percent_change_7d.setText(String.valueOf(c.percent_change_7d));
        hold.last_updated.setText(c.last_updated);
        hold.twentyVolumBRL.setText(String.valueOf(c.twentyVolum));
        hold.market_cap_brl.setText(String.valueOf(c.market_cap_brl));
        //COMANDO QUE PEGA A POSIÇÃO DAS MOEDAS
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickPosition = (int) view.getTag();
                //Toast.makeText(context, "posicao "+clickPosition,Toast.LENGTH_SHORT).show();
            }});
        //AQUI ENCERRA
    }

    @Override
    public int getItemCount() {
        return coin.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        final TextView id;
        final TextView nomeView;
        final TextView symbol;
        final TextView rank;
        final TextView price_usd;
        final TextView price_btc;
        final TextView twentyVolumUsd;
        final TextView market_cap_usd;
        final TextView available_supply;
        final TextView total_supply;
        final TextView max_supply;
        final TextView priceOneView;
        final TextView priceTwentyView;
        final TextView percent_change_7d;
        final TextView last_updated;
        final TextView priceView;
        final TextView twentyVolumBRL;
        final TextView market_cap_brl;
        final TextView percentsOne;
        final TextView percentsTwenty;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);
            //chamando as referencias do xml coinline
            id = (TextView)v.findViewById(R.id.idCoin);
            nomeView = (TextView) v.findViewById(R.id.coin_answer_view_name);
            symbol = (TextView) v.findViewById(R.id.symbol);
            rank = (TextView) v.findViewById(R.id.rank);
            price_usd = (TextView) v.findViewById(R.id.price_usd);
            price_btc = (TextView) v.findViewById(R.id.price_btc);
            twentyVolumUsd = (TextView) v.findViewById(R.id.twentyVolumUSD);
            market_cap_usd = (TextView) v.findViewById(R.id.market_cap_usd);
            available_supply = (TextView) v.findViewById(R.id.available_supply);
            total_supply = (TextView) v.findViewById(R.id.total_supply);
            max_supply = (TextView) v.findViewById(R.id.max_supply);
            priceOneView = (TextView) v.findViewById(R.id.coin_answer_view_price_one_hour);
            priceTwentyView = (TextView) v.findViewById(R.id.coin_answer_view_price_twenty_four_hours);
            percent_change_7d = (TextView) v.findViewById(R.id.percent_change_7d);
            last_updated = (TextView) v.findViewById(R.id.last_updated);
            priceView = (TextView) v.findViewById(R.id.coin_answer_view_price);
            twentyVolumBRL = (TextView) v.findViewById(R.id.twentyVolumBRL);
            market_cap_brl = (TextView) v.findViewById(R.id.market_cap_brl);

            percentsOne = (TextView) v.findViewById(R.id.coin_percentage_one_hour);
            percentsTwenty = (TextView) v.findViewById(R.id.coin_percentage_twenty_four_hours);
            //aqui termina as refs
        }
        @Override
        public void onClick(View view) {}
        @Override
        public boolean onLongClick(View view) {return false;}
    }

}
