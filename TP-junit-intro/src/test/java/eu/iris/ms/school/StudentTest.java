package eu.iris.ms.school;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student student;

    private final String STUDENT_ID = "STU001";
    private final String FIRST_NAME = "Alice";
    private final String LAST_NAME = "Dupont";
    private final String EMAIL = "alice@email.com";
    private final int AGE = 20;

    /**
     * Prépare un étudiant valide avant chaque test
     */
    @BeforeEach
    void setUp() {
        student = new Student( STUDENT_ID, FIRST_NAME, LAST_NAME, EMAIL, AGE );
    }

    @Test
    void shouldCreateStudentWithValidParameters() {

        Student student = new Student(
                "STU001", "Alice", "Dupont", "alice@email.com", 20
        );

        assertNotNull(student);
    }

    @Test
    void shouldRejectNullStudentId() {

        assertThrows(IllegalArgumentException.class,
                () -> new Student(null, FIRST_NAME, LAST_NAME, EMAIL, AGE)
        );
    }

    @Test
    void shouldRejectEmptyStudentId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("", FIRST_NAME, LAST_NAME, EMAIL, AGE)
        );
    }

    @Test
    void shouldRejectInvalidStudentIdFormat() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("ABFS4567890", FIRST_NAME, LAST_NAME, EMAIL, AGE)
        );
    }

    @Test
    void shouldRejectNullFirstName() {

        assertThrows(IllegalArgumentException.class,
                () -> new Student(STUDENT_ID, null, LAST_NAME, EMAIL, AGE)
        );
    }

    @Test
    void shouldRejectEmptyFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student(STUDENT_ID, "", LAST_NAME, EMAIL, AGE)
        );
    }

    @Test
    void shouldRejectFirstNameToShort() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student(STUDENT_ID, "a", LAST_NAME, EMAIL, AGE)
        );
    }

    @Test
    void shouldRejectNullLastName() {

        assertThrows(IllegalArgumentException.class,
                () -> new Student(STUDENT_ID, FIRST_NAME, null, EMAIL, AGE)
        );
    }

    @Test
    void shouldRejectEmptyLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student(STUDENT_ID, FIRST_NAME, "", EMAIL, AGE)
        );
    }

    @Test
    void shouldRejectLastNameToShort() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student(STUDENT_ID, FIRST_NAME,"a", EMAIL, AGE)
        );
    }

    @Test
    void shouldRejectNullEmail() {

        assertThrows(IllegalArgumentException.class,
                () -> new Student(STUDENT_ID, FIRST_NAME, LAST_NAME, null, AGE)
        );
    }

    @Test
    void shouldRejectEmailWithoutSymbol() {

        assertThrows(IllegalArgumentException.class,
                () -> new Student(STUDENT_ID, FIRST_NAME, LAST_NAME, "aliceemail.com", AGE)
        );
    }

    @Test
    void shouldRejectEmailWithoutPointAfterSymbol() {

        assertThrows(IllegalArgumentException.class,
                () -> new Student(STUDENT_ID, FIRST_NAME, LAST_NAME, "alice@emailcom", AGE)
        );
    }

    @Test
    void shouldRejectAgeToHight() {

        assertThrows(IllegalArgumentException.class,
                () -> new Student(STUDENT_ID, FIRST_NAME, LAST_NAME, EMAIL, 67)
        );
    }

    @Test
    void shouldRejectAgeToSmall() {

        assertThrows(IllegalArgumentException.class,
                () -> new Student(STUDENT_ID, FIRST_NAME, LAST_NAME, EMAIL, 12)
        );
    }

    @Test
    void shouldRejectGradeNegative() {

        assertThrows(IllegalArgumentException.class, () -> student.addGrade(-1));
    }

    @Test
    void shouldRejectGradeToHight() {
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(20.1));
    }

    @Test
    void shouldAddGradeAtTheList() {
        student.addGrade(13);
        assertEquals(1,student.getGradeCount());
    }

    @Test
    void shouldRejectAverageWhenNoGrades() {
        assertThrows(IllegalStateException.class, () -> student.getAverageGrade());
    }

    @Test
    void shouldCalculateAverageGrade() {
        student.addGrade(12);
        student.addGrade(14);
        student.addGrade(16);

        assertEquals(14.0, student.getAverageGrade());
    }

    @Test
    void shouldCalculateAverageGradeDecimal() {
        student.addGrade(10.5);
        student.addGrade(12.5);
        student.addGrade(14.5);

        assertEquals(12.5, student.getAverageGrade());
    }

    @Test
    void shouldReturnTrueWhenAverageIsAbove10() {
        student.addGrade(12);
        student.addGrade(16);

        assertTrue(student.hasPassingGrade());
    }

    @Test
    void shouldReturnTrueWhenAverageIsBelow10() {
        student.addGrade(2);
        student.addGrade(6);

        assertFalse(student.hasPassingGrade());
    }

    @Test
    void shouldReturnTrueWhenAverageIsExactly10() {
        student.addGrade(8);
        student.addGrade(12);

        assertTrue(student.hasPassingGrade());
    }

    @Test
    void shouldReturnFalseWhenThereAreNoGrades() {
        assertFalse(student.hasPassingGrade());
    }

    @Test
    void shouldReturnFullName() {
        assertEquals("Alice Dupont", student.getFullName());
    }

    @Test
    void shouldReturnZeroWhenNoGrade() {
        assertEquals(0, student.getGradeCount());
    }

    @Test
    void shouldReturnHowManyGrade() {
        student.addGrade(2);
        student.addGrade(6);
        assertEquals(2, student.getGradeCount());
    }

    @Test
    void shouldReturnTheBestGrade() {
        student.addGrade(2);
        student.addGrade(16);
        student.addGrade(12);
        student.addGrade(6);
        student.addGrade(9);
        student.addGrade(4);
        assertEquals(16, student.getBestGrade());
    }

    @Test
    void shouldReturnTheMostBadGrade() {
        student.addGrade(2);
        student.addGrade(16);
        student.addGrade(12);
        student.addGrade(6);
        student.addGrade(9);
        student.addGrade(4);
        assertEquals(2, student.getWorstGrade());
    }

    @Test
    void shouldReturnZeroIfNoGradeForTheMostBadGrade() {
        assertEquals(0, student.getWorstGrade());
    }

    @Test
    void shouldReturnZeroIfNoGradeForTheBestGrade() {
        assertEquals(0, student.getBestGrade());
    }

    @Test
    void shouldReturnCopie() {
        student.addGrade(15.0);
        List<Double> notes = student.getGrades();
        notes.add(20.0); // Modifie seulement la copie
        assertEquals(1, student.getGradeCount());// Retourne toujours 1 (non affecté)
    }
}
