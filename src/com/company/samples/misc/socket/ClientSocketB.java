package com.company.samples.misc.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * description  socket客户端通过writer不停的写操作 往server发送消息  server端不停的检测客户端的传入消息
 * @author xujianghrx@gmail.com
 * @version 1.0
 * @date 2019/6/16 15:13
 * @className ClientSocket
 * @see https://www.jianshu.com/p/cde27461c226
 */
public class ClientSocketB {

  /*
   * description  客户端往服务端socket发送消息
   * @param       args
   * @return void
   * @date 2019/6/16 15:14
   * @author xujianghrx@gmail.com
   */
  public static void main(String[] args) {

    try {
      //初始化一个socket 指定server
      Socket socket = new Socket("127.0.0.1",9999);
      //通过socket获取BufferedWriter（拿来一辆大卡车  准备囤货）
      //BufferedWriter：Writes text to a character-output stream, buffering characters so as to
      // * provide for the efficient writing of single characters, arrays, and strings.
      BufferedWriter bufferedWriter = new BufferedWriter(
          new OutputStreamWriter(socket.getOutputStream()));
      //通过标准输入流获取字符流
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));

      while (true) {
        String msg = bufferedReader.readLine();
        bufferedWriter.write(msg);
        bufferedWriter.write("\n");
        //冲啊
        bufferedWriter.flush();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
