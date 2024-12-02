import java.util.Scanner;

class WrongAge extends Exception {
  
    public WrongAge() {
        super("Age Error");
    }


    public WrongAge(String message) {
        super(message);
    }
}


class InputScanner {
    Scanner s = new Scanner(System.in);

  
    public int readAge() {
        return s.nextInt();
    }
}


class Father extends InputScanner {
    protected int fatherAge;

    
    public Father() throws WrongAge {
        System.out.print("Enter father's age: ");
        fatherAge = readAge();
        if (fatherAge < 0) {
            throw new WrongAge("Age cannot be negative");
        }
    }

    
    public void displayFatherAge() {
        System.out.println("Father's age: " + fatherAge);
    }
}


class Son extends Father {
    private int sonAge;

  
    public Son() throws WrongAge {
        
        super();
        System.out.print("Enter son's age: ");
        sonAge = readAge();

      
        if (sonAge > fatherAge) {
            throw new WrongAge("Son's age cannot be greater than father's age");
        } else if (sonAge < 0) {
            throw new WrongAge("Age cannot be negative");
        }
    }

  
    public void displaySonAge() {
        System.out.println("Son's age: " + sonAge);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            
            Son son = new Son();

            
            son.displayFatherAge();
            son.displaySonAge();
        } catch (WrongAge e) {
            
            System.out.println(e.getMessage());
        }
    }
}
