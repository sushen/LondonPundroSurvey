package blog.video.biswas.londonpundrosurvey;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import blog.video.biswas.londonpundrosurvey.databinding.ActivityShowdataBinding;

public class ShowData extends AppCompatActivity {
    private ActivityShowdataBinding binding;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private List<PundroFrom> fromList;
    private CAdapter cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_showdata);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(binding.spicountry.getSelectedItem().toString());//binding.spicountry.getSelectedItem().toString()
        fromList = new ArrayList<>();

        cAdapter = new CAdapter(ShowData.this, fromList);

        binding.RView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String name = binding.RView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }




    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                List<PundroFrom> fromList = new ArrayList<>();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    fromList.clear();
                    PundroFrom pundroFrom = dataSnapshot1.child(binding.spicountry.getSelectedItem().toString()).getValue(PundroFrom.class);
                    fromList.add(pundroFrom);
                }

                binding.RView.setAdapter(cAdapter);

//                fromList.clear();
//                for(DataSnapshot cardioHistorySnapshot : dataSnapshot.getChildren()){
//
//                    String category=cardioHistorySnapshot.child(binding.spicountry.getSelectedItem().toString()).getValue().toString();
//                    fromList.add(category);
//                }
//
//                CardioHistoryList adapter = new CardioHistoryList(Cardio_History.this, cardiosList);
//                ListViewCardioHistory.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        super.onStart();
    }
}
