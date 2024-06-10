
import static org.junit.Assert.*;

import org.junit.Test;

public class MyPrimeTest {

	//special case
	@Test
	public void testNextPrimeCheckOne() {

		assertEquals(2, MyPrime.nextPrime(0));

	}
	@Test
	public void test2() {
		assertEquals(2, MyPrime.nextPrime(1));
	}

	//basic tests
	@Test
	public void testNextPrimeCheckEqualToTwo() {
		assertEquals(2, MyPrime.nextPrime(2));
	}
	@Test
	public void testNextPrimeCheckAfterTwo() {
		assertEquals(3, MyPrime.nextPrime(3));
	}

	//exception tests
	@Test (expected=IllegalArgumentException.class)
	public void testNextPrimeHandlesIllegalNegativeArgs() {

		MyPrime.nextPrime(-1);
	}


	//complex tests
	@Test
	public void testNextPrimeThreeFactorCheck() {
		assertEquals(11, MyPrime.nextPrime(9));
	}

	@Test
	public void testNextPrimeOneRemainderCheck() {
		assertEquals(37, MyPrime.nextPrime(32));
	}

	@Test
	public void testNextPrimeOneRemainderCheckLineFourtySeven() {
		assertEquals(37, MyPrime.nextPrime(35));
	}

	@Test
	public void testNextPrimeOneRemainderCheckLineFiftyThree() {
		assertEquals(53, MyPrime.nextPrime(48));
	}

	@Test
	public void testNextPrimeOneRemainderCheckLineSixtyEight() {
		assertEquals(127, MyPrime.nextPrime(114));
	}


}
