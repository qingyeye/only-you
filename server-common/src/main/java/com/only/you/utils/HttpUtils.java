package com.only.you.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.*;
import java.util.Map;


public class HttpUtils {


	private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

   public static String instanceFollowRedirects(String url){
       HttpURLConnection conn = null;
       try {
           conn = (HttpURLConnection) new URL(url).openConnection();

       conn.setInstanceFollowRedirects(false);
       conn.setConnectTimeout(5000);
       } catch (IOException e) {
           e.printStackTrace();
       }
      return conn.getHeaderField("Location");
   }
	 /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
	public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url + param);
            ////log.info("RestUtil.sendGet：{}",realUrl);
            //log.info("RestUtil.sendGet.url：{}",url);
            //log.info("RestUtil.sendGet.param：{}",param);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	log.error("RestUtil.sendGet发送GET请求出现异常：{}" ,e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                log.error("关闭输入流:",e2);
            }
        }
        return result;
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendPushMassageGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url + param);
            log.info("RestUtil.sendGet：{}",realUrl);
            //log.info("RestUtil.sendGet.url：{}",url);
            //log.info("RestUtil.sendGet.param：{}",param);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.setRequestProperty("Authorization","Basic N2Q0MzFlNDJkZmE2YTZkNjkzYWMyZDA0OjVlOTg3YWM2ZDJlMDRkOTVhOWQ4ZjBkMQ==");
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            log.error("RestUtil.sendGet发送GET请求出现异常：{}" ,e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                log.error("关闭输入流:",e2);
            }
        }
        return result;
    }
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGetEcoTKL(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url + param);
            log.info("RestUtil.sendGet：{}",realUrl);
            //log.info("RestUtil.sendGet.url：{}",url);
            //log.info("RestUtil.sendGet.param：{}",param);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(2000);
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            log.error("RestUtil.sendGet发送GET请求出现异常：{}" ,e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                log.error("关闭输入流:",e2);
            }
        }
        return result;
    }
	 /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
	public static String sendGet(String url, Map<String, Object> param) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url + urlencode(param));
            log.info("RestUtil.sendGet：{}",realUrl);
            //log.info("RestUtil.sendGet.url：{}",url);
            //log.info("RestUtil.sendGet.param：{}",param);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	log.error("RestUtil.sendGet发送GET请求出现异常：{}" ,e);
            return null;
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                log.error("关闭输入流:",e2);
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, Map<String, Object> param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            log.info("RestUtil.sendPost：{}",realUrl);
            //log.info("RestUtil.sendPost.url：{}",url);
            //log.info("RestUtil.sendPost.param：{}",param);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            //out.print(urlencode(param));
            conn.getOutputStream().write(urlencode(param).getBytes());
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	log.error("RestUtil.sendPost发送 POST 请求出现异常：{}",e);
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                log.error("关闭输出流,输入流:",ex);
            }
        }
        return result;
    }

	public static String sendPost2(String urlString, String param){
		String result=null;
		InputStream is=null;
		try {
			URL url=new URL(urlString);
			log.info("RestUtil.sendPost2：{}",url);
			HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();
			//post请求需要设置DoOutput为true
			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod("POST");
			//设置参数
			urlConnection.getOutputStream().write(param.getBytes());
			urlConnection.getOutputStream().flush();
			urlConnection.setConnectTimeout(5*1000);
			urlConnection.setReadTimeout(5*1000);
			//连接服务器
			urlConnection.connect();
			StringBuilder stringBuilder=new StringBuilder();
			if(urlConnection.getResponseCode()==HttpURLConnection.HTTP_OK){
				is=urlConnection.getInputStream();
				int len=0;
				byte[] buffer=new byte[1024];
				while ((len=is.read(buffer))!=-1) {
					stringBuilder.append(new String(buffer,0,len));
				}
					result= stringBuilder.toString();
			}
			} catch (MalformedURLException e) {
				log.error("RestUtil.sendPost发送 POST 请求出现异常：{}",e);
				return null;
			} catch (IOException e) {
				log.error("RestUtil.sendPost发送 POST 请求出现异常：{}",e);
				return null;
			}finally {
				if(is!=null){
					try {
						is.close();
					} catch (IOException e) {
						log.error("RestUtil.sendPost发送 POST 请求出现异常：{}",e);
					}
				}
			}
		return result;
	}

	/**
	 * 对发送过来的urlencode进行格式转换
	 * 将map里的参数变成像 showapi_appid=###&showapi_sign=###&的样子
	 * @param data
	 * @return
	 */
	public static String urlencode(Map<String,Object> data) {
		if(data != null){
	      StringBuilder sb = new StringBuilder();
	      for (@SuppressWarnings("rawtypes") Map.Entry i : data.entrySet()) {
	          try {
	        	 //if("couponUrl".equals(i.getKey()) || "appkey".equals(i.getKey())) {
	        		//sb.append(i.getKey()).append("=").append(i.getValue()).append("&");
	        	 //}else {
	        		  sb.append(i.getKey()).append("/").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("/");
	        	  //}
	          } catch (UnsupportedEncodingException e) {
	              log.error("错误:",e);
	          }
	      }
	      //log.info("RestUtil.urlencode参数：{}",sb.toString().substring(0,sb.toString().length()-1).toString());
	      return sb.toString().substring(0,sb.toString().length()-1);
		}else{
			return "";
		}
	  }


    public static String getRestTemplate(String url,String params){
	    url = url+params;
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        httpHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return exchange.getBody();
    }
}
