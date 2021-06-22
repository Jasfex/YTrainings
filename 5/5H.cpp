#include <iostream>
#include <fstream>
#include <algorithm>

int main()
{
    std::ifstream cin("input.txt");

    char* s;

    int n, k;
    cin >> n >> k;
    
    s = new char[n];

    char c;
    for (int i = 0; i < n; ++i) {
        cin >> c;
        s[i] = c;
    }

    auto counter = new int[n+1][26];
    for (int i = 0; i < 26; ++i) {
        counter[0][i] = 0;
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < 26; j++) {
            counter[i][j] = counter[i - 1][j];
        }
        counter[i][s[i - 1] - 'a'] = counter[i][s[i - 1] - 'a'] + 1;
    }

    int saved_right = 0;

    int bestLen = 0;
    int bestStart = 0;

    for (int left = 0; left < n; left++) {
        int a = std::max(left + 1, saved_right);
        int b = n;
        while (a < b) {
            int m = (a + b + 1) / 2;

            bool flag = true;
            for (int z = 0; z <26;z++) {
                if (counter[m][z] - counter[left][z] > k) {
                    flag = false;
                }
            }

            if (flag) {
                a = m;
            }
            else {
                b = m - 1;
            }
        }
        bool flag = true;
        for (int z = 0; z < 26; z++) {
            if (counter[a][z] - counter[left][z] > k) {
                flag = false;
            }
        }
        if (flag) {
            saved_right = a;
            if (bestLen < a - left) {
                bestLen = a - left;
                bestStart = left + 1;
            }
        }
    }

    std::cout << bestLen << ' ' << bestStart << std::endl;

    return 0;
}
