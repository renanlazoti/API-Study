package Exercises;

import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    public static void main(String[] args) {
        String content = "Conteúdo a ser gravado no arquivo.";

        try {
            FileWriter writer = new FileWriter("file.txt");
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
