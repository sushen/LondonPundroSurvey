package blog.video.biswas.londonpundrosurvey;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CAdapter extends ArrayAdapter<PundroFrom> {

    private Activity context;
    private List<PundroFrom>fromList;

    public CAdapter(Activity context, List<PundroFrom> fromList) {
        super(context, R.layout.detailsshowdata,fromList);
        this.context = context;
        this.fromList = fromList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.detailsshowdata,null,true);

        PundroFrom pundroFrom = fromList.get(position);

//        TextView country =  view.findViewById(R.id.tvcountryname);
        TextView fristname =  view.findViewById(R.id.tvNameFrist);
        TextView lastname =  view.findViewById(R.id.tvNameLast);
        TextView email =  view.findViewById(R.id.tvEmailShow);
        TextView number =  view.findViewById(R.id.tvNumber);
        TextView q1a =  view.findViewById(R.id.rvQ1A);
        TextView chackbox =  view.findViewById(R.id.cvA);

//        country.setText(pundroFrom.getCountry());
        fristname.setText(pundroFrom.getFristName());
        lastname.setText(pundroFrom.getLastName());
        email.setText(pundroFrom.getMail());
        number.setText(pundroFrom.getComment());
        q1a.setText(pundroFrom.getRgq1());
        chackbox.setText(pundroFrom.getCbq1());

        return view;
    }
}
