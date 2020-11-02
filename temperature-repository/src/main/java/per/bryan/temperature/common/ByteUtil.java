package per.bryan.temperature.common;

/**
 * @Author:bryan.c
 * @Date:2020/11/2
 */
public class ByteUtil {
    public static int getUnsignedByte (byte data){     //将data字节型数据转换为0~255 (0xFF 即BYTE)。
        return data&0x0FF ;
    }
}
