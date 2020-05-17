package sort;

import model.Cell;
import model.Row;
import model.Table;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import serializer.TableSerializer;
import sort.TableManipulator.Duplicate;
import util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableManipulatorTest {

    private final TableManipulator tableManipulator = new TableManipulator();
    private final TableSerializer tableSerializer = new TableSerializer();
    private Table table;
    private Table initialTable;
    private Table expectedSortedTable;
    private Table expectedSortedByRowsTable;
    private Table expectedSubTable;
    private Table expectedMergedTable;
    private Table subTableForMerging;


    @BeforeMethod
    public void initTable() {

        List<Row> rows = new ArrayList<>(3);

        Cell cell11 = new Cell("22");
        Cell cell12 = new Cell("a");
        Cell cell13 = new Cell("b");
        List<Cell> cells1 = new ArrayList<>(3);
        cells1.add(cell11);
        cells1.add(cell12);
        cells1.add(cell13);
        Row row1 = new Row(cells1);
        rows.add(row1);

        Cell cell21 = new Cell("12");
        Cell cell22 = new Cell("e");
        Cell cell23 = new Cell("f");
        List<Cell> cells2 = new ArrayList<>(3);
        cells2.add(cell21);
        cells2.add(cell22);
        cells2.add(cell23);
        Row row2 = new Row(cells2);
        rows.add(row2);

        Cell cell31 = new Cell("12");
        Cell cell32 = new Cell("3");
        Cell cell33 = new Cell("f");
        List<Cell> cells3 = new ArrayList<>(3);
        cells3.add(cell31);
        cells3.add(cell32);
        cells3.add(cell33);
        Row row3 = new Row(cells3);
        rows.add(row3);

        table = new Table(rows);

    }

    @BeforeMethod
    public void initSortedByRowTable() {

        List<Row> rows = new ArrayList<>(3);

        Cell cell21 = new Cell("12");
        Cell cell22 = new Cell("e");
        Cell cell23 = new Cell("f");
        List<Cell> cells2 = new ArrayList<>(3);
        cells2.add(cell21);
        cells2.add(cell22);
        cells2.add(cell23);
        Row row2 = new Row(cells2);
        rows.add(row2);

        Cell cell31 = new Cell("12");
        Cell cell32 = new Cell("3");
        Cell cell33 = new Cell("f");
        List<Cell> cells3 = new ArrayList<>(3);
        cells3.add(cell31);
        cells3.add(cell32);
        cells3.add(cell33);
        Row row3 = new Row(cells3);
        rows.add(row3);

        Cell cell11 = new Cell("22");
        Cell cell12 = new Cell("a");
        Cell cell13 = new Cell("b");
        List<Cell> cells1 = new ArrayList<>(3);
        cells1.add(cell11);
        cells1.add(cell12);
        cells1.add(cell13);
        Row row1 = new Row(cells1);
        rows.add(row1);

        expectedSortedByRowsTable = new Table(rows);

    }


    @BeforeMethod
    public void initInitialTable() {

        List<Row> rows = new ArrayList<>(3);

        Cell cell21 = new Cell("12");
        Cell cell22 = new Cell("3");
        Cell cell23 = new Cell("f");
        List<Cell> cells2 = new ArrayList<>(3);
        cells2.add(cell21);
        cells2.add(cell22);
        cells2.add(cell23);
        Row row2 = new Row(cells2);
        rows.add(row2);

        Cell cell31 = new Cell("22");
        Cell cell32 = new Cell("e");
        Cell cell33 = new Cell("f");
        List<Cell> cells3 = new ArrayList<>(3);
        cells3.add(cell31);
        cells3.add(cell32);
        cells3.add(cell33);
        Row row3 = new Row(cells3);
        rows.add(row3);

        Cell cell11 = new Cell("12");
        Cell cell12 = new Cell("3");
        Cell cell13 = new Cell("6");
        List<Cell> cells1 = new ArrayList<>(3);
        cells1.add(cell11);
        cells1.add(cell12);
        cells1.add(cell13);
        Row row1 = new Row(cells1);
        rows.add(row1);

        initialTable = new Table(rows);

    }

    @BeforeMethod
    public void initSortedTable() {

        List<Row> rows = new ArrayList<>(3);

        Cell cell21 = new Cell("12");
        Cell cell22 = new Cell("3");
        Cell cell23 = new Cell("6");
        List<Cell> cells2 = new ArrayList<>(3);
        cells2.add(cell21);
        cells2.add(cell22);
        cells2.add(cell23);
        Row row2 = new Row(cells2);
        rows.add(row2);

        Cell cell31 = new Cell("12");
        Cell cell32 = new Cell("3");
        Cell cell33 = new Cell("f");
        List<Cell> cells3 = new ArrayList<>(3);
        cells3.add(cell31);
        cells3.add(cell32);
        cells3.add(cell33);
        Row row3 = new Row(cells3);
        rows.add(row3);

        Cell cell11 = new Cell("22");
        Cell cell12 = new Cell("e");
        Cell cell13 = new Cell("f");
        List<Cell> cells1 = new ArrayList<>(3);
        cells1.add(cell11);
        cells1.add(cell12);
        cells1.add(cell13);
        Row row1 = new Row(cells1);
        rows.add(row1);

        expectedSortedTable = new Table(rows);

    }

    @BeforeMethod
    public void initSubTable() {

        List<Row> rows = new ArrayList<>(2);

        Cell cell11 = new Cell("e");
        Cell cell12 = new Cell("f");
        List<Cell> cells1 = new ArrayList<>(2);
        cells1.add(cell11);
        cells1.add(cell12);
        Row row1 = new Row(cells1);
        rows.add(row1);

        Cell cell21 = new Cell("3");
        Cell cell22 = new Cell("f");
        List<Cell> cells2 = new ArrayList<>(2);
        cells2.add(cell21);
        cells2.add(cell22);
        Row row2 = new Row(cells2);
        rows.add(row2);

        expectedSubTable = new Table(rows);

    }

    @BeforeMethod
    public void initSubTableForMerging() {

        List<Row> rows = new ArrayList<>(2);

        Cell cell11 = new Cell("123");
        Cell cell12 = new Cell("456");
        List<Cell> cells1 = new ArrayList<>(2);
        cells1.add(cell11);
        cells1.add(cell12);
        Row row1 = new Row(cells1);
        rows.add(row1);

        Cell cell21 = new Cell("abc");
        Cell cell22 = new Cell("def");
        List<Cell> cells2 = new ArrayList<>(2);
        cells2.add(cell21);
        cells2.add(cell22);
        Row row2 = new Row(cells2);
        rows.add(row2);

        subTableForMerging = new Table(rows);
        // subTableForMerging.setFirstRowIndex(1);

    }

    @BeforeMethod
    public void initMergedSubTable() {

        List<Row> rows = new ArrayList<>(3);

        Cell cell11 = new Cell("22");
        Cell cell12 = new Cell("a");
        Cell cell13 = new Cell("b");
        List<Cell> cells1 = new ArrayList<>(3);
        cells1.add(cell11);
        cells1.add(cell12);
        cells1.add(cell13);
        Row row1 = new Row(cells1);
        rows.add(row1);

        Cell cell21 = new Cell("12");
        Cell cell22 = new Cell("123");
        Cell cell23 = new Cell("456");
        List<Cell> cells2 = new ArrayList<>(3);
        cells2.add(cell21);
        cells2.add(cell22);
        cells2.add(cell23);
        Row row2 = new Row(cells2);
        rows.add(row2);

        Cell cell31 = new Cell("12");
        Cell cell32 = new Cell("abc");
        Cell cell33 = new Cell("def");
        List<Cell> cells3 = new ArrayList<>(3);
        cells3.add(cell31);
        cells3.add(cell32);
        cells3.add(cell33);
        Row row3 = new Row(cells3);
        rows.add(row3);

        expectedMergedTable = new Table(rows);

    }

    @Test
    private void testSortComplexTable() throws IOException {
        String fileText = Util.readFile("src/test/resources/in.txt");
        Table table = tableSerializer.deserialize(fileText);
        Table sortedTable = tableManipulator.sort(table);
        String expectedSortedText = Util.readFile("src/test/resources/out.txt");
        Table expectedSortedTable = tableSerializer.deserialize(expectedSortedText);
        Assert.assertEquals(sortedTable, expectedSortedTable);
    }


    @Test
    private void testSortComplexWithNoDuplicatesTable() throws IOException {
        String fileText = Util.readFile("src/test/resources/noduplicates.txt");
        Table table = tableSerializer.deserialize(fileText);
        Table sortedTable = tableManipulator.sort(table);
        String expectedSortedText = Util.readFile("src/test/resources/noduplicates_out.txt");
        Table expectedSortedTable = tableSerializer.deserialize(expectedSortedText);
        Assert.assertEquals(sortedTable, expectedSortedTable);
    }


    @Test
    private void testSort() {
        Table actual = tableManipulator.sort(initialTable);
        Assert.assertEquals(actual, expectedSortedTable);

    }

    @Test
    private void testSortTableByRows() {
        List<Row> sortedRows = tableManipulator.sortRowsByFirstCells(table.getRows());
        Assert.assertEquals(new Table(sortedRows), expectedSortedByRowsTable);
    }

    @Test
    private void testGetDuplicates() {
        List<Duplicate> duplicateList = tableManipulator.getDuplicates(table);
        Assert.assertEquals(duplicateList.size(), 1);

    }

    @Test
    private void testCreateSubTableFromRowRange() {
        TableManipulator.Duplicate duplicate = new TableManipulator.Duplicate();
        duplicate.firstIndex = 1;
        duplicate.lastIndex = 2;
        Table actualSubTable = tableManipulator.createSubTableUsingRowRange(table, duplicate.firstIndex, duplicate.lastIndex);
        Assert.assertEquals(actualSubTable, expectedSubTable);
    }

    @Test
    private void testMergeTableWithSubTable() {
        tableManipulator.merge(table, subTableForMerging, 1);
        Assert.assertEquals(table, expectedMergedTable);
    }

}
