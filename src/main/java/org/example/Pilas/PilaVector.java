package org.example.Pilas;

import java.util.ArrayList;
import java.util.List;

public class PilaVector {
    private static final int INICIAL = 49; //tamaño maximo de la pila
    private int cima; //posicion del elemento en la cima
    private List<Object> listaPila; //array que almacena los elementos de la pila

    public PilaVector (){
        cima = -1;
        listaPila = new ArrayList<>(INICIAL);
    }
    public void insertar(Object elemento) throws Exception {
        cima++;
        listaPila.add(elemento);
    }

    public Object quitar() throws Exception {
        Object aux;
        if (pilaVacia()){
            throw new Exception("Pila vacia (Underflow");
        }
        aux = listaPila.remove(cima);
        cima --;
        return aux;
    }
    public boolean pilaVacia() {
        return cima == -1;
    }


    public boolean pilaLlena(){
        return cima == INICIAL -1;

    }

    public void limpiarPila() throws Exception {
       while(!pilaVacia()) quitar();
//ani
    }

}

