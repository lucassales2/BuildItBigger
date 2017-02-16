package lucassales.com.builditbigger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class JokeFragment extends AbstractJokeFragment {


    private Toast toast;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        AdView adView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addKeyword("Funny").build();
        adView.loadAd(adRequest);
        return rootView;
    }

    @Override
    protected void onJokeLoaded(String joke) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(getContext(), joke, Toast.LENGTH_LONG);
        toast.show();
    }


}
