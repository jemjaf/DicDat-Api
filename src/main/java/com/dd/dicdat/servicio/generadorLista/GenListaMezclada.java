package com.dd.dicdat.servicio.generadorLista;


import java.util.ArrayList;
public class GenListaMezclada {

    private ArrayList<ArrayList<String>> listaMezclada;
    private ArrayList<String> primerosLista;
    private String[] lista;
    private ArrayList<ArrayList<Integer>> cadenaElegidos;
    private int tam, numCombinaciones, minCombinaciones;
    private String palabraInicio;


    public GenListaMezclada(String[] lista, int numCombinaciones, int minCombinaciones, String palabraInicio) {
        this.cadenaElegidos = new ArrayList<ArrayList<Integer>>();
        this.listaMezclada = new ArrayList<ArrayList<String>>();
        this.primerosLista = new ArrayList<String>();
        this.palabraInicio = palabraInicio;
        this.lista = lista;
        this.tam=lista.length;
        this.numCombinaciones = numCombinaciones;
        this.minCombinaciones = minCombinaciones;

        if(this.numCombinaciones<this.minCombinaciones){
            this.minCombinaciones=this.numCombinaciones;
        }

    }



    private void combinar() {

        ArrayList<ArrayList<Integer>> cadena_1= new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> cadena_local= new ArrayList<ArrayList<Integer>> ();

        for (int i = 0; i < tam; i++) {
            ArrayList<Integer> numI= new ArrayList<Integer>();
            numI.add(i);
            cadena_local.add(numI);
        }

        while (this.numCombinaciones-1>0) {
            for(int y=0; y<this.tam; y++) {
                this.eliminarRepetidos(cadena_local, y);
                for (int x=0; x<cadena_local.size(); x++) {
                    ArrayList<Integer> cadenaPuntual= new ArrayList<Integer>();
                    cadenaPuntual.add(y);
                    cadenaPuntual.addAll(cadena_local.get(x));
                    cadena_1.add(cadenaPuntual);
                }
            }
            cadena_local = cadena_1;
            this.cadenaElegidos.addAll(cadena_1);
            cadena_1= new ArrayList<ArrayList<Integer>>();
            this.numCombinaciones--;
        }
    }


    private void eliminarRepetidos(ArrayList<ArrayList<Integer>> cadenas, int repetido) {
        while (cadenas.size()>0) {
            if(cadenas.get(0).contains(repetido)) {
                cadenas.remove(0);
            }else {
                break;
            }
        }
    }

    public ArrayList<String> getPrimosLista(){
        for(String palabra: lista){
            primerosLista.add(this.palabraInicio + palabra+"\n");
        }
        return this.primerosLista;
    }


    private void eliminarElementosMenores() {
        while(true) {
            if(listaMezclada.get(0).size()< this.minCombinaciones ) {
                this.listaMezclada.remove(0);
            }else {
                break;
            }
        }
    }

    public ArrayList<ArrayList<String>> getlistaMezclada(){

        this.combinar();

        for (ArrayList<Integer> enteros : cadenaElegidos) {
            ArrayList<String> listaPalabras = new ArrayList<String>();
            for (int e: enteros) {
                listaPalabras.add(lista[e]);
            }
            listaMezclada.add(listaPalabras);
        }

        this.eliminarElementosMenores();
        return listaMezclada;
    }
}