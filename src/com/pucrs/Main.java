package com.pucrs;

public class Main {

    public static int count = 0;
    public static int f[] = new int[60];

    public static void main(String[] args) {
        int n[] = {2, 4, 8, 16, 20, 24, 28};

        for (int i = 0; i < n.length; i++) {
            System.out.println("Result: " + pow1(2, n[i]));
        }

        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");

        for (int i = 0; i < n.length; i++) {
            System.out.println("\nN: " + n[i]);
            System.out.println("Result: " + pow2(2, n[i]));
            System.out.println("Iterações: " + count);
            count = 0;
        }

        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        for (int i = 0; i < n.length; i++) {
            System.out.println("\nN: " + n[i]);
            System.out.println("Result: " + fib(n[i]));
            System.out.println("Iterações: " + count);
            count = 0;
        }
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        for (int i = 0; i < n.length; i++) {
            System.out.println("\nN: " + n[i]);
            System.out.println("Result: " + memoizedFibo(f,n[i]));
            System.out.println("Iterações: " + count);
            count = 0;
        }

    }

    // O(n)
    public static int pow1(int a, int n) {

        int p = 1;
        System.out.println("N: " + n);
        for (int i = 0; i < n; i++) {
            count++;
            p = p * a;
        }
        System.out.println("Iterações: " + count);
        count = 0;
        return p;

    }

    // O(?)
    public static int pow2(int a, int n) {
        count++;
        if (n == 0)

            return 1;

        if (n % 2 == 0)

            return pow2(a,n/2) * pow2(a,n/2);

        else

            return pow2(a,(n-1)/2) * pow2(a,(n-1)/2) * a;

    }

    // O(?)
    public static int fib(int n){
        count++;
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        return fib(n-1) + fib(n-2);
    }

    public static int memoizedFibo(int[] f, int n){
        for(int i = 0; i<=n; i++){
            f[i] = -1;
        }

        return lookupFibo(f,n);
    }

    // O(?)
    public static int lookupFibo(int[] f, int n){
        count++;
        if(f[n] >= 0) return f[n];
        if(n <= 1) {
            f[n] = n;
        }else{
            f[n] = lookupFibo(f,n-1) + lookupFibo(f,n-2);
        }
        return f[n];
    }


}
