#include <iostream>
#include <set>
#include <map>
#include <queue>
#include "undirectedGraph.h"
class Solution {
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
      
		 if(node == NULL) return 0;
		queue <UndirectedGraphNode *> q1;
		UndirectedGraphNode *curNewNode,*curOldNode;
		UndirectedGraphNode *newRoot = new UndirectedGraphNode(node->label);
		//the first node of the copy graph

		set<int> label;
		map<int,UndirectedGraphNode *> newNode;
		// add the rootlabel and the point
		newNode[newRoot->label] = newRoot;
		q1.push(node);
		//q2.push(newRoot);
		while(!q1.empty()){	
			//q1 is the queue of the point to origin graph
			//q2 is the queue of the point to cpoy graph
			curOldNode = q1.front();
			q1.pop();
			curNewNode = newNode[curOldNode->label];
		//	curNewNode = q2.front();
			//q2.pop();

			//the Node has not vicited
			if(label.count(curOldNode->label) == 0 ){
				label.insert(curOldNode->label);
				//copy the neighbors
				for (vector<int>::size_type ix = 0; ix != curOldNode->neighbors.size(); ix++){
				
					int tempLabel = curOldNode->neighbors[ix]->label;

					//whether the tempLabel is exited or not
					map<int, UndirectedGraphNode *>::iterator iter 
						= newNode.find(tempLabel);

					if (iter == newNode.end())
							// the node is not exited
						newNode[tempLabel] = new UndirectedGraphNode(tempLabel);

					q1.push(curOldNode->neighbors[ix]);
					//q2.push(neigbor);

					// copy the neighbors of the curNode
					curNewNode->neighbors.push_back(newNode[tempLabel]);
				}
			}
		}	
		return newRoot;
    }
};