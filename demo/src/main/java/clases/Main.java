package clases;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Pokemon> pokemonMap;
        try {
            pokemonMap = LectorPokemon.readPokemons();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        System.out.println("Seleccione la implementación de Map que desea utilizar:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        int mapChoice = scanner.nextInt();
        scanner.nextLine();

        Map<String, Pokemon> selectedMap = MapFactory.createMap(mapChoice);
        selectedMap.putAll(pokemonMap);

        GestorPokemon gestorPokemon = new GestorPokemon(selectedMap);

        while (true) {
            System.out.println("\nSeleccione una operación:");
            System.out.println("1. Agregar un Pokémon a la colección");
            System.out.println("2. Mostrar los datos de un Pokémon");
            System.out.println("3. Mostrar la colección del usuario ordenada por Tipo1");
            System.out.println("4. Mostrar todos los Pokémon ordenados por Tipo1");
            System.out.println("5. Buscar Pokémon por habilidad");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Ingrese el nombre del Pokémon que desea agregar:");
                    String pokemonName = scanner.nextLine();
                    gestorPokemon.addPokemonToCollection(pokemonName);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del Pokémon que desea ver:");
                    String pokemonToShow = scanner.nextLine();
                    gestorPokemon.showPokemonData(pokemonToShow);
                    break;
                case 3:
                    System.out.println("Colección del usuario ordenada por Tipo 1:");
                    gestorPokemon.showUserCollectionByType1();
                    break;
                case 4:
                    System.out.println("Todos los Pokémon ordenados por Tipo 1:");
                    gestorPokemon.showAllPokemonByType1();
                    break;
                case 5:
                    System.out.println("Ingrese la habilidad que desea buscar:");
                    String ability = scanner.nextLine();
                    gestorPokemon.showPokemonByAbility(ability);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
