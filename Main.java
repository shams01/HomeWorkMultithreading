package CaseHomeWork;


public class Main {
    public static void main(String[] args) {
        findMinNumber(10);
    }

    private static void findMinNumber(int potok) {
        for(int i=0; i < potok; i++){
            System.out.println("Begin : " + Thread.currentThread().getName());
            Thread thread1 = new Thread(new Example());
            thread1.start();
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End : " + Thread.currentThread().getName());
        }
    }
}

class Example implements Runnable {

    @Override
    public void run() {
        System.out.println("Search min: " + Thread.currentThread().getName());

        int[] array = new int[100000];
        for (int i = 0; i < 100000; i++) {
            int number = (int) (10 + Math.random() * 999999);
            array[i] = number;
        }
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }

        System.out.println(Thread.currentThread().getName() + " Find min: " + min);
    }
}
