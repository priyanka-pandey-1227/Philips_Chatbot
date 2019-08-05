package com.philips.chatbot;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import com.philips.chatbot.exception.NoDataException;
import com.philips.chatbot.exception.NoUserInputException;

public class ChatbotWorkflowEngineTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	Scanner sc;
	
	/**
	 * This test case tests the workflow of the chatbot Model
	 * @throws NoDataException
	 * @throws NoUserInputException
	 */
	
	
	@Test
	public void testForMonitorTypeQ1() throws NoDataException, NoUserInputException {

		
		System.out.println("\n----------------------------------************************************----------------------------------------\n" );
		System.out.println("Testing Success Case where the 1st answer is choosen as 1 or 2 and modules questions are asked");
		sc = new Scanner("1 1 2 2 1 2 1 2");
		String optionalModules[] = null;
		ChatbotWorkflowEngine cwf = new ChatbotWorkflowEngine(sc);
		optionalModules = cwf.getProductList();
		String targetValue[] = new String[10];
		targetValue[0] = "IntelliVue MX450";
		targetValue[1] = "IntelliVue MX500";
		assertArrayEquals(targetValue, optionalModules);

	}

	@Test
	public void testAskModulesForMonitorTypeQ1() throws NoDataException, NoUserInputException {

		
		System.out.println("\n----------------------------------************************************----------------------------------------\n" );
		System.out.println("Testing Success Case where the 1st answer is choosen as 3 and modules questions are asked");
		sc = new Scanner("3 2 2 1 2 1 2 1");
		String optionalModules[] = null;
		ChatbotWorkflowEngine cwf = new ChatbotWorkflowEngine(sc);
		optionalModules = cwf.getProductList();
		String targetValue = "Goldway G40E";
		assertTrue(Arrays.asList(optionalModules).contains(targetValue));

	}

	@Test
	public void testFailureInvalidInputThreeTimesForQ1() {

		System.out.println("\n----------------------------------************************************----------------------------------------\n" );
		System.out.println("Testing Case where the user inputs are Invalid for 3 times for the first question [Exceptions Occurs]");
		sc = new Scanner("4 4 4 2 2 1 2 1 2 1");
		String optionalModules[] = null;
		ChatbotWorkflowEngine cwf = new ChatbotWorkflowEngine(sc);
		try {
			optionalModules = cwf.getProductList();
		} catch (NoUserInputException e) {
			assertTrue(true);
		} catch (NoDataException e) {
			assertTrue(false);
		}
		assertNull(optionalModules);

	}

	@Test
	public void testSuccessScreenTypeModule1() throws NoDataException, NoUserInputException {

		
		System.out.println("\n----------------------------------************************************----------------------------------------\n" );
		System.out.println("Testing Case where the user inputs are Invalid for 2 times for the Sixth question");
		sc = new Scanner("1 2 2 1 2 5 5 2 2 1");
		String optionalModules[] = null;
		ChatbotWorkflowEngine cwf = new ChatbotWorkflowEngine(sc);
		optionalModules = cwf.getProductList();
		String targetValue[] = new String[10];
		targetValue[0] = "IntelliVue MX800";
		assertArrayEquals(targetValue, optionalModules);
	}

	@Test
	public void testFailureInvalidInputThreeTimesForQ2() {
		
		System.out.println("\n----------------------------------************************************----------------------------------------\n" );

		System.out.println("Testing Case where the user inputs are Invalid for 3 times for the 2nd question [Exceptions Occurs]");
		sc = new Scanner("1 5 5 3 1 2 2 1 2 1 2 1");
		String optionalModules[] = null;

		ChatbotWorkflowEngine cwf = new ChatbotWorkflowEngine(sc);
		try {
			optionalModules = cwf.getProductList();
		} catch (NoUserInputException e) {
			assertTrue(true);
		} catch (NoDataException e) {
			assertTrue(false);
		}
		assertNull(optionalModules);

	}

	@Test
	public void testSuccessModular_InvalidInputTwoTimesForQ3() {
		
		System.out.println("\n----------------------------------************************************----------------------------------------\n" );

		System.out.println("Testing Case where the user inputs are Invalid for 2 times for the 3rd question");
		sc = new Scanner("1 2 6 6 1 2 2 1 2 2");
		String optionalModules[] = null;
		ChatbotWorkflowEngine cwf = new ChatbotWorkflowEngine(sc);
		try {
			optionalModules = cwf.getProductList();
		} catch (NoDataException | NoUserInputException e) {
			assertTrue(false);
		}
		assertNotNull(optionalModules);
		assertEquals(10, optionalModules.length);
		// assertEquals(optionalModules[0], "");

	}

	@Test
	public void testFailureInvalidInputThreeTimesForQ3() {
		
		
		
		System.out.println("\n----------------------------------************************************----------------------------------------\n" );

		System.out.println(
				"Testing Case where the user inputs are Invalid for 2 times for the 2nd question  And 3 times Invalid input for 3rd question [Exceptions Occurs]");
		sc = new Scanner("1 5 5 2 7 7 7 2 2 1 2 1");
		String optionalModules[] = null;

		ChatbotWorkflowEngine cwf = new ChatbotWorkflowEngine(sc);
		try {
			optionalModules = cwf.getProductList();
		} catch (NoUserInputException e) {
			assertTrue(true);
		} catch (NoDataException e) {
			assertTrue(false);
		}
		assertNull(optionalModules);

	}

	@Test
	public void testFailureInvalidInputThreeTimesForQ6() {
		
		System.out.println("\n----------------------------------************************************----------------------------------------\n" );

		System.out.println(
				"Testing Case where the user inputs are Invalid for 2 times for the 3rd question And 3 times for 6th question [Exceptions Occurs]");

		sc = new Scanner("1 2 6 6 1 2 2 1 5 5 5 2");
		String optionalModules[] = null;
		ChatbotWorkflowEngine cwf = new ChatbotWorkflowEngine(sc);
		try {
			optionalModules = cwf.getProductList();
		} catch (NoUserInputException e) {
			assertTrue(true);
		} catch (NoDataException e) {
			assertTrue(false);
		}
		assertNull(optionalModules);

	}

	
}
