
public class BinaryGap {
	void BinaryGapCounter(int arr[]){
		int len=arr.length;
		int maxCount=0;
		int startIndex=0;
		for(int i=0;i<len;i++)
		{	
			int count=0;
			if(arr[i]==0)
				continue;
			else{
				int j=i+1;
				while(j<len&&arr[j]!=1)
				{
					count++;
					j++;
				}
				if(count>maxCount)
				{
					maxCount=count;
					startIndex=i;
				}
			}
		}
		System.out.print("BinaryGap :");
		for(int i=startIndex;i<=(startIndex+maxCount+1);i++)
		{
			System.out.print(arr[i]+",");
		}
		System.out.print(" ->"+maxCount);
	
	}
	public static void main(String args[]){
		BinaryGap b1=new BinaryGap();
		int [] arr={1,0,1,0,0,0,0,1,0,1,0,0,0,1,0,1};
		b1.BinaryGapCounter(arr);
}

}

