package eu.iris.ms.banking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour la classe BankAccount.
 * 
 * Cette classe de test illustre :
 * - Tests exhaustifs d'un objet métier
 * - Validation des règles de gestion
 * - Tests de construction avec différents paramètres
 * - Tests d'exceptions avec messages explicites
 * - Tests d'état et de comportement
 */
class BankAccountTest {
    
    private BankAccount account;
    private final String ACCOUNT_NUMBER = "ACC001";
    private final String HOLDER_NAME = "Alice Dupont";
    private final double INITIAL_BALANCE = 100.0;
    
    /**
     * Prépare un compte valide avant chaque test
     */
    @BeforeEach
    void setUp() {
        account = new BankAccount(ACCOUNT_NUMBER, HOLDER_NAME, INITIAL_BALANCE);
    }
    
    // === TESTS DE CONSTRUCTION ===
    
    @Test
    void shouldCreateAccountWithValidParameters() {
        // ARRANGE & ACT - Création d'un nouveau compte
        BankAccount newAccount = new BankAccount("ACC002", "Bob Martin", 50.0);
        
        // ASSERT - Vérification de l'état initial
        assertEquals("ACC002", newAccount.getAccountNumber());
        assertEquals("Bob Martin", newAccount.getHolderName());
        assertEquals(50.0, newAccount.getBalance());
        assertTrue(newAccount.isActive());
        assertEquals(0.0, newAccount.getOverdraftLimit());
    }
    
    @Test
    void shouldRejectNullAccountNumber() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Vérifier qu'une IllegalArgumentException est levée
        // avec un message approprié
    }
    
    @Test
    void shouldRejectEmptyAccountNumber() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Tester avec une chaîne vide ""
    }
    
    @Test
    void shouldRejectNullHolderName() {
        assertTrue(false);
        // TODO: Implémenter ce test
    }
    
    @Test
    void shouldRejectEmptyHolderName() {
        assertTrue(false);
        // TODO: Implémenter ce test
    }
    
    @Test
    void shouldRejectNegativeInitialBalance() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Tester avec -10.0 par exemple
    }
    
    @Test
    void shouldAcceptZeroInitialBalance() {
        // ARRANGE & ACT
        BankAccount zeroAccount = new BankAccount("ACC003", "Charlie", 0.0);
        
        // ASSERT
        assertEquals(0.0, zeroAccount.getBalance());
    }
    
    // === TESTS DE DÉPÔT ===
    
    @Test
    void shouldIncreaseBalanceOnValidDeposit() {
        // ARRANGE
        double initialBalance = account.getBalance();
        double depositAmount = 50.0;
        
        // ACT
        account.deposit(depositAmount);
        
        // ASSERT
        assertEquals(initialBalance + depositAmount, account.getBalance());
    }
    
    @Test
    void shouldRejectZeroDeposit() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Le dépôt de 0.0 doit intercepter IllegalArgumentException
    }
    
    @Test
    void shouldRejectNegativeDeposit() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Le dépôt de -50.0 doit intercepter IllegalArgumentException
    }
    
    @Test
    void shouldRejectDepositOnInactiveAccount() {
        // ARRANGE
        account.deactivate();
        
        // ACT & ASSERT
        IllegalStateException exception = assertThrows(
            IllegalStateException.class,
            () -> account.deposit(50.0)
        );
        
        // Vérification optionnelle du message
        assertTrue(exception.getMessage().contains("not active") || 
                  exception.getMessage().contains("inactive"));
    }
    
    // === TESTS DE RETRAIT ===
    
    @Test
    void shouldDecreaseBalanceOnValidWithdrawal() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Retirer 30.0 d'un compte avec 100.0
        // Vérifier que le solde devient 70.0
    }
    
    @Test
    void shouldRejectWithdrawalExceedingBalance() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Tentative de retrait de 150.0 d'un compte avec 100.0
        // Doit intercepter IllegalArgumentException
    }
    
    @Test
    void shouldAllowWithdrawalWithinOverdraftLimit() {
        // ARRANGE
        account.setOverdraftLimit(50.0);
        double withdrawalAmount = 130.0; // Plus que le solde mais dans la limite
        
        // ACT
        account.withdraw(withdrawalAmount);
        
        // ASSERT
        assertEquals(-30.0, account.getBalance()); // 100 - 130 = -30
    }
    
    @Test
    void shouldRejectWithdrawalExceedingOverdraftLimit() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Doit intercepter IllegalArgumentException
    }
    
    @Test
    void shouldRejectWithdrawalOnInactiveAccount() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Désactiver le compte puis tenter un retrait
    }
    
    @Test
    void shouldRejectNegativeWithdrawal() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Tentative de retrait de -50.0
    }
    
    // === TESTS DE TRANSFERT ===
    
    @Test
    void shouldTransferMoneyBetweenAccounts() {
        // ARRANGE
        BankAccount targetAccount = new BankAccount("ACC002", "Bob Martin", 0.0);
        double transferAmount = 30.0;
        double initialSourceBalance = account.getBalance();
        double initialTargetBalance = targetAccount.getBalance();
        
        // ACT
        account.transfer(targetAccount, transferAmount);
        
        // ASSERT
        assertEquals(initialSourceBalance - transferAmount, account.getBalance());
        assertEquals(initialTargetBalance + transferAmount, targetAccount.getBalance());
    }
    
    @Test
    void shouldRejectTransferWithInsufficientFunds() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Tentative de transfert de 150.0 d'un compte avec 100.0
    }
    
    @Test
    void shouldRejectTransferToNullAccount() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Tentative de transfert vers null
    }
    
    @Test
    void shouldRejectTransferToInactiveAccount() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Créer un compte cible, le désactiver, tenter le transfert
    }
    
    @Test
    void shouldRejectTransferFromInactiveAccount() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Désactiver le compte source, tenter le transfert
    }
    
    // === TESTS D'ACTIVATION/DÉSACTIVATION ===
    
    @Test
    void shouldDeactivateAccount() {
        // ARRANGE
        assertTrue(account.isActive());
        
        // ACT
        account.deactivate();
        
        // ASSERT
        assertFalse(account.isActive());
    }
    
    @Test
    void shouldActivateAccount() {
        // ARRANGE
        account.deactivate();
        assertFalse(account.isActive());
        
        // ACT
        account.activate();
        
        // ASSERT
        assertTrue(account.isActive());
    }
    
    // === TESTS LIMITE DE DÉCOUVERT ===
    
    @Test
    void shouldSetValidOverdraftLimit() {
        // ARRANGE
        double newLimit = 100.0;
        
        // ACT
        account.setOverdraftLimit(newLimit);
        
        // ASSERT
        assertEquals(newLimit, account.getOverdraftLimit());
    }
    
    @Test
    void shouldRejectNegativeOverdraftLimit() {
        // TODO: Implémenter ce test
        // Tentative de définir une limite de -50.0
    }
    
    // === TESTS DES MÉTHODES UTILITAIRES ===
    
    @Test
    void shouldCalculateAvailableBalanceCorrectly() {
        // ARRANGE
        account.setOverdraftLimit(50.0);
        
        // ACT & ASSERT
        assertEquals(150.0, account.getMaxAvailableBalance()); // 100 + 50
    }
    
    @Test
    void shouldReturnTrueWhenCanWithdraw() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Vérifier que canWithdraw(50.0) retourne true pour un compte avec 100.0
    }
    
    @Test
    void shouldReturnFalseWhenCannotWithdraw() {
        assertTrue(false);
        // TODO: Implémenter ce test
        // Vérifier que canWithdraw(150.0) retourne false pour un compte avec 100.0 sans découvert
    }
    
    @Test
    void shouldReturnFalseWhenCanWithdrawOnInactiveAccount() {
        // ARRANGE
        account.deactivate();
        
        // ACT & ASSERT
        assertFalse(account.canWithdraw(50.0));
    }
    
    // === TESTS DE SCÉNARIOS COMPLEXES ===
    
    @Test
    void shouldHandleMultipleOperationsCorrectly() {
        // ARRANGE
        assertEquals(100.0, account.getBalance());
        
        // ACT - Série d'opérations
        account.deposit(50.0);    // Solde : 150.0
        account.withdraw(30.0);   // Solde : 120.0
        account.deposit(20.0);    // Solde : 140.0
        
        // ASSERT
        assertEquals(140.0, account.getBalance());
        assertTrue(account.isActive());
    }
    
    @Test
    void shouldMaintainConsistencyAfterFailedOperation() {
        // ARRANGE
        double initialBalance = account.getBalance();
        
        // ACT - Tentative d'opération invalide
        try {
            account.withdraw(1000.0); // Doit échouer
        } catch (IllegalArgumentException e) {
            // Attendu
        }
        
        // ASSERT - L'état ne doit pas avoir changé
        assertEquals(initialBalance, account.getBalance());
        assertTrue(account.isActive());
    }
}