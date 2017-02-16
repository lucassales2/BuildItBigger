package lucassales.com.jokedisplay;

import android.content.Context;
import android.content.Intent;

/**
 * Created by lucas on 16/02/17.
 */

public class JokeDisplayFactory {

    public static void displayJoke(Context context, String joke) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE, joke);
        context.startActivity(intent);
    }

}
