class ObserverPatternTester{
   public static void main(String[] args){
      System.out.println("***Observer Pattern Tester***\n");

      CurrencyChangeObserver cco1 = new CurrencyChangeObserver();
      CurrencyChangeObserver cco2 = new CurrencyChangeObserver();

      EuroToDollarConverter e2dc = new EuroToDollarConverter();

      System.out.println("\nSetting Euro-to-Dollar Value as 1.11");
      e2dc.setValue(1.11);

      System.out.println("\nRegistering cco1 with Euro-to-Dollar Converter");
      e2dc.register(cco1);

      System.out.println("\nSetting Euro-to-Dollar Value as 1.12");
      e2dc.setValue(1.12);

      System.out.println("\nRegistering cco2 with Euro-to-Dollar Converter");
      e2dc.register(cco2);

      System.out.println("\nSetting Euro-to-Dollar Value as 1.13");
      e2dc.setValue(1.13);

      System.out.println("\nUnregistering cco2 with Euro-to-Dollar Converter");
      e2dc.unregister(cco2);

      System.out.println("\nSetting Euro-to-Dollar Value as 1.14\n");
      e2dc.setValue(1.14);

      System.out.println("\nUnregistering cco1 with Euro-to-Dollar Converter");
      e2dc.unregister(cco1);

      System.out.println("\nSetting Euro-to-Dollar Value as 1.15\n");
      e2dc.setValue(1.15);
   }
}
