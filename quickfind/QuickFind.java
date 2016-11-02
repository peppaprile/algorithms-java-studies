package quickfind;

/**
 *
 * @author gaprile
 */
public class QuickFind {

    public final int[] id;
    
    public QuickFind(int N){
        id = new int[N];
        for (int i=0; i< N ;i++){                  
            id[i]=i;                                // N array access
        }
    }
    public void union(int p, int q){
        int pid =id[p];                             // 1 array access
        int qid =id[q];                             // 1 array access
        for (int i=0; i< id.length;i++){            
            if(id[i]==pid){                         // N array access
                id[i] = qid;                        // N array access
            }
        }
    }
    public boolean connected(int p, int q){
        return (id[p]==id[q]);                      //2 array access
    }   
}
