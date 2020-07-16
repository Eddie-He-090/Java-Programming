package com.company;

import java.io.*;

public class Main {

    public String location0;
    geocoding main0= new geocoding();

    public void Setlocation() throws IOException {
        main0.geocoding();
        location0=main0.location;
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        Main location1=new Main();
        Main location2=new Main();
        System.out.println("请输入location1地点");
        location1.Setlocation();
        System.out.println("location1的经纬坐标为"+location1.location0);
        System.out.println("请输入location2地点");
        location2.Setlocation();
        System.out.println("location2的经纬坐标为"+location2.location0);
    }
}
