/*
Alumno:Contreras Eduardo Federico
*/
package TP2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
class Nodo {
    //Clase Nodo
    int valor;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int valor) {
        //Constructor de la clase Nodo
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}

public class TP2BusquedaExhaustivaBFS {
    public static void bfs(Nodo raiz, int puntoA) {
        //Metodo primero en anchura
        //Este metodo recibe dos parametros donde el primero es la raiz seleccionada en el metodo main
        //y el segundo es el punto final que debemos encontrar, este se genera a partir del metodo random
        //el mismo se encuentra entre la cantidad de nodos totales del arbol
        if (raiz == null) {
            return;
        }

        Queue<Nodo> cola = new LinkedList<>(); //utilizamos una cola para resolver la busqueda
        cola.add(raiz);
        int cont=0; //variable donde vamos a almacenar la posicion donde se encontro el punto final A.
        int tamañoCola=-1;
        int puntoFinal=-1; //variable donde vamos a encontrar el valor del nodo final encontrado.
        while (!cola.isEmpty()) {
            int size = cola.size();
            
            for (int i = 0; i < size; i++) {
                tamañoCola++;
                Nodo nodo = cola.poll();
                if(nodo.valor==puntoA){
                    cont = tamañoCola;
                    puntoFinal=nodo.valor;                    
                }            
                
                System.out.print(nodo.valor+" ");
                if (nodo.izquierdo != null) {
                    cola.add(nodo.izquierdo);
                }

                if (nodo.derecho != null) {
                    cola.add(nodo.derecho);
                }
            }            
        }
        System.out.println("");
        System.out.println("El brazo mecanico encontró el punto A luego de "+ cont +" movimientos");
        //mostramos por pantalla en que posicion encontramos el punto A
        System.out.println("El punto final se encuentra en el nodo B"+ cont);
            
    }

    public static void main(String[] args) {
        // Creamos un arbol de ejemplo según nuestro caso
        //los nodos izquierdos son menores a la raiz
        //los nodos derechos son mayores a la raiz
        Nodo raiz = new Nodo(7);
        raiz.izquierdo = new Nodo(6);
        raiz.derecho = new Nodo(8);
        raiz.izquierdo.izquierdo = new Nodo(5);
        raiz.derecho.derecho = new Nodo(9);
        raiz.izquierdo.izquierdo.izquierdo = new Nodo(4);
        raiz.derecho.derecho.derecho = new Nodo(10);
        raiz.izquierdo.izquierdo.izquierdo.izquierdo = new Nodo(3);
        raiz.izquierdo.izquierdo.izquierdo.izquierdo.izquierdo = new Nodo(2);
        raiz.izquierdo.izquierdo.izquierdo.izquierdo.izquierdo.izquierdo = new Nodo(1);        
        
        Random random = new Random();
        int numeroAleatorioPuntoA = random.nextInt(9) + 1;
        System.out.println("Punto Final A: " + numeroAleatorioPuntoA);
        //la posición del punto A en coordenadas (numeroAleatorioPuntoA, 0) ya que el tp explica
        //que la posicion varia en el eje X y el punto Y es igual a cero
        // Realizar la búsqueda en anchura
        System.out.println("Recorrido BFS:");
        bfs(raiz, numeroAleatorioPuntoA);
    }
}