#include<iostream>
#include"solution.cpp"


void main(){
	ListNode *node = new ListNode(5);
	for (int i = 0; i < 9; i++)	
	{
		ListNode *p = new ListNode(i);
		p->next = node;
		node = p;
	}

	Solution sl;
	node = sl.sortList(node);

	ListNode *q = node;

	for (int i = 0; i < 10; i++)
	{
		cout << q->val << endl;
		q =q->next;
	}
	getchar();

}