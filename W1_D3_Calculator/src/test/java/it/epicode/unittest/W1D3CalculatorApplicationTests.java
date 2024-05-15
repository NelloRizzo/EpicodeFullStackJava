package it.epicode.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import it.epicode.unittest.services.CalculatorService;
import it.epicode.unittest.services.SimpleCalculatorService;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class W1D3CalculatorApplicationTests {

	CalculatorService calculator;

	@BeforeAll
	static void initialize() {
		log.info("BeforeAll");
	}

	@BeforeEach
	void initializeCalculator() {
		log.info("BeforeEach");
		calculator = new SimpleCalculatorService();
		calculator.add(10);
	}

	@AfterEach
	void afterEach() {
		log.info("AfterEach");
	}

	@AfterAll
	static void afterAll() {
		log.info("AfterAll");
	}

	@ParameterizedTest
	// @ValueSource(ints = { 10, 20, 30 })
	@CsvSource({ "1, 11", "2,12" })
	@DisplayName("Test dell'addizione")
	void addTest(int value, int expected) {
		log.info("addTest()");
		assertEquals(10, calculator.getAccumulator());
		calculator.add(value);
		//assertEquals(value + 10, calculator.getAccumulator());
		assertEquals(expected, calculator.getAccumulator());
	}

	@Test
	@DisplayName("Test della divisione")
	//@Disabled
	void divTest() {
		log.info("divTest");
		assertEquals(10, calculator.getAccumulator());
		assertThrows(RuntimeException.class, () -> calculator.div(0));
	}

}
