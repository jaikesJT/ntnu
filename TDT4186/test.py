def fork():
    return False

n = 0 

while fork():
    n += 1
    print(n)

while not fork() and n < 10:
    n += 1
    print(n) 

