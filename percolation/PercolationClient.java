/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package percolation;
import java.util.Random;
/**
 *
 * @author gaprile
 */
public class PercolationClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Random rand = new Random(); 
        int cycle =0;
        boolean res = false;
        int N=64;
        Percolation pc = new Percolation(N);  // init 
        while(!pc.percolates()){
            int r = rand.nextInt(N)+1;
            int c = rand.nextInt(N)+1;
            if(!pc.isOpen(r, c)){        
             pc.open(r, c);
             cycle++;

            }           
        }
        int c = pc.count();
        for(int i = 0; i<N; i++)
        {
            for(int j = 0; j<N; j++)
            {
                String a = "[X]";
                if(pc.isOpen(i+1,j+1)){
                    a = "[ ]";
                }    
                if(pc.isFull(i+1,j+1)){
                    a = "[@]";
                }
                System.out.print(a);
            }
            System.out.print("\n");
        }
            
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");                              
        System.out.println("result p =  " + Double.toString((double) c /(N*N)));

    }
    
}
