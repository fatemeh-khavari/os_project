import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int r1 = scanner.nextInt();
        int r2 = scanner.nextInt();
        int r3 = scanner.nextInt();
        System.out.println(r1 +  r2 + r3);

        int numberTask = scanner.nextInt();
        Task[] tasks = new Task[numberTask];
        scanner.nextLine(); // مصرف کردن کاراکتر خالی

        int quantum = 0;

        for (int i = 0; i < numberTask; i++){
            String str = scanner.nextLine();
            String strings[] = str.split(" ");
            if (strings.length != 3) {
                throw new IllegalArgumentException("Invalid input format!");
            }
            quantum += Integer.parseInt(strings[2]);
            if( strings[1].equalsIgnoreCase("X") ){
                tasks[i] = new TaskX(strings[0], Integer.parseInt(strings[2]));
            }
            else if(strings[1].equalsIgnoreCase("Y")){
                tasks[i] = new TaskY(strings[0], Integer.parseInt(strings[2]));
            }
            else if(strings[1].equalsIgnoreCase("Z")){
                tasks[i] = new TaskZ(strings[0], Integer.parseInt(strings[2]));
            }
        }
        quantum = quantum * 8 / 10 / numberTask;
        Scheduler scheduler = new Scheduler(r1, r2, r3, tasks, quantum);
        // 0 = fcfs - 1 = sfj -- 2 = rr
        scheduler.Scheduling(1);


    }
}
