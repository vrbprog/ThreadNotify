import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Task> list = new ArrayList<>();
        list.add(new Task("A"));
        list.add(new Task("B"));
        list.add(new Task("C"));

        for (Task task: list) {
            new Thread(task).start();
        }
    }
}
