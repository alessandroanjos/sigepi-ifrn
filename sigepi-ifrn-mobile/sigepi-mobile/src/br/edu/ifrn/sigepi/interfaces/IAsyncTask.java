package br.edu.ifrn.sigepi.interfaces;


public interface IAsyncTask<T> {
	
	public void onPostExecuteTask(T result);

	public T doInBackgroundTask(String... params);
	
}
