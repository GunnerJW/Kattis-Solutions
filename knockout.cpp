/*
C++ solution for the problem Knockout Tournament (https://open.kattis.com/problems/knockout)
Execution time: 0.3 s
Submitted on 2019-12-29 16:23:26
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <unordered_map>
#include <queue>
#include <cmath>
#include <algorithm>
#include <iomanip>
#include <functional>

using namespace std;

typedef unsigned long long ull;


int main() {
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    int dale;
    cin >> dale;
    vector<int> ratings;
    for(int i=1;i<n;i++){
        int rating;
        cin >> rating;
        ratings.push_back(rating);
    }
    sort(ratings.begin(), ratings.end(), greater<>());
    ratings.push_back(dale);
    int order = (int)floor(log2(n));
    int diff = n - (int)floor(pow(2u, order));
    vector<unordered_map<int, long double>> x;
    int i = 0;
    while(diff--){
        int player_1 = i;
        int player_2 = i + 1;
        unordered_map<int, long double> dct;
        dct[player_1] = 1.0 * ratings[player_1] / (ratings[player_1] + ratings[player_2]);
        dct[player_2] = 1.0 * ratings[player_2] / (ratings[player_1] + ratings[player_2]);
        x.push_back(dct);
        i += 2;
    }
    while(i < n){
        unordered_map<int, long double> dct;
        dct[i] = 1.0;
        x.push_back(dct);
        i++;
    }
    while(x.size() != 1){
        vector<unordered_map<int, long double>> tmp;
        for(int i = 0;i < x.size(); i+= 2){
            unordered_map<int, long double> games;
            unordered_map<int, long double> players_1 = x[i];
            unordered_map<int, long double> players_2 = x[i + 1];
            for(auto p1: players_1){
                int id_1 = p1.first;
                int rating_1 = ratings[id_1];
                long double proba_1 = p1.second;
                for(auto p2: players_2){
                    int id_2 = p2.first;
                    int rating_2 = ratings[id_2];
                    long double proba_2 = p2.second;
                    long double a = proba_1 * proba_2 * rating_1 / (rating_1 + rating_2);
                    long double b = proba_2 * proba_1 * rating_2 / (rating_1 + rating_2);
                    games[id_1] += a;
                    games[id_2] += b;
                }
            }
            tmp.push_back(games);
        }
        x = tmp;
    }
    cout << setprecision(10) << fixed << x[0][n - 1];
    return 0;
}