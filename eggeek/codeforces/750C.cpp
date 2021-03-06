#include <stdexcept>
#include <iostream>
#include <sstream>
#include <fstream>
#include <cassert>
#include <cstring>
#include <cstdarg>
#include <cstdio>
#include <random>
#include <cmath>
#include <ctime>
#include <functional>
#include <algorithm>
#include <complex>
#include <numeric>
#include <limits>
#include <bitset>
#include <vector>
#include <string>
#include <queue>
#include <deque>
#include <array>
#include <list>
#include <map>
#include <set>
using namespace std;
#define ALL(a) (a).begin(), (a).end()
#define SZ(a) int((a).size())
#define MP(x, y) make_pair((x),(y))
#define FI first
#define SE second
#define LOWB(x) (x & (-x))
#define UNIQUE(a) sort(ALL(a)), (a).erase(unique(ALL(a)), (a).end())
#define HEIGHT(n) (sizeof(int) * 8 - __builtin_clz(n)) //height of range n segment tree
#define INF 1e9
#define INF_LL 4e18
#define rep(i,a,b) for(__typeof(b) i=a; i<(b); ++i)
typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef vector<int> vi;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
/*-----------------------------------*/
int n;

void solve() {
  int totc = 0;
  int gte = -INF;
  int le = INF;
  for (int i=0; i<n; i++) {
    int c, d;
    cin >> c >> d;
    if (d == 1) {
      gte = max(gte, 1900 - totc);
    } else {
      le = min(le, 1899 - totc);
    }
    if (gte > le) {
      printf("Impossible\n");
      return;
    }
    totc += c;
  }
  if (le == INF) {
    printf("Infinity\n");
  } else {
    printf("%d\n", le + totc);
  }
}

int main() {
  cin >> n;
  solve();
  return 0;
}
