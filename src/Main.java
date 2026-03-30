import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        System.out.println("====Inicializtion Main====");
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

        Scanner sc = new Scanner(System.in);
        int flag=0;
        while(flag!=0)
        {
            System.out.println("Type anything to end threads:");
            flag=sc.nextInt();
        }
        threads.forEach(Thread::interrupt);





    }

}

