package main.java.ro.unibuc;

import java.util.List;
import java.util.Scanner;

public class WordCounting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti lungimea maxima a cuvintelor cautate: ");
        Integer queriedLength = Integer.valueOf(scanner.next());

        System.out.println("Introduceti cuvantul cautat: ");
        String query = scanner.next();

        FileWordCounter fileWordCounter = new FileWordCounter(queriedLength, query);

        List<String> str1 = fileWordCounter.getSizeOne("poezie1");
        List<String> str2 = fileWordCounter.getSizeLessThan3("poezie1");
        List<String> str3 = fileWordCounter.countWordAppearances("poezie2", "Captain");
        int d = 3;
        //TODO: add code here to read from console and get the length limit


    }
}
