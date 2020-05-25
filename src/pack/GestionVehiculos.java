
package pack;

import pack.auxiliar.auxiliar;
import pack.vehiculos.Vehiculo;

/**
 *
 * @author Carlos Cartes Fernandez
 */
public class GestionVehiculos {

    public static void main(String[] args) {
        
        Vehiculo[] listaVehiculos = new Vehiculo [4];
   
        int opt;
        do{
            System.out.println("");
            System.out.println("\033[34m**************************************************");
            System.out.println("\033[34m1. Crear un nuevo coche");
            System.out.println("\033[34m2. Crear una nueva carga");
            System.out.println("\033[34m3. Crear un nuevo camión");
            System.out.println("\033[34m4. Ver información de cualquier vehículo");
            System.out.println("\033[34m5. Modificar los días de alquiler");
            System.out.println("\033[34m6. Mostrar todo");
            System.out.println("\033[34m7. Salir");
            System.out.println("**************************************************\033[0m");
            opt = auxiliar.pideEntero ("\033[32mEscoge una opción del programa, por favor\033[0m");
            switch (opt){
                case 1:
                    auxiliar.crearCoche(listaVehiculos);            
                    break;
                case 2:
                    auxiliar.crearCarga(listaVehiculos);
                    break;
                case 3:
                    auxiliar.crearCamion(listaVehiculos);
                    break;
                case 4:
                    auxiliar.verInfo(listaVehiculos);
                    break;
                case 5:
                    auxiliar.modAlquiler(listaVehiculos);              
                    break;
                case 6:
                    auxiliar.mostrarTodo(listaVehiculos);
                    break;
                case 7:
                    System.out.println("\033[45;30mHas decidido salir del programa, hasta la próxima!\033[0m");
                    break;
                default:
                    System.out.println("\033[31mNo has escogido una opción del menú. Escoge del 1 al 6, o el 7 si quieres salir.\033[0m");
            }        
        }while (opt != 7);
    }  
}
