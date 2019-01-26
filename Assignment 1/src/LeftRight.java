
public class LeftRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]arr= {
						{1,0,1,0,1},
						{0,0,1,0,1},
						{1,1,1,0,1},
						{1,1,1,0,1},
						{0,0,0,0,1}
		};
		int decimalNum1=0;
		int decimalNum2=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++)
			{
				if(i==j) {
					decimalNum1+=arr[i][j]*(int)(Math.pow(2,arr.length-i-1));
					System.out.print(arr[i][j]+" ");
			}
			
		}

	}
		System.out.println(" Decimal->"+decimalNum1);
		System.out.println();
		
		for(int i=0;i<arr.length;i++) {
			for(int j=arr.length-1;j>=0;j--)
			{
				if(i+j+1==arr.length) {
					decimalNum2+=arr[i][j]*(int)(Math.pow(2,arr.length-i-1));
					System.out.print(arr[i][j]+" ");
			}
			
		}

	}
		System.out.println(" Decimal->"+decimalNum2);
		System.out.println();
		System.out.println("Sum of Decimals: "+(decimalNum1+decimalNum2));
		
}
}
