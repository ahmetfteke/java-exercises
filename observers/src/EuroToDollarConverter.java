import java.util.*;

class EuroToDollarConverter implements CurrencyConverter{
   ArrayList<CurrencyObserver> observerList = new ArrayList<CurrencyObserver>();
   private String fromCurrency = "Euro";
   private String toCurrency   = "Dollars";
   private double value;

   public double getValue(){
      return value;
   }

   public void setValue(double newValue){
      value = newValue;

      // value changed: notify observer(s)
      notifyObservers();
   }

   @Override
   public void register(CurrencyObserver observer){
      observerList.add(observer);
   }

   @Override
   public void unregister(CurrencyObserver observer){
      observerList.remove(observer);
   }

   @Override
   public void notifyObservers(){
      for(int i=0;i<observerList.size();i++){
         observerList.get(i).notify(fromCurrency, toCurrency, getValue());
      }
   }
}
