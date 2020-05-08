package top.WangFengbao.wfbbigwork2;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button but_tijiao;
	private Spinner spinner_diqv;
	private RadioGroup radio_jiankanGroup;
	private EditText edit_qita;
	private EditText edit_tel;
	private EditText edit_name;
	private String name;
	private String tel;
	private String jiankang;
	private String diqv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		// ��ȡ���
		but_tijiao = (Button) findViewById(R.id.but_tijiao);
		spinner_diqv = (Spinner) findViewById(R.id.spinner_qvxiang);
		radio_jiankanGroup = (RadioGroup) findViewById(R.id.radio_jiankang);
		edit_name = (EditText) findViewById(R.id.edit_name);
		edit_qita = (EditText) findViewById(R.id.edit_qita);
		edit_tel = (EditText) findViewById(R.id.edit_tel);
		// ��������¼�
		but_tijiao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ��ȡֵ
				name = edit_name.getText().toString();
				tel = edit_tel.getText().toString();
				for (int i = 0; i < radio_jiankanGroup.getChildCount(); i++) {
					RadioButton button = (RadioButton) radio_jiankanGroup
							.getChildAt(i);
					if (button.isChecked()) {
						jiankang = button.getText().toString();
					}
				}
				if (jiankang.equals("����")||jiankang.equals("")||jiankang==null) {
					jiankang = edit_qita.getText().toString();
				}
				diqv = spinner_diqv.getSelectedItem().toString();
				// �ж��Ƿ�ȫ����������
				if (name == null || name.equals("")) {
					Toast.makeText(getApplicationContext(), "������������",
							Toast.LENGTH_LONG).show();
				} else if (tel == null || tel.equals("")) {
					Toast.makeText(getApplicationContext(), "�������ֻ��ţ�",
							Toast.LENGTH_LONG).show();
				} else if (tel.length() != 11) {
					Toast.makeText(getApplicationContext(), "�ֻ��Ų��Ϸ���",
							Toast.LENGTH_LONG).show();
				} else if (jiankang == null || jiankang.equals("")) {
					Toast.makeText(getApplicationContext(), "��ѡ�񽡿����������д������",
							Toast.LENGTH_LONG).show();
				} else if (diqv == null || diqv.equals("")) {
					Toast.makeText(getApplicationContext(), "��ѡ��ȥ����У�",
							Toast.LENGTH_LONG).show();
				} else {
					new AlertDialog.Builder(MainActivity.this)
							.setTitle("ȷ���ύ")
							.setMessage("�Ƿ�ȷ���ύ��")
							.setPositiveButton("ȷ��",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
											// �������
											Bundle bundle = new Bundle();
											bundle.putString("name", name);
											bundle.putString("tel", tel);
											bundle.putString("jiankang",
													jiankang);
											bundle.putString("diqv", diqv);
											// ����intent
											Intent intent = new Intent(
													MainActivity.this,
													Two.class);
											intent.putExtras(bundle);
											// �����µ�Activity
											startActivity(intent);
											// ���׹رձ�Activity
											finish();
										}
									})
							.setNegativeButton("ȡ��",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
											Toast.makeText(MainActivity.this,
													"ȡ�����ύ��", Toast.LENGTH_LONG)
													.show();
										}
									}).create().show();

				}
			}
		});

	}

}
