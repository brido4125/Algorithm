#include <bits/stdc++.h>

using namespace std;

int graph[202][202];

vector<int> dij(int n, int start) {
    vector<int> dist;
    dist.resize(n + 1);
    for (int i = 1; i <= n; ++i) {
        dist[i] = INT_MAX;
    }
    dist[start] = 0;
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
    pq.emplace(0, start); // 거리, 노드 번호

    while (!pq.empty()) {
        int di = pq.top().first;
        int node = pq.top().second;
        pq.pop();
        for (int i = 1; i <= n; ++i) {
            if (graph[node][i] == INT_MAX) continue;
            if (dist[i] > di + graph[node][i]) {
                dist[i] = di + graph[node][i];
                pq.emplace(dist[i], i);
            }
        }
    }
    return dist;
}

int solution(int n, int s, int a, int b, vector<vector<int>> fares) {
    for (const auto& fare : fares) {
        int c = fare[0], d = fare[1], f = fare[2];
        graph[c][d] = f;
        graph[d][c] = f;
    }
    for (int i = 1; i <= n; ++i) {
        for (int k = 1; k <= n; ++k) {
            if (graph[i][k] == 0)
                graph[i][k] = INT_MAX;
        }
        graph[i][i] = 0; // 자기자신은 바로 감
    }
    auto sDist = dij(n, s);
    auto aDist = dij(n, a);
    auto bDist = dij(n, b);

    int result = INT_MAX;
    for (int i = 1; i <= n; ++i) {
        result = min(result, sDist[i] + aDist[i] + bDist[i]);
    }
    return result;
}
