#include <memory.h>

#include <algorithm>
#include <climits>
#include <cmath>
#include <cstdlib>
#include <iostream>
#include <map>
#include <stack>
#include <queue>
#include <string>
#include <utility>
#include <vector>

using namespace std;


string str;

bool isV(char ch) {
    switch (ch) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
            return true;
    }
    return false;
}

bool sol() {
    char prev = str[0];
    bool isPrevV = isV(prev);
    int cnt = 0;
    bool includeV = isPrevV;

    for (int i = 1; i < str.length(); ++i) {

        if (prev == str[i]) {
            if ((prev == 'e' && str[i] == 'e') || (prev == 'o' && str[i] == 'o')) {
                cnt++;
                prev = str[i];
                isPrevV = isV(prev);
                continue;
            } else {
                return false;
            }
        }

        if (isV(str[i]) && isPrevV) {
            cnt++;
        }
        else if (!isV(str[i]) && !isPrevV) {
            cnt++;
        } else {
            cnt = 0;
        }

        if (cnt >= 2) return false;
        prev = str[i];
        isPrevV = isV(prev);
        includeV |= isPrevV;
    }

    if (cnt >= 2) return false;
    if (includeV == false) return false;

    return true;
}

void print(bool good) {
    cout << '<' << str << "> is ";
    if (!good) cout << "not ";
    cout << "acceptable.\n";
}


int main() {
#ifdef LOCAL
    auto fi = freopen("input.txt", "r", stdin);
#endif
    cin.tie(0);
    ios::sync_with_stdio(false);

    cin >> str;

    while (str != "end") {
        print(sol());
        cin >> str;
    }

    return 0;
}
