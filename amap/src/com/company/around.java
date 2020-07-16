package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class around {
    public String location;
    public String keywords;

    public String name;
    public String type;
    public String address;
    public String pname;
    public String cityname;
    public String adname;

    public void Do_around() throws IOException {
        final StringBuilder json = new StringBuilder();
        final URL name = new URL("https://restapi.amap.com/v3/place/around?key=b3524cc502a4fc39c0d2a2e5cb97b516&location" +
                "="+this.location+"&keywords="+this.keywords+"&types=&radius" +
                "=&offset=&page" +
                "=&extensions=all");
//        URL name = new URL("https://restapi.amap.com/v3/direction/transit/integrated" +
//                "?key=b3524cc502a4fc39c0d2a2e5cb97b516&origin=116.481028,39" +
//                ".989643&destination=116.434446,39" +
//                ".90816&city=北京&cityd=北京&strategy=0&nightflag=0");
        final URLConnection connection = name.openConnection();
        connection.setDoOutput(true);
        final BufferedReader in =
                new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String str;
        while ((str = in.readLine()) != null) {
            json.append(str);
        }
        in.close();

        final JSONObject jsonObject = JSONObject.parseObject(String.valueOf(json));
        final JSONArray pois = jsonObject.getJSONArray("pois");
        final JSONObject temp0 = pois.getJSONObject(Integer.parseInt("0"));
        this.name = temp0.get("name").toString();
        this.type = temp0.get("type").toString();
        this.address=temp0.get("address").toString();
        this.pname=temp0.get("pname").toString();
        this.cityname=temp0.get("cityname").toString();
        this.adname=temp0.get("adname").toString();
    }
}