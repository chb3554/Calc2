package calc2.myapplication;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.MotionEvent;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button add, sub, mul, div;
    TextView t1;
    String num1, num2;
    Integer result;

    Button[] numBtn = new Button[10];
    Integer[] numBtnIDs = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9, R.id.btn0};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);
        t1 = (TextView) findViewById(R.id.t1);

        add.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent m) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                t1.setText("계산 결과 : " + result.toString());
                return false;
            }
        });
        sub.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent m) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                t1.setText("계산 결과 : " + result.toString());
                return false;
            }
        });
        mul.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent m) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                t1.setText("계산 결과 : " + result.toString());
                return false;
            }
        });
        div.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent m) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                t1.setText("계산 결과 : " + result.toString());
                return false;
            }
        });
        for (i = 0; i < numBtnIDs.length; i++) {
            numBtn[i] = (Button) findViewById(numBtnIDs[i]);
        }
        for (i = 0; i < numBtnIDs.length; i++) {
            final int index = i;
            numBtn[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (edit1.isFocused() == true) {
                        num1 = edit1.getText().toString() + numBtn[index].getText().toString();
                        edit1.setText(num1);
                    } else if (edit2.isFocused() == true) {
                        num2 = edit2.getText().toString() + numBtn[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요",Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}

