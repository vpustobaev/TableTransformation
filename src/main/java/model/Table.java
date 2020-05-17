package model;

import java.util.List;
import java.util.Objects;

public class Table {

    private final List<Row> rows;

    public Table(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "Table{" +
                "rows=" + rows +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return Objects.equals(getRows(), table.getRows());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRows());
    }


}
