package com.dd.dicdat.servicio.generadorLista;

import java.util.ArrayList;

public class MenorPosible{

    public static int menorPosible(ArrayList<Integer> posiciones, int puntero) {
        return menorPosible(agregar(posiciones, puntero));
    }

    private static int[] agregar(ArrayList<Integer> posiciones, int puntero) {
        int arreglo[];
        arreglo= new int[puntero];
        for (int i=0; i<puntero; i++) {
            arreglo[i]= posiciones.get(i);
        }
        arreglo= ordenar(arreglo);
        return arreglo;
    }

    private static int[] ordenar(int arreglo[]) {
        for (int i=1; i < arreglo.length; i++) {
            int aux = arreglo[i];
            int j;
            for (j=i-1; j>=0 && arreglo[j]>aux; j--){
                arreglo[j+1]=arreglo[j];
            }
            arreglo[j+1]=aux;
        }
        return arreglo;
    }

    private static int menorPosible(int arreglo[]) {
        int menorPosible=0;
        for(int x:arreglo) {
            if (!(menorPosible==x)) {
                break;
            }
            menorPosible++;
        }
        return menorPosible;
    }
}