#include "TreeNode.h"
#include <iostream>
#include <algorithm>

using namespace std;

class Tree
{
private:
	TreeNode* root;
	int countOfLeftNodes;
	int countOfRightNodes;
	int leftHeight;
	int rightHeight;
	int neededNodes;
public:
	Tree()
	{
		this->root = nullptr;
		this->countOfLeftNodes = 0;
		this->countOfRightNodes = 0;
		this->leftHeight = 0;
		this->rightHeight = 0;
    this->neededNodes = 0;
	}
	// Операции с корнем
	TreeNode* getRoot()
	{
		return this->root;
	}
	void setRoot(TreeNode* newRoot)
	{
		this->root = newRoot;
	}
	// Получение количества элементов слева и справа
	int getCountOfLeftNodes()
	{
		return this->countOfLeftNodes;
	}
	int getCountOfRightNodes()
	{
		return this->countOfRightNodes;
	}
	void getcountOfNeededNodes()
	{
		cout << "Количество вершин,удовлетворяющих условию: " << this->neededNodes << endl;
	}
	void addNewNode(const int& data)
	{
		TreeNode* newNode = new TreeNode(data);
		TreeNode* rootBuffer1 = root;
		TreeNode* rootBuffer2 = nullptr;
		// Поиск места узла
		while (rootBuffer1 != nullptr)
		{
			// Запоминаем родителя
			rootBuffer2 = rootBuffer1;
			if (data < rootBuffer1->getTreeNodeData())
				rootBuffer1 = rootBuffer1->getLeftNode();
			else
				rootBuffer1 = rootBuffer1->getRightNode();
		}
		newNode->addParentNode(rootBuffer2);
		// Добавление узла
		if (this->root == nullptr)
			this->root = newNode;
		else
		{
			if (data < rootBuffer2->getTreeNodeData())
				rootBuffer2->addLeftNode(newNode);
			else
				rootBuffer2->addRightNode(newNode);
		}
	}
	void printTree(TreeNode* node)
	{
		if (node == nullptr)
			return;
		cout << node->getTreeNodeData() << endl;
		printTree(node->getLeftNode());
		printTree(node->getRightNode());
	}
	void countNodes(TreeNode* node, TreeNode* rootBuffer, string& direction)
	{
		if (node == nullptr)
			return;
		if (rootBuffer->getTreeNodeData() < node->getTreeNodeData())
			direction = "right";
		if (direction == "left" && node->getTreeNodeData() != rootBuffer->getTreeNodeData())
			this->countOfLeftNodes++;
		if (direction == "right" && node->getTreeNodeData() != rootBuffer->getTreeNodeData())
			this->countOfRightNodes++;
		countNodes(node->getLeftNode(), rootBuffer, direction);
		countNodes(node->getRightNode(), rootBuffer, direction);
	}
	int calculateHeight(TreeNode* node)
	{
		if (node == nullptr || (node->getLeftNode() == nullptr && node->getRightNode() == nullptr))
			return 0;
		int left = calculateHeight(node->getLeftNode());
		int right = calculateHeight(node->getRightNode());
		return left > right ? left + 1 : right + 1;
	}
	void treeWalk(TreeNode* node)
	{
		if (node == nullptr)
			return;
		findNodesWhereSubsEqual(node);
		treeWalk(node->getLeftNode());
		treeWalk(node->getRightNode());
	}
	void findNodesWhereSubsEqual(TreeNode* node)
	{
		TreeNode* rootBuffer = node;
		TreeNode* nodeBuffer = node;
		string direction = "left";
		static int countNeededNodes = 0;
		countNodes(node, rootBuffer, direction);
		this->leftHeight = calculateHeight(node->getLeftNode());
		this->rightHeight = calculateHeight(node->getRightNode());
		// Вывод
		if (this->countOfLeftNodes == this->countOfRightNodes && this->countOfLeftNodes != 0)
		{
			cout << "Вершина: " << rootBuffer->getTreeNodeData() << " имеет одинаковое количество потомков" << endl << endl;
			this->neededNodes++;
		}
		else if (this->leftHeight == this->rightHeight && this->leftHeight != 0 && this->rightHeight != 0)
		{
			cout << "Вершина: " << nodeBuffer->getTreeNodeData() << " имеет равные величины высот правого и левого поддеревьев\n"
				<< "Высота левого поддерева: " << this->leftHeight + 1 << endl
				<< "Высота правого поддерева: " << this->rightHeight + 1 << endl << endl;
			this->neededNodes++;
		}
		this->countOfLeftNodes = this->countOfRightNodes = 0;
		this->leftHeight = this->rightHeight = 0;
	}
};
