import numpy as np

mu = 0.012277471
earth = np.array([-mu, 0])
moon = np.array([1-mu, 0])

def f(t, y):
    return 