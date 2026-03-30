import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        System.out.println("====Inicializtion Treads====");
        for(int i=0;i<10;i++)
        {
            Thread t_tmp = null;
            try
            {
               t_tmp=new Thread(new MyNewThread(i));
            }
            catch (Exception e) {
                System.out.println(e);
                System.exit(1);
            }
            threads.add(t_tmp);
        }
        threads.forEach(Thread::start);

        //Thread initialazion end;

        Scanner sc = new Scanner(System.in);
        enum commands {start,stop,end}
        String command;
        int threadNumber=0;
        while(true) {
            if ((command = sc.next()).equals("end"))
            {
                break;
            }
            threadNumber= sc.nextInt();


            switch (command) {
                case "start":
                    threads.get(threadNumber).start();

                    break;
                case "stop":
                    threads.get(threadNumber).interrupt();
                    break;
            }

        }

        threads.forEach(Thread::interrupt);

    }

}

