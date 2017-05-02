public class CurrencyChangeObserver implements CurrencyObserver{
   private static int nextID=1;
   private int id;

   public CurrencyChangeObserver() { id = nextID++; };

   public void notify(String fromCurrency, String toCurrency, double newValue) {
      System.out.println("CurrencyChangeObserver" + id + ": 1 " + fromCurrency + " = " + newValue + " " + toCurrency);
   }

}
