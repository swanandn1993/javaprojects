__author__ = 'guinnc'

from stack import *

def isNumber(n):
    ''' Returns true if n is a valid number, either integer or float.
        False otherwise.
    '''
    try:
        x = float(n)
        return True
    except:
        return False



def postfix2infix(postfix):
    ''' You will want to change this one.
    '''
    return ''


post = input("Enter a valid postfix expression: ")
infix = postfix2infix(post)
print("Here is that expression in infix:")
print(infix)
