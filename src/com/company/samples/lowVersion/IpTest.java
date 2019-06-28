package com.company.samples.lowVersion;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.junit.Test;

/**
 * @ClassName IpTest
 * @Description TODO
 * @Author xujianThinkPad
 * @Date 2019/6/28 15:14
 * @ModifyDate 2019/6/28 15:14
 * @Version 1.0
 */
public class IpTest {

	/**
	 *      * Purpose:ping ip      * @author Hermanwang      * @param ipAddress:ip      * @throws
	 * Exception      * @return boolean     
	 */

	public static boolean pingIp(String ipAddress) throws Exception {
//此处 3是超时时间,单位是秒
		return 0 == Runtime.getRuntime().exec("ping -w 3 " + ipAddress).waitFor();
	}

	/**
	 *      * Purpose:ping host或者 port      * @author Hermanwang      * @param ipAddress:ip      *
	 * @param port:port/host      * @throws Exception      * @return boolean     
	 */

	public static boolean pingHost(String ipAddress, int port) throws Exception {
		boolean isReachable = false;
		Socket connect = new Socket();
		try {
			InetSocketAddress endpointSocketAddr = new InetSocketAddress(ipAddress, port);
//此处3000是超时时间,单位 毫秒
			connect.connect(endpointSocketAddr, 3000);
			isReachable = connect.isConnected();
		} catch (Exception e) {
			System.out.println(e.getMessage() + ", ip = " + ipAddress + ", port = " + port);
		} finally {
			if (connect != null) {
				try {

					connect.close();
				} catch (IOException e) {
					System.out.println(e.getMessage() + ", ip = " + ipAddress + ", port = " + port);
				}
			}
		}
		return isReachable;
	}

	public static void main(String[] args) throws Exception {



		// 创建一个新计时器
		Timer timer = new Timer();

		while (true) {
			boolean coming = pingIp("172.18.7.116");
			if (!coming) {
				JOptionPane op = new JOptionPane("网儿，你去哪了？╮(╯▽╰)╭",JOptionPane.WARNING_MESSAGE);
				JDialog dialog = op.createDialog("116检测");
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setAlwaysOnTop(true);
				dialog.setModal(false);
				dialog.setVisible(true);
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						dialog.setVisible(false);
						dialog.dispose();
					}
				}, 1000);
//				op.showMessageDialog(null, "网儿，你去哪了？╮(╯▽╰)╭");
			}
			System.out.println(coming);
//			System.out.println(pingIp("172.18.3.103"));
		}

	}

	@Test
	public void internet() throws Exception {
		// 创建一个新计时器
		Timer timer = new Timer();

		while (true) {
			boolean coming = pingIp("221.237.156.241");
			if (!coming) {
				JOptionPane op = new JOptionPane("网儿，你去哪了？╮(╯▽╰)╭",JOptionPane.WARNING_MESSAGE);
				JDialog dialog = op.createDialog("公司外网检测");
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setAlwaysOnTop(true);
				dialog.setModal(false);
				dialog.setVisible(true);
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						dialog.setVisible(false);
						dialog.dispose();
					}
				}, 1000);
			}
			System.out.println(coming);
		}
	}
}