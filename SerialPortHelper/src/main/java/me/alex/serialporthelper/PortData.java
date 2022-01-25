package me.alex.serialporthelper;

import java.nio.charset.StandardCharsets;

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

    /**
     * 串口发送或者返回的命令(ascii)
     */
    private String commandsASCII;

    public PortData(byte[] commands) {
        this.commands = commands;
        this.commandsHex = DataUtils.encodeHexString(commands);
        this.commandsASCII = new String(commands, StandardCharsets.UTF_8);
    }

    public byte[] getCommands() {
        return commands;
    }

    public String getCommandsHex() {
        return commandsHex;
    }

    public String getCommandsASCII() {
        return commandsASCII;
    }
}
