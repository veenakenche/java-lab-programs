public class ThreadExample {
    static class BMSPrinter extends Thread {
        public void run() {
            try {
                while (true) {
                    System.out.println("BMS College of Engineering");
                    Thread.sleep(10000); 
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    static class CSEPrinter extends Thread {
        public void run() {
            try {
                while (true) {
                    System.out.println("CSE");
                    Thread.sleep(2000); 
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
  
        Thread t1 = new BMSPrinter();
        Thread t2 = new CSEPrinter();

        
        t1.start();
        t2.start();
    }
}
