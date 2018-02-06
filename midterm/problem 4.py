def evenCnt(alist, cnt):
    if len(alist)==0:

        return cnt

    if (alist[0]%2==0):
        cnt=cnt+1
        return (evenCnt(alist[1:], cnt))
    else:
        return(evenCnt(alist[1:], cnt))

a=[1,2,3,4,5,6,7,8,9,10,11,12]
cnt=0
cnt=evenCnt(a,cnt)

print("Number of evens are " , cnt,end=" ")





