package com.dd.dicdat.servicio;


import com.dd.dicdat.servicio.generadorLista.GenerarDiccionarioDatos;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DiccionarioServicio {

    private GenerarDiccionarioDatos generarDiccionarioDatos;
    public DiccionarioServicio (){

    }

    public String[] agregarParametros(String[] listaPalabras, int numCombinaciones, int minCombinaciones, String palabraInicio){
        generarDiccionarioDatos= new GenerarDiccionarioDatos(listaPalabras, numCombinaciones, minCombinaciones, palabraInicio);
        return listaPalabras;
    }

    public ArrayList<String> getdiccionario(){
        return generarDiccionarioDatos.getDiccionarioCompleto();
    }

    public void reiniciarDiccionario(){
        generarDiccionarioDatos= null;
    }

}
