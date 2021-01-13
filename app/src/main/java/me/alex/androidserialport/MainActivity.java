package me.alex.androidserialport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.math.BigInteger;

import me.alex.serialporthelper.DataUtils;
import me.alex.serialporthelper.PortData;
import me.alex.serialporthelper.SerialPortConfig;
import me.alex.serialporthelper.SerialPortHelper;
import me.alex.serialporthelper.SphResultCallback;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "SerialPort";
    private SerialPortHelper serialPortHelper;
    private SerialPortConfig config;
    private static byte[] openLoad = new byte[]{(byte) 0xA5, 0x04, (byte) 0x01, 0x00, 0x65, (byte) 0xF1};

    private PortDemo portDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        //第一种打开方式,使用config的配置
        boolean isOpen = serialPortHelper.openDevice();
        //判断是否打开设备
        Log.d(TAG, isOpen ? "串口打开成功" : "串口打开失败");
        //第二种打开方式, 默认数据位8 校验类型n 停止位1 mode 0
        //serialPortHelper.openDevice("dev/ttysWK3", 9600);

        //添加数据监听
        serialPortHelper.setSphResultCallback(new SphResultCallback() {

            @Override
            public void onReceiveData(PortData data) {
//                String str = DataUtils.encodeHexString(data);
                Log.i(TAG, data.getCommandsHex());
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete");
            }
        });

        //发送数据
        serialPortHelper.send(openLoad);

        portDemo = new PortDemo();
        portDemo.init();
        portDemo.start();
    }

    @Override
    protected void onDestroy() {
        portDemo.stop();
        try {
            if (serialPortHelper.isOpenDevice()) {
                serialPortHelper.closeDevice();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            serialPortHelper = null;
        }
        super.onDestroy();
    }
}