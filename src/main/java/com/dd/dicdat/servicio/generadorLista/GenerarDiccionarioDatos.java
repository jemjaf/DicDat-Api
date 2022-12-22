package com.dd.dicdat.servicio.generadorLista;

import java.util.ArrayList;

public class GenerarDiccionarioDatos {

    private GenListaMezclada listaMezclada;
    private ArrayList<String> diccionario;
    private String palabraInicio;
    private int minCombinaciones;

    public GenerarDiccionarioDatos(String[] lista, int numCombinaciones, int minCombinaciones, String palabraInicio){
        this.listaMezclada = new GenListaMezclada(lista, numCombinaciones, minCombinaciones, palabraInicio);
        this.palabraInicio = palabraInicio;
        this.minCombinaciones= minCombinaciones;
        diccionario= new ArrayList<String>();
    }

    private void completarDiccionario(){
        ArrayList<ArrayList<String>> listaListas = listaMezclada.getlistaMezclada();

        for (ArrayList<String> lista: listaListas) {
            ManejoPosiciones manejoPosiciones= new ManejoPosiciones(lista, this.palabraInicio);
            this.diccionario.add(manejoPosiciones.getDiccionarioParcial());
        }
    }

    public ArrayList<String> getDiccionarioCompleto(){
        if(minCombinaciones<2){
            this.diccionario.addAll(listaMezclada.getPrimosLista());
        }
        this.completarDiccionario();
        return this.diccionario;
    }

}
