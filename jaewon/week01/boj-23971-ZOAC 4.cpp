#include "bits/stdc++.h"

using namespace std;
#define FAST ios::sync_with_stdio(false); cin.tie(NULL)

int main() {
#ifdef LOCAL
    auto fi = freopen("input.txt", "r", stdin);
#endif
    FAST;
    int N, K, n, k;
    cin >> N >> K >> n >> k;
    int cntN = 0, cntK = 0;
    for (int i = 0; i < N; i += n + 1) {
        ++cntN;
    }
    for (int j = 0; j < K; j += k + 1) {
        ++cntK;
    }

    cout << cntK * cntN;

    return 0;
}
