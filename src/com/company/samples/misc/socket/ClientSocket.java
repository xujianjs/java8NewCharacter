package com.company.samples.misc.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * description  socket客户端测试
 * @author xujianghrx@gmail.com
 * @version 1.0
 * @date 2019/6/16 15:13
 * @className ClientSocket
 * @see https://www.jianshu.com/p/cde27461c226
 */
public class ClientSocket {

  /*
   * description  客户端往服务端socket发送消息
   * @param       args
   * @return void
   * @date 2019/6/16 15:14
   * @author xujianghrx@gmail.com
   */
  public static void main(String[] args) {

    //指定server
    try {
      Socket socket = new Socket("127.0.0.1",9999);

      //写入内容到缓冲区
      BufferedWriter bufferedWriter = new BufferedWriter(
          new OutputStreamWriter(socket.getOutputStream()));
      String clientMsg = "你好啊，别来无恙啊！";
      bufferedWriter.write(clientMsg);
      //由于服务端始终在端口上有无客户端接入  这是个阻塞操作
      //同时读客户端消息 也是耗时的阻塞操作  （如果没人通知它客户端消息已经传送完毕  服务端会抛出java.net.SocketException: Connection reset）
      //所以我们需要在客户端手动给server一个标记  宝宝的消息已经传递完毕啦

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
