package me.alex.serialporthelper;

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
public class PortData {
    /**
     * 串口发送或者返回的命令
     */
    private byte[] commands;

    /**
     * 串口发送或者返回的命令(hex)
     */
    private String commandsHex;

    public PortData(byte[] commands) {
        this.commands = commands;
        this.commandsHex = DataUtils.encodeHexString(commands);
    }

    public byte[] getCommands() {
        return commands;
    }

    public String getCommandsHex() {
        return commandsHex;
    }

}
