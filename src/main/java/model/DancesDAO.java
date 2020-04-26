package model;

import connection.ConnectionFactory;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class DancesDAO extends AbstractDAO<Dances> {
    public DancesDAO() {
        super();
    }

    public List<Dances> findByName(String dance){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

//        Field field = type.getDeclaredFields()[0];
        String fieldName = "dance";

        String query = createSelectQuery(fieldName);
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, dance);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException e){
            LOGGER.log(Level.WARNING, fieldName + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(connection);
        }
        return null;
    }
}
