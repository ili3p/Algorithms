package my.codefu.y09;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class nat{
public String ID;
public int poeni;
public String ime;
nat(){}
nat(String I, int p, String im){ID = I;poeni=p;ime=im;}
}
public class P2 {
public String ranklist(String[] players, String[] results) {
String r = "";
List<nat> lis = new ArrayList<nat>();

for(int i=0; i < players.length; ++i)
{
String [] num_nick = new String[2];
num_nick = players[i].split(":");
nat n = new nat(num_nick[0],0,num_nick[1]);
lis.add(n);
}
for(int i=0; i < results.length; ++i)
{
String [] igrac = new String [2];
igrac = results[i].split("-");
String [] temp = new String [2];
temp = igrac[1].split(":");
igrac[1] = temp[0];
String outcome = temp[1];
if(outcome.compareTo("F") == 0)
{
for(nat n : lis)
if(n.ID.compareTo(igrac[0]) ==0)

n.poeni+=2;
}else if(outcome.compareTo("S") == 0)
{
for(nat n : lis)
if(n.ID.compareTo(igrac[1]) ==0)
n.poeni+=2;
}else if(outcome.compareTo("D") == 0 )
{
for(nat n : lis)
if(n.ID.compareTo(igrac[0]) ==0)
n.poeni+=1;
for(nat n : lis)
if(n.ID.compareTo(igrac[1]) ==0)
n.poeni+=1;
}
}

Collections.sort(lis, new Comparator<nat>(){
public int compare(nat n1, nat n2){
	int m =n2.poeni - n1.poeni;
	if(m == 0)m=Integer.parseInt(n1.ID) - Integer.parseInt(n2.ID); 
return m;
}
});

for(nat n:lis)
{
	r+=n.ime+",";
}
char [] m = new char[r.length()];
m = r.toCharArray();
m[r.length()-1]=' ';
String x = new String(m);
r = x;
r = r.trim();
return r;
}
public static void main(String[] args) {
	P2 p = new P2();
	String [] m = {"1:Capablanca","2:Alekhine","3:Lasker"};
	String [] r = {"2-1:D","3-1:D","2-3:F"};
	
		
	String x = p.ranklist(m,r);
	System.out.print(x);

}
}

