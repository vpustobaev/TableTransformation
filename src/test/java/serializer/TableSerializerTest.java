package serializer;

import model.Cell;
import model.Row;
import model.Table;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TableSerializerTest {

    private final TableSerializer tableSerializer = new TableSerializer();
    private Table simpleTable;
    private Table table;

    @BeforeMethod
    public void prepareSimpleTable() {

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

        Cell cell31 = new Cell("j");
        Cell cell32 = new Cell("3");
        Cell cell33 = new Cell("f");
        List<Cell> cells3 = new ArrayList<>(3);
        cells3.add(cell31);
        cells3.add(cell32);
        cells3.add(cell33);
        Row row3 = new Row(cells3);
        rows.add(row3);

        simpleTable = new Table(rows);

    }

    @BeforeMethod
    public void prepareTable() {

        List<Row> rows = new ArrayList<>(12);

        Cell cell11 = new Cell("-2.2");
        Cell cell12 = new Cell("2");
        Cell cell13 = new Cell("3");
        Cell cell14 = new Cell("4");
        List<Cell> cells1 = new ArrayList<>(4);
        cells1.add(cell11);
        cells1.add(cell12);
        cells1.add(cell13);
        cells1.add(cell14);
        Row row1 = new Row(cells1);
        rows.add(row1);

        Cell cell21 = new Cell("2.2");
        Cell cell22 = new Cell("12345q");
        Cell cell23 = new Cell("69");
        Cell cell24 = new Cell("-afg");
        List<Cell> cells2 = new ArrayList<>(4);
        cells2.add(cell21);
        cells2.add(cell22);
        cells2.add(cell23);
        cells2.add(cell24);
        Row row2 = new Row(cells2);
        rows.add(row2);

        Cell cell31 = new Cell("2.2");
        Cell cell32 = new Cell("12345q");
        Cell cell33 = new Cell("69");
        Cell cell34 = new Cell("-asdf");
        List<Cell> cells3 = new ArrayList<>(4);
        cells3.add(cell31);
        cells3.add(cell32);
        cells3.add(cell33);
        cells3.add(cell34);
        Row row3 = new Row(cells3);
        rows.add(row3);

        Cell cell41 = new Cell("-22");
        Cell cell42 = new Cell("1234234");
        Cell cell43 = new Cell("asdfasf");
        Cell cell44 = new Cell("asdgas");
        List<Cell> cells4 = new ArrayList<>(4);
        cells4.add(cell41);
        cells4.add(cell42);
        cells4.add(cell43);
        cells4.add(cell44);
        Row row4 = new Row(cells4);
        rows.add(row4);

        Cell cell51 = new Cell("-22");
        Cell cell52 = new Cell("11");
        Cell cell53 = new Cell("abc");
        Cell cell54 = new Cell("");
        List<Cell> cells5 = new ArrayList<>(4);
        cells5.add(cell51);
        cells5.add(cell52);
        cells5.add(cell53);
        cells5.add(cell54);
        Row row5 = new Row(cells5);
        rows.add(row5);

        Cell cell61 = new Cell("-22");
        Cell cell62 = new Cell("-3");
        Cell cell63 = new Cell("4");
        Cell cell64 = new Cell("");
        List<Cell> cells6 = new ArrayList<>(4);
        cells6.add(cell61);
        cells6.add(cell62);
        cells6.add(cell63);
        cells6.add(cell64);
        Row row6 = new Row(cells6);
        rows.add(row6);

        Cell cell71 = new Cell("");
        Cell cell72 = new Cell("");
        Cell cell73 = new Cell("");
        Cell cell74 = new Cell("");
        List<Cell> cells7 = new ArrayList<>(4);
        cells7.add(cell71);
        cells7.add(cell72);
        cells7.add(cell73);
        cells7.add(cell74);
        Row row7 = new Row(cells7);
        rows.add(row7);

        Cell cell81 = new Cell("-1.1");
        Cell cell82 = new Cell("");
        Cell cell83 = new Cell("");
        Cell cell84 = new Cell("");
        List<Cell> cells8 = new ArrayList<>(4);
        cells8.add(cell81);
        cells8.add(cell82);
        cells8.add(cell83);
        cells8.add(cell84);
        Row row8 = new Row(cells8);
        rows.add(row8);

        Cell cell91 = new Cell("");
        Cell cell92 = new Cell("");
        Cell cell93 = new Cell("");
        Cell cell94 = new Cell("");
        List<Cell> cells9 = new ArrayList<>(4);
        cells9.add(cell91);
        cells9.add(cell92);
        cells9.add(cell93);
        cells9.add(cell94);
        Row row9 = new Row(cells9);
        rows.add(row9);

        Cell cell101 = new Cell("qqqq");
        Cell cell102 = new Cell("q1.1");
        List<Cell> cells10 = new ArrayList<>(2);
        cells10.add(cell101);
        cells10.add(cell102);
        Row row10 = new Row(cells10);
        rows.add(row10);

        Cell cell111 = new Cell("qqqq");
        Cell cell112 = new Cell("0.1");
        List<Cell> cells11 = new ArrayList<>(2);
        cells11.add(cell111);
        cells11.add(cell112);
        Row row11 = new Row(cells11);
        rows.add(row11);

        Cell cell121 = new Cell("qqqq");
        Cell cell122 = new Cell("-1.1");
        List<Cell> cells12 = new ArrayList<>(2);
        cells12.add(cell121);
        cells12.add(cell122);
        Row row12 = new Row(cells12);
        rows.add(row12);

        table = new Table(rows);


    }

    @Test
    public void testSerializerWithSimpleTable() {
        String expected = "22\ta\tb\n12\te\tf\nj\t3\tf\n";
        String actual = tableSerializer.serialize(simpleTable);
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void testDeserializerForSimpleTable() {
        String text = "22\ta\tb\n12\te\tf\nj\t3\tf\n";
        Table actual = tableSerializer.deserialize(text);
        Assert.assertEquals(actual, simpleTable);

    }

    @Test
    public void testDeserializer() {
        String text = "-2.2\t2\t3\t4\n" +
                "2.2\t12345q\t69\t-afg\n" +
                "2.2\t12345q\t69\t-asdf\n" +
                "-22\t1234234\tasdfasf\tasdgas\n" +
                "-22\t11\tabc\t\n" +
                "-22\t-3\t4\t\n" +
                "\t\t\t\n" +
                "-1.1\t\t\t\n" +
                "\t\t\t\n" +
                "qqqq\tq1.1\n" +
                "qqqq\t0.1\n" +
                "qqqq\t-1.1\n";
        Table actual = tableSerializer.deserialize(text);
        Assert.assertEquals(actual, table);


    }

    @Test
    public void testSerializer() {
        String expected = "-2.2\t2\t3\t4\n" +
                "2.2\t12345q\t69\t-afg\n" +
                "2.2\t12345q\t69\t-asdf\n" +
                "-22\t1234234\tasdfasf\tasdgas\n" +
                "-22\t11\tabc\t\n" +
                "-22\t-3\t4\t\n" +
                "\t\t\t\n" +
                "-1.1\t\t\t\n" +
                "\t\t\t\n" +
                "qqqq\tq1.1\n" +
                "qqqq\t0.1\n" +
                "qqqq\t-1.1\n";
        String actual = tableSerializer.serialize(table);
        Assert.assertEquals(actual, expected);

    }

}
