#include "bits/stdc++.h"

using namespace std;
#define FAST ios::sync_with_stdio(false); cin.tie(NULL)

int N, K, d, inputR, inputC;
int arr[51][51]; // 0 청소 X, 1, 벽, 2 청소 O

// 북, 동, 남, 서
int dLine[] = {-1, 0, 1, 0};
int dCol[] = {0, 1, 0, -1};
int cleanCnt = 0;

bool isOut(int l, int c) {
    return l < 0 || l >= N || c < 0 || c >= K;
}

void sol(int l, int c) {
    if (arr[l][c] == 0) {
        arr[l][c] = 2;
        cleanCnt++;
    }

    bool nearAllClean = true;
    for (int i = 0; i < 4; ++i) {
        int ll = l + dLine[i];
        int cc = c + dCol[i];

        if (isOut(ll, cc)) continue;
        if (arr[ll][cc] == 0) {
            nearAllClean = false;
            break;
        }
    }
    if (nearAllClean) {
        int ll = l - dLine[d];
        int cc = c - dCol[d];
        if (isOut(ll, cc) || arr[ll][cc] == 1) {
            return;
        }
        sol(ll, cc);
    } else {
        d -= 1; // 반시계
        if (d == -1) d = 3;
        int ll = l + dLine[d];
        int cc = c + dCol[d];
        if (isOut(ll, cc)) return;
        if (arr[ll][cc] == 0) {
            sol(ll, cc);
        } else {
            sol(l, c);
        }
    }

}

int main() {
#ifdef LOCAL
    auto fi = freopen("input.txt", "r", stdin);
#endif
    FAST;

    cin >> N >> K >> inputR >> inputC >> d;

    for (int i = 0; i < N; ++i) {
        for (int k = 0; k < K; ++k) {
            cin >> arr[i][k];
        }
    }

    sol(inputR, inputC);

    cout << cleanCnt;

    return 0;
}
