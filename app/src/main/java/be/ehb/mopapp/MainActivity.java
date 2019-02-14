package be.ehb.mopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import be.ehb.mopapp.model.MopDAO;
import be.ehb.mopapp.recyclerutilities.MopAdapter;
import be.ehb.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMopjes;
    private MopAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //verwijzing naar recycler
        rvMopjes = findViewById(R.id.rv_mopjes);
        //adapter, hoe recycler opvullen
        adapter = new MopAdapter(MopDAO.getInstance().getMopLijst());
        rvMopjes.setAdapter(adapter);
        //hoe elementen weergeven (horizontale Lijst?, verticale Lijst?)
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvMopjes.setLayoutManager(layoutManager);


    }
}
