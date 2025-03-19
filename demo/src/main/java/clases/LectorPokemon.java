package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class LectorPokemon {

    public static final String RUTA_ARCHIVO = "C:\\Users\\Admin\\Documents\\Yio\\U\\HT6\\demo\\src\\main\\java\\clases\\pokemon_data_pokeapi.csv";

    public static Map<String, Pokemon> readPokemons() throws IOException {
        Map<String, Pokemon> pokemonMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                Pokemon pokemon = new Pokemon(columns);
                pokemonMap.put(pokemon.getName(), pokemon);
            }
        }

        return pokemonMap;
    }
}
