#include <iostream>
#include <vector>
#include "gasStation.h"
using namespace std;
int main()
{
	int a[3] = {0,4,5};
	vector<int> v1(a,a+3);
	
	int b[3] = {1,2,6};
	vector<int> v2(b,b+3);

	Solution sl;
	int reslut = sl.canCompleteCircuit(v1,v2);
	cout << reslut << endl;

}

