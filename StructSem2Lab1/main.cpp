#include <iostream>
#include "Tree.h"
#include <time.h>
#include <random>
#include <locale.h>

using namespace std;

int main()
{
	srand(time(nullptr));
	setlocale(LC_ALL, "rus");
	Tree intTree;
	int countOfNodes;
	cout << "Введите количество узлов дерева\n";
	cin >> countOfNodes;
	cin.ignore();
	for (int i = 0; i < countOfNodes; i++)
		intTree.addNewNode(1 + rand() % 200);
	cout << "Узлы дерева:\n";
	intTree.printTree(intTree.getRoot());
	intTree.treeWalk(intTree.getRoot());
	intTree.getcountOfNeededNodes();
	return 0;
}