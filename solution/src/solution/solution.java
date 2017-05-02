package solution;

public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[8];
		A[0] = -1;
		A[1] = 1;
		A[2] = 3;
		A[3] = 3;
		A[4] = 3;
		A[5] = 2;
		A[6] = 1;
		A[7] = 0;
		int whereAmI = 0;
		int wantedDiff;
		int sliceCounter = 0;
		int next = 1;
		
		
		
		for(;;){
			if (whereAmI == A.length-1){
				break;
			}
			wantedDiff = A[whereAmI] - A[whereAmI+1];
			int tempWhereAmI = whereAmI;
			for (int i = tempWhereAmI; i < A.length - 1; i++){
				if(A[i] - A[i+1] == wantedDiff){
					whereAmI = i+1;
					sliceCounter++;
					
				}
				else{
					whereAmI = i+1;
					break;
				}
				
			}
//			
//			
//			
			
			
			
			
			
			
//			for(int i = 1 + whereAmI; i < A.length - 1; i++){
//				if(A[i] -  A[i+1] == wantedDiff){
//					whereAmI = i;
//					sliceCounter++;
//				}
//				else{
//					whereAmI++;
//					break;
//				}
//				
//			}
			
		}
		System.out.println(sliceCounter);
		
	}

}
