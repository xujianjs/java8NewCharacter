package com.company.samples.misc.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * description  socket服务端测试
 * @author xujianghrx@gmail.com
 * @version 1.0
 * @date 2019/6/16 15:13
 * @className ServerSocketTest
 * @see https://www.jianshu.com/p/cde27461c226
 */
public class ServerSocketTest {

  public static void main(String[] args) {
    try {
      // 初始化服务端socket并且绑定9999端口
      ServerSocket serverSocket = new ServerSocket(
          9999);
      //等待客户端的连接           
      Socket socket = serverSocket.accept();
      //获取输入流           
      BufferedReader bufferedReader = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));
      // 读取一行数据           
      String str = bufferedReader.readLine();
      // 输出打印           
      System.out.println(str);
    } catch (IOException e) {
      e.printStackTrace();

    }
  }
}
