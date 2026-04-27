import java.io.BufferedReader;  // BufferedReader reads text line by line efficiently
import java.io.FileReader;       // FileReader opens a text file for reading characters

public class Task1ReadTxt {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Lab9/sample.txt"))) { // open and read the file

            String line;  // store each line here temporarily

            while ((line = reader.readLine()) != null) { // read each line until there are no more lines
                System.out.println(line);
            }// stream will be closed automatically by try-with-resources

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); // if file is missing or cannot be read, print the error
        }
    }
}