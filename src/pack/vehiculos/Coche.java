
package pack.vehiculos;

import java.util.Scanner;

/**
 *
 * @author Carlos Cartes Fernandez
 */
public class Coche extends Vehiculo{

    Scanner sc = new Scanner(System.in);
    
    //atributos de Coche
    private String gama = "";

    //contructor Coche con los atributos heredados de Vehiculo y los suyos propios
    public Coche(String matricula, String modelo, int numeroPlazas, int numeroDiasAlquilado, double precioBaseAlquilerXDia, String gama) {
        super(matricula, modelo, numeroPlazas, numeroDiasAlquilado, precioBaseAlquilerXDia);
        this.gama = gama;
    }

    //constructor vacío
    public Coche() {
    }

    //*****getters y setters de Coche*****//
    
    public String getGama(){
        return gama;
    }

    public void setGama(String gama) {    
        this.gama = gama;
    }

    //*****funciones que se nos piden*****//
    
    //función que sobreescribe a la de Vehiculo con los datos de Coche para obtener el precio total
    @Override
    public double getPrecioTotalAlquilerPorDias() {
        double precioTotalAlquiler = super.getPrecioTotalAlquilerPorDias() + (super.getNumeroPlazas()*1.5)+(super.getNumeroDiasAlquilado()*1.5);
        return precioTotalAlquiler;
    }
    
    
    //función que sobreescribe Vehiculo pero cogiendo los datos de Vehiculo y añadiendo los de Coche
    //finalmente se muestran todos los datos de Coche, parte viniendo de Vehiculo
    @Override
    public void showInformacion(){
        super.showInformacion();
        System.out.printf("%-30s%-30s\n","Gama: ","" + getGama().toUpperCase());
    }
    
    
    //función que sobreescribe Vehiculo pero cogiendo los datos de Vehiculo y añadiendo los de Coche
    @Override
    public void pideDatos(){
        super.pideDatos();
        generarGama();
    }
    
    public String generarGama (){
        boolean flag = true;
        do{
            System.out.println ("\033[32mGama del vehículo (A, B, C o D): \033[0m");
            String gama = sc.nextLine();
            if (gama.toUpperCase().matches("A")){
                this.gama = gama;
                flag = false;
            }else if(gama.toUpperCase().matches("B")){
                this.gama = gama;
                flag = false;
            }else if(gama.toUpperCase().matches("C")){
                this.gama = gama;
                flag = false;
            }else if(gama.toUpperCase().matches("D")){
                this.gama = gama;
                flag = false;
            }else{
                System.out.println("\033[31mGama inválida, las únicas gamas que existen son: A, B, C y D.\033[0m");
            }
        }while (flag);      
        return gama;
    }
}
