__author__ = 'guinnc'
class Book:
    def __init__(self, name, author, year, price):
        self.name=name
        self.author=author
        self.year=year
        self.price=price

    def __str__(self):
        return("name: "+self.name + "author:" + self.author+ "year: " + self.year+ "price" +self.price)


'''
Your Book class will go in this file.
'''
