package sg.edu.rp.webservices.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoAdapter extends ArrayAdapter<DailyCA> {

    private ArrayList<DailyCA> dailyGrades;
    private Context context;
    private TextView tvWeek, tvDG, tvGrade;
    private ImageView ivIcon;

    public InfoAdapter(Context context, int resource, ArrayList<DailyCA> objects) {
        super(context, resource, objects);
        dailyGrades = objects;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//      return super.getView(position, convertView, parent);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.info_row,parent,false);

        tvDG = rowView.findViewById(R.id.textViewDG);
        tvWeek = rowView.findViewById(R.id.textViewWeek);
        tvGrade = rowView.findViewById(R.id.textViewGrade);
        ivIcon = rowView.findViewById(R.id.imageView);

        DailyCA currposition = dailyGrades.get(position);

        tvDG.setText("DG");
        tvWeek.setText("Week " + currposition.getWeek());
        tvGrade.setText(currposition.getDgGrade());
        ivIcon.setImageResource(R.drawable.dg);


        return rowView;
    }
}
