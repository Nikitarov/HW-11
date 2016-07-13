import java.io.*;
import java.util.Scanner;

public class Main {

    public static final String FILE_NAME = "test.txt";
    public static final String CHARSET = "UTF-8";
    public static final String WORD_FOR_EXIT = "--stop";
    public static final boolean WRITE_TO_END = true;

    public static void main(String[] args) {

        readTheConsole();
    }

    private static void readTheConsole() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("App was started. Enter new line or '--stop' to exit.");
            while (sc.hasNext()) {
                String line = sc.nextLine();
                if (isStopTheApp(line)) {
                    System.out.println("App was stopped");
                    return;
                }
                writeToFile(line);
                System.out.println("Enter new line...");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File was not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Access file error " + e.getMessage());
        }
    }

    private static void writeToFile(String line) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME, WRITE_TO_END);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, CHARSET);
             PrintWriter writer = new PrintWriter(outputStreamWriter)) {
            writer.println(line);
        }
    }

    private static boolean isStopTheApp(String line) {
        return line.equals(WORD_FOR_EXIT);
    }
}


