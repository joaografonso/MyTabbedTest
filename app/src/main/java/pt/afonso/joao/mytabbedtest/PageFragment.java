package pt.afonso.joao.mytabbedtest;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class PageFragment extends Fragment {
    private static final String ARG_PAGE_NUMBER = "page_number";

    public PageFragment() {
    }

    public static PageFragment newInstance(int page) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NUMBER, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        int page = getArguments().getInt(ARG_PAGE_NUMBER, -1);
        View rootView = null;
        if (page == 1){

            rootView = inflater.inflate(R.layout.bmi_fragment_page_layout, container, false);

            Spinner sex_spinner = (Spinner) rootView.findViewById(R.id.sex);
            Spinner height_spinner = (Spinner) rootView.findViewById(R.id.height_spinner);
            Spinner weight_spinner = (Spinner) rootView.findViewById(R.id.weight_spinner);

            ArrayAdapter<CharSequence> sex_adapter = ArrayAdapter.createFromResource(rootView.getContext(), R.array.sex_units, android.R.layout.simple_spinner_item);
            ArrayAdapter<CharSequence> height_adapter = ArrayAdapter.createFromResource(rootView.getContext(), R.array.height_units, android.R.layout.simple_spinner_item);
            ArrayAdapter<CharSequence> weight_adapter = ArrayAdapter.createFromResource(rootView.getContext(), R.array.weight_units, android.R.layout.simple_spinner_item);

            sex_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            height_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            weight_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            sex_spinner.setAdapter(sex_adapter);
            height_spinner.setAdapter(height_adapter);
            weight_spinner.setAdapter(weight_adapter);

        }else {

            rootView = inflater.inflate(R.layout.fragment_page_layout, container, false);

            TextView txt = (TextView) rootView.findViewById(R.id.page_number_label);
           // int page = getArguments().getInt(ARG_PAGE_NUMBER, -1);
            txt.setText(String.format("Page %d", page));

        }

        return rootView;
    }
}
