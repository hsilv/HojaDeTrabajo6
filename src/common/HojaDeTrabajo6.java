package common;

import java.io.File;
import java.util.*;

public class HojaDeTrabajo6 {

    public static void main(String[] args) {
        System.out.println("----------CREACION DE COLECCION DE USUARIO----------");
        Map<String, String> userCollection = Factory.factoryMap();
        System.out.println("---------------CREACION DE INVENTARIO---------------");
        Map<String, String> inventory = Factory.factoryMap();
        ArrayList<String> inventario;
        inventario = leerArchivo("/mnt/f/Programacion/HojaDeTrabajo6/src/resources/ListadoProducto.txt");
        inventory = elaborarInventario(inventario, inventory);
        System.out.println(inventory);
        
    }
    
    public static ArrayList<String> leerArchivo(String path){
        ArrayList<String> array = new ArrayList<>();
        try{
            File doc = new File(path);
            Scanner obj = new Scanner(doc);
            while(obj.hasNextLine()){
                array.add(obj.nextLine());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return array;
    }

    public static Map<String, String> elaborarInventario(ArrayList<String> array, Map<String, String> mapa){
        String[] strings;
        for(String string: array){
            strings = string.split("\\|");
            mapa.put(strings[1].trim(), strings[0].trim());
        }
        return mapa;
    }
    
}
