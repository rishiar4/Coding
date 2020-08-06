# Add First In Linked List

## Question

1. You are given a partially written LinkedList class.
2. Here is a list of existing functions:
2.1 addLast - adds a new element with given value to the end of Linked List
2.2. display - Prints the elements of linked list from front to end in a single line. All elements are separated by space
2.3. size - Returns the number of elements in the linked list.
2.4. removeFirst - Removes the first element from Linked List. 
2.5. getFirst - Returns the data of first element. 
2.6. getLast - Returns the data of last element. 
2.7. getAt - Returns the data of element available at the index passed. 
3. You are required to complete the body of addFirst function. This function should add the element to the beginning of the linkedlist and appropriately set the head, tail and size data-members.
4. Input and Output is managed for you. 

## Sample Input

addFirst 10
getFirst
addFirst 20
getFirst
getLast
display
size
addLast 40
getLast
addLast 50
addFirst 30
removeFirst
getFirst
removeFirst
removeFirst
getAt 3
display
size
removeFirst
removeFirst
getFirst
quit

## Sample Output

10
20
10
20 10 
2
40
20
Invalid arguments
40 50 
2
List is empty