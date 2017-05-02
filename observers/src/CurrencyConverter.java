public interface CurrencyConverter {
   void register(CurrencyObserver currencyObserver);
   void unregister( CurrencyObserver currencyObserver);
   void notifyObservers();
}
