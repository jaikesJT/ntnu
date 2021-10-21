from sympy.abc import X
from sympy import integrate
from math import sqrt
from fractions import Fraction
from sympy.solvers import solve

#2e

a, b = -1, 1

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

xqs = solve(ps[-1])
print(xqs) #After changing the interval we can see that the roots of the 3rd degree polynomial matches the 3 quadrature points from the exercise

print()

L_0 = (X-xqs[2])*(X-xqs[1])
L_0 /= L_0.subs(X, xqs[0])

L_1 = (X-xqs[2])*(X-xqs[0])
L_1 /= L_1.subs(X, xqs[1])

L_2 = (X-xqs[1])*(X-xqs[0])
L_2 /= L_2.subs(X, xqs[2])

Ls = [L_0, L_1, L_2] #Lagrange polynomials

ws = [integrate(L, (X, a, b)) for L in Ls] #weights 
print(ws) #After changing interval the weights matches the weights from the exercise (Gauss-Legendre rule)
