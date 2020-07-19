package com.example.serchbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class ResultListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑修正↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
    //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓追加↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    // xmlファイルのコンポーネントと関連付ける要素
    ListView resultListView;
    // 検証用コレクションデータ
    List<String> listData = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    // ListViewの表示内容を管理するクラス
    ArrayAdapter<String> adapter;
    //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑追加↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_list);

        // xmlファイルのコンポーネントと関連付け
        resultListView = findViewById(R.id.ResultList);
        // ListViewに表示する情報をまとめるAdapterをインスタンス化
        adapter = new ArrayAdapter<>(ResultListActivity.this
                , android.R.layout.simple_list_item_1
                , listData);
        // ListViewに表示情報をまとめたAdapterをセット
        resultListView.setAdapter(adapter);

        //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓追加↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        // ListViewに行をクリックした時のイベントを登録
        resultListView.setOnItemClickListener(ResultListActivity.this);
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑追加↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
    }

    // ListViewの各行をクリックした時の命令を実装
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓追加↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        // クリックした行番号をToastで表示する
        Toast.makeText(ResultListActivity.this
                , i+1 + "行目をクリックしました"
                , Toast.LENGTH_SHORT).show();

        if(i+1 == 1 ) {
            // 画面遷移するためのIntentをインスタンス化
            Intent intent = new Intent(ResultListActivity.this, MainActivity.class);
            // 画面遷移アクションを実行
            startActivity(intent);
        }
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑追加↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
    }
}