
package listacircular;

import javax.swing.JOptionPane;


public class ListaC {
    NodoC ultimo;
    public ListaC(){
        ultimo = null;
    }
    
    //Metodo para saber cuando la lista esta vacia
    public boolean estaVacia(){
        return ultimo == null;
    }
    
    //Metodo para insertar nodos
    public ListaC insertar(int elemento){
        NodoC nuevo = new NodoC(elemento);
        if(ultimo != null){
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
        }
        ultimo = nuevo;
        return this;
    }
    
    //Metodo para mostrar la lista
    public void mostrarLista(){
        NodoC auxiliar = ultimo.siguiente;
        String cadena = "";
        do{
            cadena = cadena + "[" + auxiliar.dato + "]-->";
            auxiliar =auxiliar.siguiente;
        }while(auxiliar != ultimo.siguiente);
        JOptionPane.showMessageDialog(null, cadena, "Mostrando la lista circular",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Metodo para eliminar un nodo de la lista
    public boolean eliminar (int elemento){
        NodoC actual;
        boolean encontrado = false;
        actual = ultimo;
        
        while(actual.siguiente != ultimo && !encontrado){
            encontrado = (actual.siguiente.dato == elemento);
            if(!encontrado){
                actual = actual.siguiente;
            }
        }
        encontrado = (actual.siguiente.dato == elemento);
        if(encontrado){
            NodoC auxiliar = actual.siguiente;
            if(ultimo == ultimo.siguiente){
                ultimo = null;
            }else{
                if(auxiliar == ultimo){
                        ultimo = actual;
                }
                actual.siguiente = auxiliar.siguiente;
            }
            auxiliar = null;
        }
        return encontrado == true;
    }
}
