#include "bits/stdc++.h"

using namespace std;

string str;

bool sol() {
    bool check[28] = {false,};

    char prev = str[0];
    check[prev - 'a'] = true;

    for (int i = 1; i < str.length(); ++i) {
        if (prev != str[i]) {
            if (check[str[i] - 'a']) {
                return false;
            }
            check[str[i] - 'a'] = true;
            prev = str[i];
        }
    }

    return true;
}

int main() {
#ifdef LOCAL
    auto fi = freopen("input.txt", "r", stdin);
#endif
    cin.tie(nullptr);
    ios::sync_with_stdio(false);

    int T;
    cin >> T;
    int res = 0;

    while (T--) {
        cin >> str;
        res += sol();
    }

    cout << res;

    return 0;
}
