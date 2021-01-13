package me.alex.serialporthelper;

/**
 * ================================================
 * Description:
 * <p>
 * Created by Alex on 2021/1/14
 * <p>
 * 页面内容介绍: 串口配置类
 * <p>
 * ================================================
 */
public class SerialPortConfig {
    /**
     * 串口地址
     */
    public String path;
    /**
     * 波特率 默认9600
     */
    public int baudRate = 9600;
    /**
     * 数据位 取值 位 7或 8 默认8
     */
    public int dataBits = 8;
    /**
     * 停止位 取值 1 或者 2 默认1
     */
    public int stopBits = 1;
    /**
     * 校验类型 取值 N ,E, O 默认n 不区分大小写
     */
    public char parity = 'n';

    /**
     * 是否使用原始模式(Raw Mode)方式来通讯 默认0
     * 取值 0=nothing,
     * 1=Raw mode,
     * 2=no raw mode
     */
    public int mode = 0;
}
