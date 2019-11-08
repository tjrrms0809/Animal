package com.mrhi.animal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView ivStart;
    ImageView ivHow;
    ImageView iv01, iv02, iv03, iv04, iv05;
    ImageView ivBoard;
    int n;
    int[] a=new int[5];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivStart=findViewById(R.id.iv_start);
        ivHow=findViewById(R.id.iv_how);
        iv01=findViewById(R.id.iv01);
        iv02=findViewById(R.id.iv02);
        iv03=findViewById(R.id.iv03);
        iv04=findViewById(R.id.iv04);
        iv05=findViewById(R.id.iv05);
        ivBoard=findViewById(R.id.iv_board);

        View.OnClickListener listener= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd= new Random();
                n=rnd.nextInt(5);//0-4
                ivBoard.setImageResource(R.drawable.b_ele+n);

                for (int i=0;i<5;i++) {
                    a[i] = rnd.nextInt(45)+1;

                    for (int k=0;k<i;k++){
                        if (a[i]==a[k]){
                            i--;
                            break;
                        }
                    }
                }

                iv01.setImageResource(R.drawable.a_ele+a[0]);
                iv02.setImageResource(R.drawable.a_ele+a[1]);
                iv03.setImageResource(R.drawable.a_ele+a[2]);
                iv04.setImageResource(R.drawable.a_ele+a[3]);
                iv05.setImageResource(R.drawable.a_ele+a[4]);

                //
            }
        };

        ivStart.setOnClickListener(listener);


        View.OnClickListener listener1= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(n==a[0]){
                    Toast.makeText(MainActivity.this,"정답!",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"틀렸다.",Toast.LENGTH_SHORT).show();

                }

            }
        };


        iv01.setOnClickListener(listener1);

        View.OnClickListener listener2= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(n==a[1]){
                    Toast.makeText(MainActivity.this,"정답!",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "틀렸다!",Toast.LENGTH_SHORT).show();
                }

            }
        };

        iv02.setOnClickListener(listener2);


        View.OnClickListener listener3= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(n==a[2]){
                    Toast.makeText(MainActivity.this,"정답!",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"틀렸다!",Toast.LENGTH_SHORT).show();
                }
            }
        };

        iv03.setOnClickListener(listener3);


        iv04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (n==a[3]){
                    Toast.makeText(MainActivity.this, "정답!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"틀렸다!",Toast.LENGTH_SHORT).show();
                }
            }
        });


        iv05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (n==a[4]){
                    Toast.makeText(MainActivity.this,"정답!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"틀렸다!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        ivHow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("게임설명");
                builder.setMessage("이 게임은 동물이나올거야. 하단에 있는 단어와 터치한 동물이 일치하면 이기는거다!");
                builder.setPositiveButton("오케이", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });








    }
}
