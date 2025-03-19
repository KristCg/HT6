package clases;
import java.util.*;

public class GestorPokemon {
    private Map<String, Pokemon> pokemonMap;
    private Set<String> userCollection;

    public GestorPokemon(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
        this.userCollection = new HashSet<>();
    }

    public void addPokemonToCollection(String name) {
        if (!pokemonMap.containsKey(name)) {
            System.out.println("Error: Pokemon no encontrado.");
            return;
        }
        if (userCollection.contains(name)) {
            System.out.println("Error: El pokemon ya existe dentro de la coleccion.");
            return;
        }
        userCollection.add(name);
        System.out.println("Pokemon agregado con exito a la colección.");
    }

    public void showPokemonData(String name) {
        Pokemon pokemon = pokemonMap.get(name);
        if (pokemon == null) {
            System.out.println("Error: Pokemon no encontrado.");
            return;
        }
        System.out.println("Name: " + pokemon.getName());
        System.out.println("Type 1: " + pokemon.getType1());
        System.out.println("Type 2: " + pokemon.getType2());
        String abilitiesStr = String.join(", ", pokemon.getAbilities());
        System.out.println("Abilities: " + abilitiesStr);
    }

    public void showUserCollectionByType1() {
        List<Pokemon> sortedCollection = new ArrayList<>();
        for (String name : userCollection) {
            sortedCollection.add(pokemonMap.get(name));
        }
        sortedCollection.sort(Comparator.comparing(Pokemon::getType1));
        for (Pokemon pokemon : sortedCollection) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType1());
        }
    }

    public void showAllPokemonByType1() {
        List<Pokemon> allPokemon = new ArrayList<>(pokemonMap.values());
        allPokemon.sort(Comparator.comparing(Pokemon::getType1));
        for (Pokemon pokemon : allPokemon) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType1());
        }
    }

    public void showPokemonByAbility(String abilitySearched) {
        abilitySearched = abilitySearched.toLowerCase();

        for (Pokemon pokemon : pokemonMap.values()) {
            for (String ability : pokemon.getAbilities()) {
                if (ability.toLowerCase().contains(abilitySearched)) {
                    System.out.println(pokemon.getName());
                    break;
                }
            }
        }
    }
}