
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//   public Deque()                           // construct an empty deque
//   public boolean isEmpty()                 // is the deque empty?
//   public int size()                        // return the number of items on the deque
//   public void addFirst(Item item)          // add the item to the front
//   public void addLast(Item item)           // add the item to the end
//   public Item removeFirst()                // remove and return the item from the front
//   public Item removeLast()                 // remove and return the item from the end
//   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
//   public static void main(String[] args)   // unit testing
/**
 *
 * @author gaprile
 * @param <Item>
 */
 public class DequeueSLL<Item> implements Iterable<Item>
 {
        private Node first, last = null;
        private int n;
        private class Node
        {
            Item item;
            Node next;   
        }
        
        public DequeueSLL(){
            first=null;
            last=null;
            n = 0;
        }  
        public int size()
        {
            return n;
        }  
        public boolean isEmpty()
        { 
            return first == null; 
        }
        public void addFirst(Item item) ///push on top of the list
        {
 
            Node oldfirst = first;
            first = new Node();  
            first.item = item;
            first.next = oldfirst;
            n++;
        }
     

        public void addLast(Item item)    //push at the bottom of the list
        {
            Node oldlast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if (isEmpty()){
                first = last;
            }
            else {
                oldlast.next = last;
            }
            n++;
           
        }

        public Item removeFirst()                 //like pop but we check if list is empty to update last node to null ....deleti the node
        {
            if(n > 0){
                Item item = first.item;
                first = first.next;             
                if (isEmpty()) last = null;
                n--;
                return item;
            }else{
                throw new UnsupportedOperationException();
            }
        }
         public Item removeLast()                
        {
            if(n > 0){
                Item item = last.item;
                last = null;              
                n--;
                return item;
            }else{
                throw new UnsupportedOperationException();
            }
        }
        
        @Override
        public Iterator<Item> iterator() {
            
            return new ListIterator(); 
   
        }
        private class ListIterator implements Iterator<Item>
        {
            private Node current = first;
            
            @Override
            public boolean hasNext() {
                return current != null; 
            }
            @Override
            public void remove() 
            { 
                throw new UnsupportedOperationException();
            }
            @Override
            public Item next()
            {
                Item item = current.item;
                current = current.next;
                if(current!=null)
                    return item;
                else
                    throw new NoSuchElementException();
            }
        }
        
}