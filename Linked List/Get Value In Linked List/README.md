# Get Value In Linked List

## Question
1. You are given a partially written LinkedList class.
2. Here is a list of existing functions:
2.1 addLast - adds a new element with given value to the end of Linked List
2.2. display - Prints the elements of linked list from front to end in a single line. All elements are separated by space
2.3. size - Returns the number of elements in the linked list.
2.4. removeFirst - Removes the first element from Linked List. 
3. You are required to complete the body of getFirst, getLast and getAt function 
3.1. getFirst - Should return the data of first element. If empty should return -1 and print "List is empty".
3.2. getLast - Should return the data of last element. If empty should return -1 and print "List is empty".
3.3. getAt - Should return the data of element available at the index passed. If empty should return -1 and print "List is empty". If invalid index is passed, should return -1 and print "Invalid arguments".
4. Input and Output is managed for you. 

## Sample Input

addLast 10
getFirst
addLast 20
addLast 30
getFirst
getLast
getAt 1
addLast 40
getLast
addLast 50
removeFirst
getFirst
removeFirst
removeFirst
getAt 3
removeFirst
removeFirst
getFirst
quit

## Sample Output

10
10
30
20
40
20
Invalid arguments
List is empty