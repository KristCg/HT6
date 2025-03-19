package clases;

import java.util.Arrays;
import java.util.List;

public class Pokemon {
    private String name;
    private String type1;
    private String type2;
    private List<String> abilities;

    public Pokemon(String[] columns) {
        this.name = columns[0];
        this.type1 = columns[2];
        this.type2 = columns[3];
        this.abilities = Arrays.asList(columns[7].replace("\"", "").split(", "));
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    @Override
    public String toString() {
        String abilitiesStr = String.join(", ", abilities);
        return "Pokemon{" +
                "nombre='" + name + '\'' +
                ", tipo1='" + type1 + '\'' +
                ", tipo2='" + type2 + '\'' +
                ", habilidades=" + abilitiesStr +
                '}';
    }
}
