import java.io.*;
import java.util.Scanner;
public class fileOp{
    public static void main(String[] args) {
        String path = "data.txt";
        File fileObject = new File(path);
        if (fileObject.exists()) {
            try{
                Scanner terminal = new Scanner(fileObject);
                while (terminal.hasNextLine()){System.out.println(terminal.nextLine());}}
            catch (Exception e){System.out.println(e);}}
        else{try {fileObject.createNewFile();} catch (Exception e) {System.out.println(e);}}}}