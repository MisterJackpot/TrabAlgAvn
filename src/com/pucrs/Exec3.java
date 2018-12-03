package com.pucrs;

import java.util.ArrayList;

public class Exec3 {

    public static void main(String[] args) {
        ArrayList<Integer> s = new ArrayList<>();
        ArrayList<Integer> f = new ArrayList<>();
        int[] x = {2,4,1,6,4,6,7,9,9,3,13};
        int[] y = {4,5,6,7,8,9,10,11,12,13,14};
        for(int i =0; i<x.length;i++){
            s.add(x[i]);
            f.add(y[i]);
        }
        System.out.println(sdmGuloso(s,f,s.size()-1));
        System.out.println(sdmGuloso2(s,f,s.size()-1));
    }

    public static ArrayList<Integer> sdmGuloso(ArrayList<Integer> s, ArrayList<Integer> f, int n){
        ArrayList<Integer> X = new ArrayList<>();
        int i = 1;
        int k;
        while(i<=n){
            X.add(i);
            k = i + 1;
            while(k <= n && s.get(k) < f.get(i)){
                k++;
            }
            i = k;
        }
        return X;
    }

    public static ArrayList<Integer> sdmGuloso2(ArrayList<Integer> s, ArrayList<Integer> f, int n){
        f.remove(0);
        f.add(0,Integer.MIN_VALUE);
        ArrayList<Integer> X = new ArrayList<>();
        int i = 0;
        for(int k = 1; k <= n; k++){
            if(s.get(k) > f.get(i)){
                X.add(k);
                i = k;
            }
        }
        return X;
    }
}
