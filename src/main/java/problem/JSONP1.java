package problem;

import net.sf.json.JSONObject;

/**
 * @author duzj
 * @create 2019-08-12 20:02
 *
 * json问题  net.sf.json-lib对5.0 double这种解析会变为5
 */
public class JSONP1 {
    public static void main(String[] args) {
        String a = "{\"num\":5.0}";
        JSONObject jsonObject = JSONObject.fromObject(a);
        System.out.println(jsonObject);

        com.alibaba.fastjson.JSONObject jsonObject1 = com.alibaba.fastjson.JSONObject.parseObject(a);
        System.out.println(jsonObject1);
    }
}
