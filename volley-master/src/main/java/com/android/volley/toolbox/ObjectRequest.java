package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.analysis.Analysis;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Created by kocomer on 2017/3/23.
 */

public class ObjectRequest<T> extends Request<T> {
    private Analysis<T> analysis;
    private final Response.Listener<T> mListener;

    public ObjectRequest(int method, String url, Response.Listener<T> mListener, Response.ErrorListener listener, Analysis<T> analysis) {
        super(method, url, listener);
        this.mListener = mListener;
        this.analysis = analysis;
    }

    @Override
    public Response<T> parseNetworkResponse(NetworkResponse response) throws JSONException {
        String json = new String(response.data);
        JSONObject jsonObject = new JSONObject(json);
        return Response.success(analysis.analysis(jsonObject), HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    public void deliverResponse(T response) {
        mListener.onResponse(response);
    }


}
