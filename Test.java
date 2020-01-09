/*A program to demonstrate serialization for various diffferent dependencies*/

import java.io.*;
class abc implements Serializable
{
String place;
String job;
abc(String place,String job){
this.place=place;
this.job=job;
}
}

import java.io.*;
public class def implements Serializable
{
int id;
String name;
def(int id,String name){
this.id=id;
this.name=name;
}
}

import java.io.*;
 
import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;


class Demo extends abc  
 
{  
  
int a; 

  int b; 

 def D; 
 

 public Demo(String place, String job, int a, int b,int id,String name) 

 { 
    
 super(place,job);
  
   D = new def( id, name);
  
   this.a = a; 
   
  this.b = b; 

 } 

}
 

class Test 

{ 

 public static void main(String[] args)
 
 { 
   
     Demo object = new Demo("kurnool","clerk",1,4,12,"abc"); 

     String filename = "file.ser"; 
       

      
     try
   
  {    

         
         FileOutputStream file = new FileOutputStream(filename); 
 
        ObjectOutputStream out = new ObjectOutputStream(file); 
 
          
         
         out.writeObject(object); 
       
    out.close(); 
       
  file.close(); 
       
    
 System.out.println("Object has been serialized"); 


     } 
     
  
     catch(IOException ex) 
    
 { 
       
  System.out.println("IOException is caught"+ex); 
   
  } 

   
  try
  
   {    
     
    
         FileInputStream file = new FileInputStream(filename); 
 
        ObjectInputStream in = new ObjectInputStream(file); 
 
          
         
         object =(Demo)in.readObject(); 
	

 
          
         in.close(); 
       
  file.close(); 
 
          
         System.out.println("Object has been deserialized "); 
 
        System.out.println("a = " + object.a); 
 
        System.out.println("b = " + object.b); 
	
       System.out.println("b = " + object.place); 

	System.out.println("b = " + object.job);
 
	System.out.println("b = " + object.D.name); 

	System.out.println("b = " + object.D.id); 
   
  } 
       
 
    catch(IOException ex) 
 
    { 
     
    System.out.println("IOException is caught"+ex); 

     } 
     
  
     catch(ClassNotFoundException ex)
 
     { 
   
      System.out.println("ClassNotFoundException is caught");
 
     } 


 }
 
}