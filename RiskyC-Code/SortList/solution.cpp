#include<iostream>
#include"ListNode.h"
using namespace std;

class Solution {
public:
	ListNode *sortList(ListNode *head) 
	{
		if (head == NULL || head->next == NULL )
			return head;

		ListNode *p,*q;
		 p = head;
		 q = head;
		//p is the middle of the list while q is the end 
		while ( q->next != NULL && q->next->next != NULL )
		{
			p = p->next;
			q = q->next->next;
		}

		//split the list into  two equilong parts
		q = p->next;
		p->next = NULL;
		p = head;

		//recursion call this function
		p = sortList(p);
		q = sortList(q);

		return merge(p,q);
	}

	ListNode *merge(ListNode *first,ListNode *second)
	{
		if (first == NULL || second == NULL)
		{
			return first == NULL?second:first;
		}
		
		ListNode *list;
		
		//insure the list is the smaller one
		(first->val <= second->val)?(first=(list = first)->next)
			:(second =(list = second)->next);

		ListNode *p = list;
		while(first!=NULL && second != NULL)
		{
			(first->val <= second->val)?(first=(p->next = first)->next)
				:(second =(p->next = second)->next);

			p = p->next;
		}
		p->next = (first != NULL?first:second);
		
		return list;
	}
};