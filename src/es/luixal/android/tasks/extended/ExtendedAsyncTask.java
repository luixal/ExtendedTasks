package es.luixal.android.tasks.extended;

import android.os.AsyncTask;
import android.os.Bundle;

public abstract class ExtendedAsyncTask<T1, T2, T3> extends AsyncTask<T1, T2, T3> {

	protected Notificable notificable;	// Notificable object that receives notifications from task
	protected Object tag;				// An object for tagging tasks if needed
	protected Bundle data;
	
	public ExtendedAsyncTask(Notificable notificable) {
		this.notificable = notificable;
		this.data = new Bundle();
	}
	
	public ExtendedAsyncTask(Notificable notificable, Object tag) {
		this.notificable = notificable;
		this.tag = tag;
		this.data = new Bundle();
	}
	
	public ExtendedAsyncTask(Notificable notificable, Object tag, Bundle data) {
		this.notificable = notificable;
		this.tag = tag;
		this.data = data;
	}
	
	public Object getTag() {
		return this.tag;
	}
	
	public void setTag(Object tag) {
		this.tag = tag;
	}
	
	public Bundle getData() {
		return this.data;
	}
	
	public void setData(Bundle data) {
		this.data = data;
	}
	
	// nofity methods:
	public void notifyTaskStarted()		{ this.notificable.onTaskStarted(this); }
	public void notifyTaskCompleted()	{ this.notificable.onTaskCompleted(this); }
	public void notifyTaskError()		{ this.notificable.onTaskError(this); }
	public void notifyTaskProgress()	{ this.notificable.onTaskProgress(this); }
	public void notifyTaskCancelled()	{ this.notificable.onTaskCancelled(this); }
	
	// automatic notifications at some points:
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		this.notifyTaskStarted();
	}
		
	@Override
	protected void onCancelled() {
		super.onCancelled();
		this.notifyTaskCancelled();
	}
	
	protected void onProgressUpdate(T2... values) {
		super.onProgressUpdate(values);
		this.notifyTaskProgress();
	}
	
}
