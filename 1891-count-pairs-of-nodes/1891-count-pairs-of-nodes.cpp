#include <iostream>
#include <sstream>
using namespace std;

class Solution{
public:
    using pii = pair<int, int>;

    vector<int> countPairs(int n, vector<vector<int>>& edges, vector<int>& queries) {
        vector<int> degree(n + 1, 0);
        map<pii, int> overlap;

        // Count degrees and overlaps
        for (auto& e : edges) {
            int u = e[0], v = e[1];
            degree[u]++;
            degree[v]++;
            if (u > v) swap(u, v);
            overlap[{min(u, v), max(u, v)}]++;
        }

        vector<int> sorted_deg = degree;
        sort(sorted_deg.begin() + 1, sorted_deg.end()); // exclude 0th index

        vector<int> res;
        for (int q : queries) {
            int total = 0;
            int left = 1, right = n;

            // Two-pointer to count pairs with deg[u] + deg[v] > q
            while (left < right) {
                if (sorted_deg[left] + sorted_deg[right] <= q) {
                    left++;
                } else {
                    total += (right - left);
                    right--;
                }
            }

            // Subtract overcounted pairs
            for (auto& [key, count] : overlap) {
                int u = key.first;
                int v = key.second;
                if (degree[u] + degree[v] > q && degree[u] + degree[v] - count <= q) {
                    total--;
                }
            }

            res.push_back(total);
        }

        return res;
    }
};