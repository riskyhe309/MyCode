#include<iostream>
using namespace std;
class Solution {
public:
    void sortColors(int A[], int n) {
        int red = 0;
		int white = 0;
		int blue = n - 1;
		while (white <= blue)
		{
			if (A[white] == 0)
			{
				int temp = A[red];
				A[red] = 0;
				A[white] = temp;
				white++;
				red++;
			}
			else if (A[white] == 1)
				white++;

			else if (A[white] == 2)
			{
				while(A[blue] == 2 && blue > white)
					blue--;

				if (blue == white)
					break;

				int temp = A[blue];
				A[blue] = 2;
				A[white] = temp;
				blue--;
			}
		}
		
		for (int i = 0; i < n; i++)
		{
			cout<<A[i]<<endl;
		}
    }
};