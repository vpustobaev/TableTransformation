package model;

import java.util.Objects;

public class Cell {

    private final String value;

    public Cell(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return value.equals(cell.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
