import java.util.*;

public class WordStoreImp implements WordStore
{
    private static class Entry
    {
     private String word;
     private int value;
     private Entry next;
     public Entry(String word,int value,Entry next)
     	{
        		this.word=word;
        		this.value=value;
        		this.next=next;
     	}
   	}
    private Entry[] table;
    private int capacity;
    public WordStoreImp(int capacity)
    {
        this.capacity=capacity;
        table= new Entry[this.capacity];
   }
   @Override
   public void add(String word)
   {
        int hash=hash(word);
        Entry newEntry= new Entry(word,hash,null);
        
        if(table[hash]==null)
        {
            table[hash]= newEntry;
        }
        else
        {
            Entry current= table[hash];
            newEntry.next=current;
            table[hash]=newEntry;
        }
   }
   @Override
   public int count(String word)
    {
        int hash = hash(word);
        int count=0;
        if(table[hash] == null)
        {
         return 0;
        }
        else
        {
         Entry temp = table[hash];
         while(temp!= null)
         {
             if(temp.word.equals(word))
             {  count++;}
             temp = temp.next;
         }         
         return count;
        }
    }
   @Override
   public void remove(String word)
   {
     int hash=hash(word);
              
      if(table[hash] == null)
      {
            return;
      }
      else
       {
        Entry previous = null;
        Entry current = table[hash];
        
        while(current != null)
        { 
          if(current.word.equals(word))
          {               
              if(previous==null)
              {  
                   table[hash]=table[hash].next;
                   return; 
              }
              else
              {
                     previous.next=current.next;
                     return;
              }
           }
          
           previous=current;
           current =current.next;
        }
        return;
      }
    
   }
   private int hash(String word)
   {
        return Math.abs(hashCode(word));
   }
   private int hashCode(String word)
   {
      int hash = 7;
      for (int i = 0; i < word.length(); i++) 
     {
     hash = (hash*31 + word.charAt(i))%     capacity;
     }
     return hash;
   }
}
