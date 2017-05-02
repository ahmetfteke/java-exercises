public interface CurrencyObserver {
   void notify(String fromCurrency, String toCurrency, double newValue);
}
