import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

class ProductDBTest {

	@Test
	void testJavaProductReturned() {
		Product product = ProductDB.getProduct("java");
		Assertions.assertEquals(product.getCode(), "java");
	}

}
