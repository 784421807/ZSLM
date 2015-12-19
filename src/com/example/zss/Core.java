package com.example.zss;

public class Core {
	int a;
	int b;
	int c;
	int d;
	public Core(int a,int b,int c,int d)
	{
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
	}
	public float calc()
	{
		if(c==0)
		{
			return a+b;
		}
		else if(c==1)
		{
			return a-b;
		}
		else if(c==2)
		{
			return a*b;
		}
		else if(c==3)
		{
			if(b==0)
			{
				b++;
			}
			return (float)Math.round(((float)a/b)*100)/100;
		}
		else
		{
			return jiecheng(d);
		}
	}
	public String toString()
	{
		String A=new String();
		String B=new String();
		if(a<0)
		{
			A="("+a+")";
		}
		else
		{
			A=a+"";
		}
		if(b<0)
		{
			B="("+b+")";
		}
		else
		{
			B=b+"";
		}
		if(c==0)
		{
			return A+"+"+B;
		}
		else if(c==1)
		{
			return A+"-"+B;
		}
		else if(c==2)
		{
			return A+"*"+B;
		}
		else if(c==3)
		{
			return A+"/"+B;
		}
		else
		{
			return d+"!";
		}
	}

	public float jiecheng(int x)
	{
		if(x==0 || x==1)
		{
			return 1;
		}
		else
		{
			return x*jiecheng(x-1);
		}
	}
}