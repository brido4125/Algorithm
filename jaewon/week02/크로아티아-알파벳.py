def sol(input):
    input = input.replace("c=", "1")
    input = input.replace("c-", "2")
    input = input.replace("dz=", "3")
    input = input.replace("d-", "4")
    input = input.replace("lj", "5")
    input = input.replace("nj", "6")
    input = input.replace("s=", "7")
    input = input.replace("z=", "8")

    return len(input)

input = str(input())
print(sol(input))
