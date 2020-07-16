package com.company;

import java.net.MalformedURLException;
import java.net.URLConnection;

import java.net.URL;
import java.io.*;
import java.util.Scanner;

import com.alibaba.fastjson.JSONObject;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        StringBuilder json = new StringBuilder();
        try {
//            URL name = new URL("https://restapi.amap.com/v3/ip?ip=114.247.50" +
//                    ".2&output=json&key=b3524cc502a4fc39c0d2a2e5cb97b516");
            URL name = new URL("http://api.map.baidu" +
                    ".com/geocoding/v3/?address=北京市海淀区上地十街10号&output=json&ak" +
                    "=Fv06UYvR1iBm2ZwDcK6LsGT20WcuAl9l");
            URLConnection connection = name.openConnection();
            connection.setDoOutput(true);
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String str;
            while ((str = in.readLine()) != null) {
//                System.out.println(str);
                json.append(str);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        以下为高德
//        System.out.println(json);
//        JSONObject jsonObject = JSONObject.parseObject(String.valueOf(json));
//        System.out.println(jsonObject.get("province"));
//        String City = jsonObject.get("province").toString();
//        System.out.println(City);

//        以下为百度
//        System.out.println(json);
        JSONObject jsonObject=JSONObject.parseObject(String.valueOf(json));
//        System.out.println(jsonObject.get("result"));
        JSONObject result = jsonObject.getJSONObject("result");
//        System.out.println(result);
        JSONObject location=result.getJSONObject("location");
//        System.out.println(location);
        String Location=
                location.get("lng").toString()+","+location.get("lat").toString();
        System.out.println(Location);
    }
}
