package lucassales.com.builditbigger;

import lucassales.com.jokedisplay.JokeDisplayFactory;

public class JokeFragment extends AbstractJokeFragment {

    @Override
    protected void onJokeLoaded(String joke) {
        JokeDisplayFactory.displayJoke(getContext(), joke);
    }
}
