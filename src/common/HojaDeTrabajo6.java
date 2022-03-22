package common;

import java.io.File;
import java.util.*;
import java.util.Map.Entry;

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
            if (opcion == 1) {
                System.out.println("Ingrese la categoría del producto que desea añadir");
                String categoria = scanner.nextLine();
                userCollection = anadirProducto(inventory, userCollection, categoria);
            } else if (opcion == 2) {
                System.out.println("Ingrese el nombre del producto");
                String producto = scanner.nextLine();
                mostrarCategoria(inventory, producto);
            } else if (opcion == 3) {
                userCollection = ordenarMap(userCollection);
            } else if (opcion == 4) {
                ordenarMap(inventory);
            } else if (opcion == 5) {
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
        if (mapa.containsKey(producto)) {
            System.out.println("\nCategoría: " + mapa.get(producto) + "\n");
        } else {
            System.out.println("\nEl producto especificado no existe en el inventario\n");
        }
    }

    public static Map<String, String> anadirProducto(Map<String, String> mapa, Map<String, String> coleccion,String categoria) {
        Scanner scan = new Scanner(System.in);
        if (mapa.containsValue(categoria)) {
            if (categoria.equals("Mueble de terraza")) {
                System.out.println(
                        "¿Qué desea agregar? \n1.Mesas de jardín\n2.Sillas de jardín\n3.Conjuntos mesas y sillas de jardín\n4.Mesas de Ping Pong exteriores");
                int opcion = scan.nextInt();
                while (opcion <= 0 || opcion >= 5) {
                    System.out.println("Opción no válida");
                    opcion = scan.nextInt();
                }
                if (opcion == 1) {
                    coleccion.put("Mesas de jardín", "Mueble de terraza");
                } else if (opcion == 2) {
                    coleccion.put("Sillas de jardín", "Mueble de terraza");
                } else if (opcion == 3) {
                    coleccion.put("Conjuntos mesas y sillas de jardín", "Mueble de terraza");
                } else if (opcion == 4) {
                    coleccion.put("Mesas de Ping Pong exteriores", "Mueble de terraza");
                }
            } else if (categoria.equals("Sillones de masaje")) {
                System.out.println(
                        "¿Qué desea agregar? \n1.Cojines y colchonetas de masaje\n2.Sillones relax y sofás de masajes\n3.Sillones de masajes avanzados\n4.Sofás camas");
                int opcion = scan.nextInt();
                while (opcion <= 0 || opcion >= 5) {
                    System.out.println("Opción no válida");
                    opcion = scan.nextInt();
                }
                if (opcion == 1) {
                    coleccion.put("Cojines y colchonetas de masaje", "Sillones de masaje");
                } else if (opcion == 2) {
                    coleccion.put("Sillones relax y sofás de masajes", "Sillones de masaje");
                } else if (opcion == 3) {
                    coleccion.put("Sillones de masajes avanzados", "Sillones de masaje");
                } else if (opcion == 4) {
                    coleccion.put("Sofás camas", "Sillones de masaje");
                }
            } else if (categoria.equals("Bebidas")) {
                System.out.println(
                        "¿Qué desea agregar? \n1.Cerveza tibetana Barley\n2.Té frios\n3.Coca cola 1 litro\n4.Coca cola 2 litros");
                int opcion = scan.nextInt();
                while (opcion <= 0 || opcion >= 5) {
                    System.out.println("Opción no válida");
                    opcion = scan.nextInt();
                }
                if (opcion == 1) {
                    coleccion.put("Cerveza tibetana Barley", "Bebidas");
                } else if (opcion == 2) {
                    coleccion.put("Té frios", "Bebidas");
                } else if (opcion == 3) {
                    coleccion.put("Coca cola 1 litro", "Bebidas");
                } else if (opcion == 4) {
                    coleccion.put("Coca cola 2 litros", "Bebidas");
                }
            } else if (categoria.equals("Condimentos")) {
                System.out.println(
                        "¿Qué desea agregar? \n1.Sirope de regaliz\n2.Especies Cajun del chef\n3.Mezcla Gumbo del chef");
                int opcion = scan.nextInt();
                while (opcion <= 0 || opcion >= 4) {
                    System.out.println("Opción no válida");
                    opcion = scan.nextInt();
                }
                if (opcion == 1) {
                    coleccion.put("Sirope de regaliz", "Condimentos");
                } else if (opcion == 2) {
                    coleccion.put("Especies Cajun del chef", "Condimentos");
                } else if (opcion == 3) {
                    coleccion.put("Mezcla Gumbo del chef", "Condimentos");
                }
            } else if (categoria.equals("Frutas")) {
                System.out.println("¿Qué desea agregar? \n1.Peras secas\n2.Pasas\n3.Manzana roja\n4.Manzana verde");
                int opcion = scan.nextInt();
                while (opcion <= 0 || opcion >= 5) {
                    System.out.println("Opción no válida");
                    opcion = scan.nextInt();
                }
                if (opcion == 1) {
                    coleccion.put("Peras secas", "Frutas");
                } else if (opcion == 2) {
                    coleccion.put("Pasas", "Frutas");
                } else if (opcion == 3) {
                    coleccion.put("Manzana roja", "Frutas");
                } else if (opcion == 4) {
                    coleccion.put("Manzana verde", "Frutas");
                }
            } else if (categoria.equals("Carnes")) {
                System.out.println("¿Qué desea agregar? \n1.Res\n2.Pollo\n3.Cerdo\n4.Camarones\n5.Pescados");
                int opcion = scan.nextInt();
                while (opcion <= 0 || opcion >= 6) {
                    System.out.println("Opción no válida");
                    opcion = scan.nextInt();
                }
                if (opcion == 1) {
                    coleccion.put("Res", "Carnes");
                } else if (opcion == 2) {
                    coleccion.put("Pollo", "Carnes");
                } else if (opcion == 3) {
                    coleccion.put("Cerdo", "Carnes");
                } else if (opcion == 4) {
                    coleccion.put("Camarones", "Carnes");
                } else if (opcion == 5) {
                    coleccion.put("Pescados", "Carnes");
                }
            } else if (categoria.equals("Lácteos")) {
                System.out.println(
                        "¿Qué desea agregar? \n1.Queso de cabra\n2.Queso Manchego\n3.Leche descremada\n4.Leche deslactosada\n5.Leche entera");
                int opcion = scan.nextInt();
                while (opcion <= 0 || opcion >= 6) {
                    System.out.println("Opción no válida");
                    opcion = scan.nextInt();
                }
                if (opcion == 1) {
                    coleccion.put("Queso de cabra", "Lácteos");
                } else if (opcion == 2) {
                    coleccion.put("Queso Manchego", "Lácteos");
                } else if (opcion == 3) {
                    coleccion.put("Leche descremada", "Lácteos");
                } else if (opcion == 4) {
                    coleccion.put("Leche deslactosada", "Lácteos");
                } else if (opcion == 5) {
                    coleccion.put("Leche entera", "Lácteos");
                }
            }
        } else {
            System.out.println("CATEGORIA NO EXISTENTE");
        }
        return coleccion;
    }

}
