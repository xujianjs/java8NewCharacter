package com.company.samples.misc.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * description  socket服务端开启多线程  每连接一个客户端开启一个线程（注意测试这样写没问题 实际生产肯定得用线程池 不然就是脑子进水哦）
 * @author xujianghrx@gmail.com
 * @version 1.0
 * @date 2019/6/16 15:13
 * @className ServerSocketTest
 * @see https://www.jianshu.com/p/cde27461c226
 */
public class ServerSocketConcurrentTest {

  public static void main(String[] args) throws IOException {

    // 初始化服务端socket并且绑定9999端口
    ServerSocket serverSocket = new ServerSocket(
        9999);

    while (true) {
      //等待客户端的连接
      Socket socket = serverSocket.accept();

      //每当有一个客户端连接进来后，就启动一个单独的线程进行处理
      new Thread(new Runnable() {
        @Override
        public void run() {
          //获取输入流,并且指定统一的编码格式
          BufferedReader bufferedReader = null;
          try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            // 读取一行数据     
            String str;

            //通过while循环不断读取信息，
            while ((str=bufferedReader.readLine())!=null) {
              // 输出打印           
              System.out.println("客户端说："+str);
            }
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }).start();

    }


  }
}
