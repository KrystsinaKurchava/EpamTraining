package ioStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Option {
    public static void main(String args[]) {
        final Integer countForRandomNumber = 6;
        final String pathBySortAndRecord = "data/sort.txt";
        final String pathByReaderForReplacePublicToPrivate ="data/publicToPrivate.txt";
        final String pathByWriterForReplacePublicToPrivate ="data/publicToPrivateResult.txt";
        sortAndRecord(pathBySortAndRecord, countForRandomNumber);
        replacePublicToPrivate(pathByReaderForReplacePublicToPrivate,pathByWriterForReplacePublicToPrivate);
    }

    public static void sortAndRecord(String path, int count) {
        List<Integer> lines = new ArrayList<Integer>();
        String line;
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < count; i++) {
                fileWriter.write((int) (Math.random() * 30 - 15) + " ");
            }
        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (BufferedReader fileReader = new BufferedReader(new FileReader(path))) {
            line = fileReader.readLine();
            if (line != null) {
                for (String s : line.split(" ")) {
                    lines.add(Integer.parseInt(s));
                }
            }
            Collections.sort(lines);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path, true))) {
            fileWriter.newLine();
            fileWriter.write(lines.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void replacePublicToPrivate(String path,String pathResult) {
      String line;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(pathResult))) {

            while ((line = fileReader.readLine()) != null) {
                fileWriter.append(line.replace("public", "private")).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

