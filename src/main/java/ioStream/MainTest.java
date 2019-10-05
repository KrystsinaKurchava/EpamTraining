package ioStream;

import java.io.*;
import java.util.*;

public class MainTest {
    public static final String offset = "    ";
    public static final String directoryPrefix = "|----";
    public static final String filePrefix = "|    ";
    public static final String descriptionName = "directoryDescription.txt";

    public static void main(String[] args) {
        String filePath = args[0];
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IllegalArgumentException("");
        }
        if (file.isDirectory()) {
            String result = describeDirectory(file, "");
            System.out.println(result);
            try {
                FileWriter writer = new FileWriter(filePath + "\\" + descriptionName);
                writer.write(result);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (!file.isDirectory() && filePath.endsWith(".txt")) {
            printFileData(filePath);
        } else {
            throw new IllegalArgumentException("");
        }
    }

    public static String describeDirectory(File directory, String currentOffset) {
        String result = currentOffset + directoryPrefix + directory.getName() + "\r\n";
        File[] files =directory.listFiles();
                Arrays.sort(files, (o1, o2) -> {
            if (o1.isDirectory() ){
                return 1;
            } else {
                if (o2.isDirectory()){
                    return -1;
                }
                return 0;
            }
        });
        for (File file : files) {
            if (file.isDirectory()) {
                result += describeDirectory(file, currentOffset + offset);
            } else {
                result += describeFile(file, currentOffset);
            }
        }
        return result;
    }

    public static String describeFile(File file, String currentOffset) {
        return currentOffset + filePrefix + file.getName() + "\r\n";
    }

    public static void printFileData(String path) {
        Integer directoryCount = 0;
        Integer fileCount = 0;
        Integer filesNamesLength = 0;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path))) {
            for (Object readLine : fileReader.lines().toArray()) {
                String line = (String) readLine;
                if (line.contains(directoryPrefix)) {
                    directoryCount++;
                } else {
                    fileCount++;
                    Integer currentOffset = line.indexOf(filePrefix);
                    Integer nameLength = line.length() - currentOffset - filePrefix.length();
                    filesNamesLength += nameLength;
                }
            }
            System.out.println("Количесвто файлов " + fileCount);
            System.out.println("Количесвто папок " + directoryCount);
            System.out.println("Среднюю длинну названия файла " + filesNamesLength / fileCount);
            System.out.println("Среднее количество файлов в папке " + fileCount / directoryCount);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
