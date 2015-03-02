#include <iostream>
#include <string>
using namespace std;

int main ()
{
 string str ("This is an example phrase.");
 string::iterator it;

 // 第(1)种用法
 str.erase (str.length()-1);
 cout << str << endl;        // "This is an phrase."

 // 第(2)种用法
 it=str.begin()+9;
 str.erase (it);
 cout << str << endl;        // "This is a phrase."

 // 第(3)种用法
 str.erase (str.begin()+5, str.end()-7);
 cout << str << endl;        // "This phrase."
 return 0;
}