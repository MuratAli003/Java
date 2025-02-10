
import java.util.Scanner;

class eleman{
    
    String isim;
    int yas;
    boolean randevu;
    
    eleman ileri;
    
    eleman(String isim,int yas, boolean randevu){
        
        this.isim = isim;
        this.randevu = randevu;
        this.yas = yas;
        this.ileri = null;
        
    }
}

class kuyruk{
    
    eleman bas;
    eleman son;
    kuyruk ileri;
    
    kuyruk(){
        
        bas = null;
        son = null;
        this.ileri = null;
        
    }
    
    void ekle(eleman x){
        
        if(bas == null){
            
            bas = x;
            son = x;
            
        }
        else{
            
            son.ileri = x;
            son = x;
            
        }
    }
    
    eleman sil(){
        
        eleman kontrol = bas;
        
        if(bas != null){
            
            bas = bas.ileri;
            
            if(bas == son){
                
                son = null;
                
            }
        }
        
        return kontrol;
        
    }  
}

class kuyrukİslem{
    
    kuyruk a = new kuyruk();
    kuyruk b = new kuyruk();
    kuyruk c = new kuyruk();
    
    kuyrukİslem(){

        a.ileri = b;
        b.ileri = c;
        c.ileri = null;
        
    }
    
    void enqueue(eleman x){
        
        if(x.yas >= 65 && x.randevu == true){
            
            a.ekle(x);
            
        }
        else if(x.yas >= 65 && x.randevu == false){
            
            a.ekle(x);
            
        }
        else if (x.yas <65 && x.randevu == true){
            
            b.ekle(x);
            
        }
        else if(x.yas <65 && x.randevu == false){
            
            c.ekle(x);
            
        }  
    }
    
    void dequeue(){
        
      eleman kontrolA = a.bas;
      eleman kontrolB = b.bas;
      eleman kontrolC = c.bas;
      
      if(kontrolA != null){
          
          a.sil();
          
      }
      else{
          
          if(kontrolB != null){
              
              b.sil();
              
          }
          else{
              
              if(kontrolC != null){
                  
                  c.sil();
                  
              }       
          }
      }
    }
    
    void listele(){
        
        eleman x = a.bas;
        eleman y = b.bas;
        eleman z = c.bas;
        
        while(true){
            
            if(x != null){
                
                System.out.println(x.isim + " 65 yas ustu / EN ONCELIKLI");
                x = x.ileri;
                
            }
            else {
                
                if(y != null){
                
                    System.out.println(y.isim + " - " + "randevulu / ONCELIKLI");
                    y = y.ileri;
                   
                }
                else{
                    
                    if(z != null){
                
                        System.out.println(z.isim + " - " + "randevusuz / ONCELIKSIZ");
                        z = z.ileri;
                     
                    }
                    else{
         
                        break;
                        
                    }  
              }   
        }
    }      
  }
}
public class BankaKuyrugu {
    
    public static void main(String[] args) {
        
        String islemSira = "Islem oncelik sirasi:\n"
                + "1-)65Yas Uzeri\n"
                + "2-)Randevulu\n"
                + "3-)Randevusuz";
        
        System.out.println(islemSira);
        System.out.println("-------------------------------------");
        
        kuyrukİslem islem = new kuyrukİslem();
        
        eleman eleman1 = new eleman("Ali",22,true);
        eleman eleman2 = new eleman("Murat",66,false);
        eleman eleman3 = new eleman("Ahmet",65,true);
        
        islem.enqueue(eleman1);
        islem.enqueue(eleman2);
        islem.enqueue(eleman3);
        
        islem.listele();
        
    }  
}


