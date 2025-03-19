package clases;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class GestorPokemonTest {

    @Test
    public void testShowPokemonData() {
        String[] columns = {
                "Bulbasaur", "1", "Grass", "Poison", "Seed Pokémon", "0.7", "6.9", "Overgrow, Chlorophyll", "1", "No"
        };
        Pokemon bulbasaur = new Pokemon(columns);

        Map<String, Pokemon> pokemonMap = new HashMap<>();
        pokemonMap.put("Bulbasaur", bulbasaur);

        GestorPokemon gestorPokemon = new GestorPokemon(pokemonMap);

        gestorPokemon.showPokemonData("Bulbasaur");
        }
    @Test
    public void testShowPokemonByAbility() {
        // Create sample Pokémon
        String[] bulbasaurColumns = {
                "Bulbasaur", "1", "Grass", "Poison", "Seed Pokémon", "0.7", "6.9", "Overgrow, Chlorophyll", "1", "No"
        };
        Pokemon bulbasaur = new Pokemon(bulbasaurColumns);

        String[] ivysaurColumns = {
                "Ivysaur", "2", "Grass", "Poison", "Seed Pokémon", "1.0", "13.0", "Overgrow, Chlorophyll", "1", "No"
        };
        Pokemon ivysaur = new Pokemon(ivysaurColumns);

        // Add the Pokémon to a map
        Map<String, Pokemon> pokemonMap = new HashMap<>();
        pokemonMap.put("Bulbasaur", bulbasaur);
        pokemonMap.put("Ivysaur", ivysaur);

        // Create a PokemonManager instance
        GestorPokemon gestorPokemon = new GestorPokemon(pokemonMap);

        // Test the showPokemonByAbility method
        gestorPokemon.showPokemonByAbility("Overgrow");
    }
}
