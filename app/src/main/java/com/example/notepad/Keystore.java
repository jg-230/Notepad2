import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;


public class Keystore { 
    private static Keystore store;
    private SharedPreferences SP;
    private static String filename="Keys";

private Keystore(Context context) {
    SP = context.getApplicationContext().getSharedPreferences(filename,0);
}

public static Keystore getInstance(Context context) {
    if (store == null) {
        Log.v("Keystore","NEW STORE");
        store = new Keystore(context);
    }
    return store;
}

public void put(String username, String password) {//Log.v("Keystore","PUT "+key+" "+value);
    Editor editor = SP.edit();
    editor.putString(username, password);
    editor.commit(); // Stop everything and do an immediate save!
    // editor.apply();//Keep going and save when you are not busy - Available only in APIs 9 and above.  This is the preferred way of saving.
}

public String get(String password) {//Log.v("Keystore","GET from "+key);
    return SP.getString(username, password);

}

public int getInt(String username) {//Log.v("Keystore","GET INT from "+key);
    return SP.getInt(username, 0);
}

public void putInt(String username, int num) {//Log.v("Keystore","PUT INT "+key+" "+String.valueOf(num));
    Editor editor = SP.edit();
    editor.putInt(username, num);
    editor.commit();
}


public void clear(){ // Delete all shared preferences
    Editor editor = SP.edit();
    editor.clear();
    editor.commit();
}

public void remove(){ // Delete only the shared preference that you want
    Editor editor = SP.edit();
    editor.remove(filename);
    editor.commit();
}
