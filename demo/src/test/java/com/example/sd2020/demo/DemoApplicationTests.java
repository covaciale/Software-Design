package com.example.sd2020.demo;

import com.example.sd2020.demo.arch.FacadeSample;
import com.example.sd2020.demo.arch.SampleOperations;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DemoApplicationTests {

	@Mock
	SampleOperations sampleOperations;
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	private FacadeSample facadeSample;

	@Before
	public void init() {
		facadeSample = new FacadeSample(sampleOperations);
	}

	@Test
	public void testSample() {
		facadeSample.retrieveList();
		verify(sampleOperations).getList();
	}

	@Test
	public void testSampleAssert() {
		List<Integer> expectedList = new ArrayList<>();
		expectedList.add(2);
		expectedList.add(4);
		expectedList.add(5);

		when(sampleOperations.getList()).thenReturn(expectedList);
		List<Integer> currentList = facadeSample.retrieveList();
		assertEquals(expectedList, currentList);
	}
}
