package random;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class Amnesia {
	
	
public static void main(String[] args) {
	TreeMap<Integer,Integer> Larrys =new TreeMap<Integer,Integer>();
	TreeMap<Integer,Integer> Robbin =new TreeMap<Integer,Integer>();
	int count_1=0;
	int count_2=0;
	Integer x=0; 
	 for(Integer i=0;i<50;i++){
		 Random randomGenerator = new Random();
		 Integer r = randomGenerator.nextInt(10)+1; 
		 if(Larrys.containsValue(r)){	 
			 count_1++;	
			 for(Object O:Larrys.keySet()){
					if(Larrys.get(O)==r){
						Larrys.remove(O);
					    break;
					}
				 }
			 Larrys.put(i, r);
		 }
		 else{
			if(Larrys.size()<5){
				Larrys.put(i, r);
			}
			else{
				Integer a=Larrys.firstKey();
				Larrys.remove(a);
				Larrys.put(i, r);
			}					
		}		
		 if(Robbin.containsValue(r)){
			 count_2++;
			
		 }
		 else{
				if(Robbin.size()<5){
					Robbin.put(i, r);
				}
				else{
					Integer b=Robbin.firstKey();
					Robbin.remove(b);
					Robbin.put(i, r);
				}
	     
		 }
		 System.out.println(Larrys.toString()+"score:" +count_1);
		 System.out.println(Robbin.toString()+"score:" +count_2);
    }
	 System.out.println(count_2);
	 System.out.println(count_1);
	 if(count_1>count_2){
		 System.out.println("Larry is Winner");
	 }
	 else if(count_1==count_2){
		 System.out.println("Its a tie break");
	 }
	 else{
		 System.out.println("Robbin is Winner");
	 }
	 
}	 
}

