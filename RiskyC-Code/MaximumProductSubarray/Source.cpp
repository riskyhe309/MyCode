#include<math.h>
class Solution {
public:
    int maxProduct(int A[], int n) {
		if (n == 0)
		{
			return 0;
		}

        int maxP = A[0];
		int minP = A[0];
		int maxProduct = A[0];

		for(int i = 1; i < n; i++){

			int temmaxP = (maxP * A[i]);
			int tempminP = (minP * A[i]);

			if(temmaxP < tempminP) 
			{
				 int tem = temmaxP;
				 temmaxP = tempminP;
				 tempminP = tem;
			
			}

			maxP = temmaxP > A[i] ? temmaxP : A[i];
			minP = tempminP < A[i] ? tempminP : A[i];
		
			maxProduct = maxP > maxProduct ? maxP : maxProduct;

		}
		return maxProduct;
	}
};