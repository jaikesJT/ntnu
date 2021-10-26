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

#2a

class EmbeddedExplicitRungeKutta:
    def __init__(self, a, b, c, bhat, order):
        self.a = a 
        self.b = b
        self.c = c
        self.bhat = bhat
        self.order = order
    
    def __call__(self, y_0, t_0, T, f, Nmax, tol):
        #Extract butcher table
        a, b, c, bhat, order = self.a, self.b, self.c, self.bhat, self.order

        #Stages 
        s = len(b)
        ks = [np.zeros_like(y_0, dtype=np.double) for s in range(s)]

        #Start time-stepping
        ys = [y_0]
        ts = [t_0]

        #Initial time step
        dt = (T - t_0)/Nmax

        #Counting steps to avoid infinite loop 
        N = 0 
        N_rej = 0

        while (ts[-1] < T and N < Nmax):
            t, y = ts[-1], ys[-1]
            N += 1

            #Compute stages derivatives k_j   
            for j in range(s):
                t_j = t + c[j]*dt
                dY_j = np.zeros_like(y, dtype=np.double)
                for l in range(j):
                    dY_j += a[j][l]*ks[l]
                
                ks[j] = f(t_j, y + dt*dY_j)

            #Compute next time-step
            dy = np.zeros_like(y, dtype=np.double)
            for j in range(s):
                dy += b[j]*ks[j]
            
            if bhat is None:
                ys.append(y + dt*dy)
                ts.append(t + dt)

            else:
                #Computing dyhat
                dyhat = np.zeros_like(y, dtype=np.double)
                for j in range(s):
                    dyhat += bhat[j]*ks[j]

                #Computing Error estimate 
                err = np.zeros_like(y, dtype=np.double)
                for j in range(s):
                    err += np.linalg.norm(dt*(bhat[j]-b[j])*ks[j])

                if err <= tol:
                    ys.append(y + dt*dyhat)
                    ts.append(t + dt)
                else:
                    print(f"Step is rejected at t = {t} with err = {err}")
                    N_rej += 1

                dt = 0.8*((tol/err)**(1/(order+1)))*dt
        
        print(f"Finishing time-stepping reaching t = {ts[-1]} with final time T = {T}")
        print(f"Used {N} steps out of {Nmax} with {N_rej} being rejected")           
        
        return (np.array(ts), np.array(ys))


#2b

#constant values
N_max = 100
tol = 1e-3
t_0, T = 0, 1
y_0 = 1
lam = 1

#RHS and exact solutions to both examples 
f_1 = lambda t,y: lam*y
y_ex_1 = lambda t: y_0*np.exp(lam*(t-t_0))

f_2 = lambda t,y: -2*t*y
y_ex_2 = lambda t : np.exp(-1*t**2)


#euler-heun
a_eh = np.array([[0, 0], 
                [1, 0]])
b_eh = np.array([0.5, 0.5])
c_eh = np.array([0, 1])
bhat_eh = np.array([1, 0])
order_eh = 2

eulerHeun = EmbeddedExplicitRungeKutta(a_eh, b_eh, c_eh, bhat_eh, order_eh)

ts_eh_1, ys_eh_1 = eulerHeun(y_0, t_0, T, f_1, N_max, tol)
ys_ex_1 = y_ex_1(ts_eh_1)


plt.plot(ts_eh_1, ys_eh_1)
plt.plot(ts_eh_1, ys_ex_1)

plt.show()


#fehlberg
a_f = np.array([[0, 0, 0], 
                [0.5, 0, 0], 
                [1/256, 255/256, 0]])
b_f = np.array([1/512, 255/256, 1/512])
c_f = np.array([0, 0.5, 1])
bhat_f = np.array([1/256, 255/256, 0])
order_f = 2

fehlberg = EmbeddedExplicitRungeKutta(a_f, b_f, c_f, bhat_f, order_f)
ts_f_1, ys_f_1 = fehlberg(y_0, t_0, T, f_1, N_max, tol)
ys_ex_1 = y_ex_1(ts_f_1)

plt.plot(ts_f_1, ys_f_1)
plt.plot(ts_f_1, ys_ex_1)

plt.show()


eulerHeun(y_0, t_0, T, f_2, N_max, tol)
fehlberg(y_0, t_0, T, f_2, N_max, tol)






