/* BadTransactionException.java */

/**
 *  Implements an exception that should be thrown for invalid amount transactions.
 **/
public class BadTransactionException extends Exception {

  public int amount;  // The invalid amount.

  /**
   *  Creates an exception object
   **/
  public BadTransactionException(int badAmount) {
    super("Invalid amount: " + badAmount);

    amount = badAmount;
  }
}