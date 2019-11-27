package com.sf.jvm.deep;

/**
 * 描述：finalize()方法在垃圾回收前的自救
 * @author 80002888
 * @date   2019年11月27日
 */
public class FinalizeEscapeGC {

	public static FinalizeEscapeGC saveHook = new FinalizeEscapeGC();
	
	public static void main(String[] args) throws Exception {
		// 对象第一次自救，finalize()方法优先级很低，睡眠0.5s等待它
		saveHook = null;
		System.gc();
		Thread.sleep(500);
		isAlive();
		
		// 下面这段代码与上面完全相同，但是却自救失败，因为finalize()只会执行一次
		saveHook = null;
		System.gc();
		Thread.sleep(500);
		isAlive();
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method execute");
		FinalizeEscapeGC.saveHook = this;
	}
	
	/**
	 * 判断是否存活
	 *	@ReturnType	void 
	 *	@Date	2019年11月27日	下午3:54:59
	 *  @Param
	 */
	public static void isAlive(){
		if (saveHook == null) {
			System.out.println("no, i am dead");
		} else {
			System.out.println("yes, i am alive");
		}
	}
	
}
