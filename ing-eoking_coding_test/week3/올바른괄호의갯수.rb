def solution(n)
    answer = 0
    dp = Array.new(15, 0)
    dp[0] = dp[1] = 1
    n > 1 and for i in 2..n
        for j in 0..i-1
            dp[i] += dp[j] * dp[i - j - 1]
        end
    end
    return dp[n]
end
