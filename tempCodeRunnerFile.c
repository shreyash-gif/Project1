#include<stdio.h>
int main()
{
	int T,N,K,sum=0,sum1=0;
	scanf("%d",&T);
	while(T--)
	{
		scanf("%d%d",&N,&K);
		sum=sum+N;
		sum1=sum1+K;
		if(sum<=sum1)
			printf("YES\n");
		else
			printf("NO\n");
		sum=0;
		sum1=0;
	}
}