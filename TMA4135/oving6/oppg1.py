def convergence_order_RK(stage, a_list, b_list, c_list):
    if not (stage == len(a_list) and stage == len(b_list) and stage == len(c_list)):
        return 0
    s1 = sum(b_list)
    if s1 == 1:
        s2 = 0
        for i in range(stage):
            s2 += b_list[i]*c_list[i]
        if s2 == 0.5:
            s3_1 = 0
            s3_2 = 0
            for i in range(stage):
                s3_1 += b_list[i]*(c_list[i]**2)
                for j in range(stage):
                    
                    s3_2 += b_list[i]

        return 1
    return 0

#midpoint rule 
a_mid = [[0, 0], [0.5, 0]]
b_mid = [0, 1]
c_mid = [0, 0.5]

print('The convergence order of the midpoint rule is ' + str(convergence_order_RK(2, a_mid, b_mid, c_mid)))

#SSPRK3
a_ssprk3 = []
b_ssprk3 = []
c_ssprk3 = []
