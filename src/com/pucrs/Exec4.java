package com.pucrs;

import java.util.Scanner;

public class Exec4 {

    public static void main(String[] args) {

        String tabuleiro[][];
        int tamanho = 4;

        tabuleiro = new String[tamanho][tamanho];

        inserirRainhas(tabuleiro, tamanho, 0);

    }

    public static void inserirRainhas(String tabuleiro[][], int tamanho, int col) {
        if (col == tamanho) {
            System.out.println("----------------------------------------------------------------------");
            exibir(tabuleiro, tamanho);
            return;
        }

        for (int i = 0; i < tamanho; i++) {
            if(permite(tabuleiro, tamanho, i, col)) {
                tabuleiro[i][col] = "Q";
                inserirRainhas(tabuleiro, tamanho, col + 1);
                tabuleiro[i][col] = "_";
            }
        }
    }

    public static boolean permite(String tabuleiro[][], int tamanho, int lin, int col) {
        for (int i = 0; i < tamanho; i++) {
            if (tabuleiro[lin][i] == "Q") { return false; }
        }

        for (int i = 0; i < tamanho; i++) {
            if (tabuleiro[i][col] == "Q") { return false; }
        }

        for (int i = lin, j = col; i >= 0 && j >= 0; i--, j--) {
            if(tabuleiro[i][j] == "Q") { return false; }
        }

        for (int i = lin, j = col; i < tamanho && j < tamanho; i++, j++) {
            if(tabuleiro[i][j] == "Q") { return false; }
        }

        for (int i = lin, j = col; i >= 0 && j < tamanho; i--, j++) {
            if(tabuleiro[i][j] == "Q") { return false; }
        }

        for (int i = lin, j = col; i < tamanho && j >= 0; i++, j--) {
            if(tabuleiro[i][j] == "Q") { return false; }
        }

        return true;
    }

    public static void exibir(String tabuleiro[][], int tamanho) {
        System.out.println();

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiro[i][j] == null) { tabuleiro[i][j] = "_"; }
                System.out.print(tabuleiro[i][j] + "   ");
            }

            System.out.println("\n");
        }
    }
}
