package lucassales.com.builditbigger;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by lucas on 15/02/17.
 */

public abstract class AbstractJokeFragment extends Fragment {

    private ProgressDialog dialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_joke, container, false);
        Button button = (Button) inflate.findViewById(R.id.button);
        dialog = new ProgressDialog(getContext());
        dialog.setIndeterminate(true);
        dialog.setTitle("Loading");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EndpointAsyncTask() {
                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                        dialog.show();
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        dialog.cancel();
                        onJokeLoaded(s);
                    }
                }.execute();
            }
        });
        return inflate;
    }

    protected abstract void onJokeLoaded(String joke);


}
