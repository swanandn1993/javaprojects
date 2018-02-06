from Book import *

inputfile = open("books.txt", "r")
books = []
lib = []
running_total = 0
count=0
for line in inputfile:
    if(count%4==0):
        title=line
    if(count%4==1):
        author=line
    if(count%4==2):
        year=line
    if(count%4==3):
        price=line
        lib.append(Book(title,author,year,price))
    count=count+1

for line in open("books.txt", "r"):
    element = line.split()
    books.append(element)
    running_total += 1

expBook = lib[0]
oldBook = lib[0]
for x in lib:
    if (float(expBook.price)) < (float(x.price)):
        expBook = x
    if float(oldBook.year) < float(x.year):
        oldBook = x
print("Expensive book is "+ str(expBook))
print("Oldest book is " + str(oldBook))
