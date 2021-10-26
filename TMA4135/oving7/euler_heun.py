import numpy as np
from numpy import pi
from numpy.linalg import solve, norm
import matplotlib.pyplot as plt

import pandas as pd

# Use a funny plotting style
plt.xkcd()
newparams = {'figure.figsize': (6.0, 6.0), 'axes.grid': True,
'lines.markersize': 8, 'lines.linewidth': 2,
'font.size': 14}
plt.rcParams.update(newparams)


def euler_heun(y0, t0, T, f, Nmax, tol):
    ts = [t0]
    ys = [y0]
    dt = (T-t0)/Nmax
    # Order for the low order method
    p = 1
    
    # Number of all steps
    N = 0
    
    # Number of rejected steps
    N_rej = 0
    
    while (ts[-1] < T and N < Nmax):
        N += 1
        t, y  = ts[-1], ys[-1]
        k1 = f(t,y)
        k2 = f(t+dt,y+dt*k1)
        
        lerr = norm(dt*0.5*(k1-k2))
        
        if lerr < tol:
            ys.append(y + dt*0.5*(k1+k2))
            ts.append(t + dt)
        else:
            N_rej += 1
        
        dt = min((tol/lerr)**(1/(p+1))*dt, np.abs(T-ts[-1]))
    
    print(f"Completed simulation at t = {ts[-1]} with final T = {T} with {N_rej} rejected steps.")
    return np.array(ts), np.array(ys)

def f(t, y):
    return -2*y*t

def y_ex(t):
    return np.exp(-1*t**2)

N_max = 100
tol = 1e-2
t_0, T = 0, 2
y_0 = 1

ts, ys = euler_heun(y_0, t_0, T, f, N_max, tol)
ys_ex = y_ex(ts)

plt.plot(ts, ys)
plt.plot(ts, ys_ex)

plt.show()