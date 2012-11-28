package es.luixal.android.tasks.extended;


public interface Notificable {

	public void onTaskStarted(ExtendedAsyncTask<?, ?, ?> task);
	public void onTaskCompleted(ExtendedAsyncTask<?, ?, ?> task);
	public void onTaskError(ExtendedAsyncTask<?, ?, ?> task);
	public void onTaskProgress(ExtendedAsyncTask<?, ?, ?> task);
	public void onTaskCancelled(ExtendedAsyncTask<?, ?, ?> task);
	
}
