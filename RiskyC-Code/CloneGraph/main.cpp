#include<iostream>
#include"colneGraph.cpp"
using namespace std;
void main(){
	UndirectedGraphNode *root = new UndirectedGraphNode(5);
	UndirectedGraphNode *root2 = new UndirectedGraphNode(10);
	root->neighbors.push_back(root2);
	root2->neighbors.push_back(root);
	Solution sl;
	UndirectedGraphNode *newnode ; 
	newnode = sl.cloneGraph(root);
	cout<< newnode->label<<endl;
	cout<<newnode->neighbors.front()->label<<endl;
	cout<<newnode->neighbors.front()->neighbors.front()->label<<endl;
	getchar();
}