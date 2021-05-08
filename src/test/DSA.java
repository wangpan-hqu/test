package test;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
public class DSA {
	
	 private static final String KEY_ALGORITHM="RSA";
	    private static final String SIGNATURE_ALGORITHM="MD5withRSA";
	    private static final String PUBLIC_KEY="RSAPublicKey";
	    private static final String PRIVATE_KEY="RSAPrivateKey";
	    /**
	     * RSA密匙长度，默认是1024位，密匙长度必须是在64的倍数
	     * 范围是512--65536之间
	     *
	     */
	    private static final int KEY_SIZE = 512;

	    public static void main(String[] args) throws Exception {
            long a=System.currentTimeMillis();
	        String str = "helloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwphelloiamwp";
	        Map<String, Object> map = initKey();
	        byte[] privateKey = getPrivateKey(map);
	        //签名
	        byte[] signData = sign(str.getBytes(), privateKey);
//	        System.out.println("signData: " + Base64.getMimeEncoder(64,  signData));
	        //校验
	        byte[] pulicKey = getPulicKey(map);
	        boolean status = verify(str.getBytes(), pulicKey, signData);
	        System.out.println("verify result: " + status);
	        System.out.println(System.currentTimeMillis()-a);

	    }

	    /**
	     *
	     * @param data 待校验的数据
	     * @param key 公钥
	     * @param sign 数据签名
	     * @return boolean 校验成功返回true,否则返回false
	     * @throws Exception
	     */
	    public static boolean verify(byte[] data,byte[] key,byte[] sign)throws Exception{
	        //获取公钥
	        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
	        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
	        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
	        //校验数据
	        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
	        signature.initVerify(publicKey);
	        signature.update(data);
	        return signature.verify(sign);
	    }
	    /**
	     * 私钥签名
	     * @param data 待签名数据
	     * @param key 私钥
	     * @return byte[] 加密数据
	     * @throws Exception
	     */
	    public static byte[] sign(byte[] data,byte[] key) throws Exception {
	        //获取私钥
	        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
	        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
	        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
	        //签名
	        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
	        signature.initSign(privateKey);
	        signature.update(data);
	        return signature.sign();
	    }
	    /**
	     * 获取私钥
	     * @param keyMap
	     * @return
	     */
	    public static byte[] getPrivateKey(Map<String,Object> keyMap){
	        Key key = (Key) keyMap.get(PRIVATE_KEY);
	        return key.getEncoded();
	    }
	    /**
	     * 获取公钥
	     * @param keyMap
	     * @return
	     */
	    public static byte[] getPulicKey(Map<String,Object> keyMap){
	        Key key = (Key) keyMap.get(PUBLIC_KEY);
	        return key.getEncoded();

	    }
	    /**
	     * 初始化密匙对
	     * @return Map 密钥map
	     * @throws Exception
	     */
	    public static Map<String,Object> initKey() throws Exception {
	        //实例化密钥对生成器
	        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
	        //初始化
	        keyPairGenerator.initialize(KEY_SIZE);
	        //生成密匙对
	        KeyPair keyPair = keyPairGenerator.genKeyPair();
	        //私钥
	        RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();
	        //公钥
	        RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
	        //封装密钥
	        HashMap<String, Object> map = new HashMap<>(2);
	        map.put(PUBLIC_KEY,publicKey);
	        map.put(PRIVATE_KEY,privateKey);
	        return map;
	    }

}
