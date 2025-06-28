import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileHandler {

    // Reads and prints the contents of a file
    public static void readFile(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            System.out.println("File Content:");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Writes content to a file (overwrites if file exists)
    public static void writeFile(String filePath, String content) {
        try {
            Files.write(Paths.get(filePath), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Modifies a file by replacing a target word with a replacement word
    public static void modifyFile(String filePath, String target, String replacement) {
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);
            List<String> modifiedLines = new ArrayList<>();

            for (String line : lines) {
                modifiedLines.add(line.replaceAll(target, replacement));
            }

            Files.write(path, modifiedLines, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    // Sample usage
    public static void main(String[] args) {
        String filePath = "sample.txt";
        
        // Write content
        writeFile(filePath, "Hello World!\nThis is a sample file.");

        // Read content
        readFile(filePath);

        // Modify content
        modifyFile(filePath, "World", "Java");

        // Read modified content
        readFile(filePath);
    }
}
