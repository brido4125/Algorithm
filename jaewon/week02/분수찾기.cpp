#include "bits/stdc++.h"

using namespace std;
#define FAST cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false)

int main() {
#ifdef LOCAL
    auto fi = freopen("input.txt", "r", stdin);
#endif
    FAST;
    int N;
    cin >> N;

    int sum = 0, i = 0;
    while (sum < N) {
        i++;
        sum += i;
    }

    if (i % 2 == 0) { // 대각선 아래로 내려가는 행
        cout << N - (sum - i) << '/' << 1 - (N - sum);

    } else {
        cout << 1 - (N - sum) << '/' << N - (sum - i);
    }

    return 0;
}
