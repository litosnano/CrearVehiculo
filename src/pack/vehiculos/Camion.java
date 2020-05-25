
package pack.vehiculos;

/**
 *
 * @author Carlos Cartes Fernandez
 */
public class Camion extends Carga{

    //atributos de Camión
    private String tipoEstructura = "";

    //constructo Camion con los atributos heredados de Cargar y los suyos propios
    public Camion(String matricula, String modelo, int numeroPlazas, int numeroDiasAlquilado, double precioBaseAlquilerXDia, int PMA, String tipoEstructura) {
        super(matricula, modelo, numeroPlazas, numeroDiasAlquilado, precioBaseAlquilerXDia, PMA);
        this.tipoEstructura = tipoEstructura;
    }

    //constructor vacio
    public Camion() {
    }

    //*****getters y setters de Camion*****//
    
    public String getTipoEstructura(){
        return tipoEstructura;
    }

    public void setTipoEstructura(String tipoEstructura) {
        this.tipoEstructura = tipoEstructura;
    }

    //*****funciones que se nos piden*****//
    
    //función que sobreescribe a la de Carga con los datos propios de Camión para obtener el precio total
    @Override
    public double getPrecioTotalAlquilerPorDias() {
        double precioTotalAlquiler = super.getPrecioTotalAlquilerPorDias()+40;
        return precioTotalAlquiler;
    }

    //función que sobreescribe Carga pero cogiendo los datos de Carga y añadiendo los de Camión
    //finalmente se muestran todos los datos de Camión, parte viniendo de Carga
    @Override
    public void showInformacion(){
        super.showInformacion();
        System.out.printf("%-30s%-30s\n","Tipo de estructura: ","" + getTipoEstructura());
    }
    
    //esta función no se pide en el apartado 5 pero es necesaria para hacer el apartado C donde se pide mostrar la estructura
    //función que sobreescribe Carga pero cogiendo los datos de Carga y añadiendo los de Camión
    //en una función aparte recogemos el tipo de estructura para que se puedan tocar individualmente en un futuro
    @Override
    public void pideDatos(){
        super.pideDatos();
        generarTipoEstructura();
    }
    
    //función que utilizaremos en pideDatos 
    //se pide al usuario introducir el tipo de estructura que desea
    public String generarTipoEstructura(){
        boolean flag = true;
        do{
            System.out.println ("\033[32mTipo de estructura: rigido, remolque o semiremolque.\033[0m");
            String tipoEstructura = sc.nextLine();
            if (tipoEstructura.toLowerCase().matches("rigido")){
                this.tipoEstructura = tipoEstructura;
                flag = false;
            }else if(tipoEstructura.toLowerCase().matches("remolque")){
                this.tipoEstructura = tipoEstructura;
                flag = false;
            }else if(tipoEstructura.toLowerCase().matches("semiremolque")){
                this.tipoEstructura = tipoEstructura;
                flag = false;
            }else{
                System.out.println("\033[31mTipo de estructura incorrecta, escribe rigido, remolque o semiremolque.\033[0m");
            }
        }while (flag);      
        return tipoEstructura; 
    }
}
