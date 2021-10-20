

package lab03;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LAB03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Pattern p[] = new Pattern[n];
        for (int i = 0; i < p.length; i++) {
            p[i] = Pattern.compile(sc.next());
        }
        int n2 = sc.nextInt();
        sc.nextLine();
        for (int j = 0; j < n2; j++) {
            Boolean b = false;
            String m = sc.next();
            for (int k = 0; k < p.length; k++) {
                Matcher mt = p[k].matcher(m); 

                
                if (mt.find()) {
                    b = true;
                    System.out.println("YES, " + (k + 1));
                }

            }
            if (!b) {
                System.out.println("No, 0");
            }
            
        }

    }

}
