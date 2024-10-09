#include<stdio.h>
#include<stdlib.h>
int mutex=1;
int full=0;
int empty=10;int x=0;

void producer()
{
	--mutex;
	++full;
	--empty;
	x++;
	printf("\n Producer produces the item %d",x);
	++mutex;
}
 
void consumer()
{
	--mutex;
	--full;
	++empty;	
	printf("\nConsumer consumes item %d",x);
	x--;
	++mutex;
}
 int main()
{
 int n,i;
printf("\n 1.press for producer""\n2.press two for consumer""\n3.press three for exit");

for(i=1;i>0;i++)
{
printf("\n Enter the choice");
scanf("%d",&n);
switch(n)
	{
case 1:
	if((mutex==1)&&(empty!=0))	
	producer();
	else
		printf("\nBuffer is full");
	break;
case 2:
	if((mutex==1)&&(full!=0)){
	consumer();}
	else
		printf("Buffer is empty");
	break;
case 3:
	exit(0);
	break;
	}
}

}
