package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

    public static ParsingResult<Double> tryParse(String source) {
        ParsingResult<Double> result = null;
        try {
            Double parsedDouble = Double.parseDouble(source);
            result = new ParsingResult<>(parsedDouble);
        } catch (NumberFormatException e) {
        }
        return result;
    }

    public static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static void saveToFile(String text, String filePath) {
        try {
            Files.write(Paths.get(filePath), text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ParsingResult<T> {
        public final T result;

        public ParsingResult(T result) {
            this.result = result;
        }
    }
}
