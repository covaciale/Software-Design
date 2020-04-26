package model;

import connection.ConnectionFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    String createSelectQuery(String field){
        return "SELECT " +
                " * " +
                " FROM " +
                "ps1." +
                type.getSimpleName() +
                " WHERE " +
                field +
                " = ?";
    }

    private String createSelectAll(){
        return "SELECT * FROM ps1." + type.getSimpleName();
    }

    private String createInsertQuery(String field){
        return "UPDATE " +
                type.getSimpleName() + "s" +
                " VALUES " + field;
    }

    public List<T> findAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String query = createSelectAll();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException e){
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public List<T> findByGender(String gender){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Field field = type.getDeclaredFields()[0];
        String fieldName = field.getName();

        String query = createSelectAll();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, gender);
            resultSet = statement.executeQuery();



            return createObjects(resultSet);
        } catch (SQLException e){
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public T findById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Field field = type.getDeclaredFields()[0];
        String fieldName = field.getName();

        String query = createSelectQuery(fieldName);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            //ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }


    public T add(T user){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createInsertQuery(user.toString());
        System.out.println(query);

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return user;
    }

    List<T> createObjects(ResultSet resultSet){
        List<T> list = new ArrayList<>();
        try{
            while (resultSet.next()){
                T instance = type.getDeclaredConstructor().newInstance();
                for (Field field : type.getDeclaredFields()){
                    Object value = resultSet.getObject(field.getName());
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                    Method method = propertyDescriptor.getWriteMethod();
                    System.out.println(instance);
                    System.out.println(value);
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException | NoSuchMethodException | SQLException | IllegalAccessException | IntrospectionException | InvocationTargetException e){
            e.printStackTrace();
        }

        return list;
    }
}
