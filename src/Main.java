import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //Initiate FileChooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a text file");

        int userSelection = fileChooser.showOpenDialog(null);
        //If user selects a file and hits OPEN, begin
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                //New BufferedReader to read text file
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                //Initialize counts
                int linesCount = 0;
                int wordsCount = 0;
                int charactersCount = 0;
                //Initialize line variable
                String line;
                //While there is a line to read, loop
                while ((line = reader.readLine()) != null) {
                    //Add 1 to line count
                    linesCount++;
                    //Identify 'words' by the space between them
                    String[] words = line.split("\\s+");
                    //Use the string length method to update the count
                    wordsCount += words.length;
                    //Use the line length method to get the total characters.
                    charactersCount += line.length();
                }
                //Close the reader
                reader.close();
                //Print results
                System.out.println("Summary report:");
                System.out.println("File name: " + selectedFile.getName());
                System.out.println("Number of lines: " + linesCount);
                System.out.println("Number of words: " + wordsCount);
                System.out.println("Number of characters: " + charactersCount);
            //Catch errors and print the error for debugging
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        }
    }
}