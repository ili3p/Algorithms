package my.codefu.y10.online1;

public class Deuce {

	public static int getWinner(String cards, int numPlayers) {

		char [] c = cards.toCharArray();
		int i;boolean ok =false;
		StringBuilder sb;
		
		for( i=0;i<c.length-1;i+=2)
		{	
			
			sb= new StringBuilder();
			sb.append(c[i]);
			sb.append(c[i+1]);
			System.out.println((i/2+1)+" :"+sb.toString());
			if(sb.toString().equals("2C"))
			{
				int numCards = c.length/2;
				int numHand = i/2;
				int leftHands = numCards-numHand;
				int player = numHand % numPlayers;
				if((numPlayers-player)<=leftHands)
				{
				ok = true;
				}
				break;
			}
		}
		int n;
		if(ok)
		n = i/2;
		else
			n=-1;
		return n % numPlayers;
	}
	public static void main(String[] args) {
		System.out.println(getWinner("QD8CQCJD5H9H7DJCAH4C8H1C8SJSKCKS2S4DKH1S9D3C9C7H5D9S8D2H7CAC6C6SKD1H6HQH2D3S4SQSJH3D3HAD5C7S5S1DAS6D2C4H",6));
				
	}
}
