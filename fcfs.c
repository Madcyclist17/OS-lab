#include<stdio.h>
int main(){

int AT[10],BT[10],TAT[10],WT[10],n;
float avg_tat,avg_wt,total=0,burst=0;
printf("enter the numebr of processes- ");
scanf("%d",&n);

for(int i=0;i<n;i++)
{
	printf("enter the arrival time and burst time of process no %d :\n",i);
	scanf("%d%d",&AT[i],&BT[i]);
}


for(int i=0;i<n;i++)
{
	if(i==0)
	WT[i]=AT[i];

	else
	WT[i]=burst-AT[i];

burst+=BT[i];
total+=WT[i];
printf("%d\n",WT[i]);
}
avg_wt=total/n;
printf("average wt:%f\n",avg_wt);

float CT=0;
total=0;

for(int i=0;i<n;i++)
{
	CT+=BT[i];
	TAT[i]=CT-AT[i];
	total+=TAT[i];
printf("%d\n",TAT[i]);
}

avg_tat=total/n;

printf("average tat :%f\n",avg_tat);

printf("AT\tBT\tTAT\tWT\n");
for(int i=0;i<n;i++)
{	
printf("%d \t %d \t %d \t %d \n",AT[i],BT[i],TAT[i],WT[i]);
}


}
