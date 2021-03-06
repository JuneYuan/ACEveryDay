/* ***********************************************
Author        :guanjun
Created Time  :2016/7/24 16:25:35
File Name     :cf362d.cpp
************************************************ */
#include <iostream>
#include <cstring>
#include <cstdlib>
#include <stdio.h>
#include <algorithm>
#include <vector>
#include <queue>
#include <set>
#include <map>
#include <string>
#include <math.h>
#include <stdlib.h>
#include <iomanip>
#include <list>
#include <deque>
#include <stack>
#define ull unsigned long long
#define ll long long
#define mod 90001
#define INF 0x3f3f3f3f
#define maxn 100010
#define cle(a) memset(a,0,sizeof(a))
const ull inf = 1LL << 61;
const double eps=1e-5;
using namespace std;
priority_queue<int,vector<int>,greater<int> >pq;
struct Node{
	int x,y;
};
struct cmp{
    bool operator()(Node a,Node b){
        if(a.x==b.x) return a.y> b.y;
        return a.x>b.x;
	}
};

bool cmp(int a,int b){
    return a>b;
}
vector<int>v[maxn];
int sz[maxn];
double ans[maxn];
int main()
{
    #ifndef ONLINE_JUDGE
    freopen("in.txt","r",stdin);
    #endif
    //freopen("out.txt","w",stdout);
    int n,x;
	while(cin>>n){
		for(int i=2;i<=n;i++){
			scanf("%d",&x);
			v[x].push_back(i);
		}
		for(int i=n;i>=1;i--){
			sz[i]=1;
			for(int j=0;j<v[i].size();j++){
				int to=v[i][j];
				sz[i]+=sz[to];
			}
		}
		//cout<<sz[1]<<endl;
		int i=1;i<=n;i+
		ans[1]=1.0;
		for(int i=1;i<=n;i++){
			for(int j=0;j<v[i].size();j++){
				int to=v[i][j];
				ans[to]=ans[i]+1+(sz[i]-1-sz[to])*0.5;
			}
		}
		for(int i=1;i<=n;i++){
			printf("%.7f ",ans[i]);
		}
	}
    return 0;
}
