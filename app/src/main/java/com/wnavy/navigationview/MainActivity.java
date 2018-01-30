package com.wnavy.navigationview;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    private Girl[] girlArry = {
            new Girl("XiaoHong", R.drawable.image_girl_1),
            new Girl("XiaoQing", R.drawable.image_girl_2),
            new Girl("XiaoYu", R.drawable.image_girl_3),
            new Girl("XiaoCui", R.drawable.image_girl_4),
            new Girl("XiaoCang", R.drawable.image_girl_5),
            new Girl("XiaoYa", R.drawable.image_girl_6),
            new Girl("XiaoQian", R.drawable.image_girl_7),
            new Girl("XiaoYan", R.drawable.image_girl_8),
    };

    private List<Girl> girlList = new ArrayList<>();
    private GirlAdapter girlAdapter;

    private void initGirlList() {
        girlList.clear();
        Random random = new Random();
        int index = 0;
        for (int i = 0; i < 300; i++) {
            index = random.nextInt(girlArry.length);
            girlList.add(girlArry[index]);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.float_action_button);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);


        initGirlList();//初始化图片列表

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*//*Toast.makeText(MainActivity.this, "You Clicked floatingActionButton", Toast.LENGTH_SHORT).show();*//**//*
                Snackbar.make(v, "You Clicked floatingActionButton", Snackbar.LENGTH_SHORT).setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "You Clicked Snackbar OK", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

        MainActivity.this.setSupportActionBar(toolbar);

        ActionBar actionBar = MainActivity.this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        navigationView.setCheckedItem(R.id.menu_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                drawerLayout, toolbar, R.string.drawer_toggle_open, R.string.drawer_toggle_close);

        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);


        gridLayoutManager = new GridLayoutManager(MainActivity.this, 3);

        recyclerView.setLayoutManager(gridLayoutManager);
        girlAdapter = new GirlAdapter(girlList);
        recyclerView.setAdapter(girlAdapter);
    }
}*/

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    private SwipeRefreshLayout swipeRefreshLayout;

    private Girl[] girlArry = {
            new Girl("XiaoHong", R.drawable.image_girl_1),
            new Girl("XiaoQing", R.drawable.image_girl_2),
            new Girl("XiaoYu", R.drawable.image_girl_3),
            new Girl("XiaoCui", R.drawable.image_girl_4),
            new Girl("XiaoCang", R.drawable.image_girl_5),
            new Girl("XiaoYa", R.drawable.image_girl_6),
            new Girl("XiaoQian", R.drawable.image_girl_7),
            new Girl("XiaoYan", R.drawable.image_girl_8),
    };

    private List<Girl> girlList = new ArrayList<>();
    private GirlAdapter girlAdapter;

    private void initGirlList() {
        girlList.clear();
        Random random = new Random();
        int index = 0;
        for (int i = 0; i < 300; i++) {
            index = random.nextInt(girlArry.length);
            girlList.add(girlArry[index]);
        }
    }

    private void refreshGirlList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initGirlList();
                        girlAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.float_action_button);

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        initGirlList();//初始化图片列表

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Toast.makeText(MainActivity.this, "You Clicked floatingActionButton", Toast.LENGTH_SHORT).show();*/
                //创建可交互提示框Snackbar,并为其绑定点击交互事件
                Snackbar.make(v, "You Clicked floatingActionButton", Snackbar.LENGTH_SHORT).
                        setAction("Ok", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "You Clicked Snackbar OK", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        MainActivity.this.setSupportActionBar(toolbar);

        ActionBar actionBar = MainActivity.this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);//设置返回键可用
            actionBar.setDisplayHomeAsUpEnabled(true);//在ToolBar左侧显示一个导航按钮
        }

        navigationView.setCheckedItem(R.id.menu_call);//设置navigationView的默认选中项目
        //为navigationView的菜单项目(menu)添加点击事件
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //这里仅用于点击菜单项之后关闭滑动菜单
                drawerLayout.closeDrawers();
                return true;
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                drawerLayout, toolbar, R.string.drawer_toggle_open, R.string.drawer_toggle_close);

        actionBarDrawerToggle.syncState();//设置导航按钮显示为三横杠

        //添加菜单拖动监听事件  根据菜单的拖动距离,折算成导航按钮旋转角度
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        gridLayoutManager = new GridLayoutManager(MainActivity.this, 3);

        recyclerView.setLayoutManager(gridLayoutManager);
        girlAdapter = new GirlAdapter(girlList);
        recyclerView.setAdapter(girlAdapter);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swip_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshGirlList();
            }
        });
    }
}
