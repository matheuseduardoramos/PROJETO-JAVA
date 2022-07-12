package TodoApp;

import controller.ProjectController;
import controller.TaskController;
import java.util.Date;

import java.sql.SQLException;
import java.util.List;
import model.Project;
import model.Task;

public class App {
    
    public static void main(String[] args) throws SQLException {
        
        
        TaskController taskController = new TaskController();
        Task task = new Task();
        task.setProjectId(18);
        
        task.setName("teste03");
        task.setDescription("testando tasks");
        task.setNotes("sem notas");
        task.setIsCompleted(true);
        task.setDeadline(new Date());
        taskController.save(task);
        List<Task> tasks = taskController.getAll(16);
        System.out.println("total de tarefas = "+ tasks.size());
    }
    
}
