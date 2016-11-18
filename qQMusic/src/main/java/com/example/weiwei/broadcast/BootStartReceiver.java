package com.example.weiwei.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.weiwei.service.MusicPlayService;

/**
 * 接收开机广播的receiver
 * @author shkstart
 *
 */
public class BootStartReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.e("TAG", "BootStartReceiver onReceive()");
		//启动监听电话服务
		context.startService(new Intent(context, MusicPlayService.class));
	}

}
