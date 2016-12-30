import java.util.*;

class CountTest
{
     public static void main(String[] args)
     {
          Scanner input = new Scanner(System.in);
          System.out.print("Enter the number of words you wish to generate initially: ");
          int n = input.nextInt();
          WordStore words = new WordStoreImp(n);
          
          for(int i=0; i<n; i++)
          {
                System.out.print("Enter word number " + (i+1) + ": ");
                words.add(input.next());
          }
             
          String line = input.nextLine();
          System.out.println("Enter words to remove, empty line to exit");
          line = input.nextLine();
          
          while(!line.equals("")) 
          {
              String[] listOfWords = line.split(" ");
              for(int i=0; i<listOfWords.length; i++)
              {
                  int count = words.count(listOfWords[i]);
                  System.out.print("\""+listOfWords[i]+"\" ");
                  if(count==0)
                     System.out.println("NOT generated");
                  else
                  {
                     words.remove(listOfWords[i]);
                     System.out.println("REMOVED word: " + (count-1) + " numbers left");
                  }
              }
              line = input.nextLine();
          }
     }
}