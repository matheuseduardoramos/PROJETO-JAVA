package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Task;
import util.ConnectionFactory;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class TaskController {

    public void save(Task task) {
        String sql = "INSERT INTO tasks (ProjectId,"
                + "Name,"
                + "Description,"
                + "Completed,"
                + "Notes,"
                + "Deadline,"
                + "CreateDate,"
                + "UpdateDate) VALUES (?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, task.getProjectId());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreateDate().getTime()));
            statement.setDate(8, new Date(task.getUpdateDate().getTime()));
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(con, statement);

        }

    }

    public void update(Task task) {
           String sql = "UPDATE tasks SET ProjectId = ?, Name = ?, Description = ?, completed = ?, notes = ?, deadline = ?, createDate = ?, updateDate = ? WHERE TaskId = ?";


        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, task.getProjectId());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreateDate().getTime()));
            statement.setDate(8, new Date(task.getUpdateDate().getTime()));
            statement.setInt(9, task.getTaskId());
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao alterar tarefa "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(con, statement);
        }
    }

    public void removeById(int taskId) throws SQLException {
        String sql = "DELETE FROM tasks WHERE TaskId = ?";

        Connection con = null;
        PreparedStatement statement = null;

        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        } catch (Exception ex) {
            throw new SQLException("Erro ao deletar a tarefa "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(con, statement);
        }
    }

    public List<Task> getAll(int ProjectId) throws SQLException {
        String sql = "SELECT * FROM tasks WHERE ProjectId = ?";
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Task> tasks = new ArrayList<Task>();
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, ProjectId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setTaskId(resultSet.getInt("TaskId"));
                task.setProjectId(resultSet.getInt("ProjectId"));
                task.setName(resultSet.getString("Name"));
                task.setDescription(resultSet.getString("Description"));
                task.setIsCompleted(resultSet.getBoolean("Completed"));
                task.setNotes(resultSet.getNString("Notes"));
                task.setDeadline(resultSet.getDate("Deadline"));
                task.setCreateDate(resultSet.getDate("CreateDate"));
                task.setUpdateDate(resultSet.getDate("UpdateDate"));
                tasks.add(task);
            }
        } catch (Exception ex) {
            throw new SQLException("Erro ao Listar a tarefa "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(con, statement, resultSet);
        }
        return tasks;
    }
}
