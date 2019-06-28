package com.company.samples.lowVersion;


import org.junit.Test;

/**
 * @ClassName DelegateMode
 * @Description 代理模式 把分给自己的任务委派给其它“人”来完成，这就好比租房子找中介代理一样 分析中介代理的模式： 1、首先得有需求：租售房子； 2、其次得有房主和中介；
 * 3、具体的租售合同
 * @Author xujianThinkPad
 * @Date 2019/6/28 10:56
 * @ModifyDate 2019/6/28 10:56
 * @Version 1.0
 */
public class DelegateMode {

	/*房主*/
	class HouseOwner implements RentAndSale {

		@Override
		public void rent() {
			System.out.println("房主自己出租...");
		}

		@Override
		public void sale() {
			System.out.println("房主自己售卖...");
		}
	}

	/*中介*/
	class Agent implements RentAndSale {

		@Override
		public void rent() {
			System.out.println("中介帮忙出租...");
		}

		@Override
		public void sale() {
			System.out.println("中介帮忙售卖...");
		}
	}

	/*租售*/
	interface RentAndSale {

		//租
		void rent();

		//售
		void sale();

	}


	class Delegate implements RentAndSale {

		private RentAndSale rentAndSale = new HouseOwner();

		@Override
		public void rent() {
			rentAndSale.rent();
		}

		@Override
		public void sale() {
			rentAndSale.sale();
		}

		//委派给房主
		void toHouseOwner() {
			rentAndSale= new HouseOwner();
		}

		//委派给中介
		void toAgent() {
			rentAndSale= new Agent();
		}

	}


	@Test
	public void delegateTest() {
		Delegate delegate = new Delegate();
		System.out.println("默认房主自己租售===============================");
		delegate.rent();
		delegate.sale();

		System.out.println("房主找中介租售===============================");
		delegate.toAgent();
		delegate.rent();
		delegate.sale();
	}


}