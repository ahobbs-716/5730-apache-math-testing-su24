
import static org.junit.Assert.*;

import org.junit.Test;

public class MyPrimeTest {

	@Test
	public void test2() {
		assertEquals(2, MyPrime.nextPrime(1));
	}

	@Test (expected=IllegalArgumentException.class)
	public void testNextPrimeHandlesIllegalNegativeArgs() {

		MyPrime.nextPrime(-1);
	}

	@Test
	public void testNextPrimeCheckOne() {

		assertEquals(2, MyPrime.nextPrime(0));

	}

	@Test
	public void testNextPrimeCheckEqualToTwo() {
		assertEquals(2, MyPrime.nextPrime(2));
	}

	@Test
	public void testNextPrimeCheckAfterTwo() {
		assertEquals(3, MyPrime.nextPrime(3));
	}

	//white box testing

	@Test			//check expected value
	public void testNextPrimeThreeFactorCheck() {
		assertEquals(11, MyPrime.nextPrime(9));
	}

	@Test			//check expected value
	public void testNextPrimeOneRemainderCheck() {
		assertEquals(37, MyPrime.nextPrime(32));
	}

	@Test			//check expected value
	public void testNextPrimeOneRemainderCheckLineFourtySeven() {
		assertEquals(37, MyPrime.nextPrime(35));
	}

	@Test			//check expected value
	public void testNextPrimeOneRemainderCheckLineFiftyThree() {
		assertEquals(53, MyPrime.nextPrime(48));
	}

	@Test			//check expected value
	public void testNextPrimeOneRemainderCheckLineSixtyEight() {
		assertEquals(53, MyPrime.nextPrime(114));
	}


}
