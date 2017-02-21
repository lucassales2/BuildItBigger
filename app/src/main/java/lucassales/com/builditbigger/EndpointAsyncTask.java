package lucassales.com.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.joketeler.backend.jokeApi.JokeApi;

import java.io.IOException;

/**
 * Created by lucas on 15/02/17.
 */

public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {


    private static final String BACKEND_IP_ADRESS = "http://10.0.2.2:8080/_ah/api/";
    public static final String ERROR_TAG = "ERROR ";
    private static JokeApi jokeApi;

    @Override
    protected String doInBackground(Void... params) {
        if (jokeApi == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl(BACKEND_IP_ADRESS)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            jokeApi = builder.build();
        }


        try {
            return jokeApi.getJoke().execute().getData();
        } catch (IOException e) {

            return ERROR_TAG + e.getMessage();
        }
    }
}
