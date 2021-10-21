import matplotlib.pyplot as plt
import numpy as np

#2a

def explicit_mid_point_rule(y_0, t_0, T, f, N_max):
    #constants from the method's Butcher table 
    a = [[0, 0], [0.5, 0]]
    b = [0, 1]
    c = [0, 0.5]

    ts = [t_0]
    ys = [y_0]
    dt = (T-t_0)/N_max

    while ts[-1] < T:
        t, y = ts[-1], ys[-1]

        k1 = f(t + c[0]*dt, y)
        k2 = f(t + c[1]*dt, y + dt*a[1][0]*k1)

        ts.append(t + dt)
        ys.append(y + dt*(b[0]*k1 + b[1]*k2))

    return np.array(ts), np.array(ys) 

def ssprk3(y_0, t_0, T, f, N_max):
    #constants from the method's Butcher table 
    a = [[0, 0, 0], [1, 0, 0], [0.25, 0.25, 0]]
    b = [(1/6), (1/6), (2/3)]
    c = [0, 1, 0.5]

    ts = [t_0]
    ys = [y_0]
    dt = (T-t_0)/N_max

    while ts[-1] < T:
        t, y = ts[-1], ys[-1]

        k1 = f(t + c[0]*dt, y)
        k2 = f(t + c[1]*dt, y + dt*(a[1][0]*k1))
        k3 = f(t + c[2]*dt, y + dt*(a[2][0]*k1 + a[2][1]*k2))

        ts.append(t + dt)
        ys.append(y + dt*(b[0]*k1 + b[1]*k2 + b[2]*k3))

    return np.array(ts), np.array(ys)

#RHS of ODE
def g(t, y):
    return -1*y

#The exact solution to compare with 
def y_ex_test(t):
    return y_0*np.exp(-1*t)

t_0, t_N = 0, 10
y_0 = 1

for N_max in [4, 8, 16]:
    ts, ys_mid = explicit_mid_point_rule(y_0, t_0, t_N, g, N_max)
    plt.plot(ts, ys_mid)
    
    ts, ys_ssprk3 = ssprk3(y_0, t_0, t_N, g, N_max)
    plt.plot(ts, ys_ssprk3)

    ys_ex = y_ex_test(ts)
    plt.plot(ts, ys_ex)

    plt.show()
    
#2b

taus = []
for m in [0, 1, 2, 3, 4, 5]:
    taus.append(2**(-1*m))

#2c

t_0, t_N = 0, 0.5
y_0 = 1

#RHS of ODE
def f(t, y):
    return -2*t*y

#The exact solution to compare with 
def y_ex(t):
    return y_0*np.exp(-1*t**2)

print("Approxiamtions of y(0.5):")
print()

#First point:

N_max = 3

ts, ys_mid = explicit_mid_point_rule(y_0, t_0, t_N, f, N_max)
print("Approximate of y(0.5) with N_max = 3 and midpoint method is: " + str(ys_mid[-1]))

#Second point 

N_max = 2

ts, ys_ssprk3 = ssprk3(y_0, t_0, t_N, f, N_max)
print("Approximate of y(0.5) with N_max = 2 and ssprk3 method is: " + str(ys_ssprk3[-1]))

print()
#Errors

print("Errors between actual solution and approximations:")
print()
print(f"|y(0.5) - y_mid(0.5)| = {abs(y_ex(ts[-1]) - ys_mid[-1])}")
print(f"|y(0.5) - y_ssprk3(0.5)| = {abs(y_ex(ts[-1]) - ys_ssprk3[-1])}")
print()
print("As expected, ssprk3 is more accurate even with N_max less than N_max of midpoint method")


