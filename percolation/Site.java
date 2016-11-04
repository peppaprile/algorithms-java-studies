
package percolation;
/**
 *
 * @author gaprile
 */
public class Site{

        private boolean open;
        private boolean full;
 
        public Site(){
            this.open=false;
            this.full=false;
        } 
        public void openSite( ){
    
            this.open=true;
        }
        public void fillSite( ){
    
            this.full=true;
        }
        public boolean isOpen( ){      
            return this.open;
        }
        public boolean isFull( ){    
            if(this.open==false) return false;
            else    return this.full;
        }
       
   }