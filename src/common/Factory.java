package common;

import java.util.*;

public class Factory {
    public Factory(){
    }
    
    /**
     *
     * @param option
     * @param parametros
     * @return
     */
    public static Map factoryMap(){
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido, seleccione la interfaz que desea utilizar: \n1.HashMap \n2.TreeMap \n3.LinkedHashMap");
        while(flag){
            int option = scan.nextInt();
            while(option <= 0 || option >=4){
                System.out.println("Ingrese una opcion valida");
                option = scan.nextInt();
            }
            if(option == 1){
                return new HashMap<>(); 
            } else if(option == 2){
                return new TreeMap<>();
            } else if(option == 3){
                return new LinkedHashMap();
            }
        }
        return null;
    }
}
