package com.example.sd2020.demo;

import com.example.sd2020.demo.arch.FacadeSample;
import com.example.sd2020.demo.arch.SampleOperations;
import connection.ConnectionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import model.AbstractDAO;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DemoApplicationTests {

	protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
	@Mock
	SampleOperations sampleOperations;
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	private FacadeSample facadeSample;
	private Object User;


	@Test
	public void testFindById() {
		User currentUser = new User(1,"Alexandra", "Covaci", 21, "F");
		User instance = new User();
		int id = 1;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		String query = "SELECT * FROM ps1.user where idUser = 1;";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();


			while (resultSet.next()) {

				for (Field field : User.class.getDeclaredFields()) {
					Object value = resultSet.getObject(field.getName());
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(),User.class);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				}
			}
		} catch (SQLException | IntrospectionException e) {
			LOGGER.log(Level.WARNING, User.class.getName() + "DAO:findById " + e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}

		assertEquals(currentUser.toString(), instance.toString());
	}


	@Test
	public void testFindByGender() {

		User currentUser = new User(3,"Liviu", "Mich", 30, "M");
		User instance = new User();
		int id = 1;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		String query = "SELECT * FROM ps1.user where gender = \"M\";";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();


			while (resultSet.next()) {

				for (Field field : User.class.getDeclaredFields()) {
					Object value = resultSet.getObject(field.getName());
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(),User.class);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				}
			}
		} catch (SQLException | IntrospectionException e) {
			LOGGER.log(Level.WARNING, User.class.getName() + "DAO:findById " + e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}

		assertEquals(currentUser.toString(), instance.toString());
	}

}
