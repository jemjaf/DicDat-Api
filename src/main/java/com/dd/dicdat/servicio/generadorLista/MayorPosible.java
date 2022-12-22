package com.dd.dicdat.servicio.generadorLista;

import java.util.ArrayList;

public class MayorPosible{

    public static int mayorPosible(ArrayList<Integer> posiciones, int puntero) {
        int[] arreglo=agregar(posiciones, puntero);
        int mayorValorArreglo=arreglo[puntero];
        return mayorPosible(arreglo, posiciones.size()-1, posiciones.get(puntero), mayorValorArreglo);

    }

    private static int[] agregar(ArrayList<Integer> posiciones, int puntero) {
        int arreglo[];
        arreglo= new int[puntero+1];
        for (int i=0; i<=puntero; i++) {
            arreglo[i]= posiciones.get(i);
        }
        arreglo= ordenar(arreglo);
        return arreglo;
    }

    private static int[] ordenar(int arreglo[]) {
        for (int i=1; i<arreglo.length; i++) {
            int aux = arreglo[i];
            int j;
            for (j=i-1; j>=0 && arreglo[j]>aux; j--){
                arreglo[j+1]=arreglo[j];
            }
            arreglo[j+1]=aux;
        }
        return arreglo;
    }

    private static int mayorPosible(int arreglo[], int mayor, int valorActual, int mayorArreglo) {
        int mayorActual=-1;
        boolean bandera=false;
        for(int x=1 ;x<arreglo.length; x++) {
            if (arreglo[x]-1!=arreglo[x-1]) {
                for (int i=arreglo[x-1]+1; i < arreglo[x]; i++) {
                    if(i>valorActual) {
                        bandera=true;
                        mayorActual=i;
                        break;
                    }
                }
                if (bandera) {
                    break;
                }
            }
        }
        if(!bandera && mayorArreglo+1<=mayor && valorActual+1<=mayor) {
            if(valorActual>mayorArreglo) {
                mayorActual=valorActual+1;
            }else {
                mayorActual=mayorArreglo+1;
            }
        }
        return mayorActual;
    }

}