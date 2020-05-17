package sort;

import model.Row;
import util.Util;

import java.util.Comparator;

public class FirstCellValueComparator implements Comparator<Row> {

    @Override
    public int compare(Row r1, Row r2) {

        String value1 = r1.getCells().get(0).getValue();
        String value2 = r2.getCells().get(0).getValue();

        Util.ParsingResult<Double> parsedValue1 = Util.tryParse(value1);
        Util.ParsingResult<Double> parsedValue2 = Util.tryParse(value2);

        //compare numerals
        if (parsedValue1 != null & parsedValue2 != null) {
            return (int) (parsedValue1.result - parsedValue2.result);
        }
        //put empty value after numerals
        if (parsedValue1 != null & value2.isEmpty()) {
            return -1;
        }
        if (parsedValue2 != null & value1.isEmpty() | value2.isEmpty()) {
            return 1;
        }
        //compare and put alphabetic values in the end
        return value1.compareTo(value2);
    }
}
