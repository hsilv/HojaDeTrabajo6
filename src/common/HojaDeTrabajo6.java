package common;

import java.io.File;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class HojaDeTrabajo6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        System.out.println("----------CREACION DE COLECCION DE USUARIO----------");
        Map<String, String> userCollection = Factory.factoryMap();
        System.out.println("---------------CREACION DE INVENTARIO---------------");
        Map<String, String> inventory = Factory.factoryMap();
        ArrayList<String> inventario;
        inventario = leerArchivo("/mnt/f/Programacion/HojaDeTrabajo6/src/resources/ListadoProducto.txt");
        inventory = elaborarInventario(inventario, inventory);
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(
                    "¿Qué desea hacer?\n1.Agregar producto\n2.Mostrar categoría de producto\n3.Mostrar estadísticas de colección del usuario\n4.Mostrar inventario\n5.Salir");
            int opcion = scan.nextInt();
            while (opcion <= 0 || opcion >= 6) {
                System.out.println("Ingrese una opción válida");
            }
            if (opcion == 2) {
                System.out.println("Ingrese el nombre del producto");
                String producto = scanner.nextLine();
                mostrarCategoria(inventory, producto);
            } else if (opcion == 4){
                ordenarMap(inventory);
            } else if (opcion == 5){
                flag = false;
            }

        }

    }

    public static ArrayList<String> leerArchivo(String path) {
        ArrayList<String> array = new ArrayList<>();
        try {
            File doc = new File(path);
            Scanner obj = new Scanner(doc);
            while (obj.hasNextLine()) {
                array.add(obj.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public static Map<String, String> elaborarInventario(ArrayList<String> array, Map<String, String> mapa) {
        String[] strings;
        for (String string : array) {
            strings = string.split("\\|");
            mapa.put(strings[1].trim(), strings[0].trim());
        }
        return mapa;
    }

    public static Map<String, String> ordenarMap(Map<String, String> mapa) {
        List<Map.Entry<String, String>> list = new ArrayList<>(mapa.entrySet());
        list.sort(Entry.comparingByValue());
        System.out.println("\n----------INVENTARIO ORDENADO----------");
        list.forEach(System.out::println);
        System.out.println("---------------------------------------\n");
        return mapa;
    }

    public static void mostrarCategoria(Map<String, String> mapa, String producto) {
        if(mapa.containsKey(producto)){
            System.out.println("\nCategoría: "+mapa.get(producto)+"\n");
        } else{
            System.out.println("\nEl producto especificado no existe en el inventario\n");
        }
    }

}
