package serializer;

import model.Cell;
import model.Row;
import model.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableSerializer {

    private final String LINE_FEED = "\n";
    private final String TAB = "\t";

    public String serialize(Table table) {

        StringBuilder result = new StringBuilder();
        List<Row> rows = table.getRows();

        for (int i = 0; i < rows.size(); i++) {

            List<Cell> cells = rows.get(i).getCells();
            int cellsSize = cells.size();

            for (int j = 0; j < cellsSize; j++) {

                String currentCellValue = cells.get(j).getValue();
                result.append(currentCellValue);
                if (j < cellsSize - 1) {
                    result.append(TAB);
                }
            }
            result.append(LINE_FEED);
        }
        return result.toString();
    }

    public Table deserialize(String text) {
        List<Row> rows = new ArrayList<>();
        List<String> lines = Arrays.asList(text.split(LINE_FEED));

        for (int i = 0; i < lines.size(); i++) {

            String[] splitedLine = lines.get(i).split(TAB, -1);
            List<Cell> cells = new ArrayList<>();
            for (int j = 0; j < splitedLine.length; j++) {
                Cell cell = new Cell(splitedLine[j].trim());
                cells.add(cell);
            }

            Row row = new Row(cells);
            rows.add(row);
        }
        return new Table(rows);
    }


}