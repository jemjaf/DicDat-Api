package com.dd.dicdat.servicio.generadorLista;

import java.util.ArrayList;

public class ManejoPosiciones {

    private ArrayList<String> listaPalabras;
    private ArrayList<Integer> posiciones;
    private ArrayList<Integer> posiciones2;
    private String palabraInicio;
    private String diccionarioParcial;

    private int puntero;


    public ManejoPosiciones(ArrayList<String> listaPalabras, String palabraInicio) {
        this.listaPalabras=listaPalabras;
        this.palabraInicio= palabraInicio;
        this.iniciarPosiciones(this.listaPalabras);
        posiciones2=new ArrayList<Integer>(posiciones);
        puntero=posiciones.size()-3;
        this.diccionarioParcial= "";
    }

    public void agregarPalabra (ArrayList<Integer> orden){
        String mezcla=this.palabraInicio;
        for (Integer i:orden) {
            mezcla+=listaPalabras.get(i);
        }
        diccionarioParcial+=mezcla+"\n";
    }


    private void iniciarPosiciones(ArrayList<String> listaPalabras) {
        posiciones= new ArrayList<Integer>();
        for (int x=0; x<listaPalabras.size(); x++) {
            posiciones.add(x);
        }
    }

    private void ajustarPosicion(int x, int y) {
        posiciones.remove(puntero+1);
        posiciones.remove(puntero+1);
        posiciones.add(x);
        posiciones.add(y);
    }


    private void posicionPuntual() throws IndexOutOfBoundsException {
        int punto=puntero;
        boolean banderaAnterior=false;
        ArrayList<Integer> auxiliarPosiciones=new ArrayList<Integer>(posiciones2);
        //---------------------------------------------------------------------------
        for (int i=0; i<=puntero; i++) {
            auxiliarPosiciones.remove(posiciones.get(i));
        }
        this.ajustarPosicion(auxiliarPosiciones.get(0), auxiliarPosiciones.get(1));
        this.agregarPalabra(posiciones);
        this.ajustarPosicion(auxiliarPosiciones.get(1), auxiliarPosiciones.get(0));
        this.agregarPalabra(posiciones);
        //-------------------------------------------------------------------------------

        do {
            if (!banderaAnterior) {
                int valorMayor= MayorPosible.mayorPosible(posiciones, punto);
                if (valorMayor>=0) {
                    posiciones.remove(punto);
                    posiciones.add(punto, valorMayor);
                    punto++;
                    banderaAnterior=true;
                }else {
                    punto--;
                }
            }else {
                int valorMenor= MenorPosible.menorPosible(posiciones, punto);
                posiciones.remove(punto);
                posiciones.add(punto, valorMenor);
                punto++;
            }
        } while (punto<=puntero);
    }

    private void rellenarDiccionario(){
        while (true) {
            try {
                this.posicionPuntual();
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
    }

    public String getDiccionarioParcial(){
        this.rellenarDiccionario();
        return this.diccionarioParcial;
    }

}