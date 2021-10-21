import numpy as np
import math 
import matplotlib.pyplot as plt

def CSR(f, a, b, m):
    x = np.linspace(a, b, m + 1)
    h = float(b - a)/m

    csr = (h/6)*(2*np.sum(f(x[1:-1])) + 4*np.sum(f((x[1:] + x[:-1])/2)) + f(x[0]) + f(x[-1]))
    return csr

def f(x):
    return np.sqrt(1-x**2)

a, b = 0, 1
int_f = math.pi/4

m = [4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048]

h_list = []
error_list = []

for m_i in range(len(m)):
    csr_f = CSR(f, a, b, m[m_i])
    h = float(b-a)/m[m_i]

    print(f"I[f] = {int_f}")
    print(f"CSR[f, {a}, {b}, {m[m_i]}] = {csr_f}")
    print(f"I[f] - CSR[f] = {abs(int_f - csr_f):.3e}")

    if (m_i < len(m)-1):
        p = (math.log(abs((int_f - CSR(f, a, b, m[m_i+1]))/(int_f-csr_f))))/(math.log((float(b-a)/m[m_i+1])/h))
        c = 10**(math.log(abs(int_f-csr_f)) - p*math.log(h))
        print(f"P = {p}")
        print(f"C = {c}")
    print()

    h_list.append(h) 
    error_list.append(abs(int_f-csr_f)) 


plt.figure()

plt.plot(h_list, error_list)
plt.plot(h_list, error_list, 'o')
plt.xscale("log")
plt.yscale("log")
plt.xlabel("h")
plt.ylabel("e(h)")
plt.title("log-log convergence plot for CSR")
plt.grid(True)

plt.show()




