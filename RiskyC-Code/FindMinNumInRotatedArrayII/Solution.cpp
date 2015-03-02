#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int findMin(vector<int> &num) {
		if (num.empty())
			return NULL;

        int  low = 0;
		int high = num.size() - 1;

		return findSubMin(num,low,high);
	}

	int findSubMin(vector<int> &num, int low, int high ){
	
		while(low < high)
		{
			int mid = low + ((high -low) >> 1);

			if (num[mid] < num[high])
			{
				high = mid;	
			}
			else if (num[mid] > num[high])
			{
				low = mid + 1;
			}
			else 
			{
				int leftMin = findSubMin(num,low,mid);
				int rightMin = findSubMin(num,mid+1,high);
				return leftMin < rightMin ? leftMin : rightMin;
			}
		}
		return num[high];
	}
};