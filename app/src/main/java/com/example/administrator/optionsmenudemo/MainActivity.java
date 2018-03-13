package com.example.administrator.optionsmenudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * 包含Optionmenu以及ContextMenu两部分代码
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //设置每个item选项的点击事件
        switch (item.getItemId()){
            case R.id.action_menu_item1:
                Toast.makeText(this,"点击了菜单1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_menu_item2:
                Toast.makeText(this,"点击了菜单2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_menu_item3:
                Toast.makeText(this,"点击了菜单3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_menu_item4:
                Toast.makeText(this,"点击了菜单4",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    /**
     * 设置ListView的显示内容
     */
    private void showListView(){
        ListView listView=findViewById(R.id.listview);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getData());
        listView.setAdapter(adapter);
        this.registerForContextMenu(listView);//注册上下文菜单
    }
    /**
     * 构造ListView显示的数据
     */
    private ArrayList<String> getData(){
        ArrayList<String> list=new ArrayList<String>();
        for(int i=0;i<5;i++){
            list.add("文件"+(i+1));
        }
        return list;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //设置Menu显示内容
        menu.setHeaderTitle("文件操作");
        menu.setHeaderIcon(R.drawable.ic_launcher_background);
//        menu.add(1,1,1,"复制");
//        menu.add(1,2,1,"粘贴");
//        menu.add(1,3,1,"剪切");
//        menu.add(1,4,1,"重命名");
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.contextmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.context_menu_item0:
                Toast.makeText(MainActivity.this,"点击复制",Toast.LENGTH_SHORT).show();
                break;
            case R.id.context_menu_item1:
                Toast.makeText(this,"点击粘贴",Toast.LENGTH_SHORT).show();
                break;
            case R.id.context_menu_item2:
                Toast.makeText(this,"点击剪切",Toast.LENGTH_SHORT).show();
                break;
            case R.id.context_menu_item3:
                Toast.makeText(this,"点击重命名",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
