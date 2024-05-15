N = io.read("n", "l")
cookie = {}
heart = {-1, -1}
for i = 1, N do
    cookie[i] = io.read("*line")
    for j = 1, N do
        if (heart[1] < 0 and cookie[i]:sub(j,j) == '*') then
            heart = {i + 1, j}
        end
    end
end
print(heart[1].." "..heart[2])
part = {0,0,0,0,0}
while (cookie[heart[1]]:sub(heart[2] - part[1] - 1, heart[2] - part[1] - 1) == '*') do
    part[1] = part[1] + 1
end
while (cookie[heart[1]]:sub(heart[2] + part[2] + 1, heart[2] + part[2] + 1) == '*') do
    part[2] = part[2] + 1
end
while (cookie[heart[1] + part[3] + 1]:sub(heart[2], heart[2]) == '*') do
    part[3] = part[3] + 1
end
while (heart[1] + part[3] + part[4] + 1 <= N and
       cookie[heart[1] + part[3] + part[4] + 1]:sub(heart[2] - 1, heart[2] - 1) == '*') do
    part[4] = part[4] + 1
end
while (heart[1] + part[3] + part[5] + 1 <= N and
       cookie[heart[1] + part[3] + part[5] + 1]:sub(heart[2] + 1, heart[2] + 1) == '*') do
    part[5] = part[5] + 1
end
print(part[1].." "..part[2].." "..part[3].." "..part[4].." "..part[5])
