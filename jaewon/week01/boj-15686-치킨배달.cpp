#include "bits/stdc++.h"

using namespace std;

int N, K;

typedef struct {
    int x;
    int y;
} Point;

vector<Point> homes;
vector<Point> chickens;

int select[14];

int calc() {
    int sum = 0;
    for (const auto &home: homes) {
        int min1 = INT_MAX;
        for (int k = 0; k < K; ++k) {
            int dist = abs(chickens[select[k]].x - home.x) + abs(chickens[select[k]].y - home.y);
            min1 = min(min1, dist);
        }
        sum += min1;
    }
    return sum;
}

int minResult = INT_MAX;

void sol(int idx, int start) {
    if (idx == K) {
        int value = calc();
        minResult = min(minResult, value);
        return;
    }

    for (int i = start; i < chickens.size(); ++i) {
        select[idx] = i;
        sol(idx + 1, i + 1);
    }
}

int main() {
#ifdef LOCAL
    auto fi = freopen("input.txt", "r", stdin);
#endif
    cin.tie(nullptr);
    ios::sync_with_stdio(false);

    cin >> N >> K;

    for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= N; ++j) {
            int num;
            cin >> num;

            if (num == 1) homes.push_back({i, j});
            if (num == 2) chickens.push_back({i, j});
        }
    }

    sol(0, 0);

    cout << minResult;

    return 0;
}
