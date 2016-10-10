package cn.edu.s07150819gdmec.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private AlertDialog.Builder builder;
    private AlertDialog ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView) this.findViewById(R.id.textView1);

        Button btn1=(Button)findViewById(R.id.button1);
        Button btn2=(Button)findViewById(R.id.button2);
        Button btn3=(Button)findViewById(R.id.button3);
        Button btn4=(Button)findViewById(R.id.button4);
        Button btn5=(Button)findViewById(R.id.button5);
        Button btn6=(Button)findViewById(R.id.button6);
        Button btn7=(Button)findViewById(R.id.button7);

        View.OnClickListener listener=new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };

        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
    }

    private void dialog1() {
        ad=new AlertDialog.Builder(this).create();
        ad.setTitle("提示");
        ad.setMessage("确定退出吗？");
        ad.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener lis1=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==DialogInterface.BUTTON_POSITIVE){
                    ad.dismiss();
                    MainActivity.this.finish();
                }else if (which==DialogInterface.BUTTON_NEGATIVE){
                    ad.dismiss();
                }
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"退出",lis1);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis1);
        ad.show();
        //Toast.makeText(this,"hi",Toast.LENGTH_LONG).show();
    }
    private void dialog2() {
        ad=new AlertDialog.Builder(this).create();
        ad.setTitle("调查");
        ad.setMessage("你平时忙吗？");
        ad.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener lis1=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str = "杜甫很忙";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str = "杜甫很闲";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str = "杜甫无所谓";
                        break;
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"很忙",lis1);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"很闲",lis1);
        ad.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",lis1);
        ad.show();
    }
    private void dialog3() {
        ad=new AlertDialog.Builder(this).create();
        ad.setTitle("请输入");
        ad.setMessage("你平时忙吗？");
        ad.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit=new EditText(this);
        ad.setView(tEdit);
        DialogInterface.OnClickListener lis1=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是:"+tEdit.getText().toString());
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis1);
        ad.show();
    }
    private void dialog4() {
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mLis=new DialogInterface.OnMultiChoiceClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which]=isChecked;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mLis);
        ad=builder.create();
        ad.setTitle("复选框");
        DialogInterface.OnClickListener lis1=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了:";
                for (int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis1);
        ad.show();

    }
    private void dialog5() {
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sLis=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                bSelect[which]=true;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,sLis);
        ad=builder.create();
        ad.setTitle("单选框");
        DialogInterface.OnClickListener lis1=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了:";
                for (int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis1);
        ad.show();
    }
    private void dialog6() {
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sLis=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了:"+item[which];
                tv1.setText(str);
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,sLis);
        ad=builder.create();
        ad.setTitle("列表框");
        DialogInterface.OnClickListener lis1=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                ad.dismiss();
            }
        };
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis1);
        ad.show();
    }
    private void dialog7() {
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.diydialog,null);
        final EditText tEdit=(EditText)layout.findViewById(R.id.editText1);
        ad=new AlertDialog.Builder(this).create();
        ad.setTitle("自定义布局");
        ad.setView(layout);
        DialogInterface.OnClickListener lis1=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是:"+tEdit.getText().toString());
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis1);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis1);
        ad.show();
    }
}
