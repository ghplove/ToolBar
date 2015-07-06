package com.lr.ghp.toolbar_material;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends ActionBarActivity {
    private JimuLoanToolBar toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initToolBar();
    }
    private void initView(){
        toolBar= (JimuLoanToolBar) findViewById(R.id.toolbar);
    }
    private void initToolBar(){
        toolBar.setCenterTitleView("ToolBar");
        toolBar.setlogoViewVisibility(View.VISIBLE);
        toolBar.setLogoViewOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });
    }
}
