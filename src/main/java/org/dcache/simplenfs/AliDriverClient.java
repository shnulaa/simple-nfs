package org.dcache.simplenfs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class AliDriverClient {

    private static final Logger LOG = LoggerFactory.getLogger(AliDriverClient.class);

    private static final String BASE_URL = "https://websv.aliyundrive.com";

    private static final String REFRESH_TOKEN_URL = BASE_URL + "/token/refresh";

    private static final String API_BASE_URL = "https://api.aliyundrive.com";

    private static final String LIST_FILE_URL = API_BASE_URL + "/adrive/v3/file/list";

    private static final String GET_DIVER_INFO_URL = API_BASE_URL + "/v2/sbox/get";

    private static final String DEFAULT_PARENT_FILE_ID = "root";

    private String accessToken;
    private String tokenType;
    private String defaultDriveId;


    public static void main(String[] args) throws Exception {
        System.out.println("-------------------------------------------------------");
        AliDriverClient client = AliDriverClient.getInstance();
        client.refreshToken();
        System.out.println("-------------------------------------------------------");
        client.getDriverInfo();
        System.out.println("-------------------------------------------------------");
        client.listFile(DEFAULT_PARENT_FILE_ID);
        System.out.println("-------------------------------------------------------");
    }

    /**
     * refreshToken
     *
     * @throws Exception
     */
    public void refreshToken() {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 11_0_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36");
            headers.put("Content-Type", "application/json;charset=utf-8");

            Map<String, Object> params = new HashMap<>();
            params.put("refresh_token", "bf21eb6274484613be856e719ffa67d3");
            HttpClientResult httpClientResult = HttpClientUtils.doPost(REFRESH_TOKEN_URL, headers, params);
            System.out.println(httpClientResult);

            if (httpClientResult.getCode() == HttpStatus.SC_OK) {
                Map<String, Object> map = new ObjectMapper().readValue(httpClientResult.getContent(), new TypeReference<Map<String, Object>>() {
                });

                this.accessToken = (String) map.get("access_token");
                this.tokenType = (String) map.get("token_type");
                this.defaultDriveId = (String) map.get("default_drive_id");
            } else {
                throw new RuntimeException("refreshToken exception");
            }
        } catch (Exception e) {
            LOG.error("refreshToken exception.", e);
        }
    }

    /**
     * refreshToken
     *
     * @return
     * @throws Exception
     */
    public Map<String, Object> listFile(String parentFileId) {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 11_0_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36");
            headers.put("Content-Type", "application/json;charset=utf-8");
            headers.put("authorization", tokenType + " " + accessToken);

            Map<String, Object> params = new HashMap<>();
            params.put("all", false);
            params.put("drive_id", defaultDriveId);
            params.put("fields", "*");
            params.put("limit", 100);
            params.put("order_by", "updated_at");
            params.put("order_direction", "DESC");
            params.put("parent_file_id", parentFileId);
            params.put("url_expire_sec", 1600);

            HttpClientResult httpClientResult = HttpClientUtils.doPost(LIST_FILE_URL, headers, params);
            System.out.println(httpClientResult);

            if (httpClientResult.getCode() == HttpStatus.SC_OK) {
                return new ObjectMapper().readValue(httpClientResult.getContent(), new TypeReference<Map<String, Object>>() {
                });
            }
        } catch (Exception e) {
            LOG.error("listFile exception.", e);
        }
        return null;
    }

    /**
     * refreshToken
     *
     * @return
     * @throws Exception
     */
    public Map<String, Object> getDriverInfo() {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 11_0_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36");
            headers.put("Content-Type", "application/json;charset=utf-8");
            headers.put("authorization", tokenType + " " + accessToken);

            HttpClientResult httpClientResult = HttpClientUtils.doPost(GET_DIVER_INFO_URL, headers, null);
            System.out.println(httpClientResult);

            if (httpClientResult.getCode() == HttpStatus.SC_OK) {
                return new ObjectMapper().readValue(httpClientResult.getContent(), new TypeReference<Map<String, Object>>() {
                });
            }
        } catch (Exception e) {
            LOG.error("getDriverInfo exception.", e);
        }
        return null;
    }

    /**
     * SingletonHolder
     *
     * @author luyil
     */
    static class SingletonHolder {
        public static final AliDriverClient aliDriverClient = new AliDriverClient();
    }

    public static AliDriverClient getInstance() {
        return SingletonHolder.aliDriverClient;
    }

}
