import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class PermutationTest {

	@Test
	void test() {
		assertEquals(true, Permutation.isStringPermutation("dad", "add"));
		assertEquals(true, Permutation.isStringPermutation("summit", "mtimsu"));
		assertEquals(true, Permutation.isStringPermutation("fabcdfedfaaa", "abacdaedfaff"));
	}

}
