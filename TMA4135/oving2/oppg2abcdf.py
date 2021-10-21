from sympy.abc import X
from sympy import integrate
from math import sqrt
from fractions import Fraction
from sympy.solvers import solve
import numpy as np

#2a

a, b = -2, 1

def scp(p, q):
    return integrate(p*q, (X, a, b))

def norm(p):
    return sqrt(integrate(p**2, (X, a, b)))

phis = [1, X, X**2, X**3]
ps = []

for phi in phis:
    if (phi != 1):
        value = phi
        for j in range(phis.index(phi)):
            value -= Fraction(str((scp(phi, ps[j]))/((norm(ps[j]))**2)))*ps[j]
        ps.append(value)
    else:
        ps.append(1)

for p in ps:
    print('p_' + str(ps.index(p)) + ': ' + str(p))

print()

#2b

for p in ps:
    for q in ps:
        print(f"scp_p_q = {scp(p, q)}")

print()

#2c

print(ps[-1])
xqs = solve(ps[-1])
print(xqs)

print()

#2d

L_0 = (X-xqs[2])*(X-xqs[1])
L_0 /= L_0.subs(X, xqs[0])

L_1 = (X-xqs[2])*(X-xqs[0])
L_1 /= L_1.subs(X, xqs[1])

L_2 = (X-xqs[1])*(X-xqs[0])
L_2 /= L_2.subs(X, xqs[2])

Ls = [L_0, L_1, L_2] #Lagrange polynomials
print(Ls)

ws = [integrate(L, (X, a, b)) for L in Ls] #weights 
print(ws) 
print()

#2f

def QR(f, xq, wq):
    """ Computes an approximation of the integral f
    for a given quadrature rule.
    
    Input:
        f:  integrand
        xq: quadrature nodes
        wq: quadrature weights
    """
    n = len(xq)
    if (n != len(wq)):
        raise RuntimeError("Error: Need same number of quadrature nodes and weights!")
    return np.array(wq)@f(np.array(xq))

def f(x): #integrand, 3rd degree orthogonal polynomial 
    return x**3+(3/2)*x**2+(3/5)*x-(11/20)

print(QR(f, xqs, ws)) #Degree exactness of 5 




