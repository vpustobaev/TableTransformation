package sort;

import model.Cell;
import model.Row;
import model.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TableManipulator {

    private static final Comparator comparator = new FirstCellValueComparator();

    public Table sort(Table table) {

        List<Row> sortedRows = sortRowsByFirstCells(table.getRows());
        Table result = new Table(sortedRows);

        List<Duplicate> duplicates = getDuplicates(result);
        if (duplicates.isEmpty()) {
            return result;
        }

        for (Duplicate duplicate : duplicates) {
            Table subTable = createSubTableUsingRowRange(result, duplicate.firstIndex, duplicate.lastIndex);
            subTable = sort(subTable);
            merge(result, subTable, duplicate.firstIndex);
        }
        return result;

    }

    protected List<Row> sortRowsByFirstCells(List<Row> rows) {
        Collections.sort(rows, comparator);
        return rows;
    }

    protected boolean areNeighbouringCellsEqualAndNotEmpty(List<Row> rows, int rowIndex) {
        return comparator.compare(rows.get(rowIndex), rows.get(rowIndex + 1)) == 0;
    }

    protected List<Duplicate> getDuplicates(Table table) {
        List<Duplicate> result = new ArrayList<>();
        List<Row> rows = table.getRows();

        for (int i = 0; i < rows.size() - 1; i++) {
            if (areNeighbouringCellsEqualAndNotEmpty(rows, i)) {
                Duplicate duplicate = new Duplicate();
                duplicate.firstIndex = i;
                do {
                    i++;
                    if (i == rows.size() - 1) break;
                } while (areNeighbouringCellsEqualAndNotEmpty(rows, i));
                duplicate.lastIndex = i;
                result.add(duplicate);
            }
        }
        return result;

    }

    protected Table createSubTableUsingRowRange(Table table, int firstIndex, int lastIndex) {
        List<Row> rows = new ArrayList<>();
        for (int i = firstIndex; i <= lastIndex; i++) {

            List<Cell> subTableCells = new ArrayList<>();
            List<Cell> cells = table.getRows().get(i).getCells();
            for (int j = 0; j < cells.size() - 1; j++) {
                Cell cell = cells.get(j + 1);
                subTableCells.add(cell);
            }
            Row row = new Row(subTableCells);
            rows.add(row);
        }
        return new Table(rows);
    }

    protected void merge(Table destination, Table source, int rowShift) {
        List<Row> sourceRows = source.getRows();
        for (int i = 0; i < sourceRows.size(); i++) {
            List<Cell> destinationCells = destination.getRows().get(i + rowShift).getCells();
            List<Cell> sourceCells = sourceRows.get(i).getCells();
            for (int j = 0; j < sourceCells.size(); j++) {
                Cell cell = sourceCells.get(j);
                destinationCells.set(j + 1, cell);
            }
        }
    }

    public static class Duplicate {
        public int firstIndex;
        public int lastIndex;
    }

}