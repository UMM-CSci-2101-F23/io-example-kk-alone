package umm2101;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {

   /**
    * @param args
    */
   public static void main(String[] args) { 
      BST<Integer> myTree = buildTreeFromTextFile(); 
      System.out.println(myTree.toString()); 
      // System.out.println(count(example())); 
      // queueStuff3();
      // String filename = args[0];//Pass the function a full filepath
      // beginParsing(filename);//call the parsing function
   }

   public static int count(String theString) {
      if (theString.equals("")) {
         return 0;
      } else {
         return 1 + count(theString.substring(1));
      }
   }

   public static BST<Integer> buildTreeFromTextFile() {
      BST<Integer> bst = new BST<>();
      try {
         Scanner sc = new Scanner(new FileReader("bst.txt"));
         while(sc.hasNext()) {
            String cmd = sc.next();
            String thing;
            switch(cmd) {
              case "insert" :
                 thing = sc.next();
                 bst.insert(Integer.parseInt(thing));
              break;
              case "break" :
              break;
              default ://Found an unrecognized command
                 System.out.println("Unrecognized input "+cmd);
              break;
            }
         }
         sc.close();
       } catch (Exception e) {
         e.printStackTrace();
       }
       return bst;
   }

   public static void buildTreeFromTextInput() {
      Scanner sc = new Scanner(new InputStreamReader(System.in));
      BST<Integer> bst = new BST<>();
      while(sc.hasNext()) {
            String cmd = sc.next();
            String thing;
            switch(cmd) {
              case "insert" :
                 thing = sc.next();
                 bst.insert(Integer.parseInt(thing));
                 System.out.println(bst);
              break;
              case "break" :
                  //Closing BufferedWriter Stream
                  System.exit(0);
                  sc.close();
              break;
              default ://Found an unrecognized command
                 System.out.println("Unrecognized input "+cmd);
              break;
            }
         }
         sc.close();
   }
   
   public static String example() {
      Scanner input = new Scanner(new InputStreamReader(System.in));
      String thingToEcho = input.next();
      System.out.println(thingToEcho);
      input.close();
      return thingToEcho;
   }

   public static void queueStuff3() {
      AQueue<String> contents = new AQueue<>();
      Scanner sc  = new Scanner(new InputStreamReader(System.in));
      File file = new File("queueExample3.txt");

      try {
         /* This logic is to create the file if the
          * file is not already present
          */
         if(!file.exists()){
            file.createNewFile();
         } 
         //Here true is to append the content to file
         FileWriter fw = new FileWriter(file,true);
         //BufferedWriter writer give better performance
         BufferedWriter bw = new BufferedWriter(fw);

         while(sc.hasNext()) {
            String cmd = sc.next();
            String thing;
            switch(cmd) {
              case "enqueue" :
                 thing = sc.next();
                 contents.enqueue(thing);
                 System.out.println(contents);
                 bw.write("enqueue " + thing + "\n");
              break;
              case "dequeue" :
                 thing = contents.dequeue();
                 System.out.println("Now serving: " + thing);
                 System.out.println("still in line: " + contents);
                 bw.write("dequeue " + "\n");
              break;
              case "break" :
                  //Closing BufferedWriter Stream
                  bw.close();
                  System.exit(0);
                  sc.close();
              break;
              default ://Found an unrecognized command
                 System.out.println("Unrecognized input "+cmd);
              break;
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }


   public static void queueStuff2() {
      AQueue<String> contents = new AQueue<>();
      try {
         Scanner sc  = new Scanner(new InputStreamReader(System.in));
         while(sc.hasNext()) {
            String cmd = sc.next();
            String thing;
            switch(cmd) {
                 case "enqueue" :
                    thing = sc.next();
                    contents.enqueue(thing);
                    System.out.println(contents);
                 break;
                 case "dequeue" :
                    thing = contents.dequeue();
                    System.out.println("Now serving: " + thing);
                    System.out.println("still in line: " + contents);
                 break;
                 case "break" :
                     System.exit(0);
                     sc.close();
                 break;
                 default ://Found an unrecognized command
                    System.out.println("Unrecognized input "+cmd);
                 break;
            }
          }
      } catch (Exception e) {
         e.printStackTrace();
       }
   }

   public static void queueStuff() {
      AQueue<String> contents = new AQueue<>();
      try {
        Scanner sc  = new Scanner(new File("queueExample.txt"));
        while(sc.hasNext()) {
          String cmd = sc.next();
          String thing;
          switch(cmd) {
               case "enqueue" :
                  thing = sc.next();
                  contents.enqueue(thing);
                  System.out.println(contents);
               break;
               case "dequeue" :
                  thing = contents.dequeue();
                  System.out.println("Now serving: " + thing);
                  System.out.println("still in line: " + contents);
               break;
               default ://Found an unrecognized command
                  System.out.println("Unrecognized input "+cmd);
               break;
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
   }
   
   public static void beginParsing(String filename) {
      try {
         Scanner sc = new Scanner(new File(filename));//Create our new scanner
         while(sc.hasNext()) {//While the scanner has information to read
            String cmd = sc.next();//Read the next term
            double x; double y; double radius;
            switch(cmd) {
               case "debug" :
                  System.out.println("debug cmd activated");
               break;
               case "add" ://Found an add command
                  x = sc.nextDouble();
                  y = sc.nextDouble();
                  String name = sc.next();
                  System.out.println("Insert node at "+x+" "+y+" with name "+name);
               break;
               case "delete" ://Found a delete command
                  x = sc.nextDouble();
                  y = sc.nextDouble();
                  System.out.println("Remove node at "+x+" "+y);
               break;
               case "search" ://Found a search command
                  x = sc.nextDouble();
                  y = sc.nextDouble();
                  radius = sc.nextDouble();
                  System.out.println("Search for node near "+x+" "+y+" within radius of "+radius);
               break;
               default ://Found an unrecognized command
                  System.out.println("Unrecognized input "+cmd);
               break;
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

}