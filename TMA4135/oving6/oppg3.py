import matplotlib.pyplot as plt
import numpy as np

#define RHS
def SIR(t, y):
    #recommended parameters 
    beta, gamma = 0.2, 0.15

    #define RHS of ODE
    dy =  np.array([-1*beta*y[0]*y[1], 
    beta*y[0]*y[1] - gamma*y[1], 
    gamma*y[1]])

    return dy

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


t_0, T = 0, 20
N_max = 1000

y_0 = np.array([50**T, 10**T, 0])

ts, ys_ssprk3 = ssprk3(y_0, t_0, T, SIR, N_max)
plt.plot(ts, ys_ssprk3)

plt.show()



