package com.example.myflowlayout;

import java.util.ArrayList;
import java.util.Random;

import org.apmem.tools.layouts.FlowLayout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private String[] str = {"cat","hello","shine","girls","beautiful","smart","everybody","lovely","sexy","healthy"};
	private ArrayList<Button> list;
	private Random random;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		random = new Random();
		list = new ArrayList<Button>();
		
		Button addBut = (Button) findViewById(R.id.add_button);
		Button delBut = (Button) findViewById(R.id.del_button);
		final FlowLayout flowView = (FlowLayout) findViewById(R.id.flow_layout);		
		
		addBut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Button but = new Button(MainActivity.this);	
				but.setText(str[getInt()]);				
				flowView.addView(but);
			}
		});
		
		delBut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(flowView.getChildCount() !=0){
					flowView.removeViewAt(flowView.getChildCount()-1);
				}	
			}
		});
	}

	
	public int getInt(){
		int num = random.nextInt(10);
		
		return num;
	}
}
