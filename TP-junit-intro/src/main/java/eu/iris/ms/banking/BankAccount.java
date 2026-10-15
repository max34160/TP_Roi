package eu.iris.ms.banking;

/*
 Classe BankAccount - Exemple d'objet métier avec règles de gestion.
*/

public class BankAccount {
    
    protected String accountNumber;
    protected String holderName;
    protected double balance;
    protected boolean isActive;
    protected double overdraftLimit; // Découvert autorisé
    
    /**
     * Constructeur principal
     * @param accountNumber numéro de compte
     * @param holderName nom du titulaire
     * @param initialBalance solde initial
     * @throws IllegalArgumentException si les paramètres sont invalides
     */
    public BankAccount(String accountNumber, String holderName, double initialBalance) throws IllegalArgumentException {
        // TODO: Implémenter les validations
        // Se référer aux règles métiers pour déterminer les validations&throws à effectuer.
        // Lever IllegalArgumentException avec message explicite si invalide
        
        // TODO: Implémenter la logique du constructor et init la classe
    }
    
    /**
     * Effectue un dépôt sur le compte
     * @param amount montant à déposer
     * @throws IllegalStateException si le compte n'est pas actif
     * @throws IllegalArgumentException si le montant est invalide
     */
    public void deposit(double amount) throws IllegalStateException, IllegalArgumentException {
        // TODO: Implémenter
        // 1. Se référer aux règles métiers pour déterminer les validations&throws à effectuer.
        //    Lever les exceptions appropriées avec messages clairs
        // 2. Ajouter amount à balance
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    /**
     * Effectue un retrait du compte
     * @param amount montant à retirer
     * @throws IllegalStateException si le compte n'est pas actif
     * @throws IllegalArgumentException si le montant est invalide ou insuffisant
     */
    public void withdraw(double amount) throws IllegalStateException, IllegalArgumentException {
        // TODO: Implémenter
        // 1. Se référer aux règles métiers pour déterminer les validations&throws à effectuer.
        //    Lever les exceptions appropriées avec messages clairs
        // 2. Déduire amount du balance
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    /**
     * Effectue un transfert vers un autre compte
     * @param targetAccount compte de destination
     * @param amount montant à transférer
     * @throws IllegalArgumentException si les paramètres sont invalides
     * @throws IllegalStateException si l'opération ne peut être effectuée
     */
    public void transfer(BankAccount targetAccount, double amount) throws IllegalStateException, IllegalArgumentException {
        // TODO: Implémenter
        // 1. Se référer aux règles métiers pour déterminer les validations&throws à effectuer.
        //    Lever les exceptions appropriées avec messages clairs
        // 2. Utiliser withdraw() pour retirer de ce compte
        // 3. Utiliser targetAccount.deposit() pour déposer
        // Note : si withdraw() échoue, le transfert échoue (cohérence)
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    /**
     * Désactive le compte (aucune opération possible)
     */
    public void deactivate() {
        // TODO : Implémenter
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    /**
     * Réactive le compte
     */
    public void activate() {
        // TODO: Implémenter
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    /**
     * Définit la limite de découvert autorisé
     * @param limit montant du découvert autorisé
     * @throws IllegalArgumentException si la limite est négative
     */
    public void setOverdraftLimit(double limit) throws IllegalArgumentException {
        // TODO: Implémenter
        // 1. Se référer aux règles métiers pour déterminer les validations&throws à effectuer.
        //    Lever les exceptions appropriées avec messages clairs
        // 2. Modifier la limite de découvert
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    /**
     * Vérifie si le compte peut effectuer un retrait d'un montant donné
     * @param amount montant à vérifier
     * @return true si le retrait est possible
     */
    public boolean canWithdraw(double amount) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    // === GETTERS ===
    
    public String getAccountNumber() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    public String getHolderName() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    public double getBalance() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    public boolean isActive() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    public double getOverdraftLimit() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    /**
     * Retourne le solde disponible (solde + découvert)
     */
    public double getMaxAvailableBalance() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    @Override
    public String toString() {
        return String.format("BankAccount{number='%s', holder='%s', balance=%.2f, active=%s, overdraft=%.2f}", 
                           this.accountNumber, this.holderName, this.balance, this.isActive, this.overdraftLimit);
    }
}