package com.example.sd2020.demo;

import com.example.sd2020.demo.arch.FacadeSample;
import com.example.sd2020.demo.arch.SampleOperations;
import connection.ConnectionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.*;
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
	private UserDAO userDAO = new UserDAO();
	private DancesDAO dancesDAO = new DancesDAO();
	private AntrenoriDAO antrenoriDAO = new AntrenoriDAO();


	@Test
	public void testFindById() {
		User currentUser = new User(1,"Alexandra", "Covaci", 21, "F", "Bachata");

		User user = userDAO.findById(1).get(0);
		assertEquals(currentUser.toString(), user.toString());
	}


	@Test
	public void testFindByGender() {

		User currentUser = new User(3,"Liviu", "Mich", 30, "M", "Kizomba");
		User user = userDAO.findByGender("M").get(0);
		assertEquals(currentUser.toString(), user.toString());
	}

	@Test
	public void testFindDance() {

		Dances currentDance = new Dances(1,"Salsa");
		Dances dance = dancesDAO.findAll().get(0);
		assertEquals(currentDance.toString(), dance.toString());
	}

	@Test
	public void testFindAntrenor() {

		Antrenori current = new Antrenori(1,"Carolina", "Capitan", "Salsa");
		Antrenori antrenor = antrenoriDAO.findAll().get(0);
		assertEquals(current.toString(), antrenor.toString());
	}

}
