/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package percolation;

import quickunion.QuickUnionWeightedPathCompression;
import quickunion.QuickUnion;


/**
 *
 * @author gaprile
 */
public class Percolation {
         
   public final Site[]  idvs;
   public int dimension;
   private QuickUnionWeightedPathCompression quwpc;
 
   public Percolation(int n){                               // create n-by-n grid, with all sites blocked
   
       if(n<0)
           throw new java.lang.IllegalArgumentException();
       quwpc =  new QuickUnionWeightedPathCompression(2+n*n);
    
       this.dimension = n;
       idvs = new Site[2+n*n];

       int k=0;
       idvs[k] = new Site();      
       k++;
       
       for(int i=0;i < n;i++){
        for(int j=0;j < n;j++){
           idvs[k++] = new Site(); 
        } 
       }
       idvs[k] = new Site();
       
        // init virtual layers 
       for(int i=0 ; i < n+1;i++){
            quwpc.union(0, i);
            quwpc.union(1+(n*n), (1+n*n)-i);
       }
   }            
   public int getPosistionFromRowCol(int row, int col){
        if((row<1)||(col<1)){
           throw new java.lang.IndexOutOfBoundsException();
        }
        int r = row-1;
        int c = col-1;
        return dimension*(r) + c + 1;// ;
   }
   public void open(int row, int col){                 // open site (row, col) if it is not open already
        if((row<1)||(col<1)){
            throw new java.lang.IndexOutOfBoundsException();
        }
        int a = getPosistionFromRowCol(row,col);
        if(!idvs[a].isOpen()){   
            idvs[a].openSite();
            if(row > 1){
                if(idvs[getPosistionFromRowCol(row-1,col)].isOpen())
                    quwpc.union(getPosistionFromRowCol(row,col), getPosistionFromRowCol(row-1,col));
            }
            if(col < dimension-1){
                if(idvs[getPosistionFromRowCol(row,col+1)].isOpen())
                    quwpc.union(getPosistionFromRowCol(row,col), getPosistionFromRowCol(row,col+1));
            }
            if(row < dimension-1){
                if(idvs[getPosistionFromRowCol(row+1,col)].isOpen())
                    quwpc.union(getPosistionFromRowCol(row,col), getPosistionFromRowCol(row+1,col));
            }
              if(col > 1){
                if(idvs[getPosistionFromRowCol(row,col-1)].isOpen())
                    quwpc.union(getPosistionFromRowCol(row,col), getPosistionFromRowCol(row,col-1));
            }
            int p=getPosistionFromRowCol(row,col);
            if(quwpc.connected(p, 0)){
                idvs[p].fillSite();         
            }
        }
   }   
   public boolean isOpen(int row, int col){                 // is site (row, col) open?     
        if((row<1)||(col<1)){
           throw new java.lang.IndexOutOfBoundsException();
        }
        int a = getPosistionFromRowCol(row,col);
        return idvs[a].isOpen();
   }  
   public boolean isFull(int row, int col){    
        if((row<1)||(col<1)){
           throw new java.lang.IndexOutOfBoundsException();
        }// is site (row, col) full?
        int r = row-1;
        int c = col-1;
        int p = getPosistionFromRowCol(row,col);
        if(idvs[p].isOpen()){
            return quwpc.connected(p, 0);                
        }else{
            return false;
        }       
   }  
   public int count(){
       int count =0;
       for (Site idv : idvs) {
           if(idv.isOpen())
            count++;
       }
       return count;
   }
   public boolean percolates(){                             // does the system percolate?
       return quwpc.connected(0, 1+dimension*dimension);
   }              
}