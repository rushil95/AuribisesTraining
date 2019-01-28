
public class BrickProblem {
	public static void main(String args[]) {
		int totalBricks=0;
		int johnBricks=0;
		int markBricks=0;
		int numOfBricks=18;
		int i=1;
		while(totalBricks<=numOfBricks) {
			johnBricks=i;
			totalBricks+=johnBricks;
			if(totalBricks>numOfBricks)
			{
				{
					int num=totalBricks-numOfBricks;
					int result=johnBricks-num;
					System.out.println("Wall completed with"+numOfBricks+" Bricks,John has placed "+result+" bricks lastly");
					break;
				}
			}
			if(totalBricks==numOfBricks)
			{
				System.out.println("Wall completed with 12 Bricks,John has placed "+johnBricks+" bricks lastly");
				break;
			}
			markBricks=2*johnBricks;
			totalBricks+=markBricks;
			if(totalBricks>numOfBricks)
			{
				{
					int num2=totalBricks-numOfBricks;
					int result2=markBricks-num2;
					System.out.println("Wall completed with"+numOfBricks+" Bricks,Mark has placed "+result2+" bricks lastly");
					break;
				}
			}
			
			if(totalBricks==numOfBricks)
			{
				System.out.println("Wall completed with 12 Bricks,Mark has placed "+markBricks+" bricks lastly");
				break;
			}
			
			i++;
			
		}
	}

}
