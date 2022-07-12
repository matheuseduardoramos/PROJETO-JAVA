package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author mathe
 */
public class ProjectController {



    public void save(Project project) {
        String sql = "INSERT INTO projects (Name,"
                + "Description,"
                + "CreateDate, "
                + "UpdateDate) VALUES (?,?,?,?)";
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            System.out.println(project.getCreateDate().getTime());
            statement.setDate(3, new java.sql.Date(project.getCreateDate().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdateDate().getTime()));
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar o projeto "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(con, statement);
        }
    }

    public void update(Project project) {
        String sql = "UPDATE projects SET name = ?, description = ?, CreateDate = ?, UpdateDate = ? WHERE ProjectId = ?";

        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreateDate().getTime()));
            statement.setDate(4, new Date(project.getUpdateDate().getTime()));
            statement.setInt(5, project.getProjectId());
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao alterar projeto "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(con, statement);
        }

    }

    public void removeById(int projectId) throws SQLException {

        String sql = "DELETE FROM projects WHERE ProjectId = ?";

        Connection con = null;

        PreparedStatement statement = null;
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            ConnectionFactory.getConnection();
            statement.setInt(1, projectId);
            statement.execute();
        } catch (Exception ex) {
            throw new SQLException("Erro ao deletar o projeto "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(con, statement);
        }
    }

    public List<Project> getAll() throws SQLException {
        String sql = "SELECT * FROM projects";
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Project> projects = new ArrayList<Project>();
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Project project = new Project();
                project.setProjectId(resultSet.getInt("ProjectId"));
                project.setName(resultSet.getString("Name"));
                project.setDescription(resultSet.getString("Description"));
                project.setCreateDate(resultSet.getDate("CreateDate"));
                project.setUpdateDate(resultSet.getDate("UpdateDate"));
                projects.add(project);
            }
        } catch (Exception ex) {
            throw new SQLException("Erro ao Listar o projeto "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(con, statement, resultSet);
        }
        return projects;
    }
}
