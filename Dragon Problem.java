package Khaleesi;

public class drogo {
//static  String a = "FaRbFR";
//static  String b = "LFaLb";
//static String e = "RLFaLbFR";
//static String f = "RLFaRbFR";
//static String g = "LLFaLbFR";
//static String h = "LLFaRbFR";
static String D_temp="";
static String D_temp1="";
static String D_temp2="aefgfehg"; //its fourth series
static String D_temp3="aefgfehgfefghehg; //its 5th series
static String D_temp4="";
static String D_temp5="";
static String D_temp6="";
static String D_temp7="";
static String D_temp8="";

static String SettingUp(){
for(int i=1; i<5;i++){
int len = D_temp3.length();
int leng = D_temp2.length();
int length = (len-leng);
int lengt=(length)/2;
D_temp=D_temp3.substring(leng,len);
D_temp1=D_temp.substring(0,1);
D_temp4=D_temp.substring(lengt,lengt+1);
//for firstpartofstring
if (D_temp4.equals("f")){
	D_temp7="h";
}
else if(D_temp4.equals("h")){
	D_temp7="f";
}
//for second part of string
if(D_temp1.equals("f")){
D_temp8 ="h";
}
else if (D_temp1.equals("h")){
	D_temp8="f";
}
//7,8,4,3,2,1,0-extraString
D_temp5=D_temp.substring(0, lengt);
D_temp5+=D_temp7;
D_temp5+=D_temp.substring(lengt+1,length);
D_temp8+=D_temp.substring(1,length);
D_temp2=D_temp3;
D_temp3=D_temp2+D_temp5+D_temp8;

}
System.out.println(D_temp3);
return D_temp3;
}
static void coordinates(String D){
    int b=-1;
	int x=1;
	int y=1;
	for(int j=1;j<D.length();j++){  
		char a=D.charAt(j); //a,f are similar in coordinates type
		
		switch(a){
		case 'e':
			x+=(b*(-1));
			y+=(b*(1));
			break;
		case 'f' :
			x+=(b*(1));
			y+=(b*(1));
			b=b*(-1);
			break;
		case 'g' :
			x+=(b*(1));
			y+=(b*(-1));
			b=b*(-1);
			break;
		case 'h' :
			x+=(b*(-1));
			y+=(b*(-1));
			break;
		}
		System.out.println("X coordinate is" +x);
		System.out.println("Y coordinate is" +y);
		}
		System.out.println("X coordinate is" +x);
		System.out.println("Y coordinate is" +y);
	}

public static void main(String[] args) {

String E=drogo.SettingUp();
//System.out.println(Datum.D_temp3);
drogo.coordinates(E);
}
}
