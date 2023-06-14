package com.JunitTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

 
class MathUtilsTest {
	
	MathUtils mathUtils;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.print("This need to run before all");
	}
	
	@BeforeEach
	void init() {
	 mathUtils = new MathUtils();
	}
	
	@AfterEach
	void cleanup() {
		System.out.print("Cleaning up....");
	}
	
	@Nested
	class AddTest{
		@Test
		@DisplayName("Testing add method for positive")
		void testAddPositive() {
			assertEquals(2, mathUtils.add(1, 1), "The add method shoud add tow numbers");
		}
		
		@Test
		@DisplayName("Testing add method for positive for negative")
		void testAddNegative() {
			assertEquals(-2, mathUtils.add(-1, -1), "The add method shoud add tow numbers");
		}
	}
	
	
	
	@Test
	void testComputeCircleArea() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Shoud retun right circle area");
	}

	@Test
	void testDivide() {
		boolean isServerUp = true;
		assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by 0 shoud throw");
	}
	
	@Test
	@DisplayName("Testing disable method")
	@Disabled
	void testDisabled() {
		fail("This test shoud be disabled");
	}
}
