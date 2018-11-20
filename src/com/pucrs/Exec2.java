package com.pucrs;



public class Exec2 {

    public static int[][] matrizAcc;
    public static int Ope = 0;

    public static void main(String[] args) {

        int p[] = {10, 12, 25, 30, 40};
        int u[] = {10, 15, 17, 30, 35};
        int m[] = {10, 20 , 30 , 40 , 50};

        for(int i =0; i< m.length; i++) {
            System.out.println("M: " + m[i]);
            System.out.println("Result: " + mochilaBruta(p, u, p.length-1, m[i]));
            System.out.println("Iterações: " + Ope);
            Ope = 0;
        }

        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");

        for(int i =0; i< m.length; i++) {
            System.out.println("M: " + m[i]);
            mochilaDinamica(p, u, p.length-1, m[i]);
            for (int j = 0; j< matrizAcc.length; j++){
                for (int k = 0; k< matrizAcc[0].length; k++){
                    System.out.print(matrizAcc[j][k]+" ");
                }
                System.out.print("\n");
            }
            System.out.println("Iterações: " + Ope);
            Ope = 0;
        }

    }

    public static int mochilaBruta(int [] p, int [] u, int n, int M){
        Ope++;
        if(n == -1)
            return 0;
        else {
            int A = mochilaBruta(p, u, n-1, M);
            if (p[n] > M)
                return A;
            else {
                int B = u[n] + mochilaBruta(p, u, n-1, M-p[n]);
                return Math.max(A, B);
            }
        }
    }

    public static void mochilaDinamica(int [] p, int [] u, int n, int M) {
        matrizAcc = new int[n][M];
        mochilaDinamicaRec(p, u, n, M);
    }

    public static void mochilaDinamicaRec(int [] p, int [] u, int n, int M){

        int B;
        for(int b = 0; b < M; b++){
            matrizAcc[0][b] = 0;
            for(int i = 1; i< n; i++){
                Ope++;
                int A = matrizAcc[i-1][b];
                if(p[i]>b){
                    B = 0;
                }else{
                    B = matrizAcc[i-1][b-p[i]] + u[i];
                }
                matrizAcc[i][b] = Math.max(A,B);
            }
        }
    }

}
