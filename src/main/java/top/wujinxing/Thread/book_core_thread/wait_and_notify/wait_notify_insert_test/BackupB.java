package top.wujinxing.Thread.book_core_thread.wait_and_notify.wait_notify_insert_test;


public class BackupB extends Thread {

	private DBTools dbtools;

	public BackupB(DBTools dbtools) {
		super();
		this.dbtools = dbtools;
	}

	@Override
	public void run() {
		dbtools.backupB();
	}

}
