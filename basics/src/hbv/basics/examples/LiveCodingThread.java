package hbv.basics.examples;
//wir fangen ganz normal mit einer Javaklasse
//mit einer Main Routine/Funktion/Methode an

//erst einmal ohne build.sh übersetzen und ausführen
//damit das verinnerlicht wird ...
public class LiveCodingThread {
 private static long counter;
 public synchronized static void incrementCounter(){
   counter++;
 }
 public synchronized static long getCounter(){
   return counter;
 }
  public static void main(String[] args) throws Exception {
    System.out.println("Moin, das geht schon mal");
    //Das geht, weil ...?
    //Antwort im Chat ..
    //Ist die Frage klar?
    // Weil LivingThing Unterklasse von Thread ist und
    // deswegen eine Zuweisung eines LivingThing-Objektes
    // an eine Referenzvariable vom Typ Thread möglich ist.
    // Denn *das* ist Polymorphie! (Mehrformigkeit)
    // Das Objekt, das da mit new erzeugt wurde, hat
    // mehr als einen Typen ...
    LivingThing[] t = new LivingThing[10];
    for(int i=0;i<10;++i){
      t[i]=new LivingThing("thing "+i);
      t[i].start();
    }
    for(int i=0;i<10;++i){
      t[i].join();
      System.out.println("       "+t[i].localcounter);
      //Abstimmung: wer glaubt, dass das geht?
    }
    System.out.println("Gesamt:"+LiveCodingThread.counter);
    System.out.println("Gesamt:"+LiveCodingThread.getCounter());

  }

}

// eine weitere Klasse, die aber nicht public ist, darf
// in der selben Quelle stehen - zur Vereinfachung
// ausprobieren, es zu übersetzen ...
// Funktioniert. Das heisst aber, weil wir ja wissen,
// dass hier Vererbung eine Rolle spielt, dass die 
// konkrete Implementierung in der run-Methode 
// überschrieben wird ..
//
// Unterschied Typ und Klasse
// Klasse ist das Konstrukt, von dem ein Objekt erzeugt wird.
// (als das, was hier new ... steht). Das erzeugte Objekt
// behält für die Zeit der Existenz diese Klasse und kann
// sie nicht wechseln. Die Klasse eines Objektes bestimmt,
// welche Methode aufgerufen wird.
// Ein Typ wird bei einer Referenzvariablen benötigt, damit
// diese Variable Objekte dieser 'Kategorie' beinhalten kann.
// (Auch bei Parameterübergabe)
//
// Thread t = new LivingThing()
//                ^^^^^^^^^^^^
//                das ist die einzige Klasse dieses Objektes
//
// ^^^^^^  
// das ist der Typ der Referenzvariablen
class LivingThing extends Thread {
  private String message;
  public int localcounter;
  // das soll dann später nebenläufig passieren
  LivingThing(String message){
    this.message=message;
  }
  public void run(){
    for(int i=0;i<1_000_000;++i){
      // sobald wir auf gemeinsame Ressource zugreifen,
      // müssen wir die Streckenabschnitte synchronisieren
      // also: es darf einen bestimmte Abschnitt nur
      // ein Thread zur gleichen Zeit passieren!
      localcounter++;
      LiveCodingThread.incrementCounter();
      // thread a                thread b
      // nimmt sich counter      nimmt sich counter
      // erhöht um 1
      //                         erhöht um 1
      //                         schreibt zurück in 
      //                         counter
      // schreibt zurück in 
      // counter
    }

  }

}
