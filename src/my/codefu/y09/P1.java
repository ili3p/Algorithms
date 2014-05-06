package my.codefu.y09;
public class P1 {
public String time(int seconds) {
int hh = seconds/3600;
seconds-=hh*3600;
int mm = seconds/60;
seconds -= mm*60;
String r = "";

if(hh<10)r = "0"+Integer.toString(hh);
else r = Integer.toString(hh);
if(mm < 10) r +=":0"+Integer.toString(mm);
else r+=":"+Integer.toString(mm);
r+=":"+Integer.toString(seconds);
return r;
}
}
