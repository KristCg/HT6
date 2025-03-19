package clases;

import org.junit.Test;
import java.io.IOException;
import java.util.Map;
import static org.junit.Assert.*;

public class LectorPokemonTest {

    @Test
    public void testReadPokemons() throws IOException {
        // Call the method to read Pokémon from the CSV file
        Map<String, Pokemon> pokemonMap = LectorPokemon.readPokemons();

        // Verify that the map is not empty
        assertNotNull(pokemonMap);
        assertFalse(pokemonMap.isEmpty());

        // Verify specific Pokémon data
        Pokemon bulbasaur = pokemonMap.get("Bulbasaur");
        assertNotNull(bulbasaur);
        assertEquals("Bulbasaur", bulbasaur.getName());
        assertEquals("Grass", bulbasaur.getType1());
        assertEquals("Poison", bulbasaur.getType2());
        assertEquals(2, bulbasaur.getAbilities().size());
        assertTrue(bulbasaur.getAbilities().contains("Overgrow"));
        assertTrue(bulbasaur.getAbilities().contains("Chlorophyll"));
    }
}
