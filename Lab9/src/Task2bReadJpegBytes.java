import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Task2bReadJpegBytes {
    public static void main(String[] args) {

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("Lab9/logo.jpeg"))) {

            System.out.println("Total available bytes: " + bis.available()); // show how many bytes are available in the stream

            int firstByte = bis.read();  // read one byte as an integer
            System.out.println("First byte (decimal): " + firstByte); // display the FIRST byte
            System.out.println("First byte as char: " + (char) firstByte);  //likely unreadable due to binary

            byte[] buffer = new byte[10];
            bis.read(buffer);
            System.out.print("Next 10 bytes (decimal values): "); // read next 10 bytes into a buffer array
            for (byte b : buffer) {
                System.out.print(b + " ");  // print each byte as a number
            }
            System.out.println();
            System.out.println("Next 10 bytes as text (garbled): " + new String(buffer)); // print as text will show garbage

            System.out.println("Mark supported: " + bis.markSupported()); // check mark support
            bis.mark(20); // remember this position
            bis.skip(5); // skip 5 bytes

            byte[] after_skip = new byte[5];
            bis.read(after_skip);
            System.out.print("5 bytes after skip (decimal): "); // read 5 bytes after the skip
            for (byte b : after_skip) {
                System.out.print(b + " ");
            }
            System.out.println();

            bis.reset();
            byte[] after_reset = new byte[5];
            bis.read(after_reset);
            System.out.print("5 bytes after reset (decimal): "); // reset to marked position
            for (byte b : after_reset) {
                System.out.print(b + " "); // read the same 5 bytes again
            }
            System.out.println();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}