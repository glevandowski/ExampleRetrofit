package gustavo.levandowski.exampleretrofit;

import com.google.gson.annotations.SerializedName;

public class Coin {
            public String id;
            public String name;
            public String symbol;
            public String rank;
            public String price_usd;
            public String price_btc;

            @SerializedName("24h_volume_usd")
            public String twentyHours;
            public String market_cap_usd;
            public String available_supply;
            public String total_supply;
            public String max_supply;
            public Double percent_change_1h;
            public Double percent_change_24h;
            public Double percent_change_7d;
            public String last_updated;
            public Double price_brl;

            @SerializedName("24h_volume_brl")
            public Double twentyVolum;
            public Double market_cap_brl;


    public Coin(String id, String name, String symbol, String rank, String price_usd, String price_btc, String twentyHours, String market_cap_usd, String available_supply, String total_supply, String max_supply, Double percent_change_1h, Double percent_change_24h, Double percent_change_7d, String last_updated, Double price_brl, Double twentyVolum, Double market_cap_brl) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.price_usd = price_usd;
        this.price_btc = price_btc;
        this.twentyHours = twentyHours;
        this.market_cap_usd = market_cap_usd;
        this.available_supply = available_supply;
        this.total_supply = total_supply;
        this.max_supply = max_supply;
        this.percent_change_1h = percent_change_1h;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_7d = percent_change_7d;
        this.last_updated = last_updated;
        this.price_brl = price_brl;
        this.twentyVolum = twentyVolum;
        this.market_cap_brl = market_cap_brl;
    }
}
