package my.topcoder;import junit.framework.TestCase;import java.util.Arrays;/*
Problem Statement
    
Elly's memories of last night's sleepover with her friends are rather blurry. She recalls that they played a game involving drinking orange and apple juice. In the beginning there were two identical bottles. One contained a gallon of orange juice, the other a gallon of apple juice. The game was played in turns, starting with turn zero. In even-numbered turns (turn 0, 2, 4, ...) the current player drank half of the remaining orange juice. In odd-numbered turns (turn 1, 3, 5, ...) the current player drank half of the remaining apple juice. The winner of the game is the player who drank the greatest total amount of liquid during the game. If multiple players are tied for the greatest amount, there is no winner.

For example, consider a game consisting of five turns. Suppose that the players to drink were, in order, Elly, Kriss, Stancho, Elly, and Stancho. (That is, Elly and Stancho both drank twice: Elly in turns 0 and 3, Stancho in turns 2 and 4.) In this game, Elly drank 0.75 gallons of liquid (0.5 gallons of orange juice and 0.25 of apple juice), Kriss drank 0.5 gallons of apple juice, and Stancho drank 0.375 gallons of orange juice (0.25 gallons in turn 2 and another 0.125 gallons in turn 4). In this game Elly would be the winner.

Elly knows all the people who played the game yesterday, and for each of them the number of times they drank. However, she remembers nothing about the order in which the players drank.

You are given a String[] players, containing the names of all players. If a player's name is contained X times in players that means that he or she drank exactly X times during the game. Determine all people who could have possibly won the game (for some particular order of turns). Return their names as a lexicographically sorted String[]. The return value should only contain each of the names once.
Definition
    
Class:
EllysJuice
Method:
getWinners
Parameters:
String[]
Returns:
String[]
Method signature:
String[] getWinners(String[] players)
(be sure your method is public)
    

Notes
-
A sequence of distinct Strings is sorted if each element is lexicographically smaller than all the ones following it.
-
String A is lexicographically smaller than String B if A contains smaller character at the first index where they differ. If there is no index where they differ, the shorter one is lexicographically smaller. For example "ariadne" is smaller than "elly", "abc" is smaller than "abd", "aaa" is smaller than "aaaaa", and "czzzzzzz" is smaller than "kaaaaaaa".
Constraints
-
players will contain between 1 and 8 elements, inclusive.
-
Each element of players will contain between 1 and 20 characters, inclusive.
-
Each element of players will consist only of lowercase English letters ('a'-'z').
Examples
0)

    
{ "elly", "kriss", "stancho", "elly", "stancho" }
Returns: {"elly", "stancho" }
Elly would win for the order given in the problem statement. If Stancho and Elly swapped all their turns, Stancho would win the game. Kriss cannot win.
1)

    
{"torb", "elly", "stancho", "kriss"}
Returns: { }
In any valid game two of the four players would be tied for the lead (with half a gallon each).
2)

    
{"elly", "elly", "elly", "elly", "elly"}
Returns: {"elly" }
Since she was the only player, apparently she won.
3)

    
{ "ariadne", "elly", "ariadne", "stancho", "stancho", "kriss", "stancho", "elly" }
Returns: {"ariadne", "elly", "stancho" }
Although Stancho has drunk three times, there are orderings in which someone else wins.
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
*/public class EllysJuiceTest extends TestCase {  	 private EllysJuice toTest;	 protected void setUp() throws Exception { 		 toTest = new EllysJuice();	 }	 protected void tearDown() throws Exception { 		 super.tearDown(); 	 }	 public void testEllysJuice0() throws Exception { 		 String[] correct;		 String[] result;		 long start,end,diff;		 int limit = 8000;		 correct = new String[]{"elly", "stancho" };		 start = System.currentTimeMillis(); result = toTest.getWinners(new String[]{ "elly", "kriss", "stancho", "elly", "stancho" });		 end = System.currentTimeMillis(); diff = end - start;		 assertTrue("High time complexity. \nExecution time exceeds " + limit +" ms, took " + diff + " ms.",diff<limit);		 assertTrue("The method returns null.", result!=null);
		 assertArrayEquals(correct,result);
	 } 	 public void testEllysJuice1() throws Exception { 		 String[] correct;		 String[] result;		 long start,end,diff;		 int limit = 8000;		 correct = new String[]{ };		 start = System.currentTimeMillis(); result = toTest.getWinners(new String[]{"torb", "elly", "stancho", "kriss"});		 end = System.currentTimeMillis(); diff = end - start;		 assertTrue("High time complexity. \nExecution time exceeds " + limit +" ms, took " + diff + " ms.",diff<limit);		 assertTrue("The method returns null.", result!=null);
		 assertArrayEquals(correct,result);
	 } 	 public void testEllysJuice2() throws Exception { 		 String[] correct;		 String[] result;		 long start,end,diff;		 int limit = 8000;		 correct = new String[]{"elly" };		 start = System.currentTimeMillis(); result = toTest.getWinners(new String[]{"elly", "elly", "elly", "elly", "elly"});		 end = System.currentTimeMillis(); diff = end - start;		 assertTrue("High time complexity. \nExecution time exceeds " + limit +" ms, took " + diff + " ms.",diff<limit);		 assertTrue("The method returns null.", result!=null);
		 assertArrayEquals(correct,result);
	 } 	 public void testEllysJuice3() throws Exception { 		 String[] correct;		 String[] result;		 long start,end,diff;		 int limit = 8000;		 correct = new String[]{"ariadne", "elly", "stancho" };		 start = System.currentTimeMillis(); result = toTest.getWinners(new String[]{ "ariadne", "elly", "ariadne", "stancho", "stancho", "kriss", "stancho", "elly" });		 end = System.currentTimeMillis(); diff = end - start;		 assertTrue("High time complexity. \nExecution time exceeds " + limit +" ms, took " + diff + " ms.",diff<limit);		 assertTrue("The method returns null.", result!=null);
		 assertArrayEquals(correct,result);
	 } 	 void assertArrayEquals(String[] correct,String[] result){
		 StringBuffer correctBuf;
		 StringBuffer resultBuf;
		 int c;		 c = result.length;
		 correctBuf = new StringBuffer("{");
		 resultBuf = new StringBuffer("{");
		 for (int i = 0; i < correct.length; i++) {
			 correctBuf.append("\""+correct[i]+"\"");
			 if(i!=correct.length-1){
				 correctBuf.append(", ");
			 }
		 }
		 correctBuf.append("}");
		 for (int i = 0; i < result.length; i++) {
			 resultBuf.append("\""+result[i]+"\"");
			 if(i!=result.length-1){
				 resultBuf.append(", ");
			 }
		 }
		 resultBuf.append("}");
		 assertTrue("Arrays are different. \nexpected " + correctBuf.toString() + " but was " + resultBuf.toString() + "\nexpected.length ("+correct.length+") does not match result.length ("+result.length+") ",result.length==correct.length);		 for(int i = 0; i < c; i++){		 assertEquals("\nexpected " + correctBuf.toString() + " but was " + resultBuf.toString() + "\nat position " + i + " ",correct[i],result[i]);		 		 }}	 }