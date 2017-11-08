package jp.livlog.instagram4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.livlog.instagram4j.exception.InstagramApiException;
import jp.livlog.instagram4j.utility.InstagramUtil;
import jp.livlog.instagram4j.utility.Parameter;
import net.arnx.jsonic.JSON;

public class InstagramApi {

    private static final String DEFAULT_VERSION = "20110626";

    private String              clientId;

    private String              clientSecret;

    private String              id;

    private String              accessToken;

    private final String        version         = DEFAULT_VERSION;

    private static final String API_URL         = "https://api.instagram.com/v1/";

    private static final String E0001           = "The access_token is not set.";

    private final InstagramUtil util            = new InstagramUtil();


    public InstagramApi() {

    }


    public InstagramApi(final String clientId, final String clientSecret) {

        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }


    /**
     * @return clientId
     */
    public String getClientId() {

        return clientId;
    }


    /**
     * @param clientId セットする clientId
     */
    public void setClientId(final String clientId) {

        this.clientId = clientId;
    }


    /**
     * @return clientSecret
     */
    public String getClientSecret() {

        return clientSecret;
    }


    /**
     * @param clientSecret セットする clientSecret
     */
    public void setClientSecret(final String clientSecret) {

        this.clientSecret = clientSecret;
    }


    /**
     * @return id
     */
    public String getId() {

        return id;
    }


    /**
     * @param id セットする id
     */
    public void setId(String id) {

        this.id = id;
    }


    /**
     * @return accessToken
     */
    public String getAccessToken() {

        return accessToken;
    }


    /**
     * @param accessToken セットする accessToken
     */
    public void setAccessToken(final String accessToken) {

        this.accessToken = accessToken;
    }


    /**
     * @return version
     */
    public String getVersion() {

        return version;
    }


    /**
     * アクセストークンの有無をチェック
     *
     * @return
     */
    private boolean isNotAccessToken() {

        if (accessToken == null) {
            return true;
        }
        return false;
    }


    /**
     * Get information about a media object.
     *
     * @param mediaId
     * @return
     * @throws InstagramApiException
     */
    @SuppressWarnings ("rawtypes")
    public Map getMedia(final String mediaId) throws InstagramApiException {

        if (isNotAccessToken()) {
            throw new InstagramApiException(E0001);
        }

        final StringBuffer sb = new StringBuffer(API_URL);
        sb.append("media/" + mediaId);

        Map map = null;

        try {
            final URL url = new URL(util.setUrlParameter(sb, new Parameter(InstagramConst.ACCESS_TOKEN, accessToken)));
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            final InputStream is = connection.getInputStream();
            final Reader r = new InputStreamReader(is, "UTF-8");

            map = JSON.decode(r);

            r.close();
            is.close();
        } catch (final MalformedURLException e) {
            throw new InstagramApiException(e);
        } catch (final IOException e) {
            throw new InstagramApiException(e);
        }

        return map;
    }


    /**
     * Search for media in a given area.
     *
     * @param lat
     * @param lng
     * @param maxTimestamp
     * @param minTimestamp
     * @param distance
     * @return
     * @throws InstagramApiException
     */
    @SuppressWarnings ("rawtypes")
    public Map getMediaSearch(final String lat, final String lng, final String maxTimestamp, final String minTimestamp, final String distance)
            throws InstagramApiException {

        if (isNotAccessToken()) {
            throw new InstagramApiException(E0001);
        }

        final StringBuffer sb = new StringBuffer(API_URL);
        sb.append("media/search");

        Map map = null;

        final List <Parameter> parameters = new ArrayList <Parameter>();
        parameters.add(new Parameter(InstagramConst.ACCESS_TOKEN, accessToken));
        if (lat != null) {
            parameters.add(new Parameter(InstagramConst.LAT, lat));
        }
        if (lng != null) {
            parameters.add(new Parameter(InstagramConst.LNG, lng));
        }
        if (maxTimestamp != null) {
            parameters.add(new Parameter(InstagramConst.MAX_TIMESTAMP, maxTimestamp));
        }
        if (minTimestamp != null) {
            parameters.add(new Parameter(InstagramConst.MIN_TIMESTAMP, minTimestamp));
        }
        if (distance != null) {
            parameters.add(new Parameter(InstagramConst.DISTANCE, distance));
        }

        try {
            final URL url = new URL(util.setUrlParameter(sb, parameters.toArray(new Parameter[parameters.size()])));
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            final InputStream is = connection.getInputStream();
            final Reader r = new InputStreamReader(is, "UTF-8");

            map = JSON.decode(r);

            r.close();
            is.close();
        } catch (final MalformedURLException e) {
            throw new InstagramApiException(e);
        } catch (final IOException e) {
            throw new InstagramApiException(e);
        }

        return map;
    }


    /**
     * Get a list of what media is most popular at the moment.
     *
     * @return
     * @throws InstagramApiException
     */
    @SuppressWarnings ("rawtypes")
    public Map getMediaPopular() throws InstagramApiException {

        if (isNotAccessToken()) {
            throw new InstagramApiException(E0001);
        }

        final StringBuffer sb = new StringBuffer(API_URL);
        sb.append("media/popular");

        Map map = null;

        try {
            final URL url = new URL(util.setUrlParameter(sb, new Parameter(InstagramConst.ACCESS_TOKEN, accessToken)));
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            final InputStream is = connection.getInputStream();
            final Reader r = new InputStreamReader(is, "UTF-8");

            map = JSON.decode(r);

            r.close();
            is.close();
        } catch (final MalformedURLException e) {
            throw new InstagramApiException(e);
        } catch (final IOException e) {
            throw new InstagramApiException(e);
        }

        return map;
    }


    /**
     * Get a list of what media is most popular at the moment.
     *
     * @return
     * @throws InstagramApiException
     */
    @SuppressWarnings ("rawtypes")
    public Map getUsers(String id) throws InstagramApiException {

        if (isNotAccessToken()) {
            throw new InstagramApiException(E0001);
        }

        String value = "self";

        if (id != null) {
            value = id;
        }

        final StringBuffer sb = new StringBuffer(API_URL);
        sb.append("/users/" + value + "/");

        Map map = null;

        try {
            final URL url = new URL(util.setUrlParameter(sb, new Parameter(InstagramConst.ACCESS_TOKEN, accessToken)));
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            final InputStream is = connection.getInputStream();
            final Reader r = new InputStreamReader(is, "UTF-8");

            map = JSON.decode(r);

            r.close();
            is.close();
        } catch (final MalformedURLException e) {
            throw new InstagramApiException(e);
        } catch (final IOException e) {
            throw new InstagramApiException(e);
        }

        return map;
    }

}
