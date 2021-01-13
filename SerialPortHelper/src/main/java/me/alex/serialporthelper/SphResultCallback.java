package me.alex.serialporthelper;

/**
 * ================================================
 * Description:
 * <p>
 * Created by Alex on 2021/1/14
 * <p>
 * 页面内容介绍: 串口数据回调
 * <p>
 * ================================================
 */
public interface SphResultCallback {
    /**
     * 收到的数据
     *
     * @param data 串口收到的数据
     */
    void onReceiveData(PortData data);

    /**
     * 发送，收取完成
     */
    void onComplete();
}
