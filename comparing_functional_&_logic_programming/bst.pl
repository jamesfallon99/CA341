tree(X, Left, Right).
/*A tree takes a value X, a left tree and a right tree */

/*Search check if the value X is contained the the tree and returns true or false*/
search(X, tree(X, Left, Right)). /*Base case- X is the value in the tree*/
search(X, tree(Root, Left, Right)):- X =< Root, search(X, Left).
/*Otherwise search for X in the Left child*/
search(X, tree(Root, Left, Right)):- search(X, Right).
/*and search for X in the right child*/
/*e.g.search(30,tree(10,tree(3,empty,empty),tree(20,empty, tree(30,empty, empty)))).
true .*/
/*checks if X is less than the Root, if it is, searches left child
otherwise X greater than Root,searches right child */

insert(X, empty, tree(X, empty, empty)). /*when inserting a value into the tree, insert value X into the tree to get tree "R" */
insert(X, tree(Root, Left, Right), tree(Root, NewLeft, Right)) :- X =< Root, insert(X, Left, NewLeft).
insert(X, tree(Root, Left, Right), tree(Root, Left, NewRight)) :- X > Root, insert(X, Left, NewRight).
/*to insert a value, it takes a value X and a tree and returns a tree with that value in it
If X is less than the Root, recursively insert into the left child
Otherwise, recursively insert into the right child
e.g.insert(30, empty, R)
R = tree(30, empty, empty)*/

inorder(empty, []). /*if tree is empty, return an empty list*/
inorder(tree(X, Left, Right), List) :- inorder(Left,LeftList), append(LeftList, [X], LeftResult), inorder(Right,RightList), append(LeftResult, RightList, List).
/*Otherwise, inorder takes a tree and returns a list of the nodes of the tree in order
It recursively calls the Left tree which has its own List called LeftList,then append the value X to LeftList. It then recusively calls the right tree which also has its own list called RightList, then append LeftList and RightList to get the final List.*/
/*run using this code in prolog terminal:
inorder(tree(10,tree(3,empty,empty),tree(20,empty, tree(30,empty, empty))),X).
X = [3, 10, 20, 30]*/

preorder(empty, []). /*if tree is empty, return an empty list*/
preorder(tree(X, Left, Right), List) :- preorder(Left,LeftList), append([X], LeftList, LeftResult), preorder(Right,RightList), append(LeftResult, RightList, List).
/*preorder behaves the same as inorder except the the root node(X) is the first value in the list*/
/*run using this code in prolog terminal:
preorder(tree(10,tree(3,empty,empty),tree(20,empty, tree(30,empty, empty))),X).
X = [10, 3, 20, 30].*/


postorder(empty, []). /*if tree is empty, return an empty list*/
postorder(tree(X, Left, Right), List) :- postorder(Left,LeftList), postorder(Right,RightList), append(LeftList, RightList, NewList), append(NewList,[X],List).
/*postorder behaves the same as inorder and preorder except the the root node(X) is the last value in the list*/
/*run using this code in prolog terminal:
postorder(tree(10,tree(3,empty,empty),tree(20,empty, tree(30,empty, empty))),X).
X = [3, 30, 20, 10].*/



