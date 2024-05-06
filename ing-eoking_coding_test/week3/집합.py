import sys

M = int(sys.stdin.readline())
s = [0] * 21
while M > 0:
    M = M - 1
    cmd = sys.stdin.readline().strip().split()
    
    if   cmd[0][1] == 'h': print(s[int(cmd[1])])
    elif cmd[0][1] == 'o': s[int(cmd[1])] ^= 1
    elif cmd[0][1] == 'l': s = [1] * 21
    elif cmd[0][1] == 'd': s[int(cmd[1])] = 1
        
    elif cmd[0][1] == 'm': s = [0] * 21
    elif cmd[0][1] == 'e': s[int(cmd[1])] = 0
