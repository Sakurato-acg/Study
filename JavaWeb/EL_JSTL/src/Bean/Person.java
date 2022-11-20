package Bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Person {
    private String name;
    private String[]phones;
    private List<String> cites;
    private Map<String,Object> map;
    public int age=18;

    public int getAge() {
        return age;
    }

    public Person(String name, String[] phones, List<String> cites, Map<String, Object> map) {
        this.name = name;
        this.phones = phones;
        this.cites = cites;
        this.map = map;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", phones=" + Arrays.toString(phones) +
                ", cites=" + cites +
                ", map=" + map +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public List<String> getCites() {
        return cites;
    }

    public void setCites(List<String> cites) {
        this.cites = cites;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
