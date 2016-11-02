/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickunion;

import java.util.Random;
/**
 *
 * @author gaprile
 */
public class ClientQuickUnionWeighted {

    private static final int N = 100000000;
    public static void main(String[] args) {
 
// init
        QuickUnionWeighted qf=new QuickUnionWeighted(N);   
        
//        for (int e: qf.id) {           
//            System.out.println(e);    
//        }

        Random rand = new Random(); 
        int p,q; 
        int nCycle= N ;
        
// union
        for(int i=0;i<nCycle;i++){
          p=rand.nextInt(N);
          q=rand.nextInt(N);
          //System.out.println("union(" + p + "," + q + ")"); 
          qf.union(p,q);
        }
        
      //  System.out.println("result after some unions"); 
//        for (int e: qf.id) {           
//            System.out.println(e);    
//        }

        
//connect
        nCycle=N;
        for(int i=0;i<nCycle;i++){
          p=rand.nextInt(N);
          q=rand.nextInt(N);
          qf.connected(p,q);
        }
//        for (int e: qf.id) {           
//            System.out.println(e);    
//        }
    }


}
