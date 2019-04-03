package top.wujinxing.Thread.book_core_thread.wait_and_notify.wait_notify_insert_test;



public class BackupA extends Thread {

	private DBTools dbtools;

	public BackupA(DBTools dbtools) {
		super();
		this.dbtools = dbtools;
	}

	@Override
	public void run() {
		dbtools.backupA();
	}

}
