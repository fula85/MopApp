package be.ehb.mopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import be.ehb.mopapp.model.MopDAO;
import be.ehb.mopapp.recyclerutilities.MopAdapter;
import be.ehb.mopapp.recyclerutilities.RecyclerTouchListener;
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

        //voor de geïnteresseerden, kan ook in de andere richtingen
        rvMopjes.setLayoutManager(layoutManager);

        //listener toevoegen aan recyclerview
        rvMopjes.addOnItemTouchListener(new RecyclerTouchListener(this, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.i("TEST", MopDAO.getInstance().getMopLijst().get(position).getMop());
            }
        }));


    }
}
