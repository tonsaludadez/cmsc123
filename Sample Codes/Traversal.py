class Node:
	item = 0
	left = None
	right = None
	
def preorder(node):
	if not node:
		return

	print node.item
	preorder(node.left)
	preorder(node.right)

def inorder(node):
	if not node:
		return

	inorder(node.left)
	print node.item
	inorder(node.right)

def postorder(node):
	if not node:
		return

	postorder(node.left)
	postorder(node.right)
	print node.item

a = Node()
b = Node()
c = Node()
d = Node()

a.item = "A"
b.item = "B"
c.item = "C"
d.item = "D"

a.left = b
a.right = c
b.right = d

print "Preorder:"
preorder(a)
print "Inorder:"
inorder(a)
print "Postorder:"
postorder(a)

