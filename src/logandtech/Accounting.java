
package logandtech;
import model.Product;
import structure.Stack;
        
public class Accounting {
    private Product prod;
    private double wbu;
    private double totalLossesTruck;
    
    public Accounting() {
        totalLossesTruck=0;
    }
    public void losses(Stack pila)
    {
        Stack aux = pila;
        Stack rev = new Stack(100);
        double totalLosses=0;
        wbu=0;
        
        while(!aux.isEmpty()){
            prod =(Product)aux.pop();
            rev.push(prod);
            wbu += Double.parseDouble(prod.getWeightByUnity());
        }
        
//        System.out.println("este es el peso de toda la carga: "+ wbu);
        while(!rev.isEmpty()){
            prod =(Product)rev.pop();
            //System.out.println(prod.getWeightByUnity());
            wbu -= Double.parseDouble(prod.getWeightByUnity());
            totalLosses += validation(prod);
            totalLossesTruck += validation(prod);
        }
        print(totalLosses);
    }
    public double validation(Product prod){
        //System.out.println("el peso que tiene eso encima es: "+ wbu + prod.getMaxWeight());
        if((wbu)>(Double.parseDouble(prod.getMaxWeight())))
            return Double.parseDouble(prod.getPrice());
        return 0;
    }
    public void print(Double totalLosses){
        System.out.println("La perdida de esta pila fue: "+ "USD " +totalLosses);
    }

    public double getTotalLossesTruck() {
        return totalLossesTruck;
    }
    
    
    
    
    
    
    
}
