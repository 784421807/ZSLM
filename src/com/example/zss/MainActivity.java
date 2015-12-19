package com.example.zss;

import java.util.*;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;
import android.os.Build;

public class MainActivity extends Activity {
	
	private Button b1,b2,b3;
	private LinearLayout l1;
	private Spinner sp1;
	private TextView[]T=new TextView[9];
	private EditText[]E=new EditText[6];
	private MediaPlayer mp;
	int i,k,n;
	long begintime,endtime,time;
	int[]a=new int[5];
	int[]b=new int[5];
	int[]c=new int[5];
	int[]d=new int[5];
	float[]answer=new float[5];
	List<String>list=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp=MediaPlayer.create(this,R.raw.music1);
        mp.setLooping(true);
        mp.start();
        
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        l1=(LinearLayout)findViewById(R.id.container);
        T[0]=(TextView)findViewById(R.id.textView4);
        T[1]=(TextView)findViewById(R.id.textView6);
        T[2]=(TextView)findViewById(R.id.textView9);
        T[3]=(TextView)findViewById(R.id.textView12);
        T[4]=(TextView)findViewById(R.id.textView15);
        T[5]=(TextView)findViewById(R.id.textView18);
        T[6]=(TextView)findViewById(R.id.textView20);
        T[7]=(TextView)findViewById(R.id.textView22);
        T[8]=(TextView)findViewById(R.id.textView24);
        E[0]=(EditText)findViewById(R.id.editText2);
        E[1]=(EditText)findViewById(R.id.editText3);
        E[2]=(EditText)findViewById(R.id.editText4);
        E[3]=(EditText)findViewById(R.id.editText5);
        E[4]=(EditText)findViewById(R.id.editText6);
        E[5]=(EditText)findViewById(R.id.editText1);
        sp1=(Spinner)findViewById(R.id.spinner1);
        list.add("默认");
        list.add("勤劳的宿舍长");
        list.add("飞奔的宿舍长");
        list.add("下海的宿舍长");
        list.add("发情期的宿舍长");
        list.add("遭袭的宿舍长");
        list.add("变身后的宿舍长");
        ArrayAdapter<String> adapter;
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);
        
        b1.setOnClickListener(new OnClickListener()
    {
			
			@Override
		public void onClick(View v)
		{
				// TODO Auto-generated method stub
			try
			{
				for(k=0;k<5;k++)
				{
					T[k].setText(null);
				}
				for(k=0;k<5;k++)
				{
					E[k].setText(null);
				}
				T[5].setText(null);
				T[6].setText(null);
				T[7].setText(null);
				T[8].setText(null);
				i=0;
				if(E[5].getText().length()==0)
				{
					Toast.makeText(MainActivity.this, "请输入题数", 1).show();
				}
				else if(Integer.parseInt(E[5].getText()+"")>5 || Integer.parseInt(E[5].getText()+"")<1)
				{
					Toast.makeText(MainActivity.this, "题数最多不超过5题,不少于1题", 1).show();
				}
				else
				{
					i=Integer.parseInt(E[5].getText()+"");
					
					for(k=0;k<i;k++)
					{
						a[k]=(int)(Math.random()*201-100);
						b[k]=(int)(Math.random()*201-100);
						c[k]=(int)(Math.random()*5);
						d[k]=(int)(Math.random()*12+1);
						Core core=new Core(a[k],b[k],c[k],d[k]);
						answer[k]=core.calc();
						T[k].setText(core.toString());
						
					}
					begintime = System.currentTimeMillis();
				}
			}catch(NumberFormatException u)
			{
				Toast.makeText(MainActivity.this, "请输入正确的数字", 1).show();
			}
		}
	});
        
        b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(i==0)
				{
					Toast.makeText(MainActivity.this, "请先开始答题", 1).show();
				}
				else
				{
					endtime = System.currentTimeMillis();
					time=(endtime-begintime)/1000;
					n=0;
					for(k=0;k<i;k++)
					{
						if(E[k].getText().length()==0)
						{
							continue;
						}
						try
						{
							if(answer[k]==Float.parseFloat(E[k].getText()+""))
							{
								n++;
							}
						}catch(NumberFormatException u)
						{
							Toast.makeText(MainActivity.this, "请输入正确的数字", 1).show();
						}
						
					}
					T[5].setText(n+"道题");
					T[6].setText((i-n)+"道题");
					T[7].setText(time+"秒");
					T[8].setText("");
					for(k=0;k<i;k++)
					{
						T[8].setText(T[8].getText()+""+answer[k]+";");
					}
					i=0;
				}
			}
		});
        
        b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				for(k=0;k<5;k++)
				{
					T[k].setText(null);
				}
				for(k=0;k<5;k++)
				{
					E[k].setText(null);
				}
				E[5].setText(null);
				T[5].setText(null);
				T[6].setText(null);
				T[7].setText(null);
				T[8].setText(null);
				i=0;
			}
		});
        
        sp1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
            	if(pos==0)
            		l1.setBackgroundResource(R.drawable.ss2);
            	if(pos==1)
            		l1.setBackgroundResource(R.drawable.ss3);
            	if(pos==2)
            		l1.setBackgroundResource(R.drawable.ss4);
            	if(pos==3)
            		l1.setBackgroundResource(R.drawable.ss5);
            	if(pos==4)
            		l1.setBackgroundResource(R.drawable.ss6);
            	if(pos==5)
            		l1.setBackgroundResource(R.drawable.ss7);
            	if(pos==6)
            		l1.setBackgroundResource(R.drawable.ss8);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // Another interface callback
            }
        });
  }

}