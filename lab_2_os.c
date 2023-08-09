#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define max 20
 
int main()
{
    int i,j=0,n,T=0,k,p[max],w[max],b[max],a[max],io[max],io1[max],t[max],t1[max],min,f=0;
    float wt=0,tt=0;
    char pn[max][max];
    FILE *fp;
    fp=fopen("f1.txt","r");
    fscanf(fp,"%d",&n);
 
    for(i=0;i<n;i++)
    {
        fscanf(fp,"%s%d%d%d%d",pn[i],&p[i],&b[i],&io[i],&io1[i]);
        a[i]=p[i];
        t[i]=b[i];
        t1[i]=b[i]+io[i]+io1[i];
    }
    while(j<n)
    {
        min=99;
        k=-1;
        for(i=0;i<n;i++)
        {
            if(p[i]<=T && b[i]<min && b[i]>0)
            {
                min=b[i];
                k=i;
            }
        }
        if(k==-1)
        {
            printf("idle for %d units\n",T);
            T++;
        }
        else
        {
            b[k]--;
            T++;
            if(b[k]==0)
            {
                j++;
                printf("%s finished at %d\n",pn[k],T);
                wt+=T-a[k]-t[k];
                tt+=T-a[k];
            }
        }
    }
    printf("Average waiting time is %f\n",wt/n);
    printf("Average turnaround time is %f\n",tt/n);
 
    return 0;
}