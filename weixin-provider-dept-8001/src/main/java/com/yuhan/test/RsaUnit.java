package com.yuhan.test;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuhan.util.DateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.codec.binary.Base64;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Login {
    private Map<String, PrivateKey> map=new HashMap<String, PrivateKey>();
//用户验证

 @RequestMapping("login")
 public void checkCode(HttpServletRequest request,HttpServletResponse response) throws Exception {
 System.out.println("开始登录");
response.setHeader("Charset", "UTF8");
response.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
String password = request.getParameter("password");
System.out.println("密文:"+password);
String publicKey = request.getParameter("publicKey");
PrivateKey privateKey =(PrivateKey)request.getSession().getAttribute("privateKey");
//         byte[] en_result = new BigInteger(password, 16).toByteArray();
        byte[] en_result= RsaUnit.hexStringToBytes(password);
        System.out.println(privateKey);
        byte[] de_result = RsaUnit.decrypt(privateKey,en_result);
        StringBuffer sb = new StringBuffer();
        sb.append(new String(de_result));
        String newpassword=sb.reverse().toString();
        System.out.println(newpassword);

//密钥用完之后删除掉map中的值

        if(map.get(publicKey)!=null){
   map.remove(publicKey);
}

}





 //生成密钥并将它放到map中
@RequestMapping("/getkey")
public void addkey(HttpServletRequest request,HttpServletResponse response) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{
response.setHeader("Charset", "UTF8");
response.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
Map<String, String> keyMap = RsaUnit.createKeys(1024);
String publicKeyString = keyMap.get("publicKey");
String privateKeyString = keyMap.get("privateKey");
RSAPublicKey rsaPublicKey=RsaUnit.getPublicKey(publicKeyString);
PrivateKey privateKey=RsaUnit.getPrivateKey(privateKeyString);
String Modulus=rsaPublicKey.getModulus().toString(16);
String Exponent=rsaPublicKey.getPublicExponent().toString(16);
System.out.println("Modulus:"+Modulus);
System.out.println("Exponent:"+Exponent);
map.put(Modulus, privateKey);
    request.getSession().setAttribute("privateKey",privateKey);
response.getWriter().write(Modulus);
 }
}

public  class RsaUnit {
public static final String CHARSET = "UTF-8";
public static final String RSA_ALGORITHM = "RSA";
public static Map<String, String> createKeys(int keySize){
 //为RSA算法创建一个KeyPairGenerator对象
 KeyPairGenerator kpg;
 try{
 kpg = KeyPairGenerator.getInstance(RSA_ALGORITHM);
}catch(NoSuchAlgorithmException e){
 throw new IllegalArgumentException("No such algorithm-->[" + RSA_ALGORITHM + "]");
}
//初始化KeyPairGenerator对象,密钥长度
kpg.initialize(keySize);
//生成密匙对
KeyPair keyPair = kpg.generateKeyPair();
//得到公钥
Key publicKey = keyPair.getPublic();
String publicKeyStr = Base64.encodeBase64URLSafeString(publicKey.getEncoded());

//得到私钥
Key privateKey = keyPair.getPrivate();
String privateKeyStr = Base64.encodeBase64URLSafeString(privateKey.getEncoded());
Map<String, String> keyPairMap = new HashMap<String, String>();
keyPairMap.put("publicKey", publicKeyStr);
keyPairMap.put("privateKey", privateKeyStr);
return keyPairMap;
}



/**
 * 得到公钥
 * @param publicKey 密钥字符串（经过base64编码）
 * @throws Exception
 */
public static RSAPublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
 //通过X509编码的Key指令获得公钥对象
 KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
 X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
 RSAPublicKey key = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
 return key;
}



/**

      * 得到私钥

      * @param privateKey 密钥字符串（经过base64编码）

      * @throws Exception

      */

public static RSAPrivateKey getPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
//通过PKCS#8编码的Key指令获得私钥对象
KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
RSAPrivateKey key = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
 return key;
}



 /**

      * 公钥加密

      * @param data

      * @param publicKey

      * @return

      */

public static String publicEncrypt(String data, RSAPublicKey publicKey){

 try{
     Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
cipher.init(Cipher.ENCRYPT_MODE, publicKey);
byte[] bs=rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET), publicKey.getModulus().bitLength());
 return Base64.encodeBase64URLSafeString(bs);
}catch(Exception e){

throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);

 }

}



/**

      * 私钥解密

      * @param data

      * @param privateKey

      * @return

      */



 public static String privateDecrypt(String data, RSAPrivateKey privateKey){
try{
Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
cipher.init(Cipher.DECRYPT_MODE, privateKey);
 byte[] bs=Base64.decodeBase64(data);
 return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, bs, privateKey.getModulus().bitLength()), CHARSET);
}catch(Exception e){
 throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
 }
}



public static String privateDecrypt(byte[] data, RSAPrivateKey privateKey){
try{
Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
cipher.init(Cipher.DECRYPT_MODE, privateKey);
return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, data, privateKey.getModulus().bitLength()), CHARSET);

}catch(Exception e){

throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);

}

}

/**

      * 私钥加密

      * @param data

      * @param privateKey

      * @return

      */


public static String privateEncrypt(String data, RSAPrivateKey privateKey){

try{

 Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);

cipher.init(Cipher.ENCRYPT_MODE, privateKey);

return Base64.encodeBase64URLSafeString(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET), privateKey.getModulus().bitLength()));

}catch(Exception e){

 throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);

}

}

 /**

      * 公钥解密

      * @param data

      * @param publicKey

      * @return

      */



public static String publicDecrypt(String data, RSAPublicKey publicKey){

 try{

 Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);

 cipher.init(Cipher.DECRYPT_MODE, publicKey);

return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data), publicKey.getModulus().bitLength()), CHARSET);
 }catch(Exception e){
throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
}
 }



private static byte[] rsaSplitCodec(Cipher cipher, int opmode, byte[] datas, int keySize){
int maxBlock = 0;
if(opmode == Cipher.DECRYPT_MODE){
 maxBlock = keySize / 8;
 }else{
maxBlock = keySize / 8 - 11;
 }

 ByteArrayOutputStream out = new ByteArrayOutputStream();

 int offSet = 0;

 byte[] buff;

 int i = 0;

 try{

 while(datas.length > offSet){

if(datas.length-offSet > maxBlock){

buff = cipher.doFinal(datas, offSet, maxBlock);

 }else{

 buff = cipher.doFinal(datas, offSet, datas.length-offSet);

 }

out.write(buff, 0, buff.length);

i++;

offSet = i * maxBlock;

 }

}catch(Exception e){

 throw new RuntimeException("加解密阀值为["+maxBlock+"]的数据时发生异常", e);

 }

 byte[] resultDatas = out.toByteArray();

 IOUtils.closeQuietly(out);

 return resultDatas;

}



public static byte[] hexStringToBytes(String hexString) {

 if (hexString == null || hexString.equals("")) {

return null;

 }

 hexString = hexString.toUpperCase();

 int length = hexString.length() / 2;

 char[] hexChars = hexString.toCharArray();

 byte[] d = new byte[length];

 for (int i = 0; i < length; i++) {

int pos = i * 2;

d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));

 }

return d;

}


    private static byte charToByte(char c) {

 return (byte) "0123456789ABCDEF".indexOf(c);

}



    /**

     * * 解密 *

     *

     * @param  \key

     *            解密的密钥 *

     * @param raw

     *            已经加密的数据 *

     * @return 解密后的明文 *

     * @throws Exception

     */

    public static byte[] decrypt(PrivateKey pk, byte[] raw) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("RSA",
                    new org.bouncycastle.jce.provider.BouncyCastleProvider());
            cipher.init(cipher.DECRYPT_MODE, pk);
            int blockSize = cipher.getBlockSize();
            ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
            int j = 0;
            while (raw.length - j * blockSize > 0) {
                bout.write(cipher.doFinal(raw, j * blockSize, blockSize));
                j++;
            }
            return bout.toByteArray();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }




//私钥解密
public static String privateKeyDecode(HttpServletRequest req,String s) throws Exception {
        String encodedData =req.getParameter(s);
        if(encodedData==null){
            return "0";
        }
        PrivateKey privateKey =(PrivateKey) req.getSession().getAttribute("privateKey");
        byte[] en_result= RsaUnit.hexStringToBytes(encodedData);
        System.out.println(privateKey);
        byte[] de_result = RsaUnit.decrypt(privateKey,en_result);
        StringBuffer sb = new StringBuffer();
        sb.append(new String(de_result));
        sb.reverse().toString();
        return sb.reverse().toString();
}



 public static void main(String[] args) throws Exception{

Map<String, String> keyMap = RsaUnit.createKeys(1024);
String publicKey = keyMap.get("publicKey");
String privateKey = keyMap.get("privateKey");

System.out.println("公钥:" + publicKey);

System.out.println("私钥:" + privateKey);

System.out.println("公钥加密——私钥解密");

RSAPublicKey rsaPublicKey=RsaUnit.getPublicKey(publicKey);

RSAPrivateKey rsaPrivateKey=RsaUnit.getPrivateKey(privateKey);

/*System.out.println(rsaPublicKey.getPublicExponent());
System.out.println(rsaPrivateKey.getPrivateExponent());*/
String modulus = rsaPublicKey.getModulus().toString();
 System.out.println(modulus);
 String str = "{\"user\":\"1234\";\"passWord\":\"123456\"}";
 System.out.println("\r明文：\r\n" + str);
 System.out.println("\r明文大小：\r\n" + str.getBytes().length);
 String encodedData = RsaUnit.publicEncrypt(str, RsaUnit.getPublicKey(publicKey));
 System.out.println("密文：\r\n" + encodedData);

 String decodedData = RsaUnit.privateDecrypt(encodedData, RsaUnit.getPrivateKey(privateKey));

 System.out.println("解密后文字: \r\n" + decodedData);
     System.out.println(Timestamp.valueOf(DateUtil.formate(new Date(),"yyyy-MM-dd HH:mm:ss")));

    }

}
/*

注：本案例的方法没有用到base64编码和解码，

        RsaUnit这个类中，只用到了生成密钥对和下面的hexStringToBytes（16进制转byte）和decrypt（解码方法）方法

        3.前台login.jsp（只将调取方法写在这里）
*/

   /*     function allWindow() {

        var isTrue;

        var userCode=document.getElementById("userCode").value;

        var password=document.getElementById("userPassword").value;

        password="abcd";

        var checkCode=document.getElementById("checkCode").value;

        if(""==userCode||""==password){

        alert("帐号和密码不能为空");

        }else{

        url= "<%=basePath%>loginAction/getkey.do";

        $.post(url,null,function(data){

        if(data!=null){

        setMaxDigits(130);

        var key = new RSAKeyPair("10001","",data);

        var result = encryptedString(key, encodeURIComponent(password));

        url="<%=basePath%>loginAction/login.do?userCode="+userCode+"&password="+result+"&checkCode="+checkCode+"&publicKey="+data;

        var str= "a=" + Math.random() * 1000;

        url=url+"&"+str;

        $.post(url,null,function(data){

        if(data!='成功'){

        alert(data);

        }else{

         var strURL = "<%=basePath%>public/jsp/main.jsp";

        fm.action=strURL;

        fm.submit();

        }

        },'JSON');

        }else{

alert("加密失败");

        }
},'JSON');
}
        }
        首先再提一下setMaxDigits()，要注意里面的参数，1024位对应130,2048位对应260。

本来应该将Modulus和Exponent都传到前台的，但是偷懒了Exponent没传，因为Exponent是固定值16进制的10001，原值是10进制的65537.Modulus和Exponent都是16进制，在Login里面转换过

        jsp页面是异步的！jsp页面是异步的！jsp页面是异步的！

      重要的事情说3遍。

      本来var key = new RSAKeyPair("10001","",data);这个方法是放在外面的，因为jsp页面是异步的，所以它在执行下一步

     var result = encryptedString(key, encodeURIComponent(password));的时候，key值还没取到，页面会卡死。

     所以我直接吧他放到方法里面了。

    这个页面还要引入

BigInt.js  – 用于生成一个大整型；（这是RSA算法的需要）
RSA.js    – RSA的主要算法；
Barrett.js – RSA算法所需要用到的一个支持文件；

这3个页面
*/
