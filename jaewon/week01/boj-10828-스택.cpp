#include "bits/stdc++.h"

using namespace std;

int main() {
    int num;
    cin >> num;

    stack<int> stack;

    while (num--) {
        string input;
        cin >> input;
        if (input == "push") {
            int number;
            cin >> number;
            stack.push(number);
        } else if (input == "pop") {
            if (stack.empty()) {
                cout << -1 << '\n';
                continue;
            }
            cout << stack.top() << '\n';
            stack.pop();
        } else if (input == "size") {
            cout << stack.size() << '\n';
        } else if (input == "empty") {
            cout << stack.empty() << '\n';
        } else if (input == "top") {
            if (stack.empty()) {
                cout << -1 << '\n';
                continue;
            }
            cout << stack.top() << '\n';
        }
    }
    return 0;
}
