#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int candy(vector<int> &ratings) {
        int preCandy = 1;		//Previous child's candy count
		int totalCandies = 0;	//total candies
		int seqLen = 0;			//the continuous ratings descending sequence length
		int maxSeqLen = preCandy; //make sure the first child in the seq is little 
									//than its pre, if its pre is equal to it like 4 5  
									//6 7 5 4 3 2 1  when we 2 we must include the 7 in the 
									//sequence,make sure 5's candy is smaller than 7
									

		if (ratings.begin() != ratings.end())
		{
			totalCandies++;
			for (vector<int>::iterator it = ratings.begin() + 1; 
				it != ratings.end() ; it++)
			{
				if (*it < *(it - 1))
				{
					seqLen++;
					if(maxSeqLen == seqLen)
						seqLen++;   // include the maxRating 

					totalCandies += seqLen;
					preCandy = 1;
				}
				else 
				{
					if (*it > *(it - 1))
						preCandy++;
					else
						preCandy = 1;

					seqLen = 0;
					maxSeqLen = preCandy;
					totalCandies += preCandy;
				}
			}
		}

		return totalCandies;
    }
};