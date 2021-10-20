
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class lab01 {
    
    public static void main (String args[]) throws FileNotFoundException{
        File f = new File("input.txt");//there should be at least one space between each lexime
        Scanner sc = new Scanner(f);
        lexicalAnalysis lA = new lexicalAnalysis();
        
        while (sc.hasNext()){
            lA.lexicalAnalyst(sc.next()); 
        }
        lA.printSymbolTable();
        
    } 
    
}
