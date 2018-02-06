
public class EggDrop {
	//done using dynamic programming

	public static int max(int a, int b) { return (a > b)? a: b; }
	
	public static int eggFLoor(int n,int k){
		int[][] matrix = new int[n+1][k+1];
		int res;
		//for zero trails for zero floors and one trail for one floor
		for(int i=1;i<=n;i++){
			matrix[i][1] = 1;
			matrix[i][0] = 0;
		}
		
		//for one egg and j floors j trails
		for(int j=1;j<=k;j++){
			matrix[1][j] = j;
		}
		
		for(int i=2;i<=n;i++){
			for(int j=2;j<=k;j++){
				matrix[i][j] = Integer.MAX_VALUE;
	            for (int x = 1; x <= j; x++)
	            {
	                res = 1 + max(matrix[i-1][x-1], matrix[i][j-x]);
	                if (res < matrix[i][j])
	                	matrix[i][j] = res;
	            }
			}
		}
		
		return matrix[n][k];
	}

	public static void main(String[] args) {
		System.out.println(eggFLoor(2, 36));
	}

}
