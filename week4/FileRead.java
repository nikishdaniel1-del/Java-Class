package week4;
import java.io.FileReader;

public class FileRead {
    public static void main(String[] args) {
        try
        {
            FileReader cursor = new FileReader("data.txt");
            int ch,index=0,id=0;
            String result = "",currentId = "",ids = "1";
            while ((ch = cursor.read()) != -1){
                char currentCharacter = (char) ch;
                if (id==1){
                    if (currentCharacter == '\n'){id=0;}
                    else {currentId = currentId+currentCharacter;}}
                if (ch==32 && result.equals("ID :")){id = 1;}
                if (currentCharacter == '\n'){index=index+1;}
                if (index == 3 && currentId.equals(ids)){System.out.println(result);break;}
                else{result="";currentId="";}
                result = result + currentCharacter;}
            cursor.close();}
        catch (Exception e){System.out.println(e.getMessage());}}}