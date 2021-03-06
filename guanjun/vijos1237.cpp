/* ***********************************************
Author        :guanjun
Created Time  :2016/7/18 10:24:40
File Name     :vijos1237.cpp
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
#define maxn 30010
#define cle(a) memset(a,0,sizeof(a))
const ull inf = 1LL << 61;
const double eps=0.6180339887498949;
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
double a[maxn];

int main()
{
//	printf("%.10lf\n",2.0/eps-3.0);
//	printf("%.10lf\n",3.0/eps-5.0);
    #ifndef ONLINE_JUDGE
    //freopen("in.txt","r",stdin);
    #endif
    //freopen("out.txt","w",stdout);
    int n;
	while(cin>>n){
		for(int i=1;i<=n;i++)scanf("%lf",&a[i]);
		sort(a+1,a+n+1);
		double ans=1000000;
		ll ans1,ans2;
		for(int i=1;i<n;i++){
			int to=ceil(a[i]*1.0/eps+0.5);
			//cout<<"to "<<to<<endl;
			int x=lower_bound(a+i+1,a+n+1,to)-a-1;
			//cout<<"x "<<x<<endl;
			double tmp=fabs((double)a[i]/(double)a[x]-eps);
			if(tmp<ans){
				ans=tmp;
				ans1=a[i];
				ans2=a[x];
			}
		}
		//cout<<a[0]<<" "<<a[1]<<endl;
		cout<<ans1<<endl<<ans2<<endl;
	}
    return 0;
}
