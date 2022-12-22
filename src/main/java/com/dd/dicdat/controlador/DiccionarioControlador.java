package com.dd.dicdat.controlador;

import com.dd.dicdat.servicio.DiccionarioServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/diccionario")
public class DiccionarioControlador {

    private final DiccionarioServicio diccionarioServicio;

    public DiccionarioControlador(DiccionarioServicio diccionarioServicio) {
        this.diccionarioServicio = diccionarioServicio;
    }
    @PostMapping("/{numC}/{minC}/{palabraInicio}")
    public ResponseEntity<String[]> createAutomovil(@RequestBody String[] listaPalabras, @PathVariable("numC") int numCombinaciones,@PathVariable("minC") int minCombinaciones, @PathVariable("palabraInicio") String palabraInicio) {
        String[] newListaPalabras=diccionarioServicio.agregarParametros(listaPalabras, numCombinaciones,minCombinaciones, palabraInicio);
        return new ResponseEntity<String[]>(newListaPalabras, HttpStatus.CREATED);
    }

    @PostMapping("/{numC}/{minC}")
    public ResponseEntity<String[]> createAutomovil(@RequestBody String[] listaPalabras, @PathVariable("numC") int numCombinaciones, @PathVariable("minC") int minCombinaciones) {
        String[] newListaPalabras=diccionarioServicio.agregarParametros(listaPalabras, numCombinaciones,minCombinaciones,"");
        return new ResponseEntity<String[]>(newListaPalabras, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<String>> retornarDiccionario(){

        List<String> dicccionarioDatos = diccionarioServicio.getdiccionario();
        diccionarioServicio.reiniciarDiccionario();
        return new ResponseEntity<List<String>>(dicccionarioDatos, HttpStatus.OK);
    }


}
