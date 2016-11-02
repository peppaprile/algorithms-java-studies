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
public class QuickUnionWeightedPathCompression {
    public final int[] id;
    private final int[] sz;
  
    
    public QuickUnionWeightedPathCompression(int N){
        id = new int[N];
        sz = new int[N];
        for (int i=0; i< N ;i++){                  
            id[i]=i;                                // N array access
            sz[i]=1;                                // N array access
        }
    }
    private int root(int i){                    
        if (i != id[i])
         {
            id[i] = id[id[i]];
            i = id[i];
         }    
        return i;
    }  
    public void union(int p, int q){                                                 
        int pid= root(p);                           // depth of p array access
        int qid= root(q);                           // depth of q access
        if(qid==pid)    return;
        if(sz[pid] < sz[qid]){                      // 1 array access
            id[pid]=qid;                            // 1 array access
            sz[qid]+= sz[pid];                      // 2 array access
        }else{
            id[qid]=pid;                            // 1 array access
            sz[pid]+= sz[qid];                      // 2 array access
        }
        
      
    }
    public boolean connected(int p, int q){
        return (root(p)==root(q));                    // depth of p + q array access
    }  
}
