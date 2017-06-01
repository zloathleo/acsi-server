package com.safefire.acsiserver.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Leo on 2017/5/18.
 */
public class QRUtils {

    private static final String Utf8 = "UTF-8";
    private static final Charset CharsetUtf8 = Charset.forName(Utf8);

    private static final String format = "png";// 默认二维码文件格式
    private static final Map<EncodeHintType, Object> hints = new HashMap();// 二维码参数

    static {
        hints.put(EncodeHintType.CHARACTER_SET, Utf8);// 字符编码
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);// 容错等级 L、M、Q、H 其中 L 为最低, H 为最高
        hints.put(EncodeHintType.MARGIN, 2);// 二维码与图片边距
    }

    public static final String generateProjectQRCode(String projectCode) {
        try {
            return URLEncoder.encode(Base64.encodeBase64String(projectCode.getBytes(CharsetUtf8)), Utf8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return projectCode;
        }
//        return Base64.encodeBase64String(projectCode.getBytes(CharsetUtf8));
    }

    public static final String unGenerateProjectQRCode(String qrCode) {
        try {
            return URLDecoder.decode(new String(Base64.decodeBase64(qrCode), CharsetUtf8), Utf8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return qrCode;
        }
//        return new String(Base64.decodeBase64(qrCode),CharsetUtf8);
    }

    /**
     * 生成二维码图片
     *
     * @param content 二维码内容
     * @param width   宽
     * @param height  高
     */
    public static byte[] createQRCodeImage(String content, int width, int height) throws WriterException, IOException {
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        //toPath() 方法由 jdk1.7 及以上提供
        ByteArrayOutputStream out = new ByteArrayOutputStream(10240);
        MatrixToImageWriter.writeToStream(bitMatrix, format, out);
        return out.toByteArray();
    }

    /**
     * 生成二维码图片
     *
     * @param content 二维码内容
     * @return
     * @throws WriterException
     * @throws IOException
     */
    public static byte[] createQRCodeImage(String content) throws WriterException, IOException {
        return createQRCodeImage(content, 200, 200);
    }

}
