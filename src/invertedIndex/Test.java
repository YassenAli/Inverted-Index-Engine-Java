/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invertedIndex;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    /**
     * Main entry point for the search engine application
     * @param args Command line arguments (not used)
     * @throws IOException If there's an error reading input/files
     */
    public static void main(String args[]) throws IOException {
        // Initialize the search engine index
        Index5 index = new Index5();

        // Configure document collection path (UPDATE THIS TO YOUR ACTUAL PATH)
        String dirPath = "Y:\\path\\to\\your\\documents\\";

        // Verify document directory exists
        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("Invalid directory path!");
            return;
        }

        // Get list of files in directory
        String[] fileList = dir.list();
        if (fileList == null || fileList.length == 0) {
            System.err.println("No files found in directory!");
            return;
        }

        // Prepend full path to filenames
        // Convert filenames to full paths (dir.list() returns base names only)
        for (int i = 0; i < fileList.length; i++) {
            fileList[i] = dirPath + File.separator + fileList[i];
        }

        // Configure and build the search index
        index.setN(fileList.length);       // Set total document count
        index.buildIndex(fileList);        // Construct inverted index
        index.printDictionary();           // Debug: show index contents

        // Test with a Sample query test
        String testQuery = "information retrieval";
        System.out.println("Results for '" + testQuery + "':\n" + index.find_24_01(testQuery));

        // Interactive query loop
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("\nEnter search phrase (empty to exit):");
                String phrase = in.readLine().trim();

                // Exit condition
                if (phrase.isEmpty()) break;

                // Process query and display results
                String results = index.find_24_01(phrase);
                System.out.println(results.isEmpty() ? "No matches found" : results);
            }
        }
    }
}

//    public static void main(String args[]) throws IOException {
//        Index5 index = new Index5();
//        //|**  change it to your collection directory
//        //|**  in windows "C:\\tmp11\\rl\\collection\\"
//        String files = "/home/ehab/tmp11/rl/collection/";
//
//        File file = new File(files);
//        //|** String[] 	list()
//        //|**  Returns an array of strings naming the files and directories in the directory denoted by this abstract pathname.
//        String[] fileList = file.list();
//
//        fileList = index.sort(fileList);
//        index.N = fileList.length;
//
//        for (int i = 0; i < fileList.length; i++) {
//            fileList[i] = files + fileList[i];
//        }
//        index.buildIndex(fileList);
//        index.store("index");
//        index.printDictionary();
//
//        String test3 = "data  should plain greatest comif"; // data  should plain greatest comif
//        System.out.println("Boo0lean Model result = \n" + index.find_24_01(test3));
//
//        String phrase = "";
//
//        do {
//            System.out.println("Print search phrase: ");
//            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//            phrase = in.readLine();
///// -3- **** complete here ****
//        } while (!phrase.isEmpty());
//
//    }
//}
