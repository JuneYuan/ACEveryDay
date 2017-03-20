#include <cstdio>
#include <iostream>
#include <cstdlib>
#include <cstring>
#include <queue>
#include <stack>
#include <string>
#include <algorithm>
#include <vector>
#include <map>
#include <functional>

using namespace std;
typedef long long ll;
const int maxn = 2e6 + 9;
const ll inf = 1e9 + 9;

int main()
{
	//std::ios::sync_with_stdio(false);
	int t;
	scanf("%d", &t);
	while (t--)
	{
		int n;
		scanf("%d", &n);
		double ans = 0;
		for (int i = 0; i < n; i++)
		{
			double x;
			scanf("%lf", &x);
			ans = max(ans*1.0, x*1.0);
		}
		printf("%.2lf\n", ans);
	}
	return 0;

}
