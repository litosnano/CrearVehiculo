
package pack.vehiculos;

import pack.auxiliar.auxiliar;

/**
 *
 * @author Carlos Cartes Fernandez
 */
public class Carga extends Vehiculo{

    //atributos de Carga
    private int PMA = 0;

    //constructor Carga con los atributos heredados de Vehiculo y los suyos propios
    public Carga(String matricula, String modelo, int numeroPlazas, int numeroDiasAlquilado, double precioBaseAlquilerXDia, int PMA) {
        super(matricula, modelo, numeroPlazas, numeroDiasAlquilado, precioBaseAlquilerXDia);
        this.PMA = PMA;
    }

    //constrctor vacio
    public Carga() {
    }

    //*****getters y setters de Carga*****//
    
    public int getPMA() {
        return PMA;
    }

    public void setPMA(int PMA) {
        this.PMA = PMA;
    }
    
    //*****funciones que se nos piden*****//
    
    //función que sobreescribe a la de Vehiculo con los datos de Carga para obtener el precio total
    @Override
    public double getPrecioTotalAlquilerPorDias(){
        double precioTotalAlquiler = super.getPrecioTotalAlquilerPorDias()+(20*getPMA());
        return precioTotalAlquiler;
    }
    
    //función que sobreescribe Vehiculo pero cogiendo los datos de Vehiculo y añadiendo los de Carga
    //finalmente se muestran todos los datos de Carga, parte viniendo de Vehiculo
    @Override
    public void showInformacion(){
        super.showInformacion();
        System.out.printf("%-30s%-30s\n","PMA: ","" + getPMA()+ " toneladas.");
    }

    //función que sobreescribe Vehiculo pero cogiendo los datos de Vehiculo y añadiendo los de Carga
    //los de carga los hacemos en otra función para que se puedan tocar individualmente en un futuro
    @Override
    public void pideDatos(){
        super.pideDatos();
        generarPMA();
    }
    
    //función que utilizaremos en pideDatos 
    //se pide al usuario introducir la carga y se revisa si excede de lo permitido por ley.
    //lo máximo permitido por ley son 32 toneladas
    public int generarPMA(){
        boolean flag = true;
        do{
            int PMA = auxiliar.pideEntero ("\033[32mPeso de la carga en toneladas: \033[0m");
            if (PMA <= 32 && PMA >0){
                this.PMA = PMA;
                flag = false;
            }else{
                System.out.println("\033[31mLo siento, la carga tiene que ser de 1 tonelada hasta la máxima legal, que es de 32 toneladas.\033[0m");
            }
        }while (flag);      
        return PMA; 
    }
}
