#include<iostream>
using namespace std;

class Solution {
public:


	int divide(int dividend, int divisor) {

		    if (divisor == 0 || dividend == 0)
		{
			return 0;
		}
		bool neg = (dividend >0 && divisor >0) || (dividend <0 && divisor <0);

		long long a = abs((long)dividend);
		long long b = abs((long)divisor);
		long long value = 0;

		while (a >= b)
		{
			int shift = 0;
			
			while ((b << shift) <= a)
			{
				shift++;
			
			}

			value += 1 << (shift - 1);
			a -= b << (shift - 1);
		}

		return neg ? value : -value;

	}
};
