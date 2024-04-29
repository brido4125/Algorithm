def dfs(info, cur, animal, beast)
    animal[info[cur]] += 1
    animal[0] == animal[1] and return
    $answer = [animal[0], $answer].max
    $edge[cur].any? and $edge[cur].each { |x| beast[info[x]].unshift(x) }
    if beast[0].any? 
        dfs(info, beast[0].shift, animal, beast)
        return
    end
    beast[1].any? and beast[1].each do |x|
        temp = beast.map(&:clone)
        temp[1].delete(x)
        dfs(info, x, animal.map(&:clone), temp)
    end
end

def solution(info, edges)
    $answer = 0
    $edge = Array.new(17) {Array.new}
    animal = Array.new(2, 0)
    beast = Array.new(2) {Array.new}
    for i in edges
        $edge[i[0]].push(i[1])
    end
    dfs(info, 0, animal, beast)
    return $answer
end
