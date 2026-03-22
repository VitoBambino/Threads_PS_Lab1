public class MyNewThread implements Runnable {

    public void run() {
        for(int i = 0; i < 100; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " running");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                MyNewThread.threadMessage("Somthing went wrong");
            }
        }

    }

    private static void threadMessage(String s) {
        System.out.println(s);
    }

}


