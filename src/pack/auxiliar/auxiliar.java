
package pack.auxiliar;

import pack.vehiculos.Camion;
import pack.vehiculos.Carga;
import pack.vehiculos.Coche;
import pack.vehiculos.Vehiculo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Carlos Cartes Fernandez
 */
public class auxiliar {

    //classe auxiliar que voy a utilizar para hacer la función pideEntero y utilizarla después en todos los sitios (ahorro código)
    //también utilizo esta clase para dejar el GestionVehiculos (main) completamente limpio.
    
    static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    
    public static int pideEntero(String pregunta){
        //función en la que vamos a obtener un número entero por parte del usuario y nos servirá para futuras funciones
        //aquí tenemos un paramtro String que es pregunta.
        boolean flag = true;
        int num = 0;      
        do{
            try {
                System.out.println (pregunta);
                num = Integer.parseInt (br.readLine());
                flag = false;
            } catch (NumberFormatException e){
                System.out.println ("\033[31mNo has introducido un número adecuado.\033[0m");
            }catch (IOException ex){
                System.out.println ("\033[31mSe ha producido un error: " +ex.getMessage()+ "\033[31m");
            }
        } while(flag);
        return num;
    }
    
    //***********************todas las funciones que vienen del main****************//
    
    //con esta función creamos un coche y lo colocamos dentro de una posición del array de Vehiculos[]
    //recibe como parámetros los posibles vehiculos ya creados.
    public static void crearCoche(Vehiculo [] listaVehiculos){

        //instancio el coche con el constructor vacío
        Coche c1 = new Coche();
        //Hago que el usuario rellene los datos mediante pideDatos que tiene 
        c1.pideDatos();    
        //pedimos al usuario que coloque el nuevo coche en una posición del array
        boolean flag = true;
        //do-while para que no se salga sin colocarlo el vehiculo en una posición correcta
        do{
            try {
                int pos = auxiliar.pideEntero("\033[32mPlaza de parquing donde colocar este vehículo:\033[0m");
                //verificamos si la plaza esta libre o no
                if (listaVehiculos [pos-1] != null){
                    //como está ocupada se lo decimos y le mostramos las plazas ocupadas
                    System.out.println("\033[31mLo siento, esta plaza está ocupada por otro vehículo.\033[0m");
                    cochesActuales(listaVehiculos);
                }else{
                    //como está libre grabamos el vehículo dentro del array en la posicion que nos ha dicho
                    listaVehiculos [pos-1] = c1;
                    System.out.println("\033[35mVehículo guardado satisfactoriamente.\033[0m");
                    flag = false;
                }
            //por si el usuario se sale del array (4 plazas del parquing)
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("\033[31mHas escogido una plaza fuera del rango, las plazas de nuestro parquing van del 1 al 4.\033[0m");
            }
        }while(flag);    
    }
    
    //con esta función creamos una carga y lo colocamos dentro de una posición del array de Vehiculos[]
    //recibe como parámetros los posibles vehiculos ya creados.
    public static void crearCarga(Vehiculo[] listaVehiculos){
        
        //instancio la carga con el constructor vacío
        Carga cg1 = new Carga();
        //Hago que el usuario rellene los datos mediante pideDatos que tiene
        cg1.pideDatos();
        boolean flag = true;
        //do-while para que no se salga sin colocarlo el vehiculo en una posición correcta
        do{
            try {
                int posa = auxiliar.pideEntero("\033[32mPlaza de parquing donde colocar este vehículo:\033[0m");
                //verificamos si la plaza esta libre o no
                if (listaVehiculos [posa-1] != null){
                    //como está ocupada se lo decimos y le mostramos las plazas ocupadas
                    System.out.println("\033[31mLo siento, esta plaza está ocupada por otro vehículo.\033[0m");
                    cochesActuales(listaVehiculos);
                }else{
                    //como está libre grabamos el vehículo dentro del array en la posicion que nos ha dicho
                    listaVehiculos [posa-1] = cg1;
                    System.out.println("\033[35mVehículo guardado satisfactoriamente.\033[0m");
                    flag = false;
                }
            //por si el usuario se sale del array (4 plazas del parquing)
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("\033[31mHas escogido una plaza fuera del rango, las plazas de nuestro parquing van del 1 al 4.\033[0m");
            }
        }while(flag);   
    }
    
    //con esta función creamos un camión y lo colocamos dentro de una posición del array de Vehiculos[]
    //recibe como parámetros los posibles vehiculos ya creados.
    public static void crearCamion(Vehiculo[]listaVehiculos){
        
        //instancio el camión con el constructor vacío
        Camion cm1 = new Camion();
        //Hago que el usuario rellene los datos mediante pideDatos que tiene
        cm1.pideDatos();
        //do-while para que no se salga sin colocarlo el vehiculo en una posición correcta
        boolean flag = true;
        do{
            try {
                int posb = auxiliar.pideEntero("\033[32mPlaza de parquing donde colocar este vehículo:\033[0m");
                //verificamos si la plaza esta libre o no
                if (listaVehiculos [posb-1] != null){
                    //como está ocupada se lo decimos y le mostramos las plazas ocupadas
                    System.out.println("\033[31mLo siento, esta plaza está ocupada por otro vehículo.\033[0m");
                    cochesActuales(listaVehiculos);
                }else{
                    //como está libre grabamos el vehículo dentro del array en la posicion que nos ha dicho
                    listaVehiculos [posb-1] = cm1;
                    System.out.println("\033[35mVehículo guardado satisfactoriamente.\033[0m");
                    flag = false;
                }
            //por si el usuario se sale del array (4 plazas del parquing)
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("\033[31mHas escogido una plaza fuera del rango, las plazas de nuestro parquing van del 1 al 4.\033[0m");
            }
        }while(flag); 
    }
    
    //función que utilizaremos en otras para no tener que repetir código.
    //muestra los vehiculos que hay grabados.
    public static void cochesActuales(Vehiculo[]listaVehiculos){
        System.out.println ("\033[34mEstos son los vehículos actuales en el sistema mostrados por matrícula y en su plaza:\033[0m");
        for (int i=0; i<listaVehiculos.length;i++){
            if(listaVehiculos[i] != null){
                System.out.println("\033[34mNúmero de plaza " +(i+1)+ ": \033[0m" + listaVehiculos[i].getMatricula());
            }
        }
    }
    
    //función que mostrará toda la información dependiendo del tipo de vehiculo seleccionado
    public static void verInfo (Vehiculo[]listaVehiculos){
        
        //esto de aquí es muy cutre pero quiero limitar la entrada si aun no se ha creado ningun coche
        //y no he sabido hacerlo mejor porque si lo hago con un for me saldría cuatro veces la frase no hay ningun vehiculo creado
        if (listaVehiculos[0] == null && listaVehiculos[1] == null && listaVehiculos[2] == null && listaVehiculos[3] == null){
            System.out.println("\033[31mNo hay ningún vehiculo creado todavía.");
        }else{
            //cogemos justo la función anterior
            cochesActuales(listaVehiculos);
            boolean flag = true;
            //do-while para que no se salga hasta escoger un vehiculo correcto
            do{
                try{
                    int ask = auxiliar.pideEntero("\033[32m¿De qué vehículo quieres ver la información?\033[0m");
                    //verificamos si en la plaza hay vehiculo o no
                    if (listaVehiculos[ask-1] != null){
                        //como hay vehiculo lo mostramos
                        listaVehiculos[ask-1].showInformacion();
                        boolean sem = true;
                        //por si quiere ver la info de otro vehiculo sin tener que salir al menú principal
                        //hasta que no escoja Si o NO correctamente le mantenemos dentro
                        do{
                            System.out.println("");
                            int deseo = pideEntero("\033[32m¿Deseas ver la información de algun vehículo más?\n\033[32m1.Si\n2.No\033[0m");
                            switch (deseo){
                                case 1:
                                    sem = false;
                                    break;
                                case 2:
                                    flag = false;
                                    sem =false;
                                    break;
                                default:
                                    System.out.println ("\033[31mNo has escogido SI o No.\033[0m");
                            }
                        }while (sem);
                        //flag = false;
                    //si no hay vehiculo, se lo decimos para que escoja otra plaza
                    }else{
                        System.out.println("\033[34mLo siento, no hay ningún vehículo en esta plaza.\033[0m");
                    }
                //por si el usuario se sale del array (4 plazas del parquing)
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("\033[31mNo existe este número de plaza en nuestro parquing, las plazas van del 1 al 4.\033[0m");
                }
            }while (flag);
        }
    }
    
    //función para modificar los días de alquiler de cualquier vehiculos
    public static void modAlquiler(Vehiculo[]listaVehiculos){
        
        //misma cutrez de antes
        if (listaVehiculos[0] == null && listaVehiculos[1] == null && listaVehiculos[2] == null && listaVehiculos[3] == null){
            System.out.println("\033[31mNo hay ningún vehiculo creado todavía.");
        }else{
            //cogemos la función que nos muestra los vehiculos guardado
            cochesActuales(listaVehiculos);
            boolean flag = true;
            //do-while para que no se salga hasta escoger un vehiculo correcto
            do{
                try{
                    int mod = auxiliar.pideEntero("\033[32m¿De que vehículo quieres modificar los días de alquiler?\033[0m");
                    //verificamos si en la plaza hay vehiculo o no
                    if(listaVehiculos[mod-1] != null){
                        //le mostramos la info actual
                        System.out.println("\033[34mActualmente este vehículo está alquilado por " +listaVehiculos[mod-1].getNumeroDiasAlquilado()+ " días.\033[0m");
                        //le pedimso qu ela modifique
                        int nuevosDias = auxiliar.pideEntero("\033[32mDías de alquiler nuevos:\033[0m");
                        //Grabamos la modificación con el setter
                        listaVehiculos[mod-1].setNumeroDias(nuevosDias);
                        //para que se muestre el símbolo €
                        NumberFormat formatoImporte = NumberFormat.getCurrencyInstance(new Locale("es","ES"));
                        System.out.println("\033[34mEl nuevo coste segun los días introducidos ahora mismo es de:\033[0m "
                                + formatoImporte.format(listaVehiculos[mod-1].getPrecioTotalAlquilerPorDias()))
                                ;
                        flag = false;
                    //si no hay vehiculo, se lo decimos para que escoja otra plaza
                    }else{
                        System.out.println("\033[31mNo hay ningún vehiculo en la plaza de parquing que has escogido.\033[0m");
                    }
                //por si el usuario se sale del array (4 plazas del parquing)
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("\033[31mNo existe este número de plaza en nuestro parquing, las plazas van del 1 al 4.\033[0m");
                }                                           
            }while(flag);
        }
    }
    
    //función que muestra todos los vehiculos guardados en las plazas (array)
    public static void mostrarTodo(Vehiculo[]listaVehiculos){
        
        //misma cutrez de antes
        if (listaVehiculos[0] == null && listaVehiculos[1] == null && listaVehiculos[2] == null && listaVehiculos[3] == null){
            System.out.println("\033[31mNo hay ningún vehiculo creado todavía.");
        }else{
            System.out.println ("\033[34mEstos son todos los vehículos actuales del sistema:\033[0m");
            for (int i=0; i<listaVehiculos.length;i++){
                //utilizo este if por si no estan todas las plazas del parquing ocupado.
                if(listaVehiculos[i] != null){
                    System.out.println("");
                    System.out.println("\033[34mPlaza de parquing número " +(i+1)+ ". \033[0m");
                    listaVehiculos[i].showInformacion();
                }
            }
        }
    }
}
