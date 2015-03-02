#include"main.cpp"
using namespace std;
int main()
{
	vector<int> vec;

    for(int i = 2; i < 7; i++ )
	   vec.push_back(i);
	

	Solution s1;

	cout << s1.findMin(vec) << endl;

	getchar();

}