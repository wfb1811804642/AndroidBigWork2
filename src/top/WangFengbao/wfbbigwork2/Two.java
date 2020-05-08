package top.WangFengbao.wfbbigwork2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Two extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 创建布局
		LinearLayout linearLayout = new LinearLayout(this);
		// 创建文本组件
		TextView textView = new TextView(this);
		// 设置字体大小
		textView.setTextSize(15);
		// 获取intent
		Intent intent = getIntent();
		// 获取传递过来的值
		Bundle bundle = intent.getExtras();
		// 给文本组件赋值
		textView.setText("姓名：" + bundle.getString("name") + "\n电话："
				+ bundle.getString("tel") + "\n健康情况："
				+ bundle.getString("jiankang") + "\n去向："
				+ bundle.getString("diqv"));
		// 将组件添加到布局中
		linearLayout.addView(textView);
		// 加载布局
		setContentView(linearLayout);

	}
}
