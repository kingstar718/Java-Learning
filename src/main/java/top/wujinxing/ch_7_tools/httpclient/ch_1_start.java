package top.wujinxing.ch_7_tools.httpclient;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * @author wujinxing
 * date 2019/4/24 16:17
 * description
 */
public class ch_1_start {

    public static void main(String[] args) {
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建httpGEt
        String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=18888888888";
        HttpGet httpGet = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            HttpEntity httpEntity = response.getEntity();
            String responseStr = EntityUtils.toString(httpEntity);
            System.out.println(responseStr);
            TelResult result = new TelResult();
            String[] strings = responseStr.split(",");
            Deque<String> list = new LinkedList<>();
            for (String s: strings){
                list.offer(s.split(":")[1].split("'")[1]);
            }
            result.setMts(list.poll());
            result.setProvince(list.poll());
            result.setCatName(list.poll());
            result.setTelString(list.poll());
            result.setAreaVid(list.poll());
            result.setIsVid(list.poll());
            result.setCarrier(list.poll());
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class TelResult{
        private String mts;
        private String province;
        private String catName;
        private String telString;
        private String areaVid;
        private String isVid;
        private String carrier;

        public String getMts() {
            return mts;
        }

        public void setMts(String mts) {
            this.mts = mts;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCatName() {
            return catName;
        }

        public void setCatName(String catName) {
            this.catName = catName;
        }

        public String getTelString() {
            return telString;
        }

        public void setTelString(String telString) {
            this.telString = telString;
        }

        public String getAreaVid() {
            return areaVid;
        }

        public void setAreaVid(String areaVid) {
            this.areaVid = areaVid;
        }

        public String getIsVid() {
            return isVid;
        }

        public void setIsVid(String isVid) {
            this.isVid = isVid;
        }

        public String getCarrier() {
            return carrier;
        }

        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }

        @Override
        public String toString() {
            return "TelResult{" +
                    "mts='" + mts + '\'' +
                    ", province='" + province + '\'' +
                    ", catName='" + catName + '\'' +
                    ", telString='" + telString + '\'' +
                    ", areaVid='" + areaVid + '\'' +
                    ", isVid='" + isVid + '\'' +
                    ", carrier='" + carrier + '\'' +
                    '}';
        }
    }
}
