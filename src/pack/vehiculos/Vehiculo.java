
package pack.vehiculos;

import pack.auxiliar.auxiliar;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Carlos Cartes Fernandez
 */
public abstract class Vehiculo implements IVehiculo {

    Scanner sc = new Scanner(System.in);
    
    //atributo de vehículo
    private String matricula = "";
    private String modelo = "";
    private int numeroPlazas = 0;
    private int numeroDiasAlquilado = 0;
    private final double precioBaseAlquilerXDia = 50;

    //constructor con todos los atributos para que pueda ser heredado
    public Vehiculo(String matricula, String modelo, int numeroPlazas, int numeroDiasAlquilado, double precioBaseAlquilerXDia) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.numeroPlazas = numeroPlazas;
        this.numeroDiasAlquilado = numeroDiasAlquilado;
    }

    //constructor vacío para más tarde
    public Vehiculo() {
    }

    //*****getters y setters de Vehículo*****//
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public int getNumeroDiasAlquilado() {
        return numeroDiasAlquilado;
    }

    public void setNumeroDiasAlquilado(int numeroDiasAlquilado) {
        this.numeroDiasAlquilado = numeroDiasAlquilado;
    }

    public double getPrecioBaseAlquilerXDia() {
        return precioBaseAlquilerXDia;
    }
    
    //*****funciones que se nos piden*****//
    
    //funcion para obtener el precio total base para Vehiculo
    @Override
    public double getPrecioTotalAlquilerPorDias(){
        double precioTotalAlquiler = numeroDiasAlquilado * precioBaseAlquilerXDia;
        return precioTotalAlquiler;
    }
 
    //función que muestra todos los datos de Vehiculo
    @Override
    public void showInformacion(){
        System.out.println("\033[34mEstos son los datos del vehículo: ");
        System.out.println("");
        System.out.printf("%-30s%-30s\n","Matricula: ","" + getMatricula().toUpperCase());
        System.out.printf("%-30s%-30s\n","Modelo: " ,""+ getModelo());
        System.out.printf("%-30s%-30s\n","Número de plazas: " ,""+ getNumeroPlazas());
        System.out.printf("%-30s%-30s\n","Número de días alquilado: " ,""+ getNumeroDiasAlquilado());
        //para que se muestre el símbolo €
        NumberFormat formatoImporte = NumberFormat.getCurrencyInstance(new Locale("es","ES"));
        System.out.printf("%-30s%-30s\n","Precio total del alquiler: ","" +formatoImporte.format(getPrecioTotalAlquilerPorDias()));
    }
    
    //función que pide los datos de vehículo vinculada a algunas otras funciones 
    //estas otras funciones son individuales y las pongo aparte así en un futuro se pueden tocar individualmente
    @Override
    public void pideDatos(){
    
        generarMatricula();
        System.out.println ("\033[32mModelo del vehiculo: \033[0m");
        String modelo = sc.nextLine();
        this.modelo = modelo;
        generarPlazas();
        generarDiasAlquiler();
    }
    
    //función que nos permite modificar el númerode días de alquiler 
    @Override
    public void setNumeroDias(int num){
        this.numeroDiasAlquilado = num;
        //num = auxiliar.pideEntero("Establece el número de días total:");
    }
    
    //función que utilizaremos en pideDatos.
    //Se pide al usuario introducir una matricular y se revisa si es válida o no
    //solo aceptamos matrículas con 4 digitos seguidos de 3 consonantes
    public String generarMatricula (){
        boolean flag = true;
        do{
            System.out.println ("\033[32mMatrícula del vehículo: \033[0m");
            String matricula = sc.nextLine();
            if (matricula.toUpperCase().matches("^[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}$")){
                this.matricula = matricula;
                flag = false;
            }else{
                System.out.println("\033[31mMatrícula inválida, la matrícula consta de cuatro números y tres consonantes todo seguido."
                        + " Ejemplo: 1111bbb\033[0m");
            }
        }while (flag);      
        return matricula;
    }
    
    //función que utilizaremos en pideDatos 
    //se pide al usuario introducit el número de plazas y se revisa si son correctas o no.
    //las plazas tienen que ser de 2 a 9
    public int generarPlazas(){
        boolean flag = true;
        do{
            int numeroPlazas = auxiliar.pideEntero ("\033[32mPlazas del vehículo: \033[0m");
            if ((numeroPlazas >= 2) && (numeroPlazas <= 9)){
                this.numeroPlazas = numeroPlazas;
                flag = false;
            }else{
                System.out.println("\033[31mNúmero de plazas incorrecto, las plazas solo pueden ser de 2 a 9.\033[0m");
            }
        }while (flag);      
        return numeroPlazas; 
    }
    
    //función que utilizaremos en pideDatos 
    //se pide al usuario introducit el número de días que quiere alquilar y se revisa si son correctas o no.
    //los días no pueden ser negativos o 0
    public int generarDiasAlquiler(){
        boolean flag = true;
        do{
            int numeroDiasAlquilado = auxiliar.pideEntero ("\033[32mDías de alquiler del vehículo: \033[0m");
            if (numeroDiasAlquilado >=1){
                this.numeroDiasAlquilado = numeroDiasAlquilado;
                flag = false;
            }else{
                System.out.println("\033[31mNúmero de días incorrecto,los días tienen que ser igual o superior a 1.\033[0m");
            }
        }while(flag);
        return numeroDiasAlquilado;
    }
    
}
