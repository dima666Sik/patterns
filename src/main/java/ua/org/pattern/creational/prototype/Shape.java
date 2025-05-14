package ua.org.pattern.creational.prototype;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shape implements Cloneable {
    int x, y;

    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
