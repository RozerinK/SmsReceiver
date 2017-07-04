package broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Rozerin on 4.07.2017.
 */

public class SmsReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage messages=null;

        Bundle pudsBundle = intent.getExtras();
        String format = pudsBundle.getString("format");
        Object[] pdus = (Object[]) pudsBundle.get("pdus");
        if (Build.VERSION.SDK_INT >Build.VERSION_CODES.M ){
            messages = SmsMessage.createFromPdu((byte[]) pdus[0]);
        }
        else if(Build.VERSION.SDK_INT <Build.VERSION_CODES.M)
        {
         messages = SmsMessage.createFromPdu((byte[]) pdus[0],format);
        }
        Toast.makeText(context, "Yeni SMS: " + messages.getMessageBody(),
                Toast.LENGTH_LONG).show();

        Log.d(getClass().getName().toString(), "yeni sms geldi");
    }

}