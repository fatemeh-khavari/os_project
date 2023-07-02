import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int r1 = scanner.nextInt();
        int r2 = scanner.nextInt();
        int r3 = scanner.nextInt();

        int numberTask = scanner.nextInt();
        Task[] tasks = new Task[numberTask];

        for (int i = 0; i < numberTask; i++){
            String str = scanner.nextLine();
            String strings[] = str.split(" ");
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
        Scheduler scheduler = new Scheduler(r1, r2, r3, tasks);


    }
}
