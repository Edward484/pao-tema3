package main.java.ro.unibuc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
    TODO:
    scrieti o clasa java care sa returneze toate cuvinetele de lungime > n dintr-un fisier text
    Lungimea n trebuie introdusa de la tastatura.

    In plus fata de lungime, care trebuie introdusa de la tastatura, putem filtra si dupa alte conditii(vedeti testele)
 */
public class FileWordCounter {
    Integer queriedLength;
    String query;
    ArrayList<String> words;

    public FileWordCounter(Integer queriedLength, String query) {
        this.queriedLength = queriedLength;
        this.query = query;
        this.words = new ArrayList<String>();
    }

    public FileWordCounter() {
        queriedLength = 1;
        query = "";
        this.words = new ArrayList<String>();
    }

    //HINT: you could make one generic method to reuse for all three methods above
    //HINT2: think about functional interfaces, one that verifies things in particular

    private void readPoetry(String filename){
        File file = new File(String.format("src/test/resources/%s.txt", filename));
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                String data = reader.next();
                this.words.add(data);
            }
            System.out.println(query);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<String> filterString(Integer sizeOverride, String op ){
        try {
            if(op.equals("eq")) {
                return this.words.stream()
                        .filter(word -> word.length() == sizeOverride)
                        .collect(Collectors.toList());
            }
            if(op.equals("lt")) {
                return this.words.stream()
                        .filter(word -> word.length() < sizeOverride)
                        .collect(Collectors.toList());
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<String> getSizeOne(String fileName) {
        readPoetry(fileName);
        return filterString(1,"eq");
    }

    //todo I don't understand what this function should do. Atm it returns the strings that have a length of 1 or 2
    public List<String> getSizeLessThan3(String fileName) {
        readPoetry(fileName);
        return filterString(3, "lt");
    }

    public List<String> countWordAppearances(String fileName, String word) {
        readPoetry(fileName);
        try{
            return this.words.stream()
                    .filter(wrd -> {
                        final int index = wrd.indexOf('!');
                        String wrdTrimmed = wrd;
                        if(index > 0) {
                            wrdTrimmed = wrd.substring(0, index);
                        }
                        return wrdTrimmed.equals(word);
                    })
                    .collect(Collectors.toList());
        }
        catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    public List<String> filterWordAndLength(String fileName, Integer sizeOverride) {
        readPoetry(fileName);
        try{
            return this.words.stream()
                    .filter(wrd -> wrd.length() == sizeOverride)
                    .collect(Collectors.toList());
        }
        catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}
