import numpy as np

mu = 0.012277471
earth = np.array([-mu, 0])
moon = np.array([1-mu, 0])

def f(t, y):

    # y = (xi, eta, xi_prime, eta_prime)
    xi, eta, xi_prime, eta_prime = y


    # the distances can be computed using linalg in numpy
    d1 = np.linalg.norm(y[0:2] - earth, 2)

    d2 = np.linalg.norm()
    return 