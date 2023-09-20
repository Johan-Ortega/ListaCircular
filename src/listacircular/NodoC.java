
package listacircular;

public class NodoC {
    int dato;
    NodoC siguiente;
    
    //Constructor 
    public NodoC(int d){
        dato = d;
        siguiente = this;
    }
}
