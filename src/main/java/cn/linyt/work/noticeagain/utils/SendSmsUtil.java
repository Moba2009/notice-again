package cn.linyt.work.noticeagain.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @ClassName SendSmsUtil
 * @Description TODO
 * 发送短信
 * //生成6位随机数
 * String checkcode = RandomStringUtils.randomNumeric(6);
 * @Author Mojo
 * @Date 2020/4/9 2:02
 * @Version 1.0
 **/
public class SendSmsUtil {

    public static boolean sendMsg(String phoneNum, String msg) throws ClientException {

        if (null == phoneNum || "".equals(phoneNum)) {
            return false;
        }

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<accessKeyId>", "<accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "13570580079");
        request.putQueryParameter("SignName", "签名");
        request.putQueryParameter("TemplateCode", "模板id");
        request.putQueryParameter("TemplateParam", "短信模板变量对应的实际值，JSON格式。");

        CommonResponse response = client.getCommonResponse(request);
        if (null != response.getData() && "OK".equals(response.getData())) {
            System.out.println(response.getData());
            return true;
        } else {
            System.out.println(response.getData());
            return false;
        }
    }
}
