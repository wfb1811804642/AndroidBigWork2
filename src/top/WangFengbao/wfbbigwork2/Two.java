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
		// ��������
		LinearLayout linearLayout = new LinearLayout(this);
		// �����ı����
		TextView textView = new TextView(this);
		// ���������С
		textView.setTextSize(15);
		// ��ȡintent
		Intent intent = getIntent();
		// ��ȡ���ݹ�����ֵ
		Bundle bundle = intent.getExtras();
		// ���ı������ֵ
		textView.setText("������" + bundle.getString("name") + "\n�绰��"
				+ bundle.getString("tel") + "\n���������"
				+ bundle.getString("jiankang") + "\nȥ��"
				+ bundle.getString("diqv"));
		// �������ӵ�������
		linearLayout.addView(textView);
		// ���ز���
		setContentView(linearLayout);

	}
}
