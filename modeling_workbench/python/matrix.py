import numpy as np
from scipy.integrate import odeint
import matplotlib.pyplot as plt

# A = np.array([[-11, 0],  [1, 0]])
# B = np.array([32, 0])
#
# x = np.array([0.1, 1])
# u = np.array(1)
#
# print (np.dot(x, A) + np.dot(u, B))

#x'(t) = A*x(t) + B*u(t)
# def rot(x, t, A, B, u):
#     ex, ex_p = x
#     input_signal = u(ex,t)
#     dxdt = [ex_p, (np.dot(ex, A) + np.dot(input_signal, B))[0][0]]
#     return dxdt

def rot(x, t, A, B, u):
    ex, current_input_sig = x
    input_signal = u(ex, t)
    dxdt = (np.dot(A, x) + np.dot(B, input_signal))
    print dxdt
    return dxdt

def u(x, t):
    targeted_speed = 1.0 if t >= 3.0 else 0
    diff_speed = abs(targeted_speed - x)
    #if diff_speed < 0.5 and diff_speed > 0.0:
    #        diff_speed += 0.3
    #input_signal = 0.5 if diff_speed > 0 else 0.0
    input_signal = diff_speed
    #print diff_speed
    return -input_signal if x > targeted_speed else input_signal

A = np.array([[-11, 0],  [1, 0]])
B = np.array([32, 0])
x0 = [0, 0]
t = np.linspace(0, 10, 201)
sol = odeint(rot, y0=x0, t=t, args=(A, B, u))
#sol2 = odeint(speed, xb_0, t, args=(A, B, u))

def desired_speed(t):
    return 1.0 if t >= 3.0 else 0

speed = []
for time in t:
    speed.append(desired_speed(time))

plt.step(t, speed, 'black', label="desired_speed")
plt.plot(t, sol[:, 0], 'b', label='x(t)')
#plt.plot(t, sol2[:, 0], 'r', label='xb(t)')
plt.legend(loc='best')
plt.xlabel('t')
plt.grid()
plt.ylim(-0.1, 2.0)
plt.show()
