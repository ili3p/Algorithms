package old.code;

public class StackMachine {

	public String getOutput(String[] instructions) {
		Long [] stackot = new Long[1000];
		int index = -1;
		String rs = new String();
		rs="";
		for(String s:instructions)
		{
			String [] com_num = new String [2];
			com_num=s.split(" ");
			if(com_num[0].equals("PUSH"))
			{
				++index;
				Long r = Long.parseLong(com_num[1]);
				stackot[index]=r;
								
			}else if(com_num[0].equals("POP"))
			{
				if(index == -1)rs+="[ERROR]";
				else  --index;
				
			}else if(com_num[0].equals("ADD"))
			{
				if(index<1)rs+="[ERROR]";
				else
				{
					stackot[index-1]+=stackot[index];
					--index;
				}
			}else if(com_num[0].equals("SUB"))
			{
				if(index<1)rs+="[ERROR]";
				else
				{
					stackot[index-1]=stackot[index]-stackot[index-1];
					--index;
				}
			}else if(com_num[0].equals("MUL"))
			{
				if(index<1)rs+="[ERROR]";
				else
				{
					stackot[index-1]*=stackot[index];
					--index;
				}
			}else if(com_num[0].equals("SWAP"))
			{
				if(index<1)rs+="[ERROR]";
				else
				{
					Long temp = stackot[index-1];
					stackot[index-1]=stackot[index];
					stackot[index]=temp;
				}
			}else if(com_num[0].equals("PRINT"))
			{
				
				if(index == -1)rs+="[EMPTY]";
				else
				{
					Long z = stackot[index];
					
					rs+=Long.toString(z);
				}
				
			}
		}
		return rs;
		}
	public static void main(String[] args) {
		StackMachine s = new StackMachine() ;
		String [] sd={"PUSH 3", "PUSH 2", "SUB", "PRINT"};
		System.out.print(s.getOutput(sd));
	}

}
