__author__ = 'guinnc'

class DoublyLinkedNode:
    """ A single node in a doubly-linked list.
        Contains 3 instance variables:
            data: The value stored at the node.
            prev: A pointer to the previous node in the linked list.
            next: A pointer to the next node in the linked list.
    """

    def __init__(self, value):
        """
        Initializes a node by setting its data to value and
        prev and next to None.
        """
        self.data = value
        self.prev = None
        self.next = None

class DoublyLinkedList:
    """
    The doubly-linked list class has 3 instance variables:
        head: The first node in the list.
        tail: The last node in the list.
        size: How many nodes are in the list.
    """

    def __init__(self):
        """
        The constructor sets head and tail to None and the size to zero.
        """
        self.head = None
        self.tail = None
        self.size = 0

    #############################################################################
    def isSorted(self):
        x=True
        temp = self.head
        b=self.head
        b=b.next
        while b != None:

            if temp.data<=b.data:
                temp = temp.next
                b=b.next

            else:
                x=False
                return x
        return x
        ''' You will want to modify this method so that it actually works.
        '''



    #############################################################################

    def addFront(self, value):
        """
        Creates a new node (with data = value) and puts it in the
        front of the list.
        """
        newNode = DoublyLinkedNode(value)
        if (self.size == 0):
            self.head = newNode
            self.tail = newNode
            self.size = 1
        else:
            newNode.next = self.head
            self.head.prev = newNode
            self.head = newNode
            self.size += 1

    def addRear(self, value):
        """
        Creates a new node (with data = value) and puts it in the
        rear of the list.
        """
        newNode = DoublyLinkedNode(value)
        if (self.size == 0):
            self.head = newNode
            self.tail = newNode
            self.size = 1
        else:
            newNode.prev = self.tail
            self.tail.next = newNode
            self.tail = newNode
            self.size += 1

    def removeFront(self):
        """
        Removes the node in the front of the list.
        @return Returns the data in the deleted node.
        """
        value = self.head.data
        self.head = self.head.next
        if self.head != None:
            self.head.prev = None
        else:
            self.tail = None
        self.size -= 1
        return value

    def removeRear(self):
        """
        Removes the node in the rear of the list.
        @return Returns the data in the deleted node.
        """
        value = self.tail.data
        self.tail = self.tail.prev
        if self.tail != None:
            self.tail.next = None
        else:
            self.head = None
        self.size -= 1
        return value

    def printItOut(self):
        """
        Prints out the list from head to tail all on one line.
        """
        temp = self.head
        while temp != None:
            print(temp.data,end=" ")
            temp = temp.next
        print()

    def printInReverse(self):
        """
        Prints out the list from tail to head all on one line.
        """
        temp = self.tail
        while temp != None:
            print(temp.data, end=" ")
            temp = temp.prev
        print()


    def atIndex(self, index):
        """
        Retrieves the data of the item at index.
        @param index The index of the item to retrieve.
        @return Returns the data of the item.
        """
        count = 0
        temp = self.head
        while count < index:
            count += 1
            temp = temp.next
        return temp.data

    def insertAt(self, index, value):
        if index == 0:
            self.addFront(value)
        elif index == self.size - 1:
            self.addRear(value)
        else:
            temp = self.head
            count = 0
            while count < index:
                count += 1
                temp = temp.next
            newNode = DoublyLinkedNode(value)
            temp.prev.next = newNode
            temp.prev = newNode
            newNode.next = temp


    def removeAt(self, index):
        if index == 0:
            return self.removeFront()
        elif index == self.size - 1:
            return self.removeRear()
        else:
            count = 0
            temp = self.head
            while count < index:
                count += 1
                temp = temp.next
            temp.prev.next = temp.next
            temp.next.prev = temp.prev
            return temp.data

list = DoublyLinkedList()
list.addRear(1)
list.addRear(2)
list.addRear(30)
list.addRear(200)
list.addRear(500)
list.printItOut()
print(list.isSorted()) # this should print True
list2 = DoublyLinkedList()
list2.addRear(1)
list2.addRear(200)
list2.addRear(30)
list2.addRear(200)
list2.addRear(500)
list2.printItOut()
print(list2.isSorted()) # this should print False


