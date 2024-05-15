#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

#define WALL(a) (a < 0 || a >= N)

int N;
vector<vector<int>> m;

int dx[4] = { 0, 1, 0, -1 };
int dy[4] = { 1, 0, -1, 0 };

void eraseTail(pair<int, int> cur) {
	m[cur.first][cur.second]--;
	if (m[cur.first][cur.second] > 0) {
		for (int i = 0; i < 4; i++) {
			int x = cur.first + dx[i];
			int y = cur.second + dy[i];
			if (!WALL(x) && !WALL(y) && m[cur.first][cur.second] == m[x][y]) {
				eraseTail({ x, y });
			}
		}
	}
}

bool moveHead(pair<int, int> &head, int d) {
	int apple = 0;
	int cur = m[head.first][head.second];
	head.first += dx[d];
	head.second += dy[d];
	if (WALL(head.first) || WALL(head.second)) return true;
	if (m[head.first][head.second] > 0) return true;
	else if (m[head.first][head.second] < 0) apple = 1;
	m[head.first][head.second] = cur + 1;
	if (!apple) eraseTail(head);
	return false;
}

int main(int argc, char** argv) {
	int K, L;
	int x, y;
	pair<int, int> head = {0, 0};
	scanf("%d", &N);
	m = vector<vector<int>>(N, vector<int>(N, 0));
	m[0][0] = 1;
	scanf("%d", &K);
	while (K--) {
		scanf("%d %d", &x, &y);
		m[x - 1][y - 1] = -1;
	}
	int t, d = 0;
	char dir;
	queue<pair<int, int>> q;
	scanf("%d", &L);
	while (L--) {
		scanf("%d %c", &t, &dir);
		if (dir == 'L') d = (d + 3) % 4;
		else if (dir == 'D') d = (d + 1) % 4;
		q.push({ t, d });
	}
	t = 0; d = 0;

	while (++t) {
		if (moveHead(head, d)) break;
		if (!q.empty() && t >= q.front().first) {
			d = q.front().second;
			q.pop();
		}
	}
	printf("%d", t);
}
