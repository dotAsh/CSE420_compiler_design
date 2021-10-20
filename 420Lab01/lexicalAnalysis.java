
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lexicalAnalysis {

    //hashSets for storing the tokens and making a symbol table
    HashSet<String> key = new HashSet<>();
    HashSet<String> id = new HashSet<>();
    HashSet<String> logOp = new HashSet<>();
    HashSet<String> matOp = new HashSet<>();
    HashSet<String> num = new HashSet<>();
    HashSet<String> others = new HashSet<>();

    public void printSymbolTable() { //prints the Symbol Table
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                printHashSet(key, "Keywords");
            } else if (i == 1) {
                printHashSet(id, "Identifiers");
            } else if (i == 2) {
                printHashSet(logOp, "Logical Operators");
            } else if (i == 3) {
                printHashSet(matOp, "Math Operators");
            } else if (i == 4) {
                printHashSet(num, "Numerical Values");
            } else if (i == 5) {
                printHashSet(others, "Others");
            }
        }
    }

    public void lexicalAnalyst(String s) {  //matches and inputs each lexime in their correct hashSet

        Pattern p1 = Pattern.compile("^(int)$|^(if)$|^(else)$|^(float)$|^(double)$");//keywords
        Pattern p2 = Pattern.compile("(^[0-9]*(.)[0-9]+)$|(^[0-9]+)$");//numerics
        Pattern p3 = Pattern.compile("^[a-zA-Z][a-zA-Z0-9$_]*$");//identifier
        Pattern p4 = Pattern.compile("^(<){1,2}$|^(>){1,2}$|^(=){2}$|^(<=){1}$|^(>=){1}$");//lodical operator
        Pattern p5 = Pattern.compile("^(\\+){1,2}$|^(\\-){1,2}$|^(\\*){1}$|^(\\/){1}$|^(\\=){1}$");//math operator
        Pattern p6 = Pattern.compile("^(\\(){1}$|^(\\)){1}$|^(\\{){1}$|^(\\}){1}$|^(;){1}$|^(,){1}$|.");//others

        if (p1.matcher(s).find()) {
            key.add(s);
        } else if (p2.matcher(s).find()) {
            num.add(s);
        } else if (p3.matcher(s).find()) {
            id.add(s);
        } else if (p4.matcher(s).find()) {
            logOp.add(s);
        } else if (p5.matcher(s).find()) {
            matOp.add(s);
        } else if (p6.matcher(s).find()) {
            others.add(s);
        }
    }

    public void printHashSet(HashSet<String> h, String s) { //prints a single hashSet

        Boolean f1 = true;
        Boolean f2 = false;
        if (s.equals("Others")) {
            f2 = true;
        }

        Iterator i = h.iterator();
        while (i.hasNext()) {
            if (f1) {
                f1 = false;
                System.out.print(s + ": " + i.next());
            } else if (f2) {
                System.out.print(" " + i.next());
            } else {
                System.out.print("," + i.next());
            }

        }
        System.out.print("\n");
    }

}
