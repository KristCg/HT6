package clases;

import org.junit.Test;
import static org.junit.Assert.*;

public class PokemonTest {

    @Test
    public void testPokemonConstructor() {
        // Sample CSV line: "Bulbasaur,1,Grass,Poison,Seed Pokémon,0.7,6.9,"Overgrow, Chlorophyll",1,No"
        String[] columns = {
                "Bulbasaur", "1", "Grass", "Poison", "Seed Pokémon", "0.7", "6.9", "Overgrow, Chlorophyll", "1", "No"
        };

        Pokemon pokemon = new Pokemon(columns);

        // Verify the fields
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals("Grass", pokemon.getType1());
        assertEquals("Poison", pokemon.getType2());
        assertEquals(2, pokemon.getAbilities().size());
        assertTrue(pokemon.getAbilities().contains("Overgrow"));
        assertTrue(pokemon.getAbilities().contains("Chlorophyll"));
    }
}