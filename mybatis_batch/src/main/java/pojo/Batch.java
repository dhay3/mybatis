package pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Batch {
    private String name;
    private int age;

    public Batch(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
