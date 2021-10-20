
package pkg420lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  
    public static void main(String[] args) throws FileNotFoundException {
       File f = new File("input.txt");
       Scanner sc = new Scanner(f);
       int n = Integer.parseInt(sc.next());
       
       String inputs[] = new String[n];
       for(int i = 0;i<inputs.length;i++){
           inputs[i] = sc.next();
       }
       
       for(int i=0;i<inputs.length;i++){
           if(web(inputs[i]) &&(!inputs[i].contains("@"))){
               System.out.println("Web, "+(i+1));
           }else if(email(inputs[i])){
               System.out.println("Email, "+(i+1));
           }else{
               System.out.println("No");
           }
       }
       
    }
    public static boolean web(String s){
      
        int state = 1;
        boolean b1 = true;
        char c [] = s.toCharArray();
        for (int i = 0; i<c.length;i++){
           switch(state){
               case 1:
                    if ((c[i]>='a' && c[i]<='z' )||(c[i]>='A' && c[i]<='Z')){
                      state = 2;
                     
                   }else{
                        b1 = false;
                    }
                    break;
               case 2:
                   if (c[i]=='.'){
                       state = 3;
                       
                   }
                   break;
               case 3:
                   if ((c[i]>='a' && c[i]<='z' )||(c[i]>='A' && c[i]<='Z')){
                      state = 4;
                     
                   }else {
                       b1 = false;
                      
                   }
                   break;
               case 4:
                  if (c[i]=='.'){
                       state = 3;
                       
                   }
                  else if (!((c[i]>='a' && c[i]<='z' )||(c[i]>='A' && c[i]<='Z'))){
                      state = 2;
                     
                   } 
               break;
           }
          if (!b1){
              break;
          }
          
        }
        
        return state == 4;

    }
 
    public static Boolean email(String s){
        int state = 1;
        boolean b1 = true;
        char c [] = s.toCharArray();
        for (int i = 0; i<c.length;i++){
           switch(state){
               case 1:
                   if ((c[i]>='a' && c[i]<='z' )||(c[i]>='A' && c[i]<='Z')){
                      state = 2;
                     
                   }else{
                      b1 = false;
                    
                   }
                 break; 
               case 2:
                   if (c[i]== '@'){
                       state = 3;
                       
                   }
                   break;
               case 3:
                   if ((c[i]>='a' && c[i]<='z' )||(c[i]>='A' && c[i]<='Z')){
                      state = 4;
                      
                   }else if (c[i]>='0' && c[i]<='9' ){
                       b1= false;
                       
                   }
                   break;
               case 4:
                   if (c[i]=='.'){
                       state = 5;
                       
                   }else if (c[i]>='0' && c[i]<='9' ){
                       b1= false;
                       
                   }
                   break;
               case 5:
                   if ((c[i]>='a' && c[i]<='z' )||(c[i]>='A' && c[i]<='Z')){
                      state = 6;
                     
                   }else if ((c[i]>='0' && c[i]<='9' )|| (c[i]== '.')){
                       b1= false;
                      
                   }
                  break; 
               case 6:
                   if (c[i]== '.'){
                       state = 4;
                   }else if (c[i]>='0' && c[i]<='9' ){
                       b1= false;
                      
                   }
                   break;
           }
          if (!b1){
              break;
          }
        }
        
        return state == 6;
    }
    
}
