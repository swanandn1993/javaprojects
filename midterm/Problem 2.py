from stack import *

a = "30 200 85 34 + * +"
tokens=a.split(" ")
b=len(tokens)
c=""
d=""
f=""
numstack = Stack()
print(b)
for l in tokens:
    if l.isnumeric():
        numstack.push(l)
    else:
        d=d+numstack.pop()
        c=c+numstack.pop()
        f=l
        f="("+c+f+d+")"
        numstack.push(f)

print(numstack.pop())