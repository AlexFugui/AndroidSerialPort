package me.alex.androidserialport;

import android.util.Log;

import me.alex.serialporthelper.PortData;
import me.alex.serialporthelper.SerialPortConfig;
import me.alex.serialporthelper.SerialPortHelper;
import me.alex.serialporthelper.SphResultCallback;

/**
 * ================================================
 * Description:
 * <p>
 * Created by Alex on 2021/1/14
 * <p>
 * 页面内容介绍:
 * <p>
 * ================================================
 */
public class PortDemo {
    private static final String TAG = "PortDemo";
    private SerialPortHelper serialPortHelper;
    private SerialPortConfig config;

    public void init() {
        serialPortHelper = new SerialPortHelper(32);//接收的数据长度
        config = new SerialPortConfig();
        // 是否使用原始模式(Raw Mode)方式来通讯
        config.mode = 0;
        // 串口地址 [ttyS0 ~ ttyS6, ttyUSB0 ~ ttyUSB4]
        config.path = "dev/ttysWK0";
        // 波特率
        config.baudRate = 115200;
        // 数据位 [7, 8]
        config.dataBits = 8;
        // 检验类型 [N(无校验) ,E(偶校验), O(奇校验)] (大小写随意)
        config.parity = 'n';
        // 停止位 [1, 2]
        config.stopBits = 1;
        serialPortHelper.setConfigInfo(config);
        //添加数据监听
        serialPortHelper.setSphResultCallback(new SphResultCallback() {

            @Override
            public void onReceiveData(PortData data) {
                Log.i(TAG, data.getCommandsHex());
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete");
            }
        });
    }

    public void start() {
        boolean isOpen = serialPortHelper.openDevice("dev/ttysWK3", 9600);
        //判断是否打开设备
        Log.d(TAG, isOpen ? "串口打开成功" : "串口打开失败");
    }

    public void stop() {
        Log.d(TAG, "stop");
        try {
            if (serialPortHelper.isOpenDevice()) {
                serialPortHelper.closeDevice();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            serialPortHelper = null;
        }
    }
}
