package square.auth.square;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import com.squareup.square.*;
import com.squareup.square.api.*;
import com.squareup.square.models.*;
import com.squareup.square.models.Error;
import com.squareup.square.exceptions.*;

public class Quickstart {

    public static void callSquareEndpoint() {
        InputStream inputStream =
                Quickstart.class.getResourceAsStream("/config.properties");
        Properties prop = new Properties();

        try {
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println("Error reading properties file");
            e.printStackTrace();
        }


        ObtainTokenRequest body = new ObtainTokenRequest.Builder("sandbox-sq0idb-127n60yf41CA5jfg3Lub_w", "refresh_token")
                .clientSecret("sandbox-sq0csb-paAAGRBTxdedmMGbPeEMdVvNRYz2m9PJofpsW8KhXig")
                .shortLived(true)
                .build();

        DefaultOAuthApi oAuthApi = null;
        oAuthApi.obtainTokenAsync(body)
                .thenAccept(result -> {
                    System.out.println("Success!");
                })
                .exceptionally(exception -> {
                    System.out.println("Failed to make the request");
                    System.out.println(String.format("Exception is : %s", exception.getMessage()));
                    return null;
                });
    }
    public static void getAccessToken() {

        InputStream inputStream =
                Quickstart.class.getResourceAsStream("/config.properties");
        Properties prop = new Properties();

        try {
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println("Error reading properties file");
            e.printStackTrace();
        }

        SquareClient client = new SquareClient.Builder()
                .accessToken(prop.getProperty("SQUARE_ACCESS_TOKEN"))
                .environment(Environment.SANDBOX)
                .build();

        LocationsApi locationsApi = client.getLocationsApi();

        locationsApi.listLocationsAsync().thenAccept(result -> {
            System.out.println("Location(s) for this account:");
            for (Location l : result.getLocations()) {
                System.out.printf("%s: %s, %s, %s\n",
                        l.getId(), l.getName(),
                        l.getAddress().getAddressLine1(),
                        l.getAddress().getLocality());
            }

        }).exceptionally(exception -> {
            try {
                throw exception.getCause();
            } catch (ApiException ae) {
                for (Error err : ae.getErrors()) {
                    System.out.println(err.getCategory());
                    System.out.println(err.getCode());
                    System.out.println(err.getDetail());
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
            return null;
        }).join();

        SquareClient.shutdown();
    }
}
