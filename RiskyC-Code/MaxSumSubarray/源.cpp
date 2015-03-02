class Solution {
public:
    int maxSum(int A[], int n) {
        int sum = 0;
		int maxSum = 0;
		for(int i = 0; i < n; i++){

			sum = sum + A[i];

			if (sum <= 0)
			{
				sum = 0;
			}

			if (sum > maxSum)
			{
				maxSum = sum;
			}

		}

		return maxSum;
    }
};