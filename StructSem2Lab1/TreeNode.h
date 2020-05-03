class TreeNode
{
protected:
	TreeNode* leftNodePointer;
	TreeNode* rightNodePointer;
	TreeNode* parentPointer;
	int data;
public:
	TreeNode(const int& data)
	{
		this->data = data;
		this->leftNodePointer = nullptr;
		this->rightNodePointer = nullptr;
		this->parentPointer = nullptr;
	}
	int getTreeNodeData()
	{
		return this->data;
	}
	void addLeftNode(TreeNode*& node)
	{
		this->leftNodePointer = node;
	}
	void addRightNode(TreeNode*& node)
	{
		this->rightNodePointer = node;
	}
	void addParentNode(TreeNode*& node)
	{
		this->parentPointer = node;
	}
	TreeNode* getLeftNode()
	{
		return this->leftNodePointer;
	}
	TreeNode* getRightNode()
	{
		return this->rightNodePointer;
	}
	TreeNode* getParentNode()
	{
		return this->leftNodePointer;
	}
};