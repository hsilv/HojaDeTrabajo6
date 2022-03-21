package common;

import java.io.File;
import java.util.*;

public class HojaDeTrabajo6 {

    public static void main(String[] args) {
        ArrayList<String> inventario;
        inventario = leerArchivo("F:\\Programacion\\HojaDeTrabajo6\\src\\resources\\ListadoProducto.txt");
        Map<String, String> miMapa = Factory.factoryMap();

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

}
