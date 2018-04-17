package com.logmaster.application.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * http 请求工具类
 *
 * @author d.d
 */
public class HttpUtil {
    /**
     * post.
     **/

    public static String post(String url, String requestBody) {
        //创建连接
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGetWithEntity httpGet = new HttpGetWithEntity(url);
        try {
            StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
            httpGet.setEntity(entity);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            return request(response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * post方法.
     *
     * @param url    请求的http地址
     * @param names  参数名称[]
     * @param values 参数值[]
     * @return 返回请求结果
     */
    public static String post(String url, String[] names, Object[] values) {
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        if (names != null) {
            if (values == null || names.length != values.length) {
                throw new RuntimeException("参数和值的数组长度不相等");
            }
            //post参数
            for (int i = 0; i < names.length; i++) {
                if (Check.notEmpty(names[i])) {
                    continue;
                }
                NameValuePair param = new BasicNameValuePair(names[i], values[i].toString());
                formParams.add(param);
            }
        }
        //创建连接
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);

        UrlEncodedFormEntity uefEntity;
        try {
            //发送请求，得到结果
            uefEntity = new UrlEncodedFormEntity(formParams, "utf-8");
            httppost.setEntity(uefEntity);
            CloseableHttpResponse response = httpClient.execute(httppost);
            return request(response);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static String post(List<NameValuePair> formParams, CloseableHttpClient httpClient,
                               HttpPost httppost) {
        UrlEncodedFormEntity uefEntity;
        try {
            //发送请求，得到结果
            uefEntity = new UrlEncodedFormEntity(formParams, "utf-8");
            httppost.setEntity(uefEntity);
            CloseableHttpResponse response = httpClient.execute(httppost);
            return request(response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static JSONObject getJson(String url, String requestBody) throws JSONException {
        System.out.println(post(url, requestBody));
        return new JSONObject(post(url, requestBody));
    }

    private static String request(CloseableHttpResponse response) throws IOException {
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity, "utf-8");
            }
        } finally {
            response.close();
        }
        return null;
    }


    /**
     * get.
     *
     * @param url    请求地址
     * @param names  参数名称[]
     * @param values 参数值[]
     * @return 返回请求结果
     */
    public static String get(String url, String[] names, Object[] values) {
        //返回结果集
        String result = null;
        //创建连接
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //追加参数
        if (names.length > 0) {
            url = changeUrl(url, names, values).toString();
        }

        HttpGet httpget = new HttpGet(url);
        addHeader(httpget);
        try {
            CloseableHttpResponse response = httpClient.execute(httpget);
            result = request(response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static StringBuffer changeUrl(String url, String[] names, Object[] values) {
        StringBuffer sbUrl = new StringBuffer();
        sbUrl.append(url);
        try {
            String flag = "?";
            if (url.contains(flag)) {
                for (int i = 0; i < names.length; i++) {
                    sbUrl.append("&").append(names[i]).append("=").append(values[i]);
                }
            } else {

                for (int i = 0; i < names.length; i++) {
                    if (i == 0) {
                        sbUrl.append("?").append(names[i]).append("=").append(URLEncoder.encode(values[i]
                                .toString(), "utf-8"));

                    } else {
                        sbUrl.append("&").append(names[i]).append("=").append(URLEncoder.encode(values[i]
                                .toString(), "utf-8"));
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sbUrl;
    }

    private static void addHeader(HttpGet httpget) {
        httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpget.addHeader("Connection", "Keep-Alive");
        httpget.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
        httpget.addHeader("Cookie", "");
    }
}
