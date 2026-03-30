public class MyNewThread implements Runnable {

    private final int threadNumber;
    private boolean suspended = true;

    public MyNewThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    public synchronized void resumeThread() {
        suspended = false;
        notify();
    }

    public synchronized void stopThread() {
        suspended = true;
    }

    @Override
    public void run() {
        char letter = 'A';

        for(int i = 0; i < 26; i++) {
            synchronized (this) {
                while (suspended) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        MyNewThread.threadMessage("Somthing went wrong");
                    }
                }
            }

            int displayNumber = (threadNumber == 10) ? 0 : threadNumber;
            MyNewThread.threadMessage(letter + "" + displayNumber);
            letter++;
            try {
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


