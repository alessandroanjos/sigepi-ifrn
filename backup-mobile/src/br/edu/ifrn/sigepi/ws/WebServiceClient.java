package br.edu.ifrn.sigepi.ws;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

import android.util.Log;



public class WebServiceClient {
	
	public final String[] get(String url){
		String[] resultado = new String[2];
		HttpGet httpGet = new HttpGet(url);
		HttpResponse resposta;
		
		try {
			resposta = HttpClientSingleton.getHttpClientInstace().execute(httpGet);
			HttpEntity entity = resposta.getEntity();
			
			if(entity != null){
				resultado[0] = String.valueOf(resposta.getStatusLine().getStatusCode());
				InputStream in = entity.getContent();
				resultado[1] = toString(in);
				in.close();
			}
		} catch (Exception e) {
			Log.e("ERRO", "Falha ao acessar webService" );
			resultado[0] = "0";
			resultado[1] = "Falha de Rede";
			e.printStackTrace();
		}
		return resultado;
	}
	
	public final String[] post(String json, String url){
		String[] resultado = new String[2];
		
		try {
			HttpPost httpPost = new HttpPost(new URI(url));
			httpPost.setHeader("Content-type", "application/json");
			StringEntity stringEntity = new StringEntity(json, "UTF-8");
			httpPost.setEntity(stringEntity);
			
			HttpResponse resposta;
			resposta = HttpClientSingleton.getHttpClientInstace().execute(httpPost);
			HttpEntity entity = resposta.getEntity();
			
			if(entity != null){
				resultado[0] = String.valueOf(resposta.getStatusLine().getStatusCode());
				InputStream in = entity.getContent();
				resultado[1] = toString(in);
				in.close();
			}
			
		} catch (Exception e) {
			Log.e("ERRO", "Falha ao acessar webService" );
			resultado[0] = "0";
			resultado[1] = "Falha de Rede";
			e.printStackTrace();
		}
		return resultado;
	}
	
	public final String[] put(String json, String url){
		String[] resultado = new String[2];
		
		try {
			HttpPut httpPut = new HttpPut(new URI(url));
			httpPut.setHeader("Content-type", "application/json");
			StringEntity stringEntity = new StringEntity(json, "UTF-8");
			httpPut.setEntity(stringEntity);
			
			HttpResponse resposta;
			resposta = HttpClientSingleton.getHttpClientInstace().execute(httpPut);
			HttpEntity entity = resposta.getEntity();
			
			if(entity != null){
				resultado[0] = String.valueOf(resposta.getStatusLine().getStatusCode());
				InputStream in = entity.getContent();
				resultado[1] = toString(in);
				in.close();
			}
			
		} catch (Exception e) {
			Log.e("ERRO", "Falha ao acessar webService" );
			resultado[0] = "0";
			resultado[1] = "Falha de Rede";
			e.printStackTrace();
		}
		return resultado;
	}
	
	public final String[] delete(String url){
		String[] resultado = new String[2];
		HttpDelete httpDelete = new HttpDelete(url);
		HttpResponse resposta;
		
		try {
			resposta = HttpClientSingleton.getHttpClientInstace().execute(httpDelete);
			HttpEntity entity = resposta.getEntity();
			
			if(entity != null){
				resultado[0] = String.valueOf(resposta.getStatusLine().getStatusCode());
				InputStream in = entity.getContent();
				resultado[1] = toString(in);
				in.close();
			}
		} catch (Exception e) {
			Log.e("ERROO", "Falha ao acessar webService" );
			resultado[0] = "0";
			resultado[1] = "Falha de Rede";
			e.printStackTrace();
		}
		return resultado;
	}
	
	private String toString(InputStream is) throws IOException {
		byte[] bytes = new byte[1024];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int lidos;
		
		while ((lidos = is.read(bytes)) > 0)
			baos.write(bytes, 0, lidos);
			
		return new String(baos.toByteArray());
	}

}
