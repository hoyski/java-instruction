package hoy.business.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import hoy.business.Grade;

class GradeTest {

	@Test
	void testLetterGradeA() {
		Grade gradeA = new Grade(88);

		assertEquals("A", gradeA.getLetter());
	}

	@Test
	void testLetterGradeF() {
		Grade gradeF = new Grade(50);

		assertEquals("F", gradeF.getLetter());
	}

}
