
public class RightShift {
	int [] RightShifter(int[] arr,int noOfShifts)
	{
		int [] arr2=new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			arr2[(i+noOfShifts)%(arr.length)]=arr[i];
		}
		return arr2;
	}

	public static void main(String[] args) {
		int [] arr= {3,8,9,7,6};
		RightShift s1=new RightShift();
		arr=s1.RightShifter(arr,3);
		
		for(int ele:arr)
		{
			System.out.print(ele+" ");
		}
		

	}

}
