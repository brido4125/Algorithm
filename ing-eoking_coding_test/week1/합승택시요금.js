function solution(n, s, a, b, fares) {
    var answer = Infinity;
    var arr = new Array(n);
    for (var i = 0; i < arr.length; i++) {
        arr[i] = new Array(n).fill(Infinity);
        arr[i][i] = 0;
    }
    fares.forEach(elem => {
        arr[elem[0] - 1][elem[1] - 1] = elem[2];
        arr[elem[1] - 1][elem[0] - 1] = elem[2];
    })
    for (var k = 0; k < n; k++) {
        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                if (arr[i][k] + arr[k][j] < arr[i][j]) {
                    arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
    }
    for (var i = 0; i < n; i++) {
        var dist = arr[s - 1][i] + arr[a - 1][i] + arr[b - 1][i];
        if (dist < answer) answer = dist;
    }
    console.log(dist);

    return answer;
}
