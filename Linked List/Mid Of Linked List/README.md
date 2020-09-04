# Mid Of Linked List

## Question
1. You are given a partially written LinkedList class.
2. Here is a list of existing functions:
     2.1 addLast - adds a new element with given value to the end of Linked List
     2.2. display - Prints the elements of linked list from front to end in a single line. 
     All elements are separated by space
    2.3. size - Returns the number of elements in the linked list.
    2.4. removeFirst - Removes the first element from Linked List. 
    2.5. getFirst - Returns the data of first element. 
    2.6. getLast - Returns the data of last element. 
    2.7. getAt - Returns the data of element available at the index passed. 
    2.8. addFirst - adds a new element with given value in front of linked list.
   2.9. addAt - adds a new element at a given index.
   2.10. removeLast - removes the last element of linked list.
   2.11. removeAt - remove an element at a given index
   2.12 kthFromLast - return kth node from end of linked list.
3. You are required to complete the body of mid function. The function should be an iterative function and should return the mid of linked list. Also, make sure to not use size data member directly or indirectly (by calculating size via making a traversal). In linked list of odd size, mid is unambigous. In linked list of even size, consider end of first half as mid.
4. Input and Output is managed for you.

## Sample Input

```
addLast 10
getFirst
addLast 20
addLast 30
getFirst
getLast
getAt 1
addLast 40
mid
getLast
addLast 50
removeFirst
getFirst
removeFirst
removeFirst
mid
removeFirst
removeFirst
getFirst
quit
```

## Sample Output

```
10
10
30
20
20
40
20
40
List is empty
```