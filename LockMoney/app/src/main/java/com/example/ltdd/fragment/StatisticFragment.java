package com.example.ltdd.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.ltdd.Model.phantichthuchi;
import com.example.ltdd.Model.thongkethuchi;
import com.example.ltdd.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class StatisticFragment extends Fragment {

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,header;
    LinearLayout pt1, pt2, pt3, pt4;
    TextView thanhtoan,doan, dichuyen, cuahang;
    TextView percent1, percent2, percent3, percent4;

    ImageView showmoney;
    TextView summoney;

    boolean checkmoney = true;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_statistic, container, false);

        view.findViewById(R.id.btnXemChiTiet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(requireActivity(), StatisticDetailActivity.class);
                startActivity(intent);*/
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.View, new StatisticDetailFragment()).commit();
            }
        });

        view.findViewById(R.id.showmoney).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                summoney = view.findViewById(R.id.summoney);
               if (checkmoney == true){
                  summoney.setText("55.555.555");
                  checkmoney = false;
                   FirebaseDatabase database = FirebaseDatabase.getInstance();
                   DatabaseReference myRef = database.getReference("message");
                   myRef.setValue("Hello, World!");
               }else{
                   summoney.setText(". . .");
                   checkmoney = true;
               }
            }
        });


        thongkethuchi[] thongkevalue = new thongkethuchi[12];
        thongkevalue[0] = new thongkethuchi(20000000,30000000);
        thongkevalue[1] = new thongkethuchi(25000000,35000000);
        thongkevalue[2] = new thongkethuchi(32000000,15000000);
        thongkevalue[3] = new thongkethuchi(26000000,10000000);
        thongkevalue[4] = new thongkethuchi(21000000,12000000);
        thongkevalue[5] = new thongkethuchi(24000000,17000000);
        thongkevalue[6] = new thongkethuchi(25000000,14000000);
        thongkevalue[7] = new thongkethuchi(20000000,15000000);
        thongkevalue[8] = new thongkethuchi(38000000,9000000);
        thongkevalue[9] = new thongkethuchi(26000000,17000000);
        thongkevalue[10] = new thongkethuchi(22000000,18000000);
        thongkevalue[11] = new thongkethuchi(45000000,19000000);

        phantichthuchi phantichvalue = new phantichthuchi(20000000,2000000,8000000,16000000);


        changevaluethuchi(thongkevalue,view);
        changevaluephantich(phantichvalue,view);
        return view;


    }

    public Integer maxpice(thongkethuchi[] listvalue) {
        int maxvalue =0;
        for(int i=0;i<12;i++){
            if(listvalue[i].chi >maxvalue){
                maxvalue = listvalue[i].chi;
            }
            if(listvalue[i].thu >maxvalue){
                maxvalue = listvalue[i].thu;
            }
        }
        return maxvalue;

    }

    public void changevaluethuchi(thongkethuchi[] listvalue, View view) {
        int maxprice = maxpice(listvalue);

        t1 =view.findViewById(R.id.t1);
        t2 =view.findViewById(R.id.t2);
        t3 = (TextView) view.findViewById(R.id.t3);
        t4 = (TextView) view.findViewById(R.id.t4);
        t5 = (TextView) view.findViewById(R.id.t5);
        t6 = (TextView) view.findViewById(R.id.t6);
        t7 = (TextView) view.findViewById(R.id.t7);
        t8 = (TextView) view.findViewById(R.id.t8);
        t9 = (TextView) view.findViewById(R.id.t9);
        t10 = (TextView) view.findViewById(R.id.t10);
        t11 = (TextView) view.findViewById(R.id.t11);
        t12 = (TextView) view.findViewById(R.id.t12);
        c1 = (TextView) view.findViewById(R.id.c1);
        c2 = (TextView) view.findViewById(R.id.c2);
        c3 = (TextView) view.findViewById(R.id.c3);
        c4 = (TextView) view.findViewById(R.id.c4);
        c5 = (TextView) view.findViewById(R.id.c5);
        c6 = (TextView) view.findViewById(R.id.c6);
        c7 = (TextView) view.findViewById(R.id.c7);
        c8 = (TextView) view.findViewById(R.id.c8);
        c9 = (TextView) view.findViewById(R.id.c9);
        c10 = (TextView) view.findViewById(R.id.c10);
        c11 = (TextView) view.findViewById(R.id.c11);
        c12 = (TextView) view.findViewById(R.id.c12);

        t1.getLayoutParams().height = listvalue[0].thu/(maxprice/200) ;
        t2.getLayoutParams().height = listvalue[1].thu/(maxprice/200) ;
        t3.getLayoutParams().height = listvalue[2].thu/(maxprice/200) ;
        t4.getLayoutParams().height = listvalue[3].thu/(maxprice/200) ;
        t5.getLayoutParams().height = listvalue[4].thu/(maxprice/200) ;
        t6.getLayoutParams().height = listvalue[5].thu/(maxprice/200) ;
        t7.getLayoutParams().height = listvalue[6].thu/(maxprice/200) ;
        t8.getLayoutParams().height = listvalue[7].thu/(maxprice/200) ;
        t9.getLayoutParams().height = listvalue[8].thu/(maxprice/200) ;
        t10.getLayoutParams().height =listvalue[9].thu/(maxprice/200) ;
        t11.getLayoutParams().height =listvalue[10].thu/(maxprice/200) ;
        t12.getLayoutParams().height =listvalue[11].thu/(maxprice/200) ;

        c1.getLayoutParams().height = listvalue[0].chi/(maxprice/200) ;
        c2.getLayoutParams().height = listvalue[1].chi/(maxprice/200) ;
        c3.getLayoutParams().height = listvalue[2].chi/(maxprice/200) ;
        c4.getLayoutParams().height = listvalue[3].chi/(maxprice/200) ;
        c5.getLayoutParams().height = listvalue[4].chi/(maxprice/200) ;
        c6.getLayoutParams().height = listvalue[5].chi/(maxprice/200) ;
        c7.getLayoutParams().height = listvalue[6].chi/(maxprice/200) ;
        c8.getLayoutParams().height = listvalue[7].chi/(maxprice/200) ;
        c9.getLayoutParams().height = listvalue[8].chi/(maxprice/200) ;
        c10.getLayoutParams().height =listvalue[9].chi/(maxprice/200) ;
        c11.getLayoutParams().height =listvalue[10].chi/(maxprice/200) ;
        c12.getLayoutParams().height =listvalue[11].chi/(maxprice/200) ;

    }

    public void  changevaluephantich(phantichthuchi value, View view){
        thanhtoan = (TextView) view.findViewById(R.id.thanhtoan);
        doan = (TextView) view.findViewById(R.id.doan);
        cuahang = (TextView) view.findViewById(R.id.cuahang);
        dichuyen = (TextView) view.findViewById(R.id.dichuyen);

        thanhtoan.setText(String.valueOf(value.thanhtoan));
        doan.setText(String.valueOf(value.doan));
        cuahang.setText(String.valueOf(value.cuahang));
        dichuyen.setText(String.valueOf(value.dichuyen));


        pt1 = (LinearLayout) view.findViewById(R.id.pt1);
        pt2 = (LinearLayout) view.findViewById(R.id.pt2);
        pt3 = (LinearLayout) view.findViewById(R.id.pt3);
        pt4 = (LinearLayout) view.findViewById(R.id.pt4);


        int sum = value.cuahang + value.dichuyen + value.doan +value.thanhtoan;


        int rowpt1 = value.doan/(sum/100);
        int rowpt2 = value.thanhtoan/(sum/100);
        int rowpt3 = value.cuahang/(sum/100);
        int rowpt4 = 100 - (rowpt2+rowpt1+rowpt3);

        pt1.getLayoutParams().width = value.doan/(sum/850);
        pt2.getLayoutParams().width = value.thanhtoan/(sum/850);
        pt3.getLayoutParams().width = value.cuahang/(sum/850);
        pt4.getLayoutParams().width = value.dichuyen/(sum/850);

        percent1 = (TextView) view.findViewById(R.id.percent1);
        percent2 = (TextView) view.findViewById(R.id.percent2);
        percent3 = (TextView) view.findViewById(R.id.percent3);
        percent4 = (TextView) view.findViewById(R.id.percent4);

        percent1.setText(String.valueOf(rowpt1)+"%");
        percent2.setText(String.valueOf(rowpt2)+"%");
        percent3.setText(String.valueOf(rowpt3)+"%");
        percent4.setText(String.valueOf(rowpt4)+"%");

    }
}