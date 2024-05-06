#include "bits/stdc++.h"

using namespace std;

int n;

class Info {
public:
    int we;
    int he;
    int rank = 1;
    bool operator<(const Info& other) {
        return we < other.we && he < other.he;
    }
    bool operator>(const Info& other) {
        return we > other.we && he > other.he;
    }
};

Info info[50];

int main() {
#ifdef LOCAL
    auto fi = freopen("input.txt", "r", stdin);
#endif
    cin.tie(0);
    ios::sync_with_stdio(false);

    cin >> n;

    for (int i = 0; i < n; ++i) {
        cin >> info[i].we >> info[i].he;
    }

    for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
            if (info[i] < info[j]) {
                info[i].rank++;
            } else if (info[i] > info[j]) {
                info[j].rank++;
            }
        }
    }

    for (int i = 0; i < n; ++i) {
        cout << info[i].rank << ' ';
    }

    return 0;
}
