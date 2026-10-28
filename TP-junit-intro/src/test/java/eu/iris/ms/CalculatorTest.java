package eu.iris.ms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour la classe Calculator.
 * 
 * Ce fichier sert de template pour apprendre :
 * - Structure AAA (Arrange-Act-Assert)
 * - Nommage descriptif des tests
 * - Tests de cas normaux et d'exceptions
 * - Utilisation de @BeforeEach pour la préparation commune
 */
class CalculatorTest {
    
    private Calculator calculator;
    
    /**
     * Méthode exécutée AVANT chaque test
     * Évite la duplication de code de préparation
     */
    @BeforeEach
    public void setUp() {
        this.calculator = new Calculator();
    }
    
    // === TESTS D'ADDITION ===
    
    @Test
    public void shouldAddPositiveNumbers() {
        // ARRANGE - Préparer les données
        int a = 5;
        int b = 3;
        
        // ACT - Exécuter l'action à tester
        int result = this.calculator.add(a, b);
        
        // ASSERT - Vérifier le résultat
        assertEquals(8, result);
    }
    
    @Test
    public void shouldAddNegativeNumbers() {
        // TODO: Compléter ce test
        // Tester l'addition avec des nombres négatifs
        // Exemple : (-5) + (-3) = -8
        int a = (-5);
        int b =(-3);

        // ACT - Exécuter l'action à tester
        int result = this.calculator.add(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(-8, result);
    }
    
    @Test
    public void shouldAddZero() {
        // TODO: Compléter ce test
        // Tester l'addition avec zéro
        // Exemple : 5 + 0 = 5

        int a = 5;
        int b = 0;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.add(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(5, result);
    }
    
    // === TESTS DE SOUSTRACTION ===
    
    @Test
    public void shouldSubtractNumbers() {
        // TODO: Compléter ce test
        // Exemple : 10 - 3 = 7
        int a = 5;
        int b = 3;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.subtract(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(2, result);
    }
    
    @Test
    public void shouldSubtractResultingInNegative() {
        // TODO: Compléter ce test
        // Exemple : 3 - 10 = -7
        int a = 3;
        int b = 5;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.subtract(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(-2, result);
    }
    
    // === TESTS DE MULTIPLICATION ===
    
    @Test
    public void shouldMultiplyNumbers() {
        // TODO: Compléter ce test
        // Exemple : 4 * 3 = 12
        int a = 5;
        int b = 3;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.multiply(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(15, result);
    }
    
    @Test
    public void shouldReturnZeroWhenMultiplyingByZero() {
        // TODO: Compléter ce test
        // Exemple : 5 * 0 = 0
        int a = 5;
        int b = 0;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.multiply(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(0, result);
    }
    
    @Test
    public void shouldMultiplyNegativeNumbers() {
        // TODO: Compléter ce test
        // Exemple : (-2) * (-3) = 6
        int a = (-5);
        int b = (-3);

        // ACT - Exécuter l'action à tester
        int result = this.calculator.multiply(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(15, result);
    }
    
    // === TESTS DE DIVISION ===
    
    @Test
    public void shouldDivideNumbers() {
        // TODO: Compléter ce test
        // Exemple : 15.0 / 3.0 = 5.0
        // Attention : utiliser des doubles !
        double a = 6.0;
        double b = 3.0;

        // ACT - Exécuter l'action à tester
        double result = this.calculator.divide(a, b);

        // ASSERT - Vérifier le résultat
        assertEquals(2, result);
    }
    
    @Test
    public void shouldThrowExceptionWhenDividingByZero() {
        // TODO: Compléter ce test avec assertThrows
        // La division par zéro doit lever une ArithmeticException.
        // Pour pouvoir tester des exceptions, il faut les catch !
        double a = 3.0;
        double b = 0;

        assertThrows(ArithmeticException.class, () -> {
            this.calculator.divide(a, b);
        });

    }
    
    // === TESTS FACTORIELLE ===
    
    @Test
    public void shouldCalculateFactorialOfPositiveNumber() {
        // TODO: Compléter ce test
        // Exemple : 5! = 120

        int a = 5;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.factorial(a);

        // ASSERT - Vérifier le résultat
        assertEquals(120, result);
    }
    
    @Test
    public void shouldReturnOneForFactorialOfZero() {
        // TODO: Compléter ce test
        // Cas spécial : 0! = 1

        int a = 0;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.factorial(a);

        // ASSERT - Vérifier le résultat
        assertEquals(1, result);
    }
    
    @Test
    public void shouldReturnOneForFactorialOfOne() {
        // TODO: Compléter ce test
        // Cas spécial : 1! = 1
        int a = 1;

        // ACT - Exécuter l'action à tester
        int result = this.calculator.factorial(a);

        // ASSERT - Vérifier le résultat
        assertEquals(1, result);
    }
    
    @Test
    public void shouldThrowExceptionForNegativeFactorial() {
        // TODO: Compléter ce test avec assertThrows
        // La factorielle d'un nombre négatif doit lever IllegalArgumentException

        int a = (-3);

        assertThrows(IllegalArgumentException.class, () -> {
            this.calculator.factorial(a);
        });
    }
    
    // === TESTS NOMBRE PAIR ===
    
    @Test
    public void shouldReturnTrueForEvenNumbers() {
        // TODO: Compléter ce test
        // Tester plusieurs nombres pairs : 0, 2, 4, 100
        int a = 2;

        boolean result  = this.calculator.isEven(a);

        assertTrue(result);
    }
    
    @Test
    public void shouldReturnFalseForOddNumbers() {
        // TODO: Compléter ce test
        // Tester plusieurs nombres impairs : 1, 3, 5, 99

        int a = 1;

        boolean result  = this.calculator.isEven(a);

        assertFalse(result);
    }
    
    // === TESTS PUISSANCE ===
    
    @Test
    public void shouldCalculatePowerCorrectly() {
        // TODO: Compléter ce test
        // Exemple : 2^3 = 8.0
        // Attention à la précision (par exemple 0.001) des doubles !
        // assertEquals(8.0, calculator.power(2, 3), 0.001);
        double a = 2.0;
        int b = 3;

        assertEquals(8.0, calculator.power(a, b), 0.001);
    }
    
    @Test
    public void shouldReturnOneForPowerZero() {
        // TODO: Compléter ce test
        // Tout nombre puissance 0 = 1
        double a = 2.0;
        int b = 0;

        assertEquals(1.0, calculator.power(a, b), 0.001);
    }
    
    @Test
    public void shouldThrowExceptionForNegativeExponent() {
        // TODO: Compléter ce test avec assertThrows
        // Exposant négatif doit lever IllegalArgumentException
        double a = 2.0;
        int b = (-3);

        assertThrows(IllegalArgumentException.class, () -> {
            this.calculator.power(a, b);
        });
    }
    
    // === TESTS SUPPLÉMENTAIRES ===
    // TODO: Ajouter au moins 2 tests de votre choix
    // Idées : cas limites, combinaisons de méthodes, valeurs extrêmes

    @Test
    public void shouldAddNumbersWithDifferentSigns() {

        int a = 10;
        int b = (-4);

        int result = this.calculator.add(a, b);

        assertEquals(6, result);
    }

    @Test
    public void shouldSubtractZero() {
        int a = 7;
        int b = 0;

        int result = this.calculator.subtract(a, b);

        assertEquals(7, result);
    }
}