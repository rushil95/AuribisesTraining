
public class KnapsackBruteForce {
	
	public static void main(String[] args) {
		int maxWeight=20;
		int currentWeight=0;
		int currentValue=0;
		int maxValue=0;
		int [] weights= {20,10,9,4,2,1};
		int [] values= {4000,3500,1800,400,1000,200};
		int len=values.length;
		int [] result=new int[len];
		int [] chosen=new int [len];
		int numOfIteration=(int)Math.pow(2,6);
		
		for(int i=0;i<numOfIteration;i++)
		{
			for(int j=len-1;j>=0;j--)
			{
				if(chosen[j]==1) {
					chosen[j]=0;
				}
				else
				{	
					chosen[j]=1;
					break;
				}
				
			}
			currentValue=0;
			currentWeight=0;
			for(int ele=0;ele<len;ele++)
			{
				if(chosen[ele]==1)
					{
					currentValue+=values[ele];
					currentWeight+=weights[ele]; }
			}
			//System.out.println(currentValue);
			
					if((currentValue>=maxValue)&&(currentWeight<=maxWeight))
					{
						maxValue=currentValue;
						for(int ele2=0;ele2<len;ele2++)
						{
							result[ele2]=chosen[ele2];
						}
						
					}
			}
			
	
	System.out.println(maxValue);
		for(int index=0;index<len;index++)
		{ 
			if(result[index]==1)
			System.out.print(values[index]+" ");
			else
				System.out.print("0 ");
		}

		

	}
}
