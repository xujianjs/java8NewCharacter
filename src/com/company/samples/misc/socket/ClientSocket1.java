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
public class ClientSocket1 {

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
      //刷新输入流
      bufferedWriter.flush();

      //传递消息有两种方式 :
      // ①socket.close()
      // Once a socket has been closed, it is not available for further networking
      // 这个如果关闭了的话，客户端传递过来的消息就获取不到了 ==慎用！
      // ②shutdownOutput()
      // If you write to a socket output stream after invoking  shutdownOutput() on the socket, the stream will throw an IOException.
      // 调用了关闭输出流的话，客户端仍能够接受到server的消息，但是不能再去写了，应为输出流已经关闭

      //关闭socket的输出流
//      socket.close();
      socket.shutdownOutput();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
