package random;

import java.util.Random;

public class Chase {
	 static int a=1;
	 static int b=51;
	 static int count=0;
public static void main(String[] args) {
	 Random randomGenerator_x = new Random();
	 Random randomGenerator_y = new Random();
	
	 
	 while(a!=b){
		 int randomInt_x = randomGenerator_x.nextInt(6)+1;
		 int randomInt_y = randomGenerator_y.nextInt(6)+1;
	 if (randomInt_x==1){
		 b++;
		 count++;
		 }
	 	else if (randomInt_x==6){
		 b--;
		 count++;
	 	} else{
		 count++;
	 	}
	 if (randomInt_y==1){
		 a--;
	 	} else if (randomInt_y==6){
		 a++;
	 	}
     }
	 System.out.println(count);
}
}
