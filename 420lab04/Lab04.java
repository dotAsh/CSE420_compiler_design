

package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Lab04 {

    
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("input.txt");
       Scanner sc = new Scanner(f);
       Pattern p = Pattern.compile("^(public)(.)(static)?(.)[(void)|(double)|(String)](.)([a-zA-Z]*)*");
       while(sc.hasNext()){
           String s = sc.nextLine();
         
           Matcher m = p.matcher(s);
           if (m.find()){
               String s1 = s.substring(m.start(), m.end());
               System.out.println(s1);
           }
           
       }
       
    }
    
}
