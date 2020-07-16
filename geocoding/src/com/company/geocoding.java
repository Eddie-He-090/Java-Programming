package com.company;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class geocoding {
    public String location;

    public void geocoding() throws IOException {
        StringBuilder json = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();
        URL name =
                new URL("http://api.map.baidu.com/geocoding/v3/?address=" + temp +
                        "&output=json&ak=Fv06UYvR1iBm2ZwDcK6LsGT20WcuAl9l&callback");
        URLConnection connection = name.openConnection();
        connection.setDoOutput(true);
        BufferedReader in =
                new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String str;
        while ((str = in.readLine()) != null) {
            json.append(str);
        }
        in.close();
        JSONObject jsonObject=JSONObject.parseObject(String.valueOf(json));
        JSONObject result = jsonObject.getJSONObject("result");
        JSONObject location=result.getJSONObject("location");
        String Location=
                location.get("lng").toString()+","+location.get("lat").toString();
        this.location = Location;
    }
}
