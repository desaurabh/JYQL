/*
 * Copyright 2014 masterOpti.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package data.engine.request.builder;

import data.engine.response.unmarshaller.BufferedResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.io.IOUtils;

public class RequestBuilder extends BufferedResponse {

    private String baseURL;

    public RequestBuilder() {

    }

    public RequestBuilder(String authenticationType) {
        if (O_AUTH == authenticationType) {
            baseURL = BASE_URL + O_AUTH;

        } else if (PUBLIC == authenticationType) {
            baseURL = BASE_URL + PUBLIC;

        } else {
            System.out.println("Error in request builder, authentication type is invalid");
        }
    }

    @Override
    public BufferedReader makeRequest(String query, String format, boolean diagnosticValue) {
        String diagnostic = "&diagnostic=";
        BufferedReader br = null;
        if (diagnosticValue) {
            diagnostic += true;
        } else {
            diagnostic += false;
        }

        if (query.length() > 10) {
            baseURL += EncodeQuery(query) + format + diagnostic;
            try {

                URL url = new URL(baseURL);
                br = getResponse(url);
            } catch (MalformedURLException e) {
                System.out.println("Unable to parse URL");
                e.printStackTrace();
            }

        } else {
            System.out.println("Error occured while making the request");
        }
        return br;
    }

    private BufferedReader getResponse(URL url) {

        try {
            setBufferedResponse(new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8")));

        } catch (IOException e) {
            System.out.println("Error occured while opening url stream");
            e.printStackTrace();
        }
        if (getBufferedResponse() != null) {
            try {
                setJsonResponse(IOUtils.toString(getBufferedResponse()));

            } catch (IOException e1) {
                System.out.println("Error occured while converting Buffered stream to string");
                e1.printStackTrace();
            }
        }
        return getBufferedResponse();
    }

    public void closeResponse() {
        try {
            getBufferedResponse().close();
        } catch (IOException e) {
            System.out.println("Error occured while closing the buffered reader");
            e.printStackTrace();
        }

    }

    private String EncodeQuery(String query) {
        String str = "";
        try {
            str = URIUtil.encodeQuery(query);
        } catch (URIException ex) {
            System.out.println("Unable to encode request query " + ex.getStackTrace());
        }
        return str;
    }

}
