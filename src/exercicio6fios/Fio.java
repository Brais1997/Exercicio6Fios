
package exercicio6fios;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Fio extends Thread {
  static int CAPINICIAL=50;
    
   public Fio (String s){
       super(s);
   }
   
   
   synchronized void ingreso() throws InterruptedException{
       
       CAPINICIAL++;
       Fio.sleep(1000);
       System.out.println("Ingreso");
   }
        synchronized void retirada() throws InterruptedException{
            CAPINICIAL=CAPINICIAL-3;
            Fio.sleep(1000);
       System.out.println("Retirar");  
   }
public void run(){
    if("Ingreso".equals(getName())){
        try {
            ingreso();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fio.class.getName()).log(Level.SEVERE, null, ex);
        }System.out.println(CAPINICIAL);
    }else{
        try {
            retirada();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fio.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(CAPINICIAL);
    }
    
}
}
