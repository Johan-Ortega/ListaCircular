package listacircular;

import javax.swing.JOptionPane;

public class ListaCircular {

    public static void main(String[] args) {
        ListaC lista = new ListaC();
        int opcion = 0, elemento;
        boolean eliminado = false;
        
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar un nodo a la lista circular\n"
                        + "2. Eliminar un nodo de la lista circular\n"
                        + "3. Mostrar los datos de la lista circular\n"
                        + "4. Salir\n"
                        + "¿Qué deseas hacer?", "Menú de opciones",
                        JOptionPane.INFORMATION_MESSAGE));

                switch (opcion) {
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento del nodo", "Agregando Nodo a la lista circular",
                                JOptionPane.INFORMATION_MESSAGE));
                        lista.insertar(elemento);
                        break;

                    case 2:
                        if(!lista.estaVacia()){
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el elemento del nodo a eliminar", "Eliminando nodo de la lista circular",
                                    JOptionPane.INFORMATION_MESSAGE));
                            
                            eliminado = lista.eliminar(elemento);
                            
                            if(eliminado){
                                JOptionPane.showMessageDialog(null, "El elemento eliminado es " + elemento,
                                        "Eliminando nodos", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "El elemento " + elemento + " no esta en la lista",
                                        "Elemento no encontrado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Aun no hay nodos",
                                "Lista vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 3:
                        if(!lista.estaVacia()){
                            lista.mostrarLista();
                        }else{
                            JOptionPane.showMessageDialog(null, "Aun no hay nodos",
                                "Lista vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 4:
                        JOptionPane.showMessageDialog(null, "Aplicacion finalizada",
                                "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "La opcion no esta en el menú",
                                "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception n) {
                JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
            }
        } while (opcion != 4);
    }
}
