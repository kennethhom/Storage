package com.example.winehipster;

/*
Code based on Example code based on code from Nicholas Smith at http://imnes.blogspot.com/2011/01/how-to-use-yelp-v2-from-java-including.html
 For a more complete example (how to integrate with GSON, etc) see the blog post above.
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

/**
 * Example for accessing the Yelp API.
 */
public class Yelp {

  OAuthService service;
  Token accessToken;

  /**
   * Setup the Yelp API OAuth credentials.
   *
   * OAuth credentials are available from the developer site, under Manage API access (version 2 API).
   *
   * @param consumerKey Consumer key
   * @param consumerSecret Consumer secret
   * @param token Token
   * @param tokenSecret Token secret
   */
  public Yelp(String consumerKey, String consumerSecret, String token, String tokenSecret) {
    this.service = new ServiceBuilder().provider(YelpApi2.class).apiKey(consumerKey).apiSecret(consumerSecret).build();
    this.accessToken = new Token(token, tokenSecret);
  }

  /**
   * Search with term and location.
   *
   * @param term Search term
   * @param latitude Latitude
   * @param longitude Longitude
   * @return JSON string response
   */
  public String search(String term, double latitude, double longitude) {
    OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");
    request.addQuerystringParameter("term", term);
    request.addQuerystringParameter("radius_filter", "40000");
    request.addQuerystringParameter("category", "wineries");
    request.addQuerystringParameter("ll", latitude + "," + longitude);
    this.service.signRequest(this.accessToken, request);
    Response response = request.send();
    return response.getBody();
  }

  // CLI
  /*public static void main(String[] args) {
    // Update tokens here from Yelp developers site, Manage API access.
    String consumerKey = "ZWkxa7xlh2CoY9XEnP0JQg";
    String consumerSecret = "L40KoPcPzNguyMSbKn_mEuV3PWw";
    String token = "bP8bIc8mmMsyWAuxBD6queHqsrA94TXm";
    String tokenSecret = "U6ne01kF0RHTTPFMy5WGWWJg7_0";

    Yelp yelp = new Yelp(consumerKey, consumerSecret, token, tokenSecret);
    String response = yelp.search("winery", 32.7153292,-117.1572551);

    try {
      JSONObject json = new JSONObject(response);
      JSONArray businesses = json.getJSONArray("businesses");

      int count = businesses.length();
      for (int i = 0; i < count; i++) {
        JSONObject current = businesses.getJSONObject(i);

        System.out.println(current.getString("name"));
        System.out.println(current.getString("phone"));

        JSONObject location = current.getJSONObject("location");
        JSONObject coors = location.getJSONObject("coordinate");

        System.out.println(coors.getLong("latitude"));
        System.out.println(coors.getLong("longitude"));

        System.out.println("");
      }
    }
    catch (Exception e) {
      System.out.println("oops");
    }

  }*/
}
