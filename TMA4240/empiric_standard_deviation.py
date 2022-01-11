import numpy as np

def S(x_list):
    average = (1/len(list))*np.sum(x_list)
    print(average)

    s = 0

    for i in range(len(list)):
        s += (average - x_list[i])**2
    
    s = s*1/(len(x_list)-1)

    print(s)


list = [64.48, 66.94, 64.62, 65.8, 64.86]

S(list)