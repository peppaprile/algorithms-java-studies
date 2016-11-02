/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickunion;

/**
 *
 * @author gaprile
 */
public class QuickUnion {
    public final int[] id;
    
    public QuickUnion(int N){
        id = new int[N];
        for (int i=0; i< N ;i++){                  
            id[i]=i;                                // N array access
        }
    }
    private int root(int i){                    
        if(id[i]!=i){                               // depth of i array access
            i=id[i];                                // depth of i array access
        }           
        return i;
    }  
    public void union(int p, int q){                                                 
        int pid= root(p);                           // depth of p array access
        int qid= root(q);                           // depth of q access
        id[pid]=qid;                                // 1 array access
      
    }
    public boolean connected(int p, int q){
        return (root(p)==root(q));                    // depth of p + q array access
    }  
}
