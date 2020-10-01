import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class get_regex {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Printed_file");
        int[] x = {65, 66, 67, 68};
        String s = "Hello Divy. You are the best";
        byte[] ch = s.getBytes();
        outputStream.write(ch);
        outputStream.close();
        printer();
    }

    private static void printer() throws IOException {
        FileInputStream inputStream = new FileInputStream("Printed_file");
        byte[] pr = inputStream.readAllBytes();
        for (byte i : pr) {
            System.out.print((char) i);
        }
    }
}
