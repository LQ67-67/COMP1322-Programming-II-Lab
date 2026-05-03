import java.io.BufferedInputStream;  // add mark/reset support to byte streams
import java.io.FileInputStream; // open a file as raw bytes

public class Task2aReadTxtBytes {
    public static void main(String[] args) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("Lab9/sample.txt"))) {

            System.out.println("Total available bytes: " + bis.available()); // print total available bytes in the stream first

            int firstByte = bis.read();  // read() returns one byte as an int (0-255)
            System.out.println("First byte as char: " + (char) firstByte); // print the first byte as a character

            byte[] buffer = new byte[10]; // create a buffer array to hold 10 bytes
            bis.read(buffer); // fill the buffer with next 10 bytes
            System.out.println("Next 10 bytes as text: " + new String(buffer));  // convert bytes to string

            System.out.println("Mark supported: " + bis.markSupported());
            bis.mark(20);  // mark this position so that we can reset up to 20 bytes ahead

            bis.skip(5); // skip 5 bytes

            byte[] after_skip = new byte[5];
            bis.read(after_skip);
            System.out.println("5 bytes after skip: " + new String(after_skip)); // read next 5 bytes after skip

            bis.reset();
            byte[] after_reset = new byte[5];
            bis.read(after_reset);
            System.out.println("5 bytes after reset: " + new String(after_reset)); // reset back to the marked position and re-read the same 5 bytes

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}