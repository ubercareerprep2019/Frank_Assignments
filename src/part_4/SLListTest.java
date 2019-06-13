package part_4;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class SLListTest {

	@Test
	// test pushBack
	public void testpushBack() {
		SLList<String> d = new SLList<>();
		assertEquals(0, d.size());

		d.pushBack("3");
		assertEquals(1, d.size());

		d.pushBack("4");
		assertEquals(2, d.size());

		d.pushBack(null);
		assertEquals(3, d.size());
	}

	@Test
	public void testEmptyString() {
		SLList<String> d = new SLList<>();
		assertEquals(0, d.size());

		d.pushBack("");
		assertEquals(1, d.size());

		d.pushBack("");
		assertEquals(2, d.size());

		d.pushBack("");
		assertEquals(3, d.size());
	}

	@Test
	public void testErase() {
		SLList<Integer> d = new SLList<>();
		d.pushBack(5);
		d.erase(d.first());
		assertEquals(0, d.size());

		d = new SLList<>();
		d.pushBack(5);
		d.pushBack(6);
		d.erase(d.first());
		assertEquals(1, d.size());

		d = new SLList<>();
		d.pushBack(5);
		d.pushBack(6);
		d.erase(d.last());
		assertEquals(1, d.size());

		d = new SLList<>();
		d.pushBack(5);
		d.pushBack(6);
		d.pushBack(7);
		d.erase(2);
		assertEquals(2, d.size());
	}

	@Test
	public void testIterator() {
		// Make a list of the integers in 10..19
		SLList<Integer> d = new SLList<>();
		for (int k = 0; k < 10; k = k + 1) {
			d.pushBack(k + 10);
		}

		// Test that the list contains 10..19
		Iterator<Integer> dit = d.iterator();
		int k = 0;
		while (dit.hasNext()) {
			assertEquals((Integer) (k + 10), dit.next());
			k = k + 1;
		}
		// Test that the loop stopped at the right place
		assertEquals(10, k);
	}

	@Test
	public void testIterable() {
		SLList<Integer> d = new SLList<>();
		for (int k = 0; k < 10; k = k + 1) {
			d.pushBack(k);
		}

		int tt = 0;
		for (int ob : d) {
			assertEquals(tt, ob);
			tt = tt + 1;
		}
	}

}
